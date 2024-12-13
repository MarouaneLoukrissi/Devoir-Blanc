package com.devoirBlanc.service;

import java.util.Objects;
import java.util.Set;

public class Incident {
	private String reference;
	private String time;
	private String status;
	private String identifiant;
	public Incident() {
		
	}
	public Incident(String ref, String time, String status) {
		this.reference = ref;
		this.time = time;
		this.status = status;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		else if (this == null) return false;
		else if(getClass() != obj.getClass()) return false;
		Incident incident = (Incident) obj;
		return Objects.equals(reference, incident.reference);
	}
	@Override
	public int hashCode() {
		return Objects.hash(reference);
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Incident{reference = '" + reference + "', time = '" + time + "', status = '" + status + "'}";
	}
}
