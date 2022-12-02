package com.tms.service;

import java.util.List;

import com.tms.entities.Route;

public interface IRouteService {
	
	public Route addRoute(Route route);
	public Route updateRoute(Route route);
	public Route removeRoute(int routeId);
	public Route searchRoute(int routeId);
	public List<Route> viewRouteList();

}
