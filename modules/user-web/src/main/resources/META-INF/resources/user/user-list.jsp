<%@page import="com.liferay.portal.kernel.service.UserLocalService"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>

<%@page import="java.util.List"%>
<%@ include file="../init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<liferay-ui:success key="userDeleted" message="user-deleted-successfully" />

<div class="container ">
	<clay:management-toolbar disabled="${userListCount eq 0}"
		displayContext="${userManagementToolbarDisplayContext}"	itemsTotal="${userListCount}" searchContainerId="userListEntries" selectable="false" />
	<liferay-ui:search-container id="userListEntries"
		iteratorURL="${portletURL}" delta="${delta }"
		emptyResultsMessage="no-users" total="${userListCount}">
		<liferay-ui:search-container-results results="${userList}" />
		<liferay-ui:search-container-row className="com.liferay.portal.kernel.model.User"
			modelVar="user">
			<%-- To Handle Different Display View(Card|Table|List) We Are Doing It In A Separate JSP --%>
		 	<%@include file="entry_search_column.jspf"%>
		 </liferay-ui:search-container-row>
		<liferay-ui:search-iterator displayStyle="${teacherManagementToolbarDisplayContext.getDisplayStyle()}"
			markupView="lexicon" />
	</liferay-ui:search-container>
</div>