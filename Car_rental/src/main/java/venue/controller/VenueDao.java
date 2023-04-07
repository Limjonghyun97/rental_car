package venue.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBManager;
import venue.Venue;
import venue.VenueDto;

public class VenueDao {
	// 1. DB 연결
	private Connection conn;
	// 2. SQL 구문 담을 객체
	private PreparedStatement pstmt;
	// 3. 결과를 담을 객체
	private ResultSet rs;

	private VenueDao() {
	}

	private static VenueDao instance = new VenueDao();

	public static VenueDao getInstance() {
		return instance;
	}

	// create
	public void creatVehicle(VenueDto venueDto) {
		Venue venue = new Venue(venueDto);

		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "INSERT INTO client (client_id, password, name) VALUES(?, ?, ?)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
//						this.pstmt.setString(1, client.getId());
//						this.pstmt.setString(2, client.getPassword());
//						this.pstmt.setString(3, client.getName());

				this.pstmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt);
			}
		}
	}

	// Read
	public ArrayList<Venue> getVenueAll() {
		ArrayList<Venue> list = new ArrayList<Venue>();

		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "SELECT * FROM `venue`";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int venue_id = this.rs.getInt(1);
					String name = this.rs.getString(2);
					String joindate = this.rs.getString(3);

					Venue venue = new Venue(venue_id, name, joindate);
					list.add(venue);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt, this.rs);
			}
		}

		return list;
	}
}
