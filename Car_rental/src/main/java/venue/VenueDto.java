package venue;

public class VenueDto {
	private int venue_id;
	private String name, join_date;


	public VenueDto(int venue_id, String name, String joindate) {
		this.venue_id = venue_id;
		this.name = name;
		this.join_date = joindate;
	}
	public int getVenue_id() {
		return venue_id;
	}
	public String getName() {
		return name;
	}
	public String getJoin_date() {
		return join_date;
	}
}
