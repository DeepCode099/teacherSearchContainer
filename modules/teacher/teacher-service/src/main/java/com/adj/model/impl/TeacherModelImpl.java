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
import com.adj.model.TeacherModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Teacher service. Represents a row in the &quot;SC_Teacher&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>TeacherModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TeacherImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeacherImpl
 * @generated
 */
public class TeacherModelImpl
	extends BaseModelImpl<Teacher> implements TeacherModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a teacher model instance should use the <code>Teacher</code> interface instead.
	 */
	public static final String TABLE_NAME = "SC_Teacher";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"teacherId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"name", Types.VARCHAR}, {"department", Types.VARCHAR},
		{"age", Types.INTEGER}, {"salary", Types.BIGINT},
		{"address", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("teacherId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("department", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("age", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("salary", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("address", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SC_Teacher (uuid_ VARCHAR(75) null,teacherId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,department VARCHAR(75) null,age INTEGER,salary LONG,address VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table SC_Teacher";

	public static final String ORDER_BY_JPQL = " ORDER BY teacher.name ASC";

	public static final String ORDER_BY_SQL = " ORDER BY SC_Teacher.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NAME_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public TeacherModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _teacherId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTeacherId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _teacherId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Teacher.class;
	}

	@Override
	public String getModelClassName() {
		return Teacher.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Teacher, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Teacher, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Teacher, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Teacher)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Teacher, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Teacher, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Teacher)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Teacher, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Teacher, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Teacher, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Teacher, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Teacher, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Teacher, Object>>();
		Map<String, BiConsumer<Teacher, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Teacher, ?>>();

		attributeGetterFunctions.put("uuid", Teacher::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Teacher, String>)Teacher::setUuid);
		attributeGetterFunctions.put("teacherId", Teacher::getTeacherId);
		attributeSetterBiConsumers.put(
			"teacherId", (BiConsumer<Teacher, Long>)Teacher::setTeacherId);
		attributeGetterFunctions.put("groupId", Teacher::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Teacher, Long>)Teacher::setGroupId);
		attributeGetterFunctions.put("companyId", Teacher::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Teacher, Long>)Teacher::setCompanyId);
		attributeGetterFunctions.put("userId", Teacher::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Teacher, Long>)Teacher::setUserId);
		attributeGetterFunctions.put("userName", Teacher::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Teacher, String>)Teacher::setUserName);
		attributeGetterFunctions.put("createDate", Teacher::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Teacher, Date>)Teacher::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Teacher::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Teacher, Date>)Teacher::setModifiedDate);
		attributeGetterFunctions.put("name", Teacher::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Teacher, String>)Teacher::setName);
		attributeGetterFunctions.put("department", Teacher::getDepartment);
		attributeSetterBiConsumers.put(
			"department", (BiConsumer<Teacher, String>)Teacher::setDepartment);
		attributeGetterFunctions.put("age", Teacher::getAge);
		attributeSetterBiConsumers.put(
			"age", (BiConsumer<Teacher, Integer>)Teacher::setAge);
		attributeGetterFunctions.put("salary", Teacher::getSalary);
		attributeSetterBiConsumers.put(
			"salary", (BiConsumer<Teacher, Long>)Teacher::setSalary);
		attributeGetterFunctions.put("address", Teacher::getAddress);
		attributeSetterBiConsumers.put(
			"address", (BiConsumer<Teacher, String>)Teacher::setAddress);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@Override
	public long getTeacherId() {
		return _teacherId;
	}

	@Override
	public void setTeacherId(long teacherId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_teacherId = teacherId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@Override
	public String getDepartment() {
		if (_department == null) {
			return "";
		}
		else {
			return _department;
		}
	}

	@Override
	public void setDepartment(String department) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_department = department;
	}

	@Override
	public int getAge() {
		return _age;
	}

	@Override
	public void setAge(int age) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_age = age;
	}

	@Override
	public long getSalary() {
		return _salary;
	}

	@Override
	public void setSalary(long salary) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_salary = salary;
	}

	@Override
	public String getAddress() {
		if (_address == null) {
			return "";
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_address = address;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Teacher.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Teacher.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Teacher toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Teacher>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TeacherImpl teacherImpl = new TeacherImpl();

		teacherImpl.setUuid(getUuid());
		teacherImpl.setTeacherId(getTeacherId());
		teacherImpl.setGroupId(getGroupId());
		teacherImpl.setCompanyId(getCompanyId());
		teacherImpl.setUserId(getUserId());
		teacherImpl.setUserName(getUserName());
		teacherImpl.setCreateDate(getCreateDate());
		teacherImpl.setModifiedDate(getModifiedDate());
		teacherImpl.setName(getName());
		teacherImpl.setDepartment(getDepartment());
		teacherImpl.setAge(getAge());
		teacherImpl.setSalary(getSalary());
		teacherImpl.setAddress(getAddress());

		teacherImpl.resetOriginalValues();

		return teacherImpl;
	}

	@Override
	public Teacher cloneWithOriginalValues() {
		TeacherImpl teacherImpl = new TeacherImpl();

		teacherImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		teacherImpl.setTeacherId(
			this.<Long>getColumnOriginalValue("teacherId"));
		teacherImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		teacherImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		teacherImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		teacherImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		teacherImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		teacherImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		teacherImpl.setName(this.<String>getColumnOriginalValue("name"));
		teacherImpl.setDepartment(
			this.<String>getColumnOriginalValue("department"));
		teacherImpl.setAge(this.<Integer>getColumnOriginalValue("age"));
		teacherImpl.setSalary(this.<Long>getColumnOriginalValue("salary"));
		teacherImpl.setAddress(this.<String>getColumnOriginalValue("address"));

		return teacherImpl;
	}

	@Override
	public int compareTo(Teacher teacher) {
		int value = 0;

		value = getName().compareTo(teacher.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Teacher)) {
			return false;
		}

		Teacher teacher = (Teacher)object;

		long primaryKey = teacher.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Teacher> toCacheModel() {
		TeacherCacheModel teacherCacheModel = new TeacherCacheModel();

		teacherCacheModel.uuid = getUuid();

		String uuid = teacherCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			teacherCacheModel.uuid = null;
		}

		teacherCacheModel.teacherId = getTeacherId();

		teacherCacheModel.groupId = getGroupId();

		teacherCacheModel.companyId = getCompanyId();

		teacherCacheModel.userId = getUserId();

		teacherCacheModel.userName = getUserName();

		String userName = teacherCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			teacherCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			teacherCacheModel.createDate = createDate.getTime();
		}
		else {
			teacherCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			teacherCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			teacherCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		teacherCacheModel.name = getName();

		String name = teacherCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			teacherCacheModel.name = null;
		}

		teacherCacheModel.department = getDepartment();

		String department = teacherCacheModel.department;

		if ((department != null) && (department.length() == 0)) {
			teacherCacheModel.department = null;
		}

		teacherCacheModel.age = getAge();

		teacherCacheModel.salary = getSalary();

		teacherCacheModel.address = getAddress();

		String address = teacherCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			teacherCacheModel.address = null;
		}

		return teacherCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Teacher, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Teacher, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Teacher, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Teacher)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Teacher>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Teacher.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _teacherId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _department;
	private int _age;
	private long _salary;
	private String _address;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Teacher, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Teacher)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("teacherId", _teacherId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("department", _department);
		_columnOriginalValues.put("age", _age);
		_columnOriginalValues.put("salary", _salary);
		_columnOriginalValues.put("address", _address);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("teacherId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("name", 256L);

		columnBitmasks.put("department", 512L);

		columnBitmasks.put("age", 1024L);

		columnBitmasks.put("salary", 2048L);

		columnBitmasks.put("address", 4096L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Teacher _escapedModel;

}