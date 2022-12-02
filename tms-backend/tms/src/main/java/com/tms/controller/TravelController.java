package com.tms.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tms.dto.TravelDetails;
import com.tms.dto.TravelRequest;
import com.tms.entities.Bus;
import com.tms.entities.Travels;
import com.tms.service.ITravelsService;
import com.tms.util.TravelUtil;

@RestController
@RequestMapping("/travels")
@Validated
@CrossOrigin(origins = "http://localhost:3000")
public class TravelController {

	@Autowired
	private ITravelsService tService;

	@Autowired
	private TravelUtil travelUtil;

	// Used for Testing
	@RequestMapping("/hello")
	public String feedbackGreet() {
		return "Hello from Travel";
	}

	// Used for adding Travels
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public TravelDetails addTravels(@RequestBody @Valid TravelRequest requestData) {
		Travels trav = new Travels(requestData.getTravelsName(), requestData.getAgentName(), requestData.getAddress(),
				requestData.getContact());
		if (requestData.getBus() != null) {
			trav.setBus(requestData.getBus());
		}
		Travels added = tService.addTravels(trav);
		TravelDetails travelDetails = travelUtil.toTravelsDetail(added);
		return travelDetails;

	}

	// Used for updating Travels using Travel ID
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/update/{id}")
	public TravelDetails updateTravels(@RequestBody @Valid TravelRequest requestData, @PathVariable @Min(1) int id){
		Travels trav = new Travels(requestData.getTravelsName(), requestData.getAgentName(), requestData.getAddress(),
				requestData.getContact());
		trav.setTravelsId(id);
		Travels travel = tService.updateTravels(trav);
		TravelDetails travelDetails = travelUtil.toTravelsDetail(travel);
		return travelDetails;

	}

	// Used for deleting Travels
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public TravelDetails deleteTravels(@PathVariable("id") @Min(1) Integer travelId){
		Travels travel = tService.removeTravels(travelId);
		TravelDetails travelDetails = travelUtil.toTravelsDetail(travel);
		return travelDetails;
	}

	// Used for searching Travels
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
	public TravelDetails searchTravels(@PathVariable("id") @Min(1) Integer travelId){
		Travels travel = tService.searchTravels(travelId);
		TravelDetails travelDetails = travelUtil.toTravelsDetail(travel);
		return travelDetails;

	}

	// Used for viewing all Travels
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/all")
	public List<TravelDetails> viewTravels() {
		List<Travels> travels = tService.viewTravels();
		List<TravelDetails> travelDetails = travelUtil.toTravelsDetail(travels);
		return travelDetails;

	}

}
