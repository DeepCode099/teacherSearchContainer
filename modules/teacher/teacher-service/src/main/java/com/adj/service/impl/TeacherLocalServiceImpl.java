/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.adj.service.impl;

import com.adj.model.Teacher;
import com.adj.model.impl.TeacherImpl;
import com.adj.service.TeacherLocalServiceUtil;
import com.adj.service.base.TeacherLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.adj.model.Teacher", service = AopService.class)
public class TeacherLocalServiceImpl extends TeacherLocalServiceBaseImpl {

	public List<Teacher> getTeacherList() {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(TeacherImpl.class, "teacher",
				PortalClassLoaderUtil.getClassLoader());
		// get All Teachers whose Name starts with A and salary > 23000
		// Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		// conjunction.add(RestrictionsFactoryUtil.like("teach.name","%A%"));
		// conjunction.add(RestrictionsFactoryUtil.gt("teach.salary", 23000L));
		// dynamicQuery.add(conjunction);

		// who lives in ghaziabad

		/*
		 * Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		 * conjunction.add(RestrictionsFactoryUtil.eq("teach.address","Ghaziabad"));
		 * dynamicQuery.add(conjunction);
		 */

		// get who from IT or Management

		Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
		// disjunction.add(RestrictionsFactoryUtil.eq("teacher.teacherId",15L));
		disjunction.add(RestrictionsFactoryUtil.like("teacher.department", "%Management%"));
		dynamicQuery.add(disjunction);
		List<Teacher> teacherList = TeacherLocalServiceUtil.dynamicQuery(dynamicQuery);
		return teacherList;
	}

	
	// create Teacher 
	
	
	public Teacher addTeacher(long groupId,String name, String department , int age, long salary , String address , ServiceContext serviceContext) throws PortalException {
		
		// Get Group(Site) and User Information
		Group 	group = groupLocalService.getGroup(groupId);
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		
		System.out.println("add Teacher method called");
		// Generate A New Primary Key For The Teacher
		long teacherId = counterLocalService.increment(Teacher.class.getName());
		
		// Using The Generated Key To Create A New Teacher Entity
		Teacher teacher = createTeacher(teacherId);
		
		// Populate The Field Values
		// 1. Update Actual Fields
		teacher.setName(name);
		teacher.setDepartment(department);
		teacher.setAge(age);
		teacher.setSalary(salary);
		teacher.setAddress(address);
		
		// 2. Update Audit and Other Generic Fields
		teacher.setGroupId(groupId);
		teacher.setCompanyId(group.getCompanyId());
		teacher.setCreateDate(serviceContext.getCreateDate(new Date()));
		teacher.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		teacher.setUserId(userId);
		teacher.setUserName(user.getScreenName());
		
		teacher = super.addTeacher(teacher);
		System.out.println("teacher added");
	
		// Persist And Return Teacher Entity Details To Databases
		return teacher;
	}
	
	
	// Update Teacher 
	
	public Teacher updateTeacher(long teacherId, String name, String department, int age, long salary, String address,
			ServiceContext serviceContext) throws PortalException  {
		Teacher teacher = getTeacher(teacherId);
		teacher.setName(name);
		teacher.setDepartment(department);
		teacher.setAddress(address);
		teacher.setAge(age);
		teacher.setSalary(salary);
		teacher.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		teacher = super.updateTeacher(teacher);
		return teacher;
	}
	
	public int getTeacherCountByList(List<Teacher> teacherList) {
		int count = teacherList.size();
		System.out.println("count is -->" + count);
		return count;
	}

	// get List of Teacher by groupId
	public List<Teacher> getTeachersByGroupId(long groupId) {
		return teacherPersistence.findByGroupId(groupId);
	}

	// get List of Teacher by groupId, start and end
	public List<Teacher> getTeachersByGroupId(long groupId, int start, int end) {
		return teacherPersistence.findByGroupId(groupId, start, end);
	}

	// get List of Teacher by groupId,start,end and orderByComparator
	public List<Teacher> getTeachersByGroupId(long groupId, int start, int end,
			OrderByComparator<Teacher> orderByComparator) {
		return teacherPersistence.findByGroupId(groupId, start, end, orderByComparator);
	}

	// get Search data using Dynamic Query by groupId and keyword
	private DynamicQuery getKeywordSearchDynamicQuery(long groupId, String keyword) {
		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));

		if (Validator.isNotNull(keyword)) {
			Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();

			disjunctionQuery.add(RestrictionsFactoryUtil.like("name", "%" + keyword + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("department", "%" + keyword + "%"));

			dynamicQuery.add(disjunctionQuery);
		}

		return dynamicQuery;
	}

	// get count by groupId and keyword
	public long getTeachersCountByKeywords(long groupId, String keyword) {
		return teacherLocalService.dynamicQueryCount(getKeywordSearchDynamicQuery(groupId, keyword));
	}

	// get List of Teacher by groupId,keyword,start,end and orderByComparator
	public List<Teacher> getTeachersByKeywords(long groupId, String keyword, int start, int end,
			OrderByComparator<Teacher> orderByComparator) {
		return teacherLocalService.dynamicQuery(getKeywordSearchDynamicQuery(groupId, keyword), start, end,
				orderByComparator);
	}

	@Reference 
	private GroupLocalService groupLocalService;
	
	
}