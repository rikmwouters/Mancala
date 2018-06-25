package nl.sogyo.mancala.controller.dto;

import nl.sogyo.mancala.domain.Mancala;
import nl.sogyo.mancala.domain.Player;

public class PlayersDTO {

	private Mancala mancalaGame;
	private String nameP1;
	private String nameP2;
	
	public PlayersDTO() {
		
	}
	
	public PlayersDTO(String nameP1, String nameP2, Mancala mancalaGame) {
		
		this.nameP1 = nameP1;
		this.nameP2 = nameP2;
		this.mancalaGame = mancalaGame;
	}
	
	
	public String getNameP1() {
		
		return this.nameP1;
	}
	
	public String getNameP2() {
		
		return this.nameP2;
	}
	
	public String getPlayerNameFromObject(Player player) {
		if(player == mancalaGame.getPlayer1()) {
			return nameP1;
		} else if(player == mancalaGame.getPlayer2()) {
			return nameP2;
		} else {
			return null;
		}
	}
}
