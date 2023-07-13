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

package com.adj.service;

import com.adj.model.Teacher;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Teacher. This utility wraps
 * <code>com.adj.service.impl.TeacherLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TeacherLocalService
 * @generated
 */
public class TeacherLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adj.service.impl.TeacherLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the teacher to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeacherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teacher the teacher
	 * @return the teacher that was added
	 */
	public static Teacher addTeacher(Teacher teacher) {
		return getService().addTeacher(teacher);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new teacher with the primary key. Does not add the teacher to the database.
	 *
	 * @param teacherId the primary key for the new teacher
	 * @return the new teacher
	 */
	public static Teacher createTeacher(long teacherId) {
		return getService().createTeacher(teacherId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the teacher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeacherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teacherId the primary key of the teacher
	 * @return the teacher that was removed
	 * @throws PortalException if a teacher with the primary key could not be found
	 */
	public static Teacher deleteTeacher(long teacherId) throws PortalException {
		return getService().deleteTeacher(teacherId);
	}

	/**
	 * Deletes the teacher from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeacherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teacher the teacher
	 * @return the teacher that was removed
	 */
	public static Teacher deleteTeacher(Teacher teacher) {
		return getService().deleteTeacher(teacher);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adj.model.impl.TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adj.model.impl.TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Teacher fetchTeacher(long teacherId) {
		return getService().fetchTeacher(teacherId);
	}

	/**
	 * Returns the teacher matching the UUID and group.
	 *
	 * @param uuid the teacher's UUID
	 * @param groupId the primary key of the group
	 * @return the matching teacher, or <code>null</code> if a matching teacher could not be found
	 */
	public static Teacher fetchTeacherByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchTeacherByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the teacher with the primary key.
	 *
	 * @param teacherId the primary key of the teacher
	 * @return the teacher
	 * @throws PortalException if a teacher with the primary key could not be found
	 */
	public static Teacher getTeacher(long teacherId) throws PortalException {
		return getService().getTeacher(teacherId);
	}

	/**
	 * Returns the teacher matching the UUID and group.
	 *
	 * @param uuid the teacher's UUID
	 * @param groupId the primary key of the group
	 * @return the matching teacher
	 * @throws PortalException if a matching teacher could not be found
	 */
	public static Teacher getTeacherByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getTeacherByUuidAndGroupId(uuid, groupId);
	}

	public static int getTeacherCountByList(List<Teacher> teacherList) {
		return getService().getTeacherCountByList(teacherList);
	}

	public static List<Teacher> getTeacherList() {
		return getService().getTeacherList();
	}

	/**
	 * Returns a range of all the teachers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adj.model.impl.TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of teachers
	 * @param end the upper bound of the range of teachers (not inclusive)
	 * @return the range of teachers
	 */
	public static List<Teacher> getTeachers(int start, int end) {
		return getService().getTeachers(start, end);
	}

	public static List<Teacher> getTeachersByGroupId(long groupId) {
		return getService().getTeachersByGroupId(groupId);
	}

	public static List<Teacher> getTeachersByGroupId(
		long groupId, int start, int end) {

		return getService().getTeachersByGroupId(groupId, start, end);
	}

	public static List<Teacher> getTeachersByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Teacher> orderByComparator) {

		return getService().getTeachersByGroupId(
			groupId, start, end, orderByComparator);
	}

	public static List<Teacher> getTeachersByKeywords(
		long groupId, String keyword, int start, int end,
		OrderByComparator<Teacher> orderByComparator) {

		return getService().getTeachersByKeywords(
			groupId, keyword, start, end, orderByComparator);
	}

	/**
	 * Returns all the teachers matching the UUID and company.
	 *
	 * @param uuid the UUID of the teachers
	 * @param companyId the primary key of the company
	 * @return the matching teachers, or an empty list if no matches were found
	 */
	public static List<Teacher> getTeachersByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getTeachersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of teachers matching the UUID and company.
	 *
	 * @param uuid the UUID of the teachers
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of teachers
	 * @param end the upper bound of the range of teachers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching teachers, or an empty list if no matches were found
	 */
	public static List<Teacher> getTeachersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Teacher> orderByComparator) {

		return getService().getTeachersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of teachers.
	 *
	 * @return the number of teachers
	 */
	public static int getTeachersCount() {
		return getService().getTeachersCount();
	}

	public static long getTeachersCountByKeywords(
		long groupId, String keyword) {

		return getService().getTeachersCountByKeywords(groupId, keyword);
	}

	/**
	 * Updates the teacher in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeacherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teacher the teacher
	 * @return the teacher that was updated
	 */
	public static Teacher updateTeacher(Teacher teacher) {
		return getService().updateTeacher(teacher);
	}

	public static TeacherLocalService getService() {
		return _service;
	}

	private static volatile TeacherLocalService _service;

}