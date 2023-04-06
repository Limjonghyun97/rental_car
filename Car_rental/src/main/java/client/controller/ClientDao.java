package client.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import client.Client;
import client.ClientDto;
import util.DBManager;

public class ClientDao {
	// 1. DB 연결
	private Connection conn;
	// 2. SQL 구문 담을 객체
	private PreparedStatement pstmt;
	// 3. 결과를 담을 객체
	private ResultSet rs;

	private ClientDao() {
	}

	private static ClientDao instance = new ClientDao();

	public static ClientDao getInstance() {
		return instance;
	}

	// create
	public void creatClient(ClientDto userDto) {
		Client client = new Client(userDto);

		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "INSERT INTO client (client_id, password, name) VALUES(?, ?, ?)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, client.getId());
				this.pstmt.setString(2, client.getPassword());
				this.pstmt.setString(3, client.getName());

				this.pstmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt);
			}
		}
	}

	// Read
	public ArrayList<Client> getClientAll() {
		ArrayList<Client> list = new ArrayList<Client>();

		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "SELECT * FROM `client`";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String id = this.rs.getString(1);
					String password = this.rs.getString(2);
					String name = this.rs.getString(3);
					String joindate = this.rs.getString(4);

					Client member = new Client(id, password, name, joindate);
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
