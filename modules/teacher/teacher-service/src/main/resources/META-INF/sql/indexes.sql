create index IX_4ABC58F1 on SC_Teacher (groupId);
create index IX_5E227D8D on SC_Teacher (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9157034F on SC_Teacher (uuid_[$COLUMN_LENGTH:75$], groupId);