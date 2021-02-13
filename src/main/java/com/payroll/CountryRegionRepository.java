package com.payroll;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

// public interface CountryRegionRepository extends CrudRepository<CountryRegion, Long> {
	
// }

public interface CountryRegionRepository extends PagingAndSortingRepository<CountryRegion, Long> {
	
}

