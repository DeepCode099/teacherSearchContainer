package com.adj.action.command;

import com.adj.constants.DemoPortletKeys;
import com.adj.constants.MVCCommandNames;
import com.adj.service.TeacherLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + DemoPortletKeys.DEMO,
		"mvc.command.name=" + MVCCommandNames.DELETE_TEACHER }, service = MVCActionCommand.class)

public class DeleteTeacherMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		System.out.println("delete action");
		String id = ParamUtil.getString(actionRequest, "teacherId");
		long teacherId = Long.parseLong(id);
		teacherLocalService.deleteTeacher(teacherId);
		// Add A New Success Message For : Assignment Deletion
		SessionMessages.add(actionRequest, "teacherDeleted");

	}

	@Reference
	private TeacherLocalService teacherLocalService;

}
