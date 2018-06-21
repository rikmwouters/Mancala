package nl.sogyo.mancala.controller.dto;

import nl.sogyo.mancala.domain.*;

public class BoardDTO {

	private Mancala mancalaGame;
	
	
	public BoardDTO(Mancala mancalaGame) {
		this.mancalaGame = mancalaGame;
	}
	
	
	public BoardDTO() {
		
		mancalaGame = new Mancala();
	}
	
	
	public Mancala getMancalaGame() {
		
		return this.mancalaGame;
	}
	
	public int getHole1Content() {
		return mancalaGame.findContent(1);
	}
	
	public int getHole2Content() {
		return mancalaGame.findContent(2);
	}
	
	public int getHole3Content() {
		return mancalaGame.findContent(3);
	}
	
	public int getHole4Content() {
		return mancalaGame.findContent(4);
	}
	
	public int getHole5Content() {
		return mancalaGame.findContent(5);
	}
	
	public int getHole6Content() {
		return mancalaGame.findContent(6);
	}
	
	public int getKalaha1Content() {
		return mancalaGame.findContent(7);
	}
	
	public int getHole7Content() {
		return mancalaGame.findContent(8);
	}
	
	public int getHole8Content() {
		return mancalaGame.findContent(9);
	}
	
	public int getHole9Content() {
		return mancalaGame.findContent(10);
	}
	
	public int getHole10Content() {
		return mancalaGame.findContent(11);
	}
	
	public int getHole11Content() {
		return mancalaGame.findContent(12);
	}
	
	public int getHole12Content() {
		return mancalaGame.findContent(13);
	}
	
	public int getKalaha2Content() {
		return mancalaGame.findContent(14);
	}
}
