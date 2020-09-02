package com.cg.scheduledprogramservice.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.scheduledprogramservice.entity.ScheduleEntity;
import com.google.common.base.Ticker;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ScheduleRepositoryTest {
  
	@Autowired
	private TestEntityManager entityManger;
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Test
	public void  testSaveSchedule() {
		ScheduleEntity scheduleEntity =getScheduleEntity();
		ScheduleEntity savedInDb= entityManger.persist(scheduleEntity);
		Optional<ScheduleEntity> optionalEntity =  scheduleRepository.findById(savedInDb.getId());
		ScheduleEntity getFromDb = optionalEntity.get();
	
		assertThat(getFromDb).isEqualTo(savedInDb);
	}
	
	@Test
	public void testGetScheduleById()
	{
		ScheduleEntity scheduleEntity =new ScheduleEntity();
		scheduleEntity.setName("Chemical");
		scheduleEntity.setLocation("Bhubhaneswar");
		scheduleEntity.setStartDate(LocalDate.of(2023, 02, 21));
		scheduleEntity.setCertificate("diploma");
		scheduleEntity.setEndDate( LocalDate.of(2026, 02, 21));
		ScheduleEntity savedInDb= entityManger.persist(scheduleEntity);
		Optional<ScheduleEntity> optionalEntity =  scheduleRepository.findById(savedInDb.getId());
		ScheduleEntity getFromDb = optionalEntity.get();
		assertThat(getFromDb).isEqualTo(savedInDb);
	}
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
		
		
		entityManger.persist(scheduleEntity1);
		entityManger.persist(scheduleEntity2);
		
		Iterable<ScheduleEntity> allSchedulesFromDb =scheduleRepository.findAll();
		List<ScheduleEntity> scheduleList =new ArrayList<>();
		for(ScheduleEntity scheduleEntity:allSchedulesFromDb)
		{
			scheduleList.add(scheduleEntity);
		}
		assertThat(scheduleList.size()).isEqualTo(2);
	}
	@Test
	public void testDeleteTicketById()
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
		
		ScheduleEntity persist1= entityManger.persist(scheduleEntity1);
		ScheduleEntity persist2=entityManger.persist(scheduleEntity2);
		entityManger.remove(persist1);
		Iterable<ScheduleEntity> allSchedulesFromDb =scheduleRepository.findAll();
		List<ScheduleEntity> scheduleList =new ArrayList<>();
		for(ScheduleEntity scheduleEntity:allSchedulesFromDb)
		{
			scheduleList.add(scheduleEntity);
		}
		assertThat(scheduleList.size()).isEqualTo(1);
	}
	
	private ScheduleEntity getScheduleEntity()
	{
		ScheduleEntity scheduleEntity =new ScheduleEntity();
		scheduleEntity.setName("Mechanical");
		scheduleEntity.setLocation("Bhubhaneswar");
		scheduleEntity.setStartDate(LocalDate.of(2022, 02, 21));
		scheduleEntity.setCertificate("degree");
		scheduleEntity.setEndDate( LocalDate.of(2024, 02, 21));
		
		return scheduleEntity;
		
	}
	
}
