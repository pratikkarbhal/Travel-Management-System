package com.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;
import com.tms.dto.PackageDetails;
import com.tms.entities.Booking;
import com.tms.entities.Hotel;
import com.tms.entities.Package;

@Component
public class PackageUtil {

	public PackageDetails toDetailsPackage(Package pack)
	{
		PackageDetails packageDetails = new PackageDetails(pack.getPackageId(), pack.getPackageName(), pack.getPackageDescription(), pack.getPackageType(), pack.getPackageCost());
		Hotel hot = pack.getHotel();
		if(hot!=null) {
			packageDetails.setHotelId(hot.getHotelId());		
		}
		return packageDetails;
	}
	
	
	public List<PackageDetails> toDetailsPackages(Collection<Package> packages) {

        List<PackageDetails> packs = new ArrayList<>();
        for (Package pack : packages) {

            PackageDetails packageDetails = toDetailsPackage(pack);
            packs.add(packageDetails);
        }

        return packs;

    }
}
