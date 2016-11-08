package com.rft.repositories;


	
	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;

	import com.rft.entities.Manufacturer;

	public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
		Manufacturer findByManufacturername(String categoryname);
		Manufacturer findByManufacturerid(long categoryid);
		List<Manufacturer> findAll();

}
