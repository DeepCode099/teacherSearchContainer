package com.adjecti.user.action;

import com.adjecti.user.constants.*;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + UserPortletKeys.USER,
		"mvc.command.name=" +MVCCommandNames.ADD_USER 
		}, service = MVCActionCommand.class)

public class AddUserMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String screenName = ParamUtil.getString(actionRequest, "screenName");
		String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String password = ParamUtil.getString(actionRequest, "password");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = null;
		try {
			user = UserLocalServiceUtil.addUser(themeDisplay.getUserId(), themeDisplay.getCompanyId(), false, password,
					password, false, screenName, emailAddress, Locale.US, firstName, "", lastName, 0, 0, false, 8, 27,
					1997, "", 1, null, null, null, null, false, new ServiceContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Reference
	private UserLocalService userLocalService;

}
