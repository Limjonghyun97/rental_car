package board.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import board.Board;
import board.BoardDto;
import client.Client;
import client.ClientDto;
import client.controller.ClientDao;
import util.DBManager;

public class BoardDao {
	// 1. DB 연결
	private Connection conn;
	// 2. SQL 구문 담을 객체
	private PreparedStatement pstmt;
	// 3. 결과를 담을 객체
	private ResultSet rs;

	private BoardDao() {
	}

	private static BoardDao instance = new BoardDao();

	public static BoardDao getInstance() {
		return instance;
	}

	// create
	public void creatBoard(BoardDto boardDto) {
		Board board = new Board(boardDto);

		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "INSERT INTO board (post_no, client_id, title, info) VALUES(?, ?, ?, ?)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
					this.pstmt.setInt(1, board.getPostNo());
					this.pstmt.setString(2, board.getClientId());
					this.pstmt.setString(3, board.getTitle());
					this.pstmt.setString(4, board.getInfo());

				this.pstmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(this.conn, this.pstmt);
			}
		}
	}

	// Read
	public ArrayList<Board> getBoardAll() {
		ArrayList<Board> list = new ArrayList<Board>();

		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "SELECT * FROM `board`";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int postNo = this.rs.getInt(1);
					String clientId = this.rs.getString(2);
					String title = this.rs.getString(3);
					String info = this.rs.getString(4);
					String joindate = this.rs.getString(5);

					Board member = new Board(postNo, clientId, title, info, joindate);
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
