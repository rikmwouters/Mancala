package nl.sogyo.mancala.domain;

public class Mancala {
	public Kalaha firstKalaha;
	
	public Mancala() {
		firstKalaha = new Kalaha(0,0,null,null);
		firstKalaha.getOwner().connectPlayers(firstKalaha);
	}
	
	public void chooseHole(int position) {
		Container currentContainer = firstKalaha;
		if(firstKalaha.getOwner().isActive() && position > 7 || firstKalaha.getOwner().getOpponent().isActive() && position < 7) {
			currentContainer = currentContainer.stepsForward(position);
			if(currentContainer.stepsForward(position).getContent() > 0) {
				((Hole) currentContainer).processHoleChoice();
			}
		}
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
	
	public int findContent(int position) {
		Container currentContainer = firstKalaha;
		for(int i = 0; i < position; i++) {
			currentContainer = currentContainer.getNextContainer();
		}
		int content = currentContainer.getContent();
		return content;
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
