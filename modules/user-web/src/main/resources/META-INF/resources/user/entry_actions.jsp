<%@page import="com.adjecti.user.constants.MVCCommandNames"%>
<%@ include file="../init.jsp"%>

<c:set var="user" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />


<%-- User Options Menu --%>
<liferay-ui:icon-menu markupView="lexicon">
	<%-- Edit Individual or Selected Teacher --%>
	<portlet:renderURL var="editUserURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.EDIT_USER%>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="userId" value="${user.userId}" />
	</portlet:renderURL>
	<liferay-ui:icon message="edit" url="${editUserURL}" />
	<%-- Deleting Individual or Selected User --%>
	<portlet:actionURL name="<%=MVCCommandNames.DELETE_USER%>"
		var="deleteUserURL">
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="userId" value="${user.userId }" />
	</portlet:actionURL>
	<liferay-ui:icon message="delete" url="${deleteUserURL}" />
</liferay-ui:icon-menu>