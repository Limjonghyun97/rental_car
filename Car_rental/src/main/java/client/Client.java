package client;

public class Client {
	private String id, password, name, joindate;

	public Client(String id, String password, String name, String joindate) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.joindate = joindate;
	}

	public Client(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public Client(ClientDto userDto) {
		this.id = userDto.getId();
		this.password = userDto.getPassword();
		this.name = userDto.getName();
		this.joindate = userDto.getJoindate();
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
