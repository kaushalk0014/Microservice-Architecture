package com.customer.event;

import java.util.Date;
import java.util.UUID;

public class CustomerEvent implements Event {

	private UUID eventId=UUID.randomUUID();
	private Date eventDate = new Date();
	private CustomerCreatedSuccess createdSuccess;

	@Override
	public UUID getEventId() {
		return eventId;
	}

	@Override
	public Date getDate() {
		return eventDate;
	}

	public CustomerEvent(CustomerCreatedSuccess createdSuccess) {
		super();
		this.createdSuccess = createdSuccess;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public CustomerCreatedSuccess getCreatedSuccess() {
		return createdSuccess;
	}

	public void setCreatedSuccess(CustomerCreatedSuccess createdSuccess) {
		this.createdSuccess = createdSuccess;
	}

	public void setEventId(UUID eventId) {
		this.eventId = eventId;
	}
	
	
	
	
}
