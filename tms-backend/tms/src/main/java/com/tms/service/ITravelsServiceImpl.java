package com.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.entities.Travels;
import com.tms.repository.ITravelRepository;

@Service
@Transactional
public class ITravelsServiceImpl implements ITravelsService {

	@Autowired
	private ITravelRepository travelRepository;
	// Used for adding Travels
	@Override
	public Travels addTravels(Travels travels) {
		Travels travel = travelRepository.save(travels);
		return travel;
	}
	// Used for Updating Travels
	@Override
	public Travels updateTravels(Travels travels) {
		Travels travel = travelRepository.save(travels);
		return travel;
	}
	// Used for removing Travels using travel ID
	@Override
	public Travels removeTravels(int travelsId) {
		Optional<Travels> optional = travelRepository.findById(travelsId);
		Travels travel = optional.get();
		travelRepository.delete(travel);
		return travel;
	}
	// Used for searching Travels using Travels ID
	@Override
	public Travels searchTravels(int travelsId) {
		Optional<Travels> optional = travelRepository.findById(travelsId);
		Travels travel = optional.get();
		return travel;
	}
	// Used for viewing all Travels
	@Override
	public List<Travels> viewTravels() {
		List<Travels> travelsList = travelRepository.findAll();
		return travelsList;
	}

}
