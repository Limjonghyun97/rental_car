package board;

public class BoardDto {
	private int postNo;
	private String clientId, title, info, joindate;
	
	public BoardDto(int postNo, String clientId, String title, String info, String joindate) {
		this.postNo = postNo;
		this.clientId = clientId;
		this.title = title;
		this.info = info;
		this.joindate = joindate;
	}

	public BoardDto(int postNo, String clientId, String title, String info) {
		this.postNo = postNo;
		this.clientId = clientId;
		this.title = title;
		this.info = info;
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
