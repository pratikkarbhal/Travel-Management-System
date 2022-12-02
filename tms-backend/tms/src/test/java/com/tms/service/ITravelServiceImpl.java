package com.tms.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tms.entities.Travels;

import junit.framework.Assert;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(ITravelsServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ITravelServiceImpl {
	
	@Autowired
	private ITravelsService travelsService;
	
	@Test
	public void testAddTravels() {
		Travels travel = travelsService.addTravels(new Travels(20, "Express Travels", "Rohit", "Mumbai", "7875396886"));
		String outcome = travelsService.addTravels(travel).toString();
		Assert.assertEquals(outcome, "Travels [travelsId=" + travel.getTravelsId() + ", travelsName=" + "Express Travels" + ", agentName=" + "Rohit"
				+ ", address=" + "Mumbai" + ", contact=" + "7875396886" + ", bus=" + "null" + "]");
	}
	
	@Test
	public void testUpdateTravels() {
		Travels travel = travelsService.addTravels(travelsService.addTravels(new Travels(20, "Express Travels", "Rohit", "Mumbai", "7875396886")));
		Travels newTravel = new Travels(travel.getTravelsId(), "Express Travels", "Ramesh", "Pune", "7875396886");
		String outcome = travelsService.searchTravels(travelsService.updateTravels(newTravel).getTravelsId()).toString();
		Assert.assertEquals(outcome, "Travels [travelsId=" + travel.getTravelsId() + ", travelsName=" + "Express Travels" + ", agentName=" + "Ramesh"
				+ ", address=" + "Pune" + ", contact=" + "7875396886" + ", bus=" + "null" + "]");
	}
	
	@Test
	public void testRemoveTravels() {
		Travels travel = travelsService.addTravels(travelsService.addTravels(new Travels(20, "Express Travels", "Rohit", "Mumbai", "7875396886")));
		Assert.assertEquals(travel, travelsService.removeTravels(travel.getTravelsId()));
	}
	
	@Test
	public void testSearchTravels() {
		Travels travel = travelsService.addTravels(travelsService.addTravels(new Travels(20, "Express Travels", "Rohit", "Mumbai", "7875396886")));
		Assert.assertEquals(travel, travelsService.searchTravels(travel.getTravelsId()));
	}
	
	@Test
	public void testViewTravels() {
		Travels travel1 = travelsService.addTravels(travelsService.addTravels(new Travels("Express Travels", "Rohit", "Mumbai", "7875396886")));
		Travels travel2 = travelsService.addTravels(travelsService.addTravels(new Travels("Express Travels", "Rohit", "Mumbai", "7875396886")));
		String outcome = travelsService.viewTravels().toString();
		Assert.assertEquals(outcome, travelsService.viewTravels().toString());
	}
}
