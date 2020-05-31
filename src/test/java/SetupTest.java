
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * @author Yvonne Davis
 * @version 1
 * This program test the methods that uses the Pokemon API to find the largest berry
 *  with the shortest growth time. 
 */
public class SetupTest {

	// Test for the correct number of current berries
	@Test
	public void countTotalNumbersOfBerriesTest() throws IOException {
		String apiURL = "https://pokeapi.co/api/v2/berry/";
		assertEquals(64, LargestBerryShortestTime.countTotalNumbersOfBerries(apiURL));
	}

	// Test that correct information for count of berries is being collected
	@Test
	public void berryInformationCollectedTest() throws Exception {
		int count = 64;
		List<Berry> theBerries = new ArrayList<>();
		Berry results1 = new Berry("watmel", 15, 250);
		assertEquals(results1.toString(),
				LargestBerryShortestTime.anArrayOfCurrentBerries(theBerries, count).get(32).toString());

	}

	// check that the largest berry with the shortest growth time is selected
	@Test
	public void largeBerryWithShortTimeTest() throws Exception {
		List<Berry> theBerries = new ArrayList<>();
		theBerries.add(new Berry("spelon", 15, 133));
		theBerries.add(new Berry("ganlon", 24, 33));
		theBerries.add(new Berry("rabuta", 6, 226));
		theBerries.add(new Berry("rindo", 18, 156));
		theBerries.add(new Berry("payapa", 18, 42));

		String theOne = "rabuta grows the largest berry of 226cms, in the shortest time of 6 hours.";

		assertEquals(theOne, LargestBerryShortestTime.LargestBerryWithTheShortestGrowthTime(theBerries).toString());

	}

}
