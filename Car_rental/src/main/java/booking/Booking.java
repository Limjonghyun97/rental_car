package booking;

public class Booking {
	private String vehicle_id, client_id, date_time, join_date;
	private int venue_id, hour, total_payment;

	public Booking(String vehicle_id, int venue_id, String client_id, String date_time, int hour, int total_payment,
			String join_date) {
		this.vehicle_id = vehicle_id;
		this.venue_id = venue_id;
		this.client_id = client_id;
		this.date_time = date_time;
		this.hour = hour;
		this.total_payment = total_payment;
		this.join_date = join_date;
	}

	public Booking(BookingDto bookingDto) {
		// TODO Auto-generated constructor stub
	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public String getClient_id() {
		return client_id;
	}

	public String getDate_time() {
		return date_time;
	}

	public String getJoin_date() {
		return join_date;
	}

	public int getVenue_id() {
		return venue_id;
	}

	public int getHour() {
		return hour;
	}

	public int getTotal_payment() {
		return total_payment;
	}
}
