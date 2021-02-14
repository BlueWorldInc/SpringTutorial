package com.payroll.country;

import java.util.List;

// import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface RegionRepository extends PagingAndSortingRepository<Region, Long>
// public interface RegionRepository extends PagingAndSortingRepository<Region, Long>, QuerydslPredicateExecutor<Region>, QuerydslBinderCustomizer<QUser>
{

	// @RestResource(path="searchByName", rel="searchByName")
	// default String abc() {
	// 	return "hey";
	// }

	List<Region> findByCountryCode(@Param("code") String code);

	List<Region> findByRegionName(@Param("name") String name);

}


