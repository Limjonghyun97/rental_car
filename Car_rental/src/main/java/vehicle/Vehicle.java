package vehicle;

public class Vehicle {
	private String name, vehicleId, joindate;
	private int hourRate, venueId;
	
	public Vehicle(String name, String vehicleId, int hourRate, int venueId, String joindate) {
		this.name = name;
		this.vehicleId = vehicleId;
		this.hourRate = hourRate;
		this.venueId = venueId;
		this.joindate = joindate;
	}

	public Vehicle(VehicleDto vehicleDto) {
		this.name = vehicleDto.getName();
		this.vehicleId = vehicleDto.getVehicleId();
		this.hourRate = vehicleDto.getHourRate();
		this.venueId = vehicleDto.getVenueId();
		this.joindate = vehicleDto.getJoindate();
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
