package venue;

public class VenueDto {
	private int venueId;
	private String name, joindate;


	public VenueDto(int venueId, String name, String joindate) {
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
}
