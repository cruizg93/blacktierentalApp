package com.cruizg93.virtualbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cruizg93.virtualbook.model.Location;

@Repository("locationRepository")
public interface LocationRepository extends JpaRepository<Location, Long> {
	
	Location findByBuildingName(String buildingName);
	List<Location> findByAddressContaining(String address);
	Location findByPhoneNumber(String phoneNumber);
	List<Location> findByCity(String city);
	List<Location> findByZipcode(int zipcode);
}
