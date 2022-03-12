import java.util.HashMap;

public class FlightScheduler {
	
	static final HashMap<Integer, Flight> flightList;
	static
	{
		flightList = new HashMap<Integer,Flight>();
	}

	public static HashMap<Integer, Flight> getFlightList() {
		return flightList;
	}

	public static void setFlightList(Flight flight) {
		
		flightList.put(flight.getFlightNumber(), flight);
	}
}