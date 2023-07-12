package com.adj.render.command;

import com.adj.constants.DemoPortletKeys;
import com.adj.constants.MVCCommandNames;
import com.adj.core.util.Pagination;
import com.adj.model.Teacher;
import com.adj.portlet.display.TeacherManagementToolbarDisplayContext;
import com.adj.service.TeacherLocalService;
import com.adj.service.TeacherLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + DemoPortletKeys.DEMO,
		"mvc.command.name=/",
		"mvc.command.name="+MVCCommandNames.VIEW_TEACHERS, }, service = MVCRenderCommand.class)
public class TeacherListMVCRenderCommad implements MVCRenderCommand {

	@Reference
	private TeacherLocalService teacherLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		addTeacherListAttributes(renderRequest);
		addTeacherToolbarAttributes(renderRequest, renderResponse);
		return "/teacher_list.jsp";
	}
	

	/**
	 * Adds Assignment Related List Information To Request Parameter
	 * 
	 * @param renderRequest
	 */
	private void addTeacherListAttributes(RenderRequest renderRequest) {
		// Resolve Start and End Of The Search Container Which Will Be Used As View Or Table To Display Teachers Details
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
		
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;
		
		// Get The Sorting Details For Teacher From The Search Container
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "age");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "asc");
		
		// Create A OrderbyComparator Which Will Be Also Used For Getting The List Of Teacher
		OrderByComparator<Teacher> orderByComparator = OrderByComparatorFactoryUtil.create("Teacher", orderByCol, !("asc").equals(orderByType));
		
		// Get The Keywords Information From The Search Container
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		
		// For Teacher Retrival Purpose We Also Need Information About Which Site (Group Details) So Getting GroupId Information
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();

		// Call For Teacher Service To Get The Teacher Information and Count Details
		//List<Teacher> assignments = assignmentService.getAssignmentsByKeywords(groupId, keywords, start, end, orderByComparator);
		//long assignmentCount = assignmentService.getAssignmentsCountByKeywords(groupId, keywords);
		List<Teacher> teacherList = teacherLocalService.getTeacherList();
		int teacherCount = teacherLocalService.getTeacherCountByList(teacherList);

		// Finally Setting Up the Teacher Relavant Values To The Request
		renderRequest.setAttribute("teacherList", teacherList);
		renderRequest.setAttribute("teacherCount", teacherCount);
	}

	private void addTeacherToolbarAttributes(RenderRequest renderRequest , RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		TeacherManagementToolbarDisplayContext teacherManagementToolbarDisplayContext = new TeacherManagementToolbarDisplayContext(liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		System.out.println("teacher managemnt toolbar "+teacherManagementToolbarDisplayContext);
		renderRequest.setAttribute("teacherManagementToolbarDisplayContext", teacherManagementToolbarDisplayContext);

	}
	
	@Reference
	private Portal _portal;

}
