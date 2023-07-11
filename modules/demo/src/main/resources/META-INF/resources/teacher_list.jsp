<%@page import="com.adj.service.TeacherLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.adj.model.Teacher"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/teacher_list.jsp" />
</liferay-portlet:renderURL>
<div class="container">

	<clay:management-toolbar disabled="${teacherListCount eq 0}"
		displayContext="${teacherManagementToolbarDisplayContext}"
		itemsTotal="${teacherListCount}"
		searchContainerId="teacherListEntries" selectable="false" />
	<liferay-ui:search-container id="teacherListEntries"
		iteratorURL="<%=iteratorURL %>" total="${teacherListCount}" delta="5"
		deltaConfigurable="true">
		<liferay-ui:search-container-results results="${teacherList}" />
		<liferay-ui:search-container-row className="com.adj.model.Teacher"
			keyProperty="teacherId" modelVar="teacher">

			<liferay-ui:search-container-column-text name="Name"
				value="<%=teacher.getName()%>" />
			<liferay-ui:search-container-column-text name="Department"
				value="<%=teacher.getDepartment()%>" />
			<liferay-ui:search-container-column-text name="Age"
				value="<%=String.valueOf(teacher.getAge())%>" />
			<liferay-ui:search-container-column-text name="Salary"
				value="<%=String.valueOf(teacher.getSalary())%>" />
			<liferay-ui:search-container-column-text name="Address"
				value="<%=teacher.getAddress()%>" />
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator
			displayStyle="${teacherManagementToolbarDisplayContext.getDisplayStyle()}"
			markupView="lexicon" />
	</liferay-ui:search-container>
</div>