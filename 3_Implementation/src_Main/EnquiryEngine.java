import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class EnquiryEngine
{

	HashMap<Integer,Flight> enquire() throws Exception
	{
		HashMap<Integer,Flight> flightsAvailable = new HashMap<Integer,Flight>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("*************************************");

		System.out.print("1)Enter Start City: ");
		String startCity = br.readLine();
		System.out.print("2)Enter Destination City: ");
		String endCity = br.readLine();
		System.out.print("3)Enter travel date (dd/mm/yyyy): ");
		String dateString = br.readLine();
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		String day = sdf.format(date);
		day = day.toUpperCase();
		HashMap<Integer, Flight> flightDetails = FlightScheduler.getFlightList();
		for(Map.Entry<Integer, Flight> entry : flightDetails.entrySet())
		{
			Flight t = entry.getValue();
			String t_startCity = t.getStartCity();
			String t_endCity = t.getEndCity();
			HashMap<String, Integer> operatingDays = t.getOperatingDays();
			if(startCity.equals(t_startCity) && endCity.equals(t_endCity))
			{
				if(operatingDays.get(day) == 1) 
				{
					System.out.println("*******************************************");
					System.out.println("Airline number: " + t.getFlightNumber());
					System.out.println("Airline start city: " + t_startCity);
					System.out.println("Airline end city: " + t_endCity);
					System.out.println("Airline fare: " + t.getFlightFare());
					System.out.println("Number of seats available: " + t.getNumberOfSeats());
					flightsAvailable.put(t.getFlightNumber(),t);
				}
			}
			//else
			//	System.out.println("No Airlines found!");
			
		}
		return flightsAvailable;
	}
}