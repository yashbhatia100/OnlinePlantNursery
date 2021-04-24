package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddPlanterRequest {
	@NotNull
	private float planterHeight;
	@NotNull
	private int planterCapacity;
	@NotNull
	private int drainageHoles;
	@NotNull
	private int planterColor;
	@NotBlank
	private String planterShape;
	@NotNull
	private int planterStock;
	@NotNull
	private int planterCost;
	@NotNull
	private int plantId;
	@NotNull
	private int seedId;

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public int getSeedId() {
		return seedId;
	}

	public void setSeedId(int seedId) {
		this.seedId = seedId;
	}

	public float getPlanterHeight() {
		return planterHeight;
	}

	public void setPlanterHeight(float planterHeight) {
		this.planterHeight = planterHeight;
	}

	public int getPlanterCapacity() {
		return planterCapacity;
	}

	public void setPlanterCapacity(int planterCapacity) {
		this.planterCapacity = planterCapacity;
	}

	public int getDrainageHoles() {
		return drainageHoles;
	}

	public void setDrainageHoles(int drainageHoles) {
		this.drainageHoles = drainageHoles;
	}

	public int getPlanterColor() {
		return planterColor;
	}

	public void setPlanterColor(int planterColor) {
		this.planterColor = planterColor;
	}

	public String getPlanterShape() {
		return planterShape;
	}

	public void setPlanterShape(String planterShape) {
		this.planterShape = planterShape;
	}

	public int getPlanterStock() {
		return planterStock;
	}

	public void setPlanterStock(int planterStock) {
		this.planterStock = planterStock;
	}

	public int getPlanterCost() {
		return planterCost;
	}

	public void setPlanterCost(int planterCost) {
		this.planterCost = planterCost;
	}

}
