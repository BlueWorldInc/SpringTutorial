package com.payroll.country;

// import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
// import org.springframework.web.bind.annotation.CrossOrigin;

// public interface CountryRegionRepository extends CrudRepository<CountryRegion, Long> {
	
// }

public interface CountryRegionRepository extends PagingAndSortingRepository<CountryRegion, Long> {
	
}

