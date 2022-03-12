import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


public class FlightAdmin extends Flight{
	
	static Scanner in = new Scanner(System.in);
	private static FlightAdmin tAdmin;

	private FlightAdmin() {
		init();
	}

	private void init() {  // default listing
		Flight t1 = new Flight();
		Flight t2 = new Flight();
		Flight t3 = new Flight();
		Flight t4 = new Flight();
		Flight t5 = new Flight();
		
		t2.setStartCity("Chennai");
		t2.setEndCity("Mumbai");
		t2.setFlightFare(1200.00);
		t2.setOperatingDays(1234567);
		t2.setNumberOfSeats(120);
		
		t1.setStartCity("Chennai");
		t1.setEndCity("Hydreabad");
		t1.setFlightFare(700.00);
		t1.setOperatingDays(1234567);
		t1.setNumberOfSeats(50);
		
		t3.setStartCity("Chennai");
		t3.setEndCity("Bangalore");
		t3.setFlightFare(450.0);
		t3.setOperatingDays(1234567);
		t3.setNumberOfSeats(110);
		
		t4.setStartCity("Coimbatore");
		t4.setEndCity("Goa");
		t4.setFlightFare(900.0);
		t4.setOperatingDays(1234567);
		t4.setNumberOfSeats(180);
		
		t5.setStartCity("Mysore");
		t5.setEndCity("Delhi");
		t5.setFlightFare(1300.75);
		t5.setOperatingDays(1234567);
		t5.setNumberOfSeats(25);
		
		
		
		FlightScheduler.setFlightList(t2);
		FlightScheduler.setFlightList(t1);
		FlightScheduler.setFlightList(t3);
	}

	public static FlightAdmin getFlightAdmin() {
		if (tAdmin == null) {
			synchronized (FlightAdmin.class) {
				if (tAdmin == null) {
					tAdmin = new FlightAdmin();
															}
			}
		}
		return tAdmin;
	}

	public void addFlight() {
		Flight flight = new Flight();
		
		System.out.println("Enter start city:");
		String startCity = in.nextLine();
		flight.setStartCity(startCity.toLowerCase());
		
		System.out.println(("Enter destination city:"));
		
		String destinationCity = in.nextLine();
		flight.setEndCity(destinationCity.toLowerCase());
		
		System.out.println("Enter Airline fare:");
		double flightFare = in.nextDouble();
		flight.setFlightFare(flightFare); 
		
		System.out.println("Enter the total number of seats:");
		int totalSeats = in.nextInt();
		flight.setNumberOfSeats(totalSeats);
		
		System.out.println("Enter the days the Airline will operate on (eg: 12 = Sunday & Monday, 467 = Wed,Fri & Sat");
		int days = in.nextInt();
		flight.setOperatingDays(days);
		FlightScheduler.setFlightList(flight);
	}
	
	public boolean flightExists(int n)
	{
		HashMap<Integer, Flight> flightList = FlightScheduler.getFlightList();
		if(!flightList.containsKey(n))
			return false;
		return true;
	}
	
	public Flight flightSelector(int n)
	{
			//flightList.remove(n);
		HashMap<Integer, Flight> flightList = FlightScheduler.getFlightList();
		return flightList.get(n);
	}
	
	public void deleteFlight(int n)
	{
		HashMap<Integer, Flight> flightList = FlightScheduler.getFlightList();
		if(!flightList.containsKey(n))
		{
			System.out.println("Invalid Key Selected");
			return;
		}
		else
		{
			flightList.remove(n);
			System.out.println("Deleted Successfully ");
		}
	}
	
	public void updateFlight(int n)
	{
		
		System.out.println("Select the field to update::");
		System.out.println("1) Start City :");
		System.out.println("2) destination city:");
		System.out.println("3) Airline fare:");
		System.out.println("4) Days Airline operates;");
		System.out.println("5) Number of seats:");
		int choice = in.nextInt();
		in.nextLine();
		String temp;
		Flight f = flightSelector(n);
		switch(choice)
		{
			case 1:
				System.out.println("Enter new Start City:");
				temp = in.nextLine();
				f.setStartCity(temp.toLowerCase());
				break;
			case 2:
				System.out.println("Enter New end City:");
				temp = in.nextLine().toLowerCase();
				f.setEndCity(temp);
				break;
			case 3:
				System.out.println("Enter New Fare:");
				double tt = in.nextDouble();
				in.nextLine();
				f.setFlightFare(tt);
				break;
			case 4:
				System.out.println("Enter the days the Flight operates on now:");
				int opDay = in.nextInt();
				f.setOperatingDays(opDay);
				break;
			case 5:
				System.out.println("Enter the Total Number of seats:");
				int seats = in.nextInt();
				f.setNumberOfSeats(seats);
				break;
			default:
				System.out.println("Inavlid option selected. Please enter again:");
		}
		
		FlightScheduler.setFlightList(f);
		
	}
	
	public void display()
	{
		HashMap<Integer, Flight> flightList = FlightScheduler.getFlightList();
		
	    for (Map.Entry<Integer, Flight> entry : flightList.entrySet()) {
	        Integer key = entry.getKey();
	        System.out.println("AirLine Number: "+key);
	        Flight f = entry.getValue();
	        System.out.println("Source City: "+f.getStartCity());
	        System.out.println("Destination City: "+f.getEndCity());
	        System.out.println("AirLine Fare: "+f.getFlightFare());
	        System.out.println("Total Number of seats "+f.getNumberOfSeats());
	        System.out.print("Days the AirLine operates:");
	        HashMap<String,Integer> h = f.getOperatingDays();
			for(String d : h.keySet())
			{
				if(h.get(d) == 1)
					System.out.print(d+" ");
			}
	        System.out.println();
	        
	        System.out.println();
	    }
	}
	
	public void adminMenu()
	{
		System.out.println("*******************************************");
		System.out.println("Admin logged in");
		mainloop:
		while(true)
		{	
			System.out.println("*******************************************");
			System.out.println("Please select an option");
			System.out.println("1) Add Airline");
			System.out.println("2) Update AirLine");
			System.out.println("3) Delete Airline");
			System.out.println("4) Display Information of all the Airlines");
			System.out.println("5) Return to Main Menu");
			int option = in.nextInt();
			in.nextLine();
			FlightAdmin nithish = FlightAdmin.getFlightAdmin();
			switch(option)
			{
				case 1:
					System.out.println("*******************************************");
					System.out.println("Adding Airline");
					System.out.println("*******************************************");

					System.out.println("Please fill the Airline info");
					nithish.addFlight();
				break;
				
				case 2:
					System.out.println("*******************************************");
					System.out.println("Updating Airline Info");
					System.out.println("*******************************************");
					System.out.println("Please enter the Airline number to update the Airline's info");
					int n = in.nextInt();
					if(nithish.flightExists(n))
						nithish.updateFlight(n);
					else
						System.out.println("Invalid Airline number entered");
				break;
			
				case 3:
					System.out.println("*******************************************");
					System.out.println("Deleting Airline");
					System.out.println("*******************************************");

					System.out.println("Please enter the Airline number to delete the Airline from the Listing");
					n = in.nextInt();
					if(nithish.flightExists(n))
						nithish.deleteFlight(n);
					else
						System.out.println("Please select a valid Airline Number");
				break;
				
				case 4:
					System.out.println("*******************************************");
					System.out.println("Displaying all the Airlines");
					System.out.println("*******************************************");

					System.out.println("Display");
					nithish.display();
				    
				break;
				case 5:
					System.out.println("...");
				break mainloop;
				
				default:
					System.out.println("Invalid option selected");
			}
		}
		
	} // end main
	
	
}