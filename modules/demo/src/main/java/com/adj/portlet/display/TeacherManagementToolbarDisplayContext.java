package com.adj.portlet.display;

import com.adj.constants.DemoPortletKeys;
import com.adj.constants.MVCCommandNames;
import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.BaseManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItemList;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class TeacherManagementToolbarDisplayContext extends BaseManagementToolbarDisplayContext {

	public TeacherManagementToolbarDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, HttpServletRequest httpServletRequest) {
		super(liferayPortletRequest, liferayPortletResponse, httpServletRequest);
		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
		_themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);

	}
	/**
	 * Returns the creation menu for the toolbar
	 * (plus sign on the management toolbar).
	 *
	 * @return creation menu
	 */
	@Override
	public CreationMenu getCreationMenu() {
		// Creating A New Creation Menu For Adding A New Assignment
		System.out.println("called-->");
		System.out.println("currnet url ->"+currentURLObj.toString());
		return new CreationMenu() {
			{
				addDropdownItem(
					dropdownItem -> {
						dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcRenderCommandName", MVCCommandNames.VIEW_TEACHERS, "redirect", currentURLObj.toString());
						dropdownItem.setLabel(LanguageUtil.get(request, "add-teacher"));
					}
				);
			}
		};
	}
	
	@Override
	public String getClearResultsURL() {
		return getSearchActionURL();
	}

	@Override
	public String getDisplayStyle() {
		// Getting Style Selection From The Clay Management Toolbar
		String displayStyle = ParamUtil.getString(request, "displayStyle");
		System.out.println("display style called ");
		
		if(Validator.isNull(displayStyle)) {
			// We Need To Setup A Default Display Style As Its Null
			displayStyle = _portalPreferences.getValue(DemoPortletKeys.DEMO, "teacher-display-style", "descriptive");
		} 
		else {
			_portalPreferences.setValue(DemoPortletKeys.DEMO, "teacher-display-style", displayStyle);
			
			// Need To Ensure The Cache Is Resetted
			request.setAttribute(WebKeys.SINGLE_PAGE_APPLICATION_CLEAR_CACHE, Boolean.TRUE);
		}
		
		return displayStyle;
	}
	
	/**
	 * Return Order By Columns
	 */
	@Override
	protected String getOrderByCol() {
		return ParamUtil.getString(request, "orderByCol", "age");
	}
	/**
	 * Return Order By Type
	 */
	@Override
	protected String getOrderByType() {
		return ParamUtil.getString(request, "orderByType", "asc");
	}
	
	/**
	 * Returns the action URL for the search.
	 *
	 * @return search action URL
	 */
	@Override
	public String getSearchActionURL() {
		// First I Need Is The URL For The Search
		PortletURL searchURL = liferayPortletResponse.createRenderURL();
		// Setting Up The Paramter Values
		searchURL.setProperty("mvcRenderCommandName", MVCCommandNames.VIEW_TEACHERS);
		String navigation = ParamUtil.getString(request, "navigation", "entries");
		searchURL.setParameter("navigation", navigation);
		searchURL.setParameter("orderByCol", getOrderByCol());
		searchURL.setParameter("orderByType", getOrderByType());
		return searchURL.toString();
	}
	
	@Override
	public List<ViewTypeItem> getViewTypeItems() {
		// First I Need A URL For View References
		PortletURL portletURL = liferayPortletResponse.createRenderURL();
		portletURL.setProperty("mvcRenderCommandName", MVCCommandNames.VIEW_TEACHERS);
		
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
		if (delta > 0) {
			portletURL.setParameter("delta", String.valueOf(delta));
		}
		
		String orderByCol = ParamUtil.getString(request, "orderByCol", "age");
		String orderByType = ParamUtil.getString(request, "orderByType", "decs");

		portletURL.setParameter("orderByCol", orderByCol);
		portletURL.setParameter("orderByType", orderByType);
		
		int cur = ParamUtil.getInteger(request, SearchContainer.DEFAULT_CUR_PARAM);
		if (cur > 0) {
			portletURL.setParameter("cur", String.valueOf(cur));
		}
		
		return new ViewTypeItemList(portletURL, getDisplayStyle()) {
			{
				addCardViewTypeItem();
				addListViewTypeItem();
				addTableViewTypeItem();
			}
		};
	}

	
	/**
	 * Return the option items for the sort column menu.
	 *
	 * @return options list for the sort column menu
	 */
	@Override
	protected List<DropdownItem> getOrderByDropdownItems() {
		return new DropdownItemList() {
			{
				add(
					dropdownItem -> {
						dropdownItem.setActive("age".equals(getOrderByCol()));
						dropdownItem.setHref(getCurrentSortingURL(), "orderByCol", "age");
						dropdownItem.setLabel(LanguageUtil.get(request, "age"));
					}
				);
				add(
					dropdownItem -> {
						dropdownItem.setActive("createDate".equals(getOrderByCol()));
						dropdownItem.setHref(getCurrentSortingURL(), "orderByCol", "createDate");
						dropdownItem.setLabel(LanguageUtil.get(request, "create-date"));
					}
				);
			}
		};
	}
	
	/**
	 * Returns the current sorting URL.
	 *
	 * @return current sorting portlet URL
	 *
	 * @throws PortletException
	 */
	private PortletURL getCurrentSortingURL() throws PortletException {
		PortletURL sortingURL = PortletURLUtil.clone(currentURLObj, liferayPortletResponse);
		sortingURL.setParameter("mvcRenderCommandName", MVCCommandNames.VIEW_TEACHERS);
		
		// Reset My View For Current Sorted View
		sortingURL.setParameter(SearchContainer.DEFAULT_CUR_PARAM, "0");
		
		String keywords = ParamUtil.getString(request, "keywords");
		
		if (Validator.isNotNull(keywords)) {
			sortingURL.setParameter("keywords", keywords);
		}
		
		return sortingURL;
	}
	
	

	private final PortalPreferences _portalPreferences;

	private final ThemeDisplay _themeDisplay;

}
