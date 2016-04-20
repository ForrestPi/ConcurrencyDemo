/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import java.util.Date;

/**
 *
 * @author Win7
 */
public class Event {
    /**
	 * Date of the event
	 */
	private Date date;
	
	/**
	 * Message of the event
	 */
	private String event;
	
	/**
	 * Reads the Date of the event
	 * @return the Date of the event
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * Writes the Date of the event
	 * @param date the date of the event
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * Reads the message of the event
	 * @return the message of the event
	 */
	public String getEvent() {
		return event;
	}
	
	/**
	 * Writes the message of the event
	 * @param event the message of the event
	 */
	public void setEvent(String event) {
		this.event = event;
	}
    
}
