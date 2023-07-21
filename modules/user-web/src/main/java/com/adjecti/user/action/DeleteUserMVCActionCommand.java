package com.adjecti.user.action;

import com.adjecti.user.constants.*;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + UserPortletKeys.USER,
		"mvc.command.name=" + com.adjecti.user.constants.MVCCommandNames.DELETE_USER}, service = MVCActionCommand.class)

public class DeleteUserMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
