package com.cg.onlineplantnursery.planter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnursery.planter.entity.Planter;

@Repository
public interface IPlanterRepository extends JpaRepository<Planter, Integer> {

	@Query("from Planter where planterShape=:planterShapeArgs")
	List<Planter> viewPlanter(@Param("planterShapeArgs") String planterShape);

	@Query("from Planter")
	List<Planter> viewAllPlanters();

	@Query("from Planter where planterCost>=:minCost and planterCost<=:maxCost")
	List<Planter> viewAllPlanters(@Param("minCost") double minCost, @Param("maxCost") double maxCost);


}
