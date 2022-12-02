package com.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.entities.Booking;
import com.tms.entities.Package;
import com.tms.repository.IBookingRepository;
import com.tms.repository.IPackageRepository;

@Service
@Transactional
public class IPackageServiceImpl implements IPackageService {

	@Autowired
	private IPackageRepository packageRepository;
	
	@Autowired
	private IBookingRepository bookingRepository;
	
	// Used for adding Package
	@Override
	public Package addPackage(Package pack) {
		Package newPack = packageRepository.save(pack);
		return newPack;
	}
	// Used for deleting Package
	@Override
	public Package deletePackage(int packageId){
		Package pack = searchPackage(packageId);
		packageRepository.deleteById(packageId);
		return pack;
	}
	// Used for searching package using package ID
	@Override
	public Package searchPackage(int packageId){
		Optional<Package> opt = packageRepository.findById(packageId);
		Package pack = opt.get();
		return pack;
	}
	// Used for viewing all packages
	@Override
	public List<Package> viewAllPackages() {
		List<Package> packs = packageRepository.findAll();
		return packs;
	}
	
}
