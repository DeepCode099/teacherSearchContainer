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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TeacherLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TeacherLocalService
 * @generated
 */
public class TeacherLocalServiceWrapper
	implements ServiceWrapper<TeacherLocalService>, TeacherLocalService {

	public TeacherLocalServiceWrapper() {
		this(null);
	}

	public TeacherLocalServiceWrapper(TeacherLocalService teacherLocalService) {
		_teacherLocalService = teacherLocalService;
	}

	@Override
	public com.adj.model.Teacher addTeacher(
			long groupId, String name, String department, int age, long salary,
			String address,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teacherLocalService.addTeacher(
			groupId, name, department, age, salary, address, serviceContext);
	}

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
	@Override
	public com.adj.model.Teacher addTeacher(com.adj.model.Teacher teacher) {
		return _teacherLocalService.addTeacher(teacher);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teacherLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new teacher with the primary key. Does not add the teacher to the database.
	 *
	 * @param teacherId the primary key for the new teacher
	 * @return the new teacher
	 */
	@Override
	public com.adj.model.Teacher createTeacher(long teacherId) {
		return _teacherLocalService.createTeacher(teacherId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teacherLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.adj.model.Teacher deleteTeacher(long teacherId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teacherLocalService.deleteTeacher(teacherId);
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
	@Override
	public com.adj.model.Teacher deleteTeacher(com.adj.model.Teacher teacher) {
		return _teacherLocalService.deleteTeacher(teacher);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _teacherLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _teacherLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _teacherLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _teacherLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _teacherLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _teacherLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _teacherLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _teacherLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.adj.model.Teacher fetchTeacher(long teacherId) {
		return _teacherLocalService.fetchTeacher(teacherId);
	}

	/**
	 * Returns the teacher matching the UUID and group.
	 *
	 * @param uuid the teacher's UUID
	 * @param groupId the primary key of the group
	 * @return the matching teacher, or <code>null</code> if a matching teacher could not be found
	 */
	@Override
	public com.adj.model.Teacher fetchTeacherByUuidAndGroupId(
		String uuid, long groupId) {

		return _teacherLocalService.fetchTeacherByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _teacherLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _teacherLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _teacherLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _teacherLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teacherLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the teacher with the primary key.
	 *
	 * @param teacherId the primary key of the teacher
	 * @return the teacher
	 * @throws PortalException if a teacher with the primary key could not be found
	 */
	@Override
	public com.adj.model.Teacher getTeacher(long teacherId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teacherLocalService.getTeacher(teacherId);
	}

	/**
	 * Returns the teacher matching the UUID and group.
	 *
	 * @param uuid the teacher's UUID
	 * @param groupId the primary key of the group
	 * @return the matching teacher
	 * @throws PortalException if a matching teacher could not be found
	 */
	@Override
	public com.adj.model.Teacher getTeacherByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teacherLocalService.getTeacherByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public int getTeacherCountByList(
		java.util.List<com.adj.model.Teacher> teacherList) {

		return _teacherLocalService.getTeacherCountByList(teacherList);
	}

	@Override
	public java.util.List<com.adj.model.Teacher> getTeacherList() {
		return _teacherLocalService.getTeacherList();
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
	@Override
	public java.util.List<com.adj.model.Teacher> getTeachers(
		int start, int end) {

		return _teacherLocalService.getTeachers(start, end);
	}

	@Override
	public java.util.List<com.adj.model.Teacher> getTeachersByGroupId(
		long groupId) {

		return _teacherLocalService.getTeachersByGroupId(groupId);
	}

	@Override
	public java.util.List<com.adj.model.Teacher> getTeachersByGroupId(
		long groupId, int start, int end) {

		return _teacherLocalService.getTeachersByGroupId(groupId, start, end);
	}

	@Override
	public java.util.List<com.adj.model.Teacher> getTeachersByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.adj.model.Teacher>
			orderByComparator) {

		return _teacherLocalService.getTeachersByGroupId(
			groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.adj.model.Teacher> getTeachersByKeywords(
		long groupId, String keyword, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.adj.model.Teacher>
			orderByComparator) {

		return _teacherLocalService.getTeachersByKeywords(
			groupId, keyword, start, end, orderByComparator);
	}

	/**
	 * Returns all the teachers matching the UUID and company.
	 *
	 * @param uuid the UUID of the teachers
	 * @param companyId the primary key of the company
	 * @return the matching teachers, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adj.model.Teacher> getTeachersByUuidAndCompanyId(
		String uuid, long companyId) {

		return _teacherLocalService.getTeachersByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.adj.model.Teacher> getTeachersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.adj.model.Teacher>
			orderByComparator) {

		return _teacherLocalService.getTeachersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of teachers.
	 *
	 * @return the number of teachers
	 */
	@Override
	public int getTeachersCount() {
		return _teacherLocalService.getTeachersCount();
	}

	@Override
	public long getTeachersCountByKeywords(long groupId, String keyword) {
		return _teacherLocalService.getTeachersCountByKeywords(
			groupId, keyword);
	}

	@Override
	public com.adj.model.Teacher updateTeacher(
			long teacherId, String name, String department, int age,
			long salary, String address,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teacherLocalService.updateTeacher(
			teacherId, name, department, age, salary, address, serviceContext);
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
	@Override
	public com.adj.model.Teacher updateTeacher(com.adj.model.Teacher teacher) {
		return _teacherLocalService.updateTeacher(teacher);
	}

	@Override
	public TeacherLocalService getWrappedService() {
		return _teacherLocalService;
	}

	@Override
	public void setWrappedService(TeacherLocalService teacherLocalService) {
		_teacherLocalService = teacherLocalService;
	}

	private TeacherLocalService _teacherLocalService;

}