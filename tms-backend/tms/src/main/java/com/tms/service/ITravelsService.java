package com.tms.service;

import com.tms.entities.Travels;

import java.util.List;

public interface ITravelsService {
	
    public Travels addTravels(Travels travels);
    public Travels updateTravels(Travels travels);
    public Travels removeTravels(int travelsId);
    public Travels searchTravels(int travelsId);
    public List<Travels> viewTravels();
    
}
