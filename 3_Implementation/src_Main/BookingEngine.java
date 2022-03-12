class BookingEngine extends Flight{

	
	void bookTicket(int n, User user)
	{
		Flight t = FlightScheduler.getFlightList().get(n);
		System.out.println("****************** TICKET BOOKED *****************");
		System.out.println("From "+t.getStartCity());
		System.out.println("To "+t.getEndCity());
		int seats = t.getNumberOfSeats()-1;
		Ticket ticket = new Ticket();
		ticket.setStartCity(t.getStartCity());
		ticket.setEndCity(t.getEndCity());
		ticket.setFare(t.getFlightFare());
		user.bookings.put(ticket.getBookingNumber(),ticket);
		t.setNumberOfSeats(seats);
		FlightScheduler.setFlightList(t);
		
		System.out.println("Seats left "+seats);
		
		System.out.println("*****************************************");

	}
	
}