package com.csse.travelpay.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="journey")
public class Journey {
	@Id
	private String journeyId;
	private String passengerId;
	private String busId;
	private String busroot;
	private String jstartloc;
	private String jendloc;
	private Date jstarttime;
	private Date jendtime;
	private String jstatus;
	private double jfare;
	
	public String getJourneyId() {
		return journeyId;
	}
	public void setJourneyId(String journeyId) {
		this.journeyId = journeyId;
	}
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
	}
	public String getBusroot() {
		return busroot;
	}
	public void setBusroot(String busroot) {
		this.busroot = busroot;
	}
	public String getJstartloc() {
		return jstartloc;
	}
	public void setJstartloc(String jstartloc) {
		this.jstartloc = jstartloc;
	}
	public String getJendloc() {
		return jendloc;
	}
	public void setJendloc(String jendloc) {
		this.jendloc = jendloc;
	}
	public Date getJstarttime() {
		return jstarttime;
	}
	public void setJstarttime(Date jstarttime) {
		this.jstarttime = jstarttime;
	}
	public Date getJendtime() {
		return jendtime;
	}
	public void setJendtime(Date jendtime) {
		this.jendtime = jendtime;
	}
	public String getJstatus() {
		return jstatus;
	}
	public void setJstatus(String jstatus) {
		this.jstatus = jstatus;
	}
	public double getJfare() {
		return jfare;
	}
	public void setJfare(double jfare) {
		this.jfare = jfare;
	}
	
}
