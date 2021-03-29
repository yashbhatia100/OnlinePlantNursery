package com.cg.onlineplantnursery.planter.dto;

public class UpdatePlanterDrainageHolesRequest {
	int planterId;
	int drainageHoles;
	public int getPlanterId() {
		return planterId;
	}
	public void setPlanterId(int planterId) {
		this.planterId = planterId;
	}
	public int getDrainageHoles() {
		return drainageHoles;
	}
	public void setDrainageHoles(int drainageHoles) {
		this.drainageHoles = drainageHoles;
	}

}
