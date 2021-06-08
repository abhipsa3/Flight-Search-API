package com.aa.flightsearchapi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aa.flightsearchapi.entity.Flight;
import com.aa.flightsearchapi.entity.Flights;
import com.aa.flightsearchapi.exception.NullValueException;
import com.aa.flightsearchapi.service.FlightSearchService;




@RestController
@CrossOrigin("*")
@RequestMapping("/flight_management")
public class FlightController {

	@Autowired
	FlightSearchService flightSearchService;
	
	@GetMapping("/viewAllFlights")
	public Flights getAllFlights() {
		Flights flights = new Flights(flightSearchService.viewAllFlights());
       return flights;
    }
	
	@GetMapping("/getFlightById")
	public Flight getFlightById(@RequestParam String id) {
       return flightSearchService.getFlightById(id);
    }
	
	
	@GetMapping("/getFlightBySourceDestinationDate")
	public List<Flight> getFlightBySourceDestinationDate(@RequestParam String source , @RequestParam String destination, @RequestParam String date) {
		if (source.equals("") || destination.equals("") || date.equals("")) {
			throw new NullValueException("Please provide correct details!");
		}
		return flightSearchService.getFlightBySourceDestinationDate(source, destination, date);
	}
	
	@PostMapping("/addflight")
	public String addFlight(@RequestBody Flight flight) throws Exception {
		return flightSearchService.addFlight(flight);
	}
	
	
	
	
	
}
