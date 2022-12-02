package com.tms.service;

import java.util.List;
import com.tms.entities.Package;

public interface IPackageService {
	
	public Package addPackage(Package pack);
	public Package deletePackage(int packageId);
	public Package searchPackage(int packageId);
	public List<Package> viewAllPackages();

}
