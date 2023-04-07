package vehicle;

public class VehicleDto {
	private String name, vehicleId, joindate;
	private int hourRate, venueId;
	
	public VehicleDto(String name, String vehicleId, int hourRate, int venueId, String joindate) {
		this.name = name;
		this.vehicleId = vehicleId;
		this.hourRate = hourRate;
		this.venueId = venueId;
		this.joindate = joindate;
	}
	
	public String getName() {
		return name;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public String getJoindate() {
		return joindate;
	}

	public int getHourRate() {
		return hourRate;
	}

	public int getVenueId() {
		return venueId;
	}
}
