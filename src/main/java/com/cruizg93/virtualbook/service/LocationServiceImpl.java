package com.cruizg93.virtualbook.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruizg93.virtualbook.model.Location;
import com.cruizg93.virtualbook.repository.LocationRepository;
import com.cruizg93.virtualbook.repository.UserRepository;

@Service("locationService")
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationRepository locationRepository ;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Location findLocationByBuildingName(String buildingName) {
		return locationRepository.findByBuildingName(buildingName);
	}

	@Override
	public List<Location> findLocationByAddress(String address) {
		return locationRepository.findByAddressContaining(address);
	}

	@Override
	public void saveLocation(Location location) {
		location.setStatus(1);
		location.setCreatedDate(new Date());
		if ( location.getCreatedBy() == null ) {
			location.setCreatedBy(userRepository.findByUsername("system"));
		}
		locationRepository.save(location);
	}

}
