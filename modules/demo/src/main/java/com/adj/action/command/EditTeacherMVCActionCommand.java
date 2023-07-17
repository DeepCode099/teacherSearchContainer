package com.adj.action.command;

import com.adj.constants.DemoPortletKeys;
import com.adj.constants.MVCCommandNames;
import com.adj.model.Teacher;
import com.adj.service.TeacherLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(immediate = true, property = { "javax.portlet.name=" + DemoPortletKeys.DEMO,
		"mvc.command.name=" + MVCCommandNames.EDIT_TEACHER}, service = MVCActionCommand.class)
public class EditTeacherMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		System.out.println("edit data");
		// As It For Editing Purpose We Need The Assignment Id
		String id = ParamUtil.getString(actionRequest, "teacherId");
		System.out.println("teacher id in action command"+id);
	    long teacherId =	Long.valueOf(id);
	    System.out.println("teacher id in aciton command after change into long"+teacherId);
		// We Also Need Service Context For Our Add Operation
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Teacher.class.getName(), actionRequest);
		String name = ParamUtil.getString(actionRequest, "name");
		String department = ParamUtil.getString(actionRequest, "department");
		String age = ParamUtil.getString(actionRequest, "age");
		int teacherAge = Integer.valueOf(age);
		String salary = ParamUtil.getString(actionRequest, "salary");
		long teacherSalary = Long.valueOf(salary);
		String address = ParamUtil.getString(actionRequest, "address");

		// call teacher LocalServiceImpl method for updata
		teacherLocalService.updateTeacher(teacherId, name, department, teacherAge, teacherSalary, address,
				serviceContext);
		System.out.println("teacher updated ");
		actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.VIEW_TEACHERS);
	}

	@Reference
	private TeacherLocalService teacherLocalService;

}
