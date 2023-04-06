package client;

public class ClientDto {
	private String id, password, name, joindate;
	
	public ClientDto(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}
	
	public ClientDto(String id, String password, String name, String joindate) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.joindate = joindate;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getJoindate() {
		return joindate;
	}
}
