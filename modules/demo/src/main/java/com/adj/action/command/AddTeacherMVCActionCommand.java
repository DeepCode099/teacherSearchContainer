package com.adj.action.command;

import com.adj.constants.DemoPortletKeys;
import com.adj.constants.MVCCommandNames;
import com.adj.model.Teacher;
import com.adj.service.TeacherLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + DemoPortletKeys.DEMO,
			"mvc.command.name=" + MVCCommandNames.ADD_TEACHER
		},
		service = MVCActionCommand.class
	)

public class AddTeacherMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
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

	
	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private TeacherLocalService teacherLocalService;

	
}
