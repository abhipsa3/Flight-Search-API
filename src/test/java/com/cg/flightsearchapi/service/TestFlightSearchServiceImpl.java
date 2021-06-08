package com.cg.flightsearchapi.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aa.flightsearchapi.entity.Flight;
import com.aa.flightsearchapi.repository.FlightRepository;
import com.aa.flightsearchapi.service.FlightSearchServiceImpl;

public class TestFlightSearchServiceImpl {

	@InjectMocks
	private FlightSearchServiceImpl service;

	@Mock
	private FlightRepository repository;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	
	
	@Test
	public void getAllFlightsTest() {

		List<Flight> flights = new ArrayList<>();
		flights.add(new Flight("1", "GOAIR A36", "BBS", "MUM", "03-02-2021", 6000));
		flights.add(new Flight("3", "INDIGO B415", "KOL", "BLR", "15-01-201", 7000));
		when(repository.findAll()).thenReturn(flights);
		assertNotNull(service.viewAllFlights());

	}

	@Test
	public void getFlightBySourceDestinationDateTest() {
		when(repository.findBySourceDestinationDate("BBS", "MUM", "03-02-2021")).thenReturn((List<Flight>) Stream
				.of(new Flight("1", "GOAIR A36", "BBS", "MUM", "03-02-2021", 6000)).collect(Collectors.toList()));

		assertEquals(1, service.getFlightBySourceDestinationDate("BBS", "MUM", "03-02-2021").size());
	}

	@Test
	public void addFlightTest() throws Exception {
		Flight flight = new Flight("99", "GOAIR 999", "BBS", "BLR", "03-02-2021", 4000);
		when(repository.save(flight)).thenReturn(flight);

		assertEquals("flight "+flight.getFlightName()+"is UP!", service.addFlight(flight));

	}
}
