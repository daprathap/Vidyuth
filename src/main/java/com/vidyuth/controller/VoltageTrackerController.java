package com.vidyuth.controller;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;

import com.vidyuth.db.VoltagesDB;
import com.vidyuth.dto.BaseRestResponse;
import com.vidyuth.dto.ListWrapper;
import com.vidyuth.dto.VoltageSummary;
import com.vidyuth.dto.Voltages;
import com.vidyuth.helper.VoltageHelper;

@Controller
public class VoltageTrackerController {
	@Autowired
	private VoltageMongoRepository voltageMongoRepository;
	
	@Autowired
	private VoltageRepository voltageRepository;
	
	@RequestMapping(value="voltages",method=RequestMethod.GET)
	public @ResponseBody BaseRestResponse postData1(@RequestParam float volt,float ampere){
		try{
			
			VoltagesDB voltDB = VoltageHelper.createVoltageDB(volt,ampere);
			voltageMongoRepository.save(voltDB);
			return new BaseRestResponse(200, "Voltage Created successfully!");
		}catch(Exception ex){
			return new BaseRestResponse(500, "Internal Server Error Occured");
		}

	}
	
	@RequestMapping(value="voltages",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public @ResponseBody BaseRestResponse postData(@RequestBody Voltages volt){
		try{
			VoltagesDB voltDB = VoltageHelper.createVoltageDB(volt);
			voltageMongoRepository.save(voltDB);
			return new BaseRestResponse(200, "Voltage Created successfully!");
		}catch(Exception ex){
			return new BaseRestResponse(500, "Internal Server Error Occured");
		}

	}
	
	@RequestMapping(value="voltagesDaily",method=RequestMethod.GET)
	public @ResponseBody ListWrapper<VoltageSummary> dailySummary(){
		try{
			
			
			VoltageSummary summary=null;
			ListWrapper<VoltageSummary>  response= new ListWrapper<VoltageSummary>(VoltageSummary.class);
			String fiveAM = new DateTime().withTimeAtStartOfDay().plusHours(5).withZone(DateTimeZone.forID("UTC")).toString();
			String tenAM = new DateTime().withTimeAtStartOfDay().plusHours(10).withZone(DateTimeZone.forID("UTC")).toString();
			summary = voltageRepository.dailyVoltages(fiveAM, tenAM);
			if(summary!=null){
				summary.setName("5 AM-10AM");
				response.add(summary);
			}
			String threePM = new DateTime().withTimeAtStartOfDay().plusHours(15).withZone(DateTimeZone.forID("UTC")).toString();
			summary = voltageRepository.dailyVoltages(tenAM, threePM);
			if(summary!=null){
				summary.setName("10AM - 3PM");
				response.add(summary);
			}
			
			String sevenPM = new DateTime().withTimeAtStartOfDay().plusHours(19).withZone(DateTimeZone.forID("UTC")).toString();
			summary = voltageRepository.dailyVoltages(threePM, sevenPM);
			if(summary!=null){
				summary.setName("3PM - 7PM");
				response.add(summary);
			}
			return response;
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RestClientException("Internal Error");
		}
	}
	
    @RequestMapping(value ="hello")
    public String greeting(Model model){
    	//model.addAttribute("name", "Graph");
    	return "dailyGraph";
    }
	
	
	public static void main(String args[]){
		System.out.println(new DateTime().withTimeAtStartOfDay().plusHours(5).withZone(DateTimeZone.forID("UTC")));
		System.out.println(new DateTime(DateTimeZone.UTC).withTimeAtStartOfDay().plusHours(10));
	}

}
