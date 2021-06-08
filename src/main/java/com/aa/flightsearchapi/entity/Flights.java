package com.aa.flightsearchapi.entity;

import java.util.List;

public class Flights {
	
	private List<Flight> flights;

	
	public Flights() {
	
	}
	

	public Flights(List<Flight> flights) {
		super();
		this.flights = flights;
	}


	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
}
