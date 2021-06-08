package com.cg.flightsearchapi;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aa.flightsearchapi.FlightSearchApiApplication;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlightSearchApiApplication.class)
class TestFlightSearchApiApplication {

	@Test
	public void contextLoads() {
		assertTrue(true);
	}
}
