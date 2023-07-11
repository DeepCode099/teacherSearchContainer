package cron_job.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;


@Component(
	    immediate = true,
	    property = {
	        "cron.expression= 0 0/05 1/1 1/1 * ?"   // scheduler runs every 5 min.
	    },
	    service = JobSchedular.class
	)
public class JobSchedular extends BaseMessageListener{
	private static Log log = LogFactoryUtil.getLog(JobSchedular.class);
	
	TimeZone timeZone;
	@Override
	protected void doReceive(Message message) throws Exception {
		System.out.println("do Receive method called at 5 mins ");
	}
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) throws SchedulerException {
	 
	    try {
	        String cronExpression = GetterUtil.getString(properties.get("cron.expression"), "cronExpression");
	        log.info(" cronExpression: " + cronExpression);
	 
	        String listenerClass = getClass().getName();
	        Trigger jobTrigger = TriggerFactoryUtil.createTrigger(listenerClass, listenerClass, new Date(), null, cronExpression,timeZone);
	      
	      //  SchedulerEntryImpl schedulerEntryImpl = new SchedulerEntryImpl(listenerClass,jobTrigger);
	      
	       // SchedulerEngineHelperUtil.register(this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
	 
	    } catch (Exception e) {
	        log.error(e);
	    }
	}
	
	
	
	
	

}
