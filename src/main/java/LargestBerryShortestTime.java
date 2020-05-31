import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/*
 * @author Yvonne Davis
 * @version 1
 * This program uses the Pokemon API to find the largest berry with the shortest growth time. 
 */

public class LargestBerryShortestTime {

	// use to get the total number of berries
	public static int count;

	// URL to Pokemon API berry resources listing
	public static String apiURL = "https://pokeapi.co/api/v2/berry/";

	// array to store the berries
	public static final List<Berry> theBerries = new ArrayList<>();

	// store the value of the shortest growth time
	int theShortestGrowthTime;

	// variable stores the results of the largest berry with the shortest growth
	// time
	static Berry LargestBerryInTheShortestTime;

	public static void main(String[] args) throws IOException {

		// count the current number of berries
		countTotalNumbersOfBerries(apiURL);
		// System.out.println(count);

		// Get an array of the current berries
		anArrayOfCurrentBerries(theBerries, count);
		// System.out.println(theBerries);

		// select the largest berry within the range of the shortest growth time
		LargestBerryWithTheShortestGrowthTime(theBerries);

		// print out results
		System.out.println(LargestBerryInTheShortestTime);

	}

	public static Berry LargestBerryWithTheShortestGrowthTime(List<Berry> theBerries) {
		// Get the shortest growth time as an integer
		int shortestGrowthTime = theBerries.stream().map(Berry::getBerryGrowhtTime).min(Integer::compare).get();

		// Take berries and filter by shortest-growth-time and extract this list
		List<Berry> shortestGrowthTimeSort = theBerries.stream()
				.filter(x -> x.getBerryGrowhtTime() == shortestGrowthTime).collect(Collectors.toList());

		// This largest berry by size is extracted from this list
		LargestBerryInTheShortestTime = shortestGrowthTimeSort.stream().max(Comparator.comparing(Berry::getBerrySize))
				// .map(Object::toString);
				.get();
		return LargestBerryInTheShortestTime;
	}

	public static List<Berry> anArrayOfCurrentBerries(List<Berry> thBerries, int count)
			throws MalformedURLException, IOException {
		int id = 1;
		// add the berries to an array by their id identifier along with the name, size
		// and growth times
		while (id < count) {
			String berryInfo = apiURL;
			berryInfo += id + "/";
			URL request = new URL(berryInfo);

			InputStream openStream = request.openStream();

			String response = IOUtils.toString(openStream);

			JSONObject root = new JSONObject(response);
			String berryName = (String) root.get("name");
			int berryGrowthTime = (int) root.get("growth_time");
			int berrySize = (int) root.get("size");
			theBerries.add(new Berry(berryName, berryGrowthTime, berrySize));
			id++;

		}
		return theBerries;
	}

	// Get Pokemon berry count
	public static int countTotalNumbersOfBerries(String apiURL) throws IOException {
		URL request = new URL(apiURL);
		InputStream openStream = request.openStream();
		String response = IOUtils.toString(openStream, StandardCharsets.UTF_8.name());
		JSONObject root = new JSONObject(response);
		return count = (int) root.get("count");

	}

}

//Copyright Yvonne Davis 2020