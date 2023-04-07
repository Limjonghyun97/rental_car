package vehicle.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBManager;
import vehicle.Vehicle;
import vehicle.VehicleDto;

public class VehicleDao {
	// 1. DB 연결
		private Connection conn;
		// 2. SQL 구문 담을 객체
		private PreparedStatement pstmt;
		// 3. 결과를 담을 객체
		private ResultSet rs;

		private VehicleDao() {
		}

		private static VehicleDao instance = new VehicleDao();

		public static VehicleDao getInstance() {
			return instance;
		}

		// create
		public void creatVehicle(VehicleDto vehicleDto) {
			Vehicle vehicle = new Vehicle(vehicleDto);

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
		public ArrayList<Vehicle> getVehicleAll() {
			ArrayList<Vehicle> list = new ArrayList<Vehicle>();

			this.conn = DBManager.getConnectionFromMySQL();
			if (this.conn != null) {
				String sql = "SELECT * FROM `vehicle`";

				try {
					this.pstmt = this.conn.prepareStatement(sql);
					this.rs = this.pstmt.executeQuery();

					while (this.rs.next()) {
						String name = this.rs.getString(1);
						String vehicleId = this.rs.getString(2);
						int hourRate = this.rs.getInt(3);
						int venueId = this.rs.getInt(4);
						String joindate = this.rs.getString(5);

						Vehicle vehicle = new Vehicle(name, vehicleId, hourRate, venueId, joindate);
						list.add(vehicle);
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
