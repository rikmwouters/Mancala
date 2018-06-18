package nl.sogyo.mancala;

public class Container {

	private int content = 0;
	private Player owner;
	private Container nextContainer = null;
	
	/*
	 * Getters and setters
	 */
	
	public Container getNextContainer() {
		return nextContainer;
	}
	
	public void setNextContainer(Container nextContainer) {
		this.nextContainer = nextContainer;
	}
	
	public int getContent() {
		return content;
	}
	
	//here for testing
	public void setContent(int content) {
		this.content = content;
	}
	
	public void setHoleStartContent() {
		this.content = 4;
	}
	
	public void setContentToZero() {
		this.content = 0;
	}
	
	public void addOneToContent() {
		content++;
	}
	
	public void addLootToContent(int loot) {
		if(this.getClass() == Kalaha.class) {
			content=content+loot;
		}
		else {
			System.out.println("The loot can't be added to a hole.");
		}
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player player) {
		this.owner = player;
	}
	
	/*
	 * Movement method
	 */
	
	public Container stepsForward(int steps) {
		Container currentContainer = this;
		for(int i = 0; i < steps; i++) {
			currentContainer = currentContainer.getNextContainer();
		}
		return currentContainer;
	}

}
