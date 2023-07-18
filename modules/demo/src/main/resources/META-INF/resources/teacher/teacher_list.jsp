<%@page import="com.adj.service.TeacherLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.adj.model.Teacher"%>
<%@page import="java.util.List"%>
<%@ include file="../init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<liferay-ui:success key="teacherDeleted" message="teacher-deleted-successfully" />

<div class="container ">
	<clay:management-toolbar disabled="${teacherCount eq 0}"
		displayContext="${teacherManagementToolbarDisplayContext}"
		itemsTotal="${teacherCount}" searchContainerId="teacherListEntries"
		selectable="false" />
	<liferay-ui:search-container id="teacherListEntries"
		iteratorURL="${portletURL}" delta="${delta }"
		emptyResultsMessage="no-teachers" total="${teacherCount}">
		<liferay-ui:search-container-results results="${teacherList}" />
		<liferay-ui:search-container-row className="com.adj.model.Teacher"
			modelVar="teacher">
			<%-- To Handle Different Display View(Card|Table|List) We Are Doing It In A Separate JSP --%>
			<%@include file="entry_search_column.jspf"%>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator
			displayStyle="${teacherManagementToolbarDisplayContext.getDisplayStyle()}"
			markupView="lexicon" />
	</liferay-ui:search-container>
</div>