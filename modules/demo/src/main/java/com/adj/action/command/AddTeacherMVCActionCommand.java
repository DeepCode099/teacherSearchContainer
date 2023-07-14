package com.adj.action.command;

import com.adj.constants.DemoPortletKeys;
import com.adj.constants.MVCCommandNames;
import com.adj.model.Teacher;
import com.adj.service.TeacherLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + DemoPortletKeys.DEMO,
		"mvc.command.name=" + MVCCommandNames.ADD_TEACHER }, service = MVCActionCommand.class)

public class AddTeacherMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		System.out.println("process action called");

		String name = ParamUtil.getString(actionRequest, "name");
		String department = ParamUtil.getString(actionRequest, "department");
		String age = ParamUtil.getString(actionRequest, "age");
		int teacherAge = Integer.parseInt(age);
		String salary = ParamUtil.getString(actionRequest, "salary");
		long teacherSalary = Long.parseLong(salary);
		String address = ParamUtil.getString(actionRequest, "address");
		// we need groupId Which is get by themeDisplay Object
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();

		// We Also Need Service Context For Our Add Operation
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Teacher.class.getName(), actionRequest);

		teacherLocalService.addTeacher(groupId, name, department, teacherAge, teacherSalary, address, serviceContext);

		actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.VIEW_TEACHERS);
	}

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private TeacherLocalService teacherLocalService;

	@Reference
	private UserLocalService userLocalService;

}
