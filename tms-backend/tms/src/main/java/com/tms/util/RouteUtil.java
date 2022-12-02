package com.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tms.dto.RouteDetails;
import com.tms.entities.Route;

@Component
public class RouteUtil {

	public RouteDetails toRouteDetail(Route route) {
		RouteDetails routeDetails = new RouteDetails(route.getRouteId(),route.getRouteFrom(),route.getRouteTo(),route.getDepartureTime(),route.getArrivalTime(),route.getDoj(),route.getPickupPoint(),route.getFare());
		return routeDetails;
	}
	
	public List<RouteDetails> toRouteDetail(Collection<Route> routes)
	{
		List<RouteDetails> desired = new ArrayList<>();
		for (Route route : routes) {

			RouteDetails routeDetails = toRouteDetail(route);
			desired.add(routeDetails);
		}
		return desired;
	}
}
