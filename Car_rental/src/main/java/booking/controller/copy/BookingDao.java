package booking.controller.copy;

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
						int venue_id = this.rs.getInt(2);
						String client_id = this.rs.getString(3);
						String date_time = this.rs.getString(4);
						int hour = this.rs.getInt(5);
						int total_payment = this.rs.getInt(6);
						String join_date = this.rs.getString(7);

						Booking booking = new Booking(vehicle, venue_id, client_id, date_time, hour, total_payment, join_date);
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
