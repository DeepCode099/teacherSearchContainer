package com.adj.render.command;

import com.adj.constants.DemoPortletKeys;
import com.adj.constants.MVCCommandNames;
import com.adj.model.Teacher;
import com.adj.portlet.display.TeacherManagementToolbarDisplayContext;
import com.adj.service.TeacherLocalService;
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

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + DemoPortletKeys.DEMO,
		"mvc.command.name=/",
		"mvc.command.name="+MVCCommandNames.VIEW_TEACHERS, }, service = MVCRenderCommand.class)
public class TeacherListMVCRenderCommad implements MVCRenderCommand {
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		addTeacherListAttributes(renderRequest);
		addTeacherToolbarAttributes(renderRequest, renderResponse);
		return "/teacher/teacher_list.jsp";
	}
	

	/**
	 * Adds Assignment Related List Information To Request Parameter
	 * 
	 * @param renderRequest
	 */
	private void addTeacherListAttributes(RenderRequest renderRequest) {
		// Resolve Start and End Of The Search Container Which Will Be Used As View Or Table To Display Teachers Details
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;
		
		// Get The Sorting Details For Teacher From The Search Container
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "name");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "asc");
		System.out.println("orderbycol---"+orderByCol);
		// Create A OrderbyComparator Which Will Be Also Used For Getting The List Of Teacher
		OrderByComparator<Teacher> orderByComparator = OrderByComparatorFactoryUtil.create("Teacher", orderByCol, !("asc").equals(orderByType));
		
		// Get The Keywords Information From The Search Container
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		System.out.println("keywords========"+keywords);
		// For Teacher Retrival Purpose We Also Need Information About Which Site (Group Details) So Getting GroupId Information
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();

		System.out.println("groupId=="+groupId+"keywords=="+keywords+"start==="+start+"end===="+end+"orderByComparator====="+orderByComparator);
		
		// Call For Teacher Service To Get The Teacher Information and Count Details
		List<Teacher> teachers = teacherLocalService.getTeachersByKeywords(groupId, keywords, start, end, orderByComparator);
		long teacherCount = teacherLocalService.getTeachersCountByKeywords(groupId, keywords);

				System.out.println("---list------"+teachers);
		
	//	List<Teacher> teacherList = teacherLocalService.getTeacherList();
		//int teacherCount = teacherLocalService.getTeacherCountByList(teacherList);
	
		// Finally Setting Up the Teacher Relavant Values To The Request
		renderRequest.setAttribute("teacherList", teachers);
		renderRequest.setAttribute("teacherCount", teacherCount);
		renderRequest.setAttribute("delta", delta);
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
	
	@Reference
	private TeacherLocalService teacherLocalService;

}
