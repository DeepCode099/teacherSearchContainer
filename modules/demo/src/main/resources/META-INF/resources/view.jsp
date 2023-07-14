<%@page import="com.adj.constants.MVCCommandNames"%>
<%@ include file="init.jsp"%>

<portlet:renderURL var="teacherListURL" >
<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_TEACHERS%>"/>
</portlet:renderURL>
<portlet:actionURL name="<%=MVCCommandNames.ADD_TEACHER%>" var="addTeacherActionURL"/>
<aui:form action="<%= addTeacherActionURL %>" name="teacherForm"  method="POST">
	<aui:row>
		<aui:col width="50">
			<aui:input label="Teacher Name" name="name" id="name" type="text" />
		</aui:col>
		<aui:col width="50">
			<aui:input label="Department" name="department" id="department"
				type="text" />
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col width="50">
			<aui:input label="Teacher Age" name="age" id="age" type="text" />
		</aui:col>
		<aui:col width="50">
			<aui:input label="Teacher Salary" name="salary" id="salary"
				type="text" />
		</aui:col>
	</aui:row>
	<aui:col width="100">
		<aui:input label="Address" name="address" id="address" type="text" />
	</aui:col>
	<aui:button type="submit" name="" value="Submit" />
</aui:form>
<br>
<a href="<%= teacherListURL %>" ><button class="btn btn-primary"> 
            Teacher List
        </button></a>


