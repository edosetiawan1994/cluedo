package control;

public class Card {
	private int id;
	private String name;
	
	//TODO: better way to initialize id ... e.g. some global counter
	public Card(int id, String name) {
		this.name = name;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
}
