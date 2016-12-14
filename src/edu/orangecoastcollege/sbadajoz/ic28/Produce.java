package edu.orangecoastcollege.sbadajoz.ic28;

import java.io.Serializable;

public class Produce extends PaleoFood implements Serializable {
	private boolean mOrganic;
	
	 public Produce(String name, int calories, int carbohydrates, boolean organic) {
		 mName = name;
		 mNumCalories = calories;
		 mNumCarbohydrates = carbohydrates;
		 mOrganic = organic;
	 }

	public boolean isOrganic() {
		return mOrganic;
	}

	public void setOrganic(boolean organic) {
		this.mOrganic = organic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (mOrganic ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produce other = (Produce) obj;
		if (mName != other.mName)
			return false;
		if (mNumCalories != other.mNumCalories)
			return false;
		if (mNumCarbohydrates != other.mNumCarbohydrates)
			return false;
		if (mOrganic != other.mOrganic)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ((mOrganic)? "Organic":"") + "Produce: " + mName + "," + mNumCalories + "calories, "
				+ mNumCarbohydrates + "g carbs";
	}
	 
	 
}
