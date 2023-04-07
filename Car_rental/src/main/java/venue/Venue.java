package venue;


public class Venue {
	
	private int venueId;
	private String name, joindate;


	public Venue(int venueId, String name, String joindate) {
		this.venueId = venueId;
		this.name = name;
		this.joindate = joindate;
	}
	public int getVenueId() {
		return venueId;
	}
	public String getName() {
		return name;
	}
	public String getJoindate() {
		return joindate;
	}
	public Venue(VenueDto venueDto) {
		this.venueId = venueDto.getVenueId();
		this.name = venueDto.getName();
		this.joindate = venueDto.getJoindate();
	}

}
