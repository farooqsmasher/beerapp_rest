package com.webteam_rest.util;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * This utility is to generate components for Google Analytics.
 * @author platform
 *
 */
public class GAUtil {

	static Logger logger = Logger.getLogger(GAUtil.class);
	
	public enum GA_EventCategory { email }
	public enum GA_EventAction { sent, opened }
	public enum GA_CampaignMedium { email }
	

	/**
	 * Build the GA url
	 * @param eventAction
	 * @param recipient
	 * @param orderId
	 * @param companyCode
	 * @param campaignName
	 * @return
	 */
	public static String buildEventUrl(GA_EventAction eventAction, 
			String recipient, String orderId, String companyCode, String campaignName,String gaURL,String gaTrackingId){
		try {
			StringBuffer url = new StringBuffer(gaURL)
					.append("&cid=").append(URLEncoder.encode(companyCode,"UTF-8"))
					.append("&tid=").append(URLEncoder.encode(gaTrackingId,"UTF-8"))
					.append("&t=event")
					.append("&ec=").append(GA_EventCategory.email)
					.append("&ea=").append(eventAction)
					.append("&el=").append(URLEncoder.encode(recipient,"UTF-8"))
					.append("&cn=").append(URLEncoder.encode(campaignName,"UTF-8"))
					.append("&cs=invite")
					.append("&cn=").append(GA_CampaignMedium.email)
					.append("&ci=").append(URLEncoder.encode(orderId,"UTF-8"));
			return url.toString();
		} catch (Exception e) {
			logger.error("", e);
			return null;
		}
	}
	
	
	/**
	 * Build GA url and log event.
	 * @param eventAction
	 * @param recipient
	 * @param orderId
	 * @param companyCode
	 * @param campaignName
	 * @return
	 */
	public static boolean sendEvent(GA_EventAction eventAction, 
			String recipient, String orderId, String companyCode, String campaignName,String gaURL,String gaTrackingId){
		try {

			StringBuffer url = new StringBuffer(gaURL)
					.append("&cid={companyCode}")
					.append("&tid={gaTrackingId}")
					.append("&t=event")
					.append("&ec={eventCategory}")
					.append("&ea={eventAction}")
					.append("&el={eventLabel}")
					.append("&cn={campaignName}")
					.append("&cs={campaignSource}")
					.append("&cm={campaignMedium}")
					.append("&ci={campaignId}");
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("gaTrackingId", gaTrackingId);
			params.put("companyCode", companyCode);
			params.put("eventCategory", GA_EventCategory.email);
			params.put("eventAction", eventAction);
			params.put("eventLabel", recipient);
			params.put("campaignName", campaignName);
			params.put("campaignSource", "invite");
			params.put("campaignMedium", GA_CampaignMedium.email);
			params.put("campaignId", orderId);

			RestTemplate template = new RestTemplate();
			ResponseEntity<String> response = template.getForEntity(url.toString(), String.class, params);

			if( response!=null ){
				logger.info("StatusCode: " + response.getStatusCode());
			}
			return true;
		} catch (Exception e) {
			logger.error("", e);
			return false;
		}
	}

		


}
