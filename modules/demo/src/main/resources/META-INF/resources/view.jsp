<%@page import="com.adj.constants.MVCCommandNames"%>
<%@ include file="init.jsp"%>
<portlet:renderURL var="teacherListURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.VIEW_TEACHERS%>" />
</portlet:renderURL>

<%-- Generating Adding and Editing Action URL and Title Based On State Of Assignment Recieved By View --%>
<c:choose>
	<c:when test="${not empty teacher}">
		<portlet:actionURL var="addTeacherActionURL"
			name="<%=MVCCommandNames.EDIT_TEACHER%>">
		</portlet:actionURL>
	</c:when>
	<c:otherwise>
		<portlet:actionURL name="<%=MVCCommandNames.ADD_TEACHER%>"
			var="addTeacherActionURL">
		</portlet:actionURL>
	</c:otherwise>
</c:choose>

<aui:form action="${addTeacherActionURL}" method="POST" name="fm">
	<aui:input name="teacherId" value="${teacher.teacherId}" type="hidden" />
	<aui:row>
		<aui:col width="50">
			<aui:input label="Teacher Name" name="name" id="name" type="text"
				value="${teacher.name}" />
		</aui:col>
		<aui:col width="50">
			<aui:input label="Department" name="department" id="department"
				type="text" value="${teacher.department}" />
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col width="50">
			<aui:input label="Teacher Age" name="age" id="age" type="text"
				value="${teacher.age}" />
		</aui:col>
		<aui:col width="50">
			<aui:input label="Teacher Salary" name="salary" id="salary"
				type="text" value="${teacher.salary}" />
		</aui:col>
	</aui:row>
	<aui:col width="100">
		<aui:input label="Address" name="address" id="address" type="text"
			value="${teacher.address}" />
	</aui:col>
	<aui:button type="submit" name="" value="Submit" />
</aui:form>
<br>
<a href="<%=teacherListURL%>"><button class="btn btn-primary">
		Teacher List</button></a>