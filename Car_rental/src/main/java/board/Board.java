package board;

public class Board {
	private int postNo;
	private String clientId, title, info, joindate;
	
	public Board(int postNo, String clientId, String title, String info, String joindate) {
		this.postNo = postNo;
		this.clientId = clientId;
		this.title = title;
		this.info = info;
		this.joindate = joindate;
	}

	public Board(BoardDto boardDto) {
		this.postNo = boardDto.getPostNo();
		this.clientId = boardDto.getClientId();
		this.title = boardDto.getTitle();
		this.info = boardDto.getInfo();
		this.joindate = boardDto.getJoindate();
	}

	public int getPostNo() {
		return postNo;
	}

	public String getClientId() {
		return clientId;
	}

	public String getTitle() {
		return title;
	}

	public String getInfo() {
		return info;
	}

	public String getJoindate() {
		return joindate;
	}

}
