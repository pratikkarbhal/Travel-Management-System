package com.tms.controller;

import com.tms.entities.Package;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tms.service.IPackageService;

@RestController
@RequestMapping("/package")
@Validated
@CrossOrigin(origins = "http://localhost:3000")
public class PackageController {
	
	@Autowired
	private IPackageService packService;
	// Used for testing
	@RequestMapping("/hello")
	public String feedbackGreet() {
		return "Hello from Package!";
	}
	// Used for adding Package
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public Package addPackage(@RequestBody Package request) {
	return packService.addPackage(request);
	}
	
	// Used for deleting package for package ID
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public Package deletePackage(@PathVariable("id") Integer packageId) {
		return packService.deletePackage(packageId);
	}
	
	// Used for viewing package by package ID
	@GetMapping("/view/{id}")
	public Package searchPackage(@PathVariable("id")Integer packageId)  {
		return packService.searchPackage(packageId);
	}
	
	// Used for viewing all packages 
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/all")
	public List<Package> viewAllPackages()  {
		return packService.viewAllPackages();
	}
}