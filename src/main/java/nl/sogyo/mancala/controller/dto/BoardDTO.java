package nl.sogyo.mancala.controller.dto;

import nl.sogyo.mancala.domain.*;

public class BoardDTO {

	private Mancala mancalaGame;
	
	
	public BoardDTO(Mancala mancalaGame) {
		this.mancalaGame = mancalaGame;
	}
	
	
	public BoardDTO() {
		
		Mancala mancalaGame = new Mancala();
	}
	
	
	public Mancala getMancalaGame() {
		
		return this.mancalaGame;
	}
}
