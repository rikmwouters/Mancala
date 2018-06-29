package nl.sogyo.mancala.domain;

public class Mancala {
	public Kalaha firstKalaha;
	
	public Mancala() {
		firstKalaha = new Kalaha(0,0,null,null);
		firstKalaha.getOwner().connectPlayers(firstKalaha);
	}
	
	public String chooseHole(int position) {
		Container currentContainer = firstKalaha;
		if(firstKalaha.getOwner().isActive() && position > 7 || firstKalaha.getOwner().getOpponent().isActive() && position < 7) {
			currentContainer = currentContainer.stepsForward(position);
			if(currentContainer.getContent() > 0) {
				((Hole) currentContainer).processHoleChoice();
			} else {
				return "empty";
			}
		} else {
			return "wrongside";
		}
		return "correct";
	}
	
	public int[] getAllContent() {
		Container currentContainer = firstKalaha;
		int[] AllContent = new int[14];
		for(int i = 0; i < 14; i++) {
			AllContent[i] = currentContainer.getContent();
			currentContainer = currentContainer.getNextContainer();
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
		} else if(firstKalaha.getOwner().gameIsFinished() || firstKalaha.getOwner().getOpponent().gameIsFinished()) {
			//An unknown player is given in case of a stalemate
			winner = new Player(false, null);
		}
		else {
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
	
	public Player getPlayer1() {
		return firstKalaha.getOwner().getOpponent();
	}
	
	public Player getPlayer2() {
		return firstKalaha.getOwner();
	}
}
