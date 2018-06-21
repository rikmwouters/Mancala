package nl.sogyo.mancala.controller.dto;

public class PlayersDTO {

	private String nameP1;
	private String nameP2;
	
	public PlayersDTO() {
		
	}
	
	public PlayersDTO(String nameP1, String nameP2) {
		
		this.nameP1 = nameP1;
		this.nameP2 = nameP2;
	}
	
	
	public String getNameP1() {
		
		return this.nameP1;
	}
	
	public String getNameP2() {
		
		return this.nameP2;
	}
}
