public class PaymentEngine {

	public boolean deductBalance(Flight t, User user) {
		// TODO Auto-generated method stub
		
		
		if(t.getFlightFare() < user.debitBalance)
		{
			user.debitBalance-= t.getFlightFare();
			System.out.println("Balance of "+t.getFlightFare()+" has been deducted for the booking");
			return true;
		}
		else
			return false;
		
	}


	public void processRefund(User user, Ticket t) {
		System.out.println("Amount of "+t.getFare()+" has been credited to the user's account");
		user.debitBalance+=t.getFare();

	}

}