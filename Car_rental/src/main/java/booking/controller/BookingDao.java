package booking.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import booking.Booking;
import booking.BookingDto;
import client.ClientDto;
import util.DBManager;

public class BookingDao {
	// 1. DB 연결
	private Connection conn;
	// 2. SQL 구문 담을 객체
	private PreparedStatement pstmt;
	// 3. 결과를 담을 객체
	private ResultSet rs;

	private BookingDao() {
	}

	private static BookingDao instance = new BookingDao();

	public static BookingDao getInstance() {
		return instance;
	}

	// create
	public void creatBooking(BookingDto bookingDto) {
		Booking booking = new Booking(bookingDto);

		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "INSERT INTO booking (vehicle_id, venue_id, client_id, date_time, hour, total_payment) values (?, ?, ?, ?, ?, ?);";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, booking.getVehicle_id());
				this.pstmt.setInt(2, booking.getVenue_id());
				this.pstmt.setString(3, booking.getClient_id());
				this.pstmt.setString(4, booking.getDate_time());
				this.pstmt.setInt(5, booking.getHour());
				this.pstmt.setInt(6, booking.getTotal_payment());

				this.pstmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt);
			}
		}
	}

	// Read
	public ArrayList<Booking> getBookingAll() {
		ArrayList<Booking> list = new ArrayList<Booking>();

		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "SELECT * FROM `booking`";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String vehicle_id = this.rs.getString(1);
					int venue_id = Integer.parseInt(this.rs.getString(2));
					String client_id = this.rs.getString(3);
					String date_time = this.rs.getString(4);
					int hour = Integer.parseInt(this.rs.getString(5));
					int total_payment = Integer.parseInt(this.rs.getString(6));
					String join_date = this.rs.getString(7);

					Booking member = new Booking(vehicle_id, venue_id, client_id, date_time, hour, total_payment,
							join_date);
					list.add(member);
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
