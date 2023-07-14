<%@page import="com.adj.constants.MVCCommandNames"%>
<%@ include file="../init.jsp"%>

<c:set var="teacher" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />


<%-- Teacher Options Menu --%>
<liferay-ui:icon-menu markupView="lexicon">
	<%-- Edit Individual or Selected Teacher --%>
	<portlet:renderURL var="editTeacherURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.EDIT_TEACHER%>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="teacherId" value="${teacher.teacherId}" />
	</portlet:renderURL>
	<liferay-ui:icon message="edit" url="${editTeacherURL}" />
	<%-- Deleting Individual or Selected Teacher --%>
	<portlet:actionURL name="<%=MVCCommandNames.DELETE_TEACHER%>"
		var="deleteTeacherURL">
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="teacherId" value="${teacher.teacherId }" />
	</portlet:actionURL>
	<liferay-ui:icon message="delete" url="${deleteTeacherURL}" />
</liferay-ui:icon-menu>