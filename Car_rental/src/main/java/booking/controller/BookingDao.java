package booking.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import booking.Booking;
import booking.BookingDto;
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
			String sql = "INSERT INTO client (client_id, password, name) VALUES(?, ?, ?)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
//					this.pstmt.setString(1, client.getId());
//					this.pstmt.setString(2, client.getPassword());
//					this.pstmt.setString(3, client.getName());

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
					String vehicle = this.rs.getString(1);
					int venueId = this.rs.getInt(2);
					String clientId = this.rs.getString(3);
					String dateTime = this.rs.getString(4);
					int hour = this.rs.getInt(5);
					int totalPayment = this.rs.getInt(6);
					String joindate = this.rs.getString(7);

					Booking booking = new Booking(vehicle, venueId, clientId, dateTime, hour, totalPayment, joindate);
					list.add(booking);
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
