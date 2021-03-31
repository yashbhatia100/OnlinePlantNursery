package com.cg.onlineplantnursery.dto;

public class UpdatePlanterShapeRequest {
	int planterId;
	String planterShape;
	public int getPlanterId() {
		return planterId;
	}
	public void setPlanterId(int planterId) {
		this.planterId = planterId;
	}
	public String getPlanterShape() {
		return planterShape;
	}
	public void setPlanterShape(String planterShape) {
		this.planterShape = planterShape;
	}
}
