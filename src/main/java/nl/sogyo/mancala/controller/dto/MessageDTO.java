package nl.sogyo.mancala.controller.dto;

public class MessageDTO {
	
	private String currentMessage = "";
	private String stalemateMessage = "It's a stalemate!";
	private String emptyHoleMessage = "The chosen pocket is empty.";
	private String wrongSideMessage = "You can only select pockets on your own side.";
	
	public MessageDTO(){
		
	}
	
	public String getCurrentMessage() {
		return currentMessage;
	}
	
	public void pushPlayerTurnMessage(String playerName) {
		this.currentMessage = "It's " + playerName + "'s turn!";
	}
	
	public void pushPlayerWinMessage(String playerName) {
		//The string "#Stalemate" is given in case of a stalemate
		if(playerName.equals("#Stalemate")) {
			this.currentMessage = stalemateMessage;
		} else {
			this.currentMessage = playerName + " won!";
		}
	}
	
	public void pushStalemateMessage() {
		this.currentMessage = stalemateMessage;
	}
	
	public void pushEmptyHoleMessage() {
		this.currentMessage = emptyHoleMessage;
	}
	
	public void pushWrongSideMessage() {
		this.currentMessage = wrongSideMessage;
	}
	
	public void resetMessage() {
		this.currentMessage = "";
	}
	
}
