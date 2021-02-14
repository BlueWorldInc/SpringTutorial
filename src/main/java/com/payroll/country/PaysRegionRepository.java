package com.payroll.country;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = InlinePaysRegion.class)
public interface PaysRegionRepository extends PagingAndSortingRepository<PaysRegion, Long> {
	
}


