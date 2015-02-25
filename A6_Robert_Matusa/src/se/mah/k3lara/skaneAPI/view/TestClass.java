package se.mah.k3lara.skaneAPI.view;

import java.util.ArrayList;
import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class TestClass {

	public static void main(String[] args) {
		// Specifies startstaton and endstation and number of results
		String searchURL = Constants.getURL("80000", "81216", 20); // Malmo C =
																	// 80000,
																	// Lund C,
																	// 81216
																	// Malmo
																	// Gatorg
																	// 80100,
																	// Hässleholm
																	// C 93070
		System.out.println(searchURL);
		System.out.println("// Results when searching:");

		// Takes info from getJourneys in the parserclass and prints all the
		// info regarding the journey
		Journeys journeys = Parser.getJourneys(searchURL);
		for (Journey journey : journeys.getJourneys()) {
			System.out.print(journey.getStartStation() + " - ");
			System.out.print(journey.getEndStation());
			String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)
					+ ":" + journey.getDepDateTime().get(Calendar.MINUTE);
			System.out.println(" Departs " + time + " that is in "
					+ journey.getTimeToDeparture() + " minutes. And it is "
					+ journey.getDepTimeDeviation() + " min late");
		}

		System.out
				.println("// Stations when searching for stations containing \"Malm\"");
		// Creates an arraylist with searchable stations
		ArrayList<Station> searchStations = new ArrayList<Station>();
		// Adds all stations from the URL in the parserclass
		searchStations.addAll(Parser.getStationsFromURL("Malm"));
		for (Station s : searchStations) {
			System.out.println(s.getStationName() + " number:"
					+ s.getStationNbr());
		}
	}
}
