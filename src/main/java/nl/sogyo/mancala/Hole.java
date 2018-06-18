package nl.sogyo.mancala;

public class Hole extends Container {
	
	private final int rowLength = 6;
	private final int sides = 2;
	
	public Hole(int holesConstructed, int kalahasConstructed, Kalaha firstKalaha, Player owner) {
		
		holesConstructed++;
		super.setHoleStartContent();
		setOwner(owner);

		chooseNextContainerType(holesConstructed, kalahasConstructed, firstKalaha, owner);
	}
	
	/*
	 * Getters and setters
	 */
	
	public int getRowLength(){
		return rowLength;
	}
	
	/*
	 * Construction methods
	 */
	
	private void chooseNextContainerType(int holesConstructed, int kalahasConstructed, Kalaha firstKalaha, Player owner) {
		
		if(holesConstructed < rowLength) {
			super.setNextContainer(new Hole(holesConstructed, kalahasConstructed, firstKalaha, owner));
		}
		else if(kalahasConstructed < sides) {
			super.setNextContainer(new Kalaha(holesConstructed, kalahasConstructed, firstKalaha, owner));
		}
		else {
			super.setNextContainer(firstKalaha);
			this.getNextContainer().setOwner(owner);
		}
	}
	
	/*
	 * Movement methods
	 */
	
	public void grabAndDistribute() {
		
		int content = getContent();
		Container currentContainer = this;
		int originalContent = content;
		setContentToZero();
		Boolean extraMoves = false;
		for(int hand = originalContent; hand > 0; hand--) {
			currentContainer = currentContainer.getNextContainer();
			extraMoves = destinationCheck(currentContainer, hand);
			if(extraMoves == true) {
				hand++;
			}
		}
	}
	
	private Boolean destinationCheck(Container currentContainer, int hand) {
		
		Boolean extraMoves = false;
		if(currentContainer.getClass() == Hole.class) {
			encounterHole(currentContainer, hand);
		}
		else if(currentContainer.getClass() == Kalaha.class) {
			extraMoves = encounterKalaha(currentContainer, hand);
		}
		return extraMoves;
	}
	
	private Boolean encounterKalaha(Container currentContainer, int hand) {
		
		Boolean extraMoves = false;
		if(currentContainer.getOwner().isActive() == true) {
			currentContainer.addOneToContent();
			if(hand == 1) {currentContainer.getOwner().checkIfGameOver(currentContainer);}
			//Repeating of the player's turn is done because no switching of turns is initiated here
		}
		else {
			extraMoves = true;
		}
		return extraMoves;
	}
	
	private void encounterHole(Container currentContainer, int hand) {
		
		currentContainer.addOneToContent();
		if(hand == 1) {
			landOnHole(currentContainer);
		}
	}
	
	private void landOnHole(Container currentContainer) {
		
		if(currentContainer.getContent() == 1 && currentContainer.getOwner().isActive() == true) {
			strike(currentContainer);
		}
		currentContainer.getOwner().changeActive(currentContainer);
	}
	
	private void strike(Container currentContainer) {
		
		Container oppositeContainer = this.findOpposite();
		int loot = currentContainer.getContent()+oppositeContainer.getContent(); 
		oppositeContainer.setContentToZero();
		currentContainer.setContentToZero();
		Container associatedKalaha = findKalaha(currentContainer);
		associatedKalaha.addLootToContent(loot);
	}
	
	/*
	 * Search methods for finding certain positions
	 */
	
	public Container findOpposite() {
		
		Container currentContainer = this;
		int stepCounter = 0;
		while(currentContainer.getClass() != Kalaha.class) {
			currentContainer = currentContainer.getNextContainer();
			stepCounter++;
		}
		for(int i = 0; i < stepCounter; i++) {
			currentContainer = currentContainer.getNextContainer();
		}
		return currentContainer;
	}
	
	public Container findKalaha(Container currentContainer) {
		
		while(currentContainer.getClass() != Kalaha.class) {
			currentContainer = currentContainer.getNextContainer();
		}
		return currentContainer;
	}
}
