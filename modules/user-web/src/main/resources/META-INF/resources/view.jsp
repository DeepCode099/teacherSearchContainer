<%@ include file="init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>


<portlet:actionURL name="userAction" var="userActionCommand">
</portlet:actionURL>

<portlet:renderURL var="userRenderCommand">
	<portlet:param name="mvcRenderCommandName" value="userRender" />
</portlet:renderURL>
<aui:form action="<%=userActionCommand %>" method="post">

 <aui:input name="screenName" type="text"/>
 <aui:input name="emailAddress" type="text"/>
 <aui:input name="firstName" type="text"/>
 <aui:input name="lastName" type="text"/>
  <aui:input name="password" type="password"/>
 <aui:button type="submit" value="Add User" />
 
</aui:form>

<aui:a href="<%=userRenderCommand %>" cssClass="">UserList</aui:a>