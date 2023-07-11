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

package com.adj.model.impl;

import com.adj.model.Teacher;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Teacher in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TeacherCacheModel implements CacheModel<Teacher>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TeacherCacheModel)) {
			return false;
		}

		TeacherCacheModel teacherCacheModel = (TeacherCacheModel)object;

		if (teacherId == teacherCacheModel.teacherId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, teacherId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", teacherId=");
		sb.append(teacherId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", department=");
		sb.append(department);
		sb.append(", age=");
		sb.append(age);
		sb.append(", salary=");
		sb.append(salary);
		sb.append(", address=");
		sb.append(address);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Teacher toEntityModel() {
		TeacherImpl teacherImpl = new TeacherImpl();

		if (uuid == null) {
			teacherImpl.setUuid("");
		}
		else {
			teacherImpl.setUuid(uuid);
		}

		teacherImpl.setTeacherId(teacherId);
		teacherImpl.setGroupId(groupId);
		teacherImpl.setCompanyId(companyId);
		teacherImpl.setUserId(userId);

		if (userName == null) {
			teacherImpl.setUserName("");
		}
		else {
			teacherImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			teacherImpl.setCreateDate(null);
		}
		else {
			teacherImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			teacherImpl.setModifiedDate(null);
		}
		else {
			teacherImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			teacherImpl.setName("");
		}
		else {
			teacherImpl.setName(name);
		}

		if (department == null) {
			teacherImpl.setDepartment("");
		}
		else {
			teacherImpl.setDepartment(department);
		}

		teacherImpl.setAge(age);
		teacherImpl.setSalary(salary);

		if (address == null) {
			teacherImpl.setAddress("");
		}
		else {
			teacherImpl.setAddress(address);
		}

		teacherImpl.resetOriginalValues();

		return teacherImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		teacherId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		department = objectInput.readUTF();

		age = objectInput.readInt();

		salary = objectInput.readLong();
		address = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(teacherId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (department == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(department);
		}

		objectOutput.writeInt(age);

		objectOutput.writeLong(salary);

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}
	}

	public String uuid;
	public long teacherId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String department;
	public int age;
	public long salary;
	public String address;

}