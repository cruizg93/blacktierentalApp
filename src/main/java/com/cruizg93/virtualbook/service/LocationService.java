package com.cruizg93.virtualbook.service;

import java.util.List;

import com.cruizg93.virtualbook.model.Location;

public interface LocationService {
	
	public Location findLocationByBuildingName(String buildingName);
	public List<Location> findLocationByAddress(String address);
	public void saveLocation(Location location);
}
