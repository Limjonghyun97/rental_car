package booking;

public class BookingDto {
	private String vehicleId, clientId, dateTime, joindate;
	private int venueId, hour, totalPayment;
	
	public BookingDto(String vehicleId, int venueId, String clientId, String dateTime, int hour, int totalPayment, String joindate) {
		this.vehicleId = vehicleId;
		this.venueId = venueId;
		this.clientId = clientId;
		this.dateTime = dateTime;
		this.hour = hour;
		this.totalPayment = totalPayment;
		this.joindate = joindate;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public String getClientId() {
		return clientId;
	}

	public String getDateTime() {
		return dateTime;
	}

	public String getJoindate() {
		return joindate;
	}

	public int getVenueId() {
		return venueId;
	}

	public int getHour() {
		return hour;
	}

	public int getTotalPayment() {
		return totalPayment;
	}

}
