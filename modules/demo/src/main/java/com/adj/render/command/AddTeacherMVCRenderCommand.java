
package com.adj.render.command;

import com.adj.constants.DemoPortletKeys;
import com.adj.constants.MVCCommandNames;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + DemoPortletKeys.DEMO,
		"mvc.command.name=" + MVCCommandNames.ADD_TEACHER_FORM }, service = MVCRenderCommand.class)
public class AddTeacherMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		System.out.println("view.jsp page ");
		return "/view.jsp";
	}
}
