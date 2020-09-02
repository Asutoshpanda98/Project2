package com.cg.scheduledprogramservice.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Schedule_Table_representation")
public class ScheduleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@NotNull
	@Size(min =3, max = 100, message = "Name should have atleast 2 characters and at most 100 characters")
	@Column(name = "Schedule_Name")
	private String name;
	@NotNull
	@Size(min = 2, max = 120, message = "location should have atleast 2 characters and at most 120 characters")
	@Column(name = "Location")
	private String location;
	@Future
	@Column(name = "Start_Date_Of_Program")
	private LocalDate startDate;
	@Future
	@Column(name = "End_Date_Of_Program")
	private LocalDate endDate;
	@NotNull
	@Column(name = "Certificate")
	private String certificate;

	@AssertTrue(message = "start date field should be lesser than end date field")
	private boolean isValid() {
		if (startDate == null || endDate == null)
			return false;
		if (startDate.isBefore(endDate)) {
			return true;
		} else {
			return false;
		}
	}

	public ScheduleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScheduleEntity(int id, String name, String location, LocalDate startDate, LocalDate endDate,
			String certificate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.certificate = certificate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	@Override
	public String toString() {
		return "ScheduleEntity [id=" + id + ", name=" + name + ", location=" + location + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", certificate=" + certificate + "]";
	}

}
