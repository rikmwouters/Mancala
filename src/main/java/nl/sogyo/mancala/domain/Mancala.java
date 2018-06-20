package nl.sogyo.mancala.domain;

public class Mancala {
	private Kalaha firstKalaha;
	
	public Mancala() {
		firstKalaha = new Kalaha(0,0,null,null);
	}
	
	public void chooseHole(int position) {
		Container currentContainer = findStartingPosition();
		currentContainer = currentContainer.stepsForward(position);
		((Hole) currentContainer).processHoleChoice();
	}
	
	public int[] getAllContent() {
		Container currentContainer = firstKalaha;
		int[] AllContent = new int[14];
		for(int i = 0; i < 14; i++) {
			AllContent[i] = currentContainer.getContent();
			currentContainer = firstKalaha.getNextContainer();
		}
		return AllContent;
	}
	
	private Container findStartingPosition() {
		Container currentContainer = firstKalaha;
		while(currentContainer.getClass() != Kalaha.class || currentContainer.getOwner().isActive() == true) {
			currentContainer = currentContainer.getNextContainer();
		}
		return currentContainer;
	}
	
	public Player determineWinner() {
		Player winner;
		if(firstKalaha.getOwner().hasWon()) {
			winner = firstKalaha.getOwner();
		} else if (firstKalaha.getOwner().getOpponent().hasWon()) {
			winner = firstKalaha.getOwner().getOpponent();
		} else {
			winner = null;
		}
		return winner;
	}
	
	public Player getActivePlayer() {
		Player activePlayer;
		if(firstKalaha.getOwner().isActive()) {
			activePlayer = firstKalaha.getOwner();
		} else {
			activePlayer = firstKalaha.getOwner().getOpponent();
		}
		return activePlayer;
	}
}