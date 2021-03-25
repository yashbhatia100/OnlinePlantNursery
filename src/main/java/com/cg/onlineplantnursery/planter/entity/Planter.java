package com.cg.onlineplantnursery.planter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Planter {
	@Id
	@GeneratedValue
	private Integer planterId;
	private float planterheight;
	private int planterCapacity;
	private int drainageHoles;
	private String planterColor;
	private String planterShape;
	private int planterStock;
	private int planterCost;
	//private Plant plants;
	//private Seed seeds;
	
	public Planter() {

	}

	
	
	public Planter(float planterheight, int planterCapacity, int drainageHoles, String planterColor,
			String planterShape, int planterStock, int planterCost) {
		this.planterheight = planterheight;
		this.planterCapacity = planterCapacity;
		this.drainageHoles = drainageHoles;
		this.planterColor = planterColor;
		this.planterShape = planterShape;
		this.planterStock = planterStock;
		this.planterCost = planterCost;
	}



	public Integer getPlanterId() {
		return planterId;
	}

	public void setPlanterId(Integer planterId) {
		this.planterId = planterId;
	}

	public float getPlanterheight() {
		return planterheight;
	}

	public void setPlanterheight(float planterheight) {
		this.planterheight = planterheight;
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


	public String getPlanterColor() {
		return planterColor;
	}

	public void setPlanterColor(String planterColor) {
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


	@Override
	public String toString() {
		return "Planter Details [planterId=" + planterId + ", planterheight=" + planterheight + ", planterCapacity="
				+ planterCapacity + ", drainageHoles=" + drainageHoles + ", planterColor=" + planterColor
				+ ", planterShape=" + planterShape + ", planterStock=" + planterStock + ", planterCost=" + planterCost
				+ "]";
	}

	

}
