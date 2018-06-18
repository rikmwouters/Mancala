package nl.sogyo.mancala;

public class Mancala {
	private Kalaha firstKalaha;
	
	public Mancala() {
		firstKalaha = new Kalaha(0,0,null,null);
	}
	
	public void chooseHole(int position) {
		Container currentContainer = firstKalaha.stepsForward(position);
		((Hole) currentContainer).processHoleChoice();
	}
	
	public int[] getAllContent() {
		Container currentContainer = firstKalaha;
		int[] contentOfAllContainers = new int[14];
		for(int i = 0; i < 14; i++) {
			contentOfAllContainers[i] = currentContainer.getContent();
			currentContainer = firstKalaha.stepsForward(1);
		}
		return contentOfAllContainers;
	}
	
	public Container findStartingPosition() {
		Container currentContainer = firstKalaha;
		while(currentContainer.getClass() != Kalaha.class || currentContainer.getOwner().isActive() == true) {
			currentContainer = currentContainer.getNextContainer();
		}
		return currentContainer;
	}
}
