package com.cg.onlineplantnursery.planter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.seed.entity.Seed;

@Entity
public class Planter {
	@Id
	@GeneratedValue
	private Integer planterId;
	private float planterheight;
	private int planterCapacity;
	private int drinageHoles;
	private String planterColor;
	private String planterShape;
	private int planterStock;
	private int planterCost;
	private Plant plants;
	private Seed seeds;

	public Plant getPlants() {
		return plants;
	}
	

	public Planter( float planterheight, int planterCapacity, int drinageHoles, String planterColor,
			String planterShape, int planterStock, int planterCost) {
		this.planterheight = planterheight;
		this.planterCapacity = planterCapacity;
		this.drinageHoles = drinageHoles;
		this.planterColor = planterColor;
		this.planterShape = planterShape;
		this.planterStock = planterStock;
		this.planterCost = planterCost;
	}


	public void setPlants(Plant plants) {
		this.plants = plants;
	}

	public Seed getSeeds() {
		return seeds;
	}

	public void setSeeds(Seed seeds) {
		this.seeds = seeds;
	}

	public Planter() {

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

	public int getDrinageHoles() {
		return drinageHoles;
	}

	public void setDrainageHoles(int drinageHoles) {
		this.drinageHoles = drinageHoles;
	}

	
	

	public String getPlanterColor() {
		return planterColor;
	}

	public void setPlanterColor(String planterColor) {
		this.planterColor = planterColor;
	}

	public void setDrinageHoles(int drinageHoles) {
		this.drinageHoles = drinageHoles;
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
		return "Planter [planterId=" + planterId + ", planterheight=" + planterheight + ", planterCapacity="
				+ planterCapacity + ", drinageHoles=" + drinageHoles + ", planterColor=" + planterColor
				+ ", planterShape=" + planterShape + ", planterStock=" + planterStock + ", planterCost=" + planterCost
				+ "]";
	}

}
