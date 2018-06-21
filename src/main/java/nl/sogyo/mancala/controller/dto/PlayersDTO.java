package nl.sogyo.mancala.controller.dto;

public class PlayersDTO {

	private String nameP1;
	private String nameP2;
	
	public PlayersDTO() {
		
	}
	
	public String getNameP1() {
		
		return this.nameP1;
	}
	
	public String getNameP2() {
		
		return this.nameP2;
	}
	
	public void setNameP1(String nameP1) {
		this.nameP1 = nameP1;
	}
	
	public void setNameP2(String nameP2) {
		this.nameP2 = nameP2;
	}
}
