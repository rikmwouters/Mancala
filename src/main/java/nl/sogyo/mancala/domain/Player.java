package nl.sogyo.mancala.domain;

public class Player {
	
	private Boolean active;
	private Player opponent;
	private Boolean won = false;
	private Boolean endGame = false;

	public Player(Boolean active, Player opponent) {
		this.active = active;
		this.opponent = opponent;
	}
	
	/*
	 * Construction method
	 */
	
	public void connectPlayers(Container currentContainer) {
		
		int rowLength = fetchRowLength(currentContainer);
		Player player1 = currentContainer.getOwner();
		currentContainer = currentContainer.stepsForward(rowLength+1);
		Player player2 = currentContainer.getOwner();
		currentContainer.getOwner().setOpponent(player1);
		currentContainer.getOwner().getOpponent().setOpponent(player2);
	}
	
	/*
	 * Getters, setters and the like
	 */
	
	public Player getOpponent() {
		return this.opponent;
	}
	
	public void setOpponent(Player player) {
		this.opponent = player;
	}
	
	public void changeActive(Container currentContainer) {
		active = !active;
		opponent.alsoChangesActive();
		
		if(active) {
			checkIfGameOver(currentContainer);
		} else {
			currentContainer = currentContainer.stepsForward(7);
			checkIfGameOver(currentContainer);
		}
		
	}
	
	private void alsoChangesActive() {
		active = !active;
	}
	
	public Boolean isActive() {
		return active;
	}
	
	public int fetchRowLength(Container currentContainer) {
		int rowLength;
		try{
			rowLength = ((Hole) currentContainer).getRowLength();
		}
		catch(ClassCastException e) {
			rowLength = ((Hole) currentContainer.stepsForward(1)).getRowLength();
		}
		
		return rowLength;
	}
	
	public Boolean hasWon() {
		return won;
	}
	
	public Boolean gameIsFinished() {
		return endGame;
	}
	
	/*
	 * Checking game status and end-game methods
	 */
	
	public void checkIfGameOver(Container currentContainer) {
		while(currentContainer.getClass() != Kalaha.class || currentContainer.getOwner().isActive() == true) {
			currentContainer = currentContainer.getNextContainer();
		}
		int totalRowContent = ((Kalaha) currentContainer).findTotalRowContent();
		if(totalRowContent == 0) {
			endGame = true;
			determineScores(currentContainer);
		}
	}
	
	private void determineScores(Container currentContainer) {
		currentContainer = currentContainer.stepsForward(7);
		int currentPlayerScore = currentContainer.getContent();
		int opponentRowContent = ((Kalaha) currentContainer).findTotalRowContent();
		currentContainer = currentContainer.stepsForward(7);
		int opponentScore = currentContainer.getContent()+opponentRowContent;
		compareScores(currentPlayerScore, opponentScore);
	}
	
	private void compareScores(int currentPlayerScore, int opponentScore) {
		if(currentPlayerScore > opponentScore) {
			this.won = true;
		}
		else if(currentPlayerScore < opponentScore) {
			this.won = false;
			this.opponent.won = true;
		}
		else {
			this.won = false;
		}
	}
}
