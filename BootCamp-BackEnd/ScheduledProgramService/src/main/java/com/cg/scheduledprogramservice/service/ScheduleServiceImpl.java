package com.cg.scheduledprogramservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.dao.TransientDataAccessException;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.stereotype.Service;

import com.cg.scheduledprogramservice.entity.ScheduleEntity;
import com.cg.scheduledprogramservice.exception.CrudException;
import com.cg.scheduledprogramservice.exception.ResourceNotFoundException;
import com.cg.scheduledprogramservice.repository.ScheduleRepository;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;

	private String dataAccessException = "distributed transaction exception!";
	private String scriptException = "Not well-formed script or error SQL command exception!";
	private String transientDataAccessException = "database timeout! exception!";

	
	/*
	 * name - getAllSchedules()
	 * description - It will show all the schedule present in the Schedule Repository
	 */
	@Override
	public List<ScheduleEntity> getAllSchedules()  {
		
		return (List<ScheduleEntity>) scheduleRepository.findAll();
	}

	/*
	 * name - getScheduleById()
	 * description - It will show Schedule present in the database if id
	 *                is a valid
	 */
	@Override
	public Optional<ScheduleEntity> getScheduleById(int id) {
		if (scheduleRepository.existsById(id)) {

			return scheduleRepository.findById(id);
		} else {

			throw new ResourceNotFoundException("Id not found,please provide a valid Id");
		}
	}

	/*
	 * name - addSchedule()
	 * description - It will show Schedule present in the database if id
	 *                is a valid
	 */
	@Override
	public ScheduleEntity addSchedule(ScheduleEntity scheduleEntity) {
		try {
			return scheduleRepository.save(scheduleEntity);
		} catch (RecoverableDataAccessException e) {

			throw new CrudException(dataAccessException);
		} catch (ScriptException e) {

			throw new CrudException(scriptException);

		} catch (TransientDataAccessException e) {

			throw new CrudException(transientDataAccessException);
		}
	}
	/*
	 * name -updateScheduleById()
	 * description - It will show update the schedule present in the database if id
	 *                is a valid
	 */

	@Override
	public void updateScheduleById(int id, ScheduleEntity scheduleEntity) {
		if (scheduleRepository.existsById(id)) {
			try {

				scheduleRepository.save(scheduleEntity);

			} catch (RecoverableDataAccessException e) {

				throw new CrudException(dataAccessException);
			} catch (ScriptException e) {

				throw new CrudException(scriptException);

			} catch (TransientDataAccessException e) {

				throw new CrudException(transientDataAccessException);
			}
		} else {
			throw new ResourceNotFoundException("Id not found,please provide a valid Id");

		}
	}
	/*
	 * name -deleteScheduleById()
	 * description - It will delete  the schedule present in the database if id
	 *                is a valid
	 */


	@Override
	public void deleteSchedulebyId(int id) {
		if (scheduleRepository.existsById(id)) {
			try {
				scheduleRepository.deleteById(id);
			} catch (RecoverableDataAccessException e) {

				throw new CrudException(dataAccessException);
			} catch (ScriptException e) {

				throw new CrudException(scriptException);

			} catch (TransientDataAccessException e) {

				throw new CrudException(transientDataAccessException);
			}
		} else {
			throw new ResourceNotFoundException("Id not found,please provide a valid Id");
		}
	}

}
