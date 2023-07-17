package com.adj.render.command;

import com.adj.constants.DemoPortletKeys;
import com.adj.constants.MVCCommandNames;
import com.adj.exception.NoSuchTeacherException;
import com.adj.model.Teacher;
import com.adj.service.TeacherLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + DemoPortletKeys.DEMO,
		"mvc.command.name=" + MVCCommandNames.EDIT_TEACHER }, service = MVCRenderCommand.class)
public class EditTeacherMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		Teacher teacher = null;
		// Get teacherId If The Purpose Is For Editing
		long teacherId = ParamUtil.getLong(renderRequest, "teacherId");

		System.out.println("teacher Id -->"+teacherId);
		// If TeacherId Is Greater Than Zero - Editing Purpose.
		if (teacherId > 0) {
			try {
				System.out.println("yes");
				teacher = teacherLocalSerive.getTeacher(teacherId);
			} catch (NoSuchTeacherException nste) {
				nste.printStackTrace();
			} catch (PortalException pe) {
				pe.printStackTrace();
			}
		}
		// Want To Also Setup A Back Button To Return From Appropriate Individual
		// Assignment View
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		String redirect = renderRequest.getParameter("redirect");

		portletDisplay.setShowBackIcon(true);
		portletDisplay.setURLBack(redirect);

		// Setting Up Teacher Details To The Request For The Appropriate or Edit View.
		renderRequest.setAttribute("teacher", teacher);
		renderRequest.setAttribute("assignmentClass", Teacher.class);
		return "/view.jsp";
	}

	@Reference
	private TeacherLocalService teacherLocalSerive;
}
