package com.adjecti.user.render;

import com.adjecti.user.constants.UserPortletKeys;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + UserPortletKeys.USER,
		"mvc.command.name=userRender" }, service = MVCRenderCommand.class)

public class UserListMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
				
		addUserToolbarAttributes(renderRequest,renderResponse);
		addTeacherListAttributes(renderRequest);

		return "/user-list.jsp";
	}

	
	private void addTeacherListAttributes(RenderRequest renderRequest) {
		// Resolve Start and End Of The Search Container Which Will Be Used As View Or Table To Display Teachers Details
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 4);
		
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;
		
		// Get The Sorting Details For Teacher From The Search Container
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "firstName");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "asc");
		System.out.println("orderbycol---"+orderByCol);
		// Create A OrderbyComparator Which Will Be Also Used For Getting The List Of Teacher
		OrderByComparator<User> orderByComparator = OrderByComparatorFactoryUtil.create("User", orderByCol, !("asc").equals(orderByType));
		
		// Get The Keywords Information From The Search Container
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		System.out.println("keywords========"+keywords);
		// For Teacher Retrival Purpose We Also Need Information About Which Site (Group Details) So Getting GroupId Information
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();

		System.out.println("groupId=="+groupId+"keywords=="+keywords+"start==="+start+"end===="+end+"orderByComparator====="+orderByComparator);
		
		// Call For Teacher Service To Get The Teacher Information and Count Details
		List<User> userList = userLocalService.dynamicQuery(getKeywordSearchDynamicQuery(20119,keywords), start, end, orderByComparator);
		long userListCount = userLocalService.dynamicQueryCount(getKeywordSearchDynamicQuery(20119,keywords));

		renderRequest.setAttribute("userList", userList);
		renderRequest.setAttribute("userListCount", userListCount);
		renderRequest.setAttribute("delta", delta);
	}

	private void addUserToolbarAttributes(RenderRequest renderRequest , RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		UserManagementToolbarDisplayContext userManagementToolbarDisplayContext = new UserManagementToolbarDisplayContext(liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("userManagementToolbarDisplayContext", userManagementToolbarDisplayContext);

	}
	
	
	private DynamicQuery getKeywordSearchDynamicQuery(long groupId, String keyword) {
		//DynamicQuery dynamicQuery = userLocalService.dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));

		  ClassLoader classLoader = getClass().getClassLoader();

	        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(User.class, classLoader);
		
		
		if (Validator.isNotNull(keyword)) {
			Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();

			disjunctionQuery.add(RestrictionsFactoryUtil.like("firstName", "%" + keyword + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("lastName", "%" + keyword + "%"));

			dynamicQuery.add(disjunctionQuery);
		}

		return dynamicQuery;
	}
	
	@Reference
	private Portal _portal;
	
	@Reference
	private UserLocalService userLocalService;

	
	
	
	
	
}
