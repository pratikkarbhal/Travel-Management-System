package com.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.entities.Route;


import com.tms.repository.IRouteRepository;

@Service
@Transactional
public class IRouteServiceImpl implements IRouteService {

	@Autowired
	private IRouteRepository rRep;
	//FOR adding report
	@Override
	public Route addRoute(Route route) {
		Route rout = rRep.save(route);
		return rout;
	}

	// for updating Route
	@Override
	public Route updateRoute(Route route){
		Route newRoute = rRep.save(route);
		return newRoute;
	}

	// to search
	@Override
	public Route searchRoute(int routeId){
		Optional<Route> opt = rRep.findById(routeId);
   		Route newRoute = opt.get();
		return newRoute;
	}
		
	// to remove Route
	@Override
	public Route removeRoute(int routeId){
		Route newRoute = searchRoute(routeId);
		rRep.delete(newRoute);
		return newRoute;
	}

	// for viewing all Routes
	@Override
	public List<Route> viewRouteList() {
		List<Route> routeList = rRep.findAll();
		return routeList;
	}

}
