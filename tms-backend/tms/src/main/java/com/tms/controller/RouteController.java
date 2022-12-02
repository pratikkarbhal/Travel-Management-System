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

import com.tms.dto.RouteDetails;
import com.tms.dto.RouteRequest;
import com.tms.entities.Route;
import com.tms.service.IRouteService;
import com.tms.util.RouteUtil;

@RestController
@RequestMapping("/route")
@Validated
@CrossOrigin(origins = "http://localhost:3000")
public class RouteController {

	@Autowired
	private IRouteService rService;

	@Autowired
	private RouteUtil routeUtil;

	// Used for testing
	@RequestMapping("/hello")
	public String feedbackGreet() {
		return "Hello from feedback";
	}

	// Used for adding Route
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/add")
	public RouteDetails addRoute(@RequestBody @Valid RouteRequest requestData) {
		Route rout = new Route(requestData.getRouteFrom(), requestData.getRouteTo(), requestData.getDepartureTime(),
				requestData.getArrivalTime(), requestData.getDoj(), requestData.getPickupPoint(),
				requestData.getFare());
		
		Route route = rService.addRoute(rout);
		RouteDetails routeDetails = routeUtil.toRouteDetail(route);
		return routeDetails;
	}

	// Used for updating Route
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/update/{id}")
	public RouteDetails updateRoute(@RequestBody @Valid RouteRequest requestData,
			@PathVariable("id") @Min(1) int routeId) {
		Route rout = new Route(requestData.getRouteFrom(), requestData.getRouteTo(), requestData.getDepartureTime(),
				requestData.getArrivalTime(), requestData.getDoj(), requestData.getPickupPoint(),
				requestData.getFare());
		
		rout.setRouteId(routeId);
		Route route = rService.addRoute(rout);
		RouteDetails routeDetails = routeUtil.toRouteDetail(route);
		return routeDetails;
	}

	// Used for deleting Route
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public RouteDetails deleteRoute(@PathVariable("id") @Min(1) Integer routeId){
		Route route = rService.removeRoute(routeId);
		RouteDetails routeDetails = routeUtil.toRouteDetail(route);
		return routeDetails;
	}

	// Used for searching route using route ID
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
	public RouteDetails searchRoute(@PathVariable("id") @Min(1) Integer routeId) {
		Route route = rService.searchRoute(routeId);
		RouteDetails routeDetails = routeUtil.toRouteDetail(route);
		return routeDetails;
	}

	// Used for viewing all Routes
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/all")
	public List<RouteDetails> viewRouteList() {
		List<Route> routes = rService.viewRouteList();
		List<RouteDetails> routeDetails = routeUtil.toRouteDetail(routes);
		return routeDetails;
	}

}
