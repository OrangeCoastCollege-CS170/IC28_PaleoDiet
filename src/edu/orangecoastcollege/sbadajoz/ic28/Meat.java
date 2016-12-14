package edu.orangecoastcollege.sbadajoz.ic28;

import java.io.Serializable;

public class Meat extends PaleoFood implements Serializable{
	private int mType;
	private int mCookingTemp;
	
	public Meat(String name, int calories, int type, int cookingTemp) throws UnkownMeatException {
		mName = name;
		mNumCalories = calories;
		if(type > 1 || type < 0)
			throw new UnkownMeatException("Please enter meat type 1 or 2");
		mType = type;
		mCookingTemp = cookingTemp;
		mNumCarbohydrates = 0;
	}

	public int getmType() {
		return mType;
	}

	public int getCookingTemp() {
		return mCookingTemp;
	}

	public void setType(int type) {
		this.mType = type;
	}

	public void setCookingTemp(int cookingTemp) {
		this.mCookingTemp = cookingTemp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mCookingTemp;
		result = prime * result + mType;
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
		Meat other = (Meat) obj;
		if (mCookingTemp != other.mCookingTemp)
			return false;
		if (mType != other.mType)
			return false;
		if (mName != other.mName)
			return false;
		if (mNumCalories != other.mNumCalories)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ((mType == 1)? "Meat":"Seafood") + ": " + mName + ", " + mNumCalories + " calories, " + mNumCarbohydrates + "g carbs, "+ mCookingTemp + " degrees F";
	}
	
	
}
