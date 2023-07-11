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
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.adj.model.Teacher", service = AopService.class)
public class TeacherLocalServiceImpl extends TeacherLocalServiceBaseImpl {

	public List<Teacher> getTeacherList() {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(TeacherImpl.class, "teacher",PortalClassLoaderUtil.getClassLoader());
		// get All Teachers whose Name starts with A and salary > 23000
	//	Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
	//	conjunction.add(RestrictionsFactoryUtil.like("teach.name","%A%"));
		//conjunction.add(RestrictionsFactoryUtil.gt("teach.salary", 23000L));
	//	dynamicQuery.add(conjunction); 
		
		// who lives in ghaziabad 
		
	/*	Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		conjunction.add(RestrictionsFactoryUtil.eq("teach.address","Ghaziabad"));
		dynamicQuery.add(conjunction); */
		
		// get who from IT or Management 
		
		Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
		disjunction.add(RestrictionsFactoryUtil.eq("teacher.teacherId",15L));
		disjunction.add(RestrictionsFactoryUtil.like("teacher.department", "%Management%"));
		dynamicQuery.add(disjunction); 
		List<Teacher> teacherList = TeacherLocalServiceUtil.dynamicQuery(dynamicQuery);
		return teacherList;
	}

	
	
	
	public int getTeacherCountByList(List<Teacher> teacherList) {
		int count = teacherList.size();
		System.out.println("count is -->"+count);
		return count;
	}

}