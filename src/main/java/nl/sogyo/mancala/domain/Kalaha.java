package nl.sogyo.mancala.domain;

public class Kalaha extends Container {
	
	public Kalaha(int holesConstructed, int kalahasConstructed, Kalaha firstKalaha, Player owner) {
		
		kalahasConstructed++;
		setOwner(owner);
		holesConstructed = 0;
		Player ownerOfNextRow;
		
		if(kalahasConstructed == 1) {
			firstKalaha = this;
			ownerOfNextRow = new Player(true, null);
		}
		else {
			ownerOfNextRow = new Player(false, null);
		}
		
		super.setNextContainer(new Hole(holesConstructed, kalahasConstructed, firstKalaha, ownerOfNextRow));
	}
	
	public int findTotalRowContent() {
		Container currentContainer = this;
		int rowLength = ((Hole) currentContainer.stepsForward(1)).getRowLength();
		
		int totalRowContent = 0;
		for(int i=0; i<rowLength; i++) {
			currentContainer = currentContainer.stepsForward(1);
			totalRowContent = totalRowContent + currentContainer.getContent();
		}
		return totalRowContent;
	}
}
