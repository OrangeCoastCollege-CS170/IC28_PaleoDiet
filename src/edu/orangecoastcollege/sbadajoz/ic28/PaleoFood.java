package edu.orangecoastcollege.sbadajoz.ic28;

public abstract class PaleoFood {
	protected String mName;
	protected int mNumCalories;
	
	public String getName() {
		return mName;
	}
	public int getCalories() {
		return mNumCalories;
	}
	public void setName(String name) {
		this.mName = name;
	}
	public void setCalories(int calories) {
		this.mNumCalories = calories;
	}
	
	
}
