import java.io.BufferedReader;
import java.util.HashMap;

class UserSystem
{
	HashMap<String, User> users;
	
	public UserSystem()
	{
		users = new HashMap<>();
		User user = new User();
		user.username ="admin";
		user.password = "admin";
		users.put("admin",user);
	}
	
	public HashMap<String, User> getUsers()
	{
		return users;
	}
	
	public void setUsers(String username, User user)
	{
		users.put(username, user);
	}
	void disp(BufferedReader br) throws Exception
	{
		while(true)
		{	
			FlightBooking.disps.clear();
			FlightBooking.disps.add("New User");
			FlightBooking.disps.add("Returning User");
			FlightBooking.disps.add("Return to previous menu");
			FlightBooking.disp(FlightBooking.disps.size(), FlightBooking.disps);
			int secondChoice = Integer.parseInt(br.readLine());
			if(secondChoice == 1)
			{
				RegisterSystem rs = new RegisterSystem();
				rs.newUser(this);
			}
			else if(secondChoice == 2)
			{
				LoginSystem ls = new LoginSystem();
				ls.login(this);
			}
			else 
				return;
		}	
	}
}