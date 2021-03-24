package com.cg.onlineplantnursery.planter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnursery.planter.entity.Planter;
@Repository
public interface IPlanterRepository extends JpaRepository<Planter, Integer> {
	List<Planter> viewAllPlanters();

	List<Planter> viewAllPlanters(double minCost, double maxCost);
}
