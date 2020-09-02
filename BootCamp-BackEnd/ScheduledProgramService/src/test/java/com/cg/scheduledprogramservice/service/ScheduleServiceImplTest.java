package com.cg.scheduledprogramservice.service;

import static org.assertj.core.api.Assertions.assertThat;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.scheduledprogramservice.entity.ScheduleEntity;
import com.cg.scheduledprogramservice.repository.ScheduleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleServiceImplTest 
{
	@Autowired
	private ScheduleService scheduleService;
	
    @MockBean
	private ScheduleRepository scheduleRepository;

    @Test
    public void testAddSchedule()
    {
    	ScheduleEntity scheduleEntity =new ScheduleEntity();
    	scheduleEntity.setId(1);
		scheduleEntity.setName("Mechanical");
		scheduleEntity.setLocation("Bhubhaneswar");
		scheduleEntity.setStartDate(LocalDate.of(2022, 02, 21));
		scheduleEntity.setCertificate("degree");
		scheduleEntity.setEndDate( LocalDate.of(2024, 02, 21));
		Mockito.when(scheduleRepository.save(scheduleEntity)).thenReturn(scheduleEntity);
		assertThat(scheduleService.addSchedule(scheduleEntity)).isEqualTo(scheduleEntity);
    }
    
//    @Test
//    public void testGetScheduleById()
//    {
//    	ScheduleEntity scheduleEntity =new ScheduleEntity();
//    	scheduleEntity.setId(1);
//		scheduleEntity.setName("Mechanical");
//		scheduleEntity.setLocation("Bhubhaneswar");
//		scheduleEntity.setStartDate(LocalDate.of(2022, 02, 21));
//		scheduleEntity.setCertificate("degree");
//		scheduleEntity.setEndDate( LocalDate.of(2024, 02, 21));
//	
//		Optional<ScheduleEntity> optionalEntity =  scheduleRepository.findById(1);
//		Mockito.when(optionalEntity).thenReturn(scheduleEntity);
//		assertThat(scheduleService.getScheduleById(1)).isEqualTo(scheduleEntity);
//		
//    }
    @Test
    public void testGetAllSchedules()
    {
    	ScheduleEntity scheduleEntity1 =new ScheduleEntity();
		scheduleEntity1.setName("Mechanical");
		scheduleEntity1.setLocation("Bhubhaneswar");
		scheduleEntity1.setStartDate(LocalDate.of(2022, 02, 21));
		scheduleEntity1.setCertificate("degree");
		scheduleEntity1.setEndDate( LocalDate.of(2024, 02, 21));
		
		ScheduleEntity scheduleEntity2 =new ScheduleEntity();
		scheduleEntity2.setName("Chemical");
		scheduleEntity2.setLocation("Bhubhaneswar");
		scheduleEntity2.setStartDate(LocalDate.of(2021, 02, 21));
		scheduleEntity2.setCertificate("diploma");
		scheduleEntity2.setEndDate( LocalDate.of(2025, 02, 21));
		
		List<ScheduleEntity> scheduleList =new ArrayList<>();
		scheduleList.add(scheduleEntity1);
		scheduleList.add(scheduleEntity2);
		
		Mockito.when(scheduleRepository.findAll()).thenReturn(scheduleList);
		assertThat(scheduleService.getAllSchedules()).isEqualTo(scheduleList);
		
    }
    
}
