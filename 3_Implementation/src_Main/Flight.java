import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Flight {  
	static final Map<Integer,String> convertToDay;
	static {
        HashMap<Integer, String> temp = new HashMap<Integer,String>();
        temp.put(1, "SUNDAY");
        temp.put(2, "MONDAY");
        temp.put(3, "TUESDAY");
        temp.put(4, "WEDNESDAY");
        temp.put(5, "THURSDAY");
        temp.put(6, "FRIDAY");
        temp.put(7, "SATURDAY");
        convertToDay =  Collections.unmodifiableMap(temp);
    }
	
	private String startCity;
	private String endCity;
	private HashMap<String,Integer> operatingDays;
	private Double flightFare;
	private static int flightNumberGenerator = 0;
	private int flightNumber;
	private int numberOfSeats;
	
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	protected void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
		
	public String getStartCity() {
		return startCity;
	}
	
	protected void setStartCity(String startCity) {
		this.startCity = startCity.toLowerCase();
	}
	
	public HashMap<String, Integer> getOperatingDays() {
		return operatingDays;
	}
	
	protected void setOperatingDays(int Days) {
		
		operatingDays = new HashMap<String,Integer>();
		
		int temp = Days;
		while(temp!=0)
		{
			int rem = temp%10;
			String s = convertToDay.get(rem);
			operatingDays.put(s, 1);
			temp = temp/10;
		}
		
	}
	
	public String getEndCity() {
		return endCity.toLowerCase();
	}
	
	protected void setEndCity(String endCity) {
		this.endCity = endCity.toLowerCase();
	}
	
	public Double getFlightFare() {
		return flightFare;
	}
	
	protected void setFlightFare(Double flightFare) {
		this.flightFare = flightFare;
	}
	
	public int getFlightNumber(){
		return flightNumber;
	}
	
	Flight(){
		flightNumberGenerator++;
		flightNumber = flightNumberGenerator;
	}
	
}