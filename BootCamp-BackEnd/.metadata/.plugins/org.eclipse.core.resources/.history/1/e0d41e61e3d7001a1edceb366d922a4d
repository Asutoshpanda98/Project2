package com.cg.scheduledprogramservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.scheduledprogramservice.entity.ScheduleEntity;
import com.cg.scheduledprogramservice.service.ScheduleService;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

@RestController
@RequestMapping("/schedule")
public class ScheduleController 
{
	private static final Logger Logger = org.apache.log4j.Logger.getLogger(ScheduleController.class);
	
	@Autowired
	private ScheduleService scheduleService;
	
	
	
	@GetMapping ("/getallschedules")
	public  Iterable<ScheduleEntity> getAllSchedules() {
		
		return this.scheduleService.getAllSchedules();
	}

	
	@GetMapping("/getschedulebyid/{id}")
	public Optional<ScheduleEntity> getScheduleById(@PathVariable("id") String id)
	{
		return this.scheduleService.getScheduleById(id);
	}
	
	@PostMapping("/addschedule")
	public void addSchedule(@RequestBody ScheduleEntity scheduleEntity)
	{
		scheduleService.addSchedule(scheduleEntity);
	}

	
	@RequestMapping(method = RequestMethod.PUT,value="/updateschedule/{id}")
	public void updateScheduleById(@RequestBody ScheduleEntity scheduleEntity,@PathVariable("id") String id)
	{
	   scheduleService.updateScheduleById(id,scheduleEntity);	
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/deleteschedule/{id}")
	public void delteScheduleById(@PathVariable("id") String id)
	{
	   scheduleService.deleteSchedulebyId(id);	
	}
	
	

	
	  
	
	

}
