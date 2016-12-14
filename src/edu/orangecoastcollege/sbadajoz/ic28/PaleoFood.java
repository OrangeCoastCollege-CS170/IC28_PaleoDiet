package edu.orangecoastcollege.sbadajoz.ic28;

import java.io.Serializable;
/*
Badajoz, Seve
CS A170
December 14, 2016

IC28
*/
public abstract class PaleoFood implements Serializable {
	protected String mName;
	protected int mNumCalories;
	protected int mNumCarbohydrates;
	
	public String getName() {
		return mName;
	}
	public int getCalories() {
		return mNumCalories;
	}
	public int getCarbohydrates() {
		return mNumCarbohydrates;
	}
	public void setName(String name) {
		this.mName = name;
	}
	public void setCalories(int calories) {
		this.mNumCalories = calories;
	}
	public void setCarbohydrates(int carbohydrates) {
		this.mNumCarbohydrates = carbohydrates;
	}
	
	
}
