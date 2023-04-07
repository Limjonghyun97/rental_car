package vehicle;

public class VehicleDto {
	private String name, vehicle_id, join_date;
	private int hour_rate, venue_id;
	
	public VehicleDto(String name, String vehicle_id, int hour_rate, int venue_id, String join_date) {
		this.name = name;
		this.vehicle_id = vehicle_id;
		this.hour_rate = hour_rate;
		this.venue_id = venue_id;
		this.join_date = join_date;
	}

	public String getName() {
		return name;
	}
	
	public String getVehicle_id() {
		return vehicle_id;
	}

	public String getJoin_date() {
		return join_date;
	}

	public int getHour_rate() {
		return hour_rate;
	}

	public int getVenue_id() {
		return venue_id;
	}
}
