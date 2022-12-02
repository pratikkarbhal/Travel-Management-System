package com.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tms.dto.TravelDetails;
import com.tms.entities.Bus;
import com.tms.entities.Travels;

@Component
public class TravelUtil {

	public TravelDetails toTravelsDetail(Travels travel) {
		TravelDetails travelDetails = new TravelDetails(travel.getTravelsId(), travel.getTravelsName(),
				travel.getAgentName(), travel.getAddress(), travel.getContact());
		Bus bus = travel.getBus();
		if (bus != null) {
			travelDetails.setBusId(bus.getBusId());
		} else {
			travelDetails.setBusId(0);
		}
		return travelDetails;
	}

	public List<TravelDetails> toTravelsDetail(Collection<Travels> travels) {
		List<TravelDetails> desired = new ArrayList<>();
		for (Travels travel : travels) {

			TravelDetails travelDetails = toTravelsDetail(travel);
			desired.add(travelDetails);
		}

		return desired;

	}

}
