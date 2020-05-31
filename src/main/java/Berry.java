/*
 * @author Yvonne Davis
 * @version 1
 * This program uses the Pokemon API to find the largest berry with the shortest growth time. 
 */

public class Berry {
	// attributes of Pokemon berries
	int berrySize;
	int berryGrowhtTime;
	String berryName;
	// String berryURL;

	// Berry constructor
	public Berry(String berryName, int berryGrowthTime, int berrySize) {
		this.berryName = berryName;
		// this.berryURL = berryURL;
		this.berryGrowhtTime = berryGrowthTime;
		this.berrySize = berrySize;
	}

	public int getBerrySize() {
		return berrySize;
	}

	public int getBerryGrowhtTime() {
		return berryGrowhtTime;
	}

	public String getBerryName() {
		return berryName;
	}

	// public String getBerryURL() {
	// return berryURL;
	// }

	@Override
	public String toString() {
		return this.berryName + " " + "grows the largest berry of " + this.berrySize + "cms, in the shortest time of "
				+ this.berryGrowhtTime + " hours.";
	}

}

//Copyright Yvonne Davis 2020