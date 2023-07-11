package com.adj.portlet;


import com.adj.constants.DemoPortletKeys;
import com.adj.constants.MVCCommandNames;
import com.adj.model.Teacher;
import com.adj.service.TeacherLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionLocalServiceUtil;
import com.liferay.object.service.ObjectEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Admin
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Demo", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + DemoPortletKeys.DEMO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class DemoPortlet extends MVCPortlet {

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private TeacherLocalService teacherLocalService;
	private List<ObjectEntry> objectEntries;
	private List<ObjectEntry> objectEntries2;

	private Map<String, Serializable> values2;


	@ProcessAction(name = "addTeacher")
	public void addTeacher(ActionRequest actionRequest, ActionResponse actionResponse) {
		System.out.println("test");
		long teacherId = counterLocalService.increment(Teacher.class.getName());
		String name = ParamUtil.getString(actionRequest, "name");
		String department = ParamUtil.getString(actionRequest, "department");
		String age = ParamUtil.getString(actionRequest, "age");
		int teacherAge = Integer.parseInt(age);
		String salary = ParamUtil.getString(actionRequest, "salary");
		long teacherSalary = Long.parseLong(salary);
		String address = ParamUtil.getString(actionRequest, "address");

		Teacher teacher = teacherLocalService.createTeacher(teacherId);
		teacher.setName(name);
		teacher.setDepartment(department);
		teacher.setAge(teacherAge);
		teacher.setSalary(teacherSalary);
		teacher.setAddress(address);
		teacherLocalService.addTeacher(teacher);
		actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.VIEW_TEACHERS);
	}
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		Map<String, Serializable> values = new HashMap<>();
		values.put("name", "test");
		ServiceContext sc = new ServiceContext();
		List<ObjectDefinition> objectDefinitionList = ObjectDefinitionLocalServiceUtil.getObjectDefinitions(-1, -1);
		for (ObjectDefinition objectDef : objectDefinitionList) {
			if(objectDef.getName().equalsIgnoreCase("C_Student")) {
				try {
					ObjectEntryLocalServiceUtil.addObjectEntry(20123, 0,objectDef.getObjectDefinitionId() , values, sc);
					objectEntries2 = ObjectEntryLocalServiceUtil.getObjectEntries(0, objectDef.getObjectDefinitionId(), -1, -1);
					for(ObjectEntry obj:objectEntries2) {
						values2 = ObjectEntryLocalServiceUtil.getValues(obj);
						System.out.println("values2"+values2);
					}
				} catch (PortalException e) {
					e.printStackTrace();
				}
				
			}
		}
		super.doView(renderRequest, renderResponse);
	}

	
	
	
}