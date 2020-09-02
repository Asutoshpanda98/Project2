package com.cg.scheduledprogramservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cg.scheduledprogramservice.entity.ScheduleEntity;
import com.cg.scheduledprogramservice.repository.ScheduleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
@RunWith(SpringRunner.class)
@SpringBootTest
class ScheduledProgramServiceApplicationTests {

	
	private MockMvc mockMvc;
	
	private WebApplicationContext context;
	@MockBean
	private ScheduleRepository scheduleRepository;
	
	ObjectMapper om =new ObjectMapper();
	
	
	@Before
	private void setUp() {
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	public void getAllSchedulesTest()
	{
		
	
	}
	@Test
	public void addScheduleTest() throws Exception {
		ScheduleEntity scheduleEntity =new ScheduleEntity();
		scheduleEntity.setName("Mechanical");
		scheduleEntity.setLocation("Bhubhaneswar");
		scheduleEntity.setStartDate(LocalDate.now());
		scheduleEntity.setEndDate( LocalDate.of(2024, 02, 21));
		scheduleEntity.setCertificate("got it");
		String jsonRequest=om.writeValueAsString(scheduleEntity);	
		MvcResult result=mockMvc.perform(post("/schedule/addschedule")
				.content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent =result.getResponse().getContentAsString();

		
		}
	
	@Test
	void contextLoads() {
	}

}
