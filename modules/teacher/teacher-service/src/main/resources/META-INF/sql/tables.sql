create table SC_Teacher (
	uuid_ VARCHAR(75) null,
	teacherId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	department VARCHAR(75) null,
	age INTEGER,
	salary LONG,
	address VARCHAR(75) null
);