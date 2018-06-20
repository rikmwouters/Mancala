package nl.sogyo.mancala.domain;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

public class StartBoardTests {

	/*
	 * First Container tests
	 */
	
    @Test
    public void doesFirstContainerHaveNeighbor() {
    	Container currentContainer = new Kalaha(0,0,null,null);
    	Assert.assertNotNull(currentContainer.getNextContainer());
    }
    @Test
    public void firstKalahaContentNotNull() {
    	Container currentContainer = new Kalaha(0,0,null,null);
    	Assert.assertNotNull(currentContainer.getContent());
    }
    @Test
    public void firstKalahaContentZero() {
    	Container currentContainer = new Kalaha(0,0,null,null);
    	Assert.assertEquals(0, currentContainer.getContent());
    }
    
    /*
     * Total field tests
     */
	
    @Test
    public void firstHoleContentFour() {
    	Container currentContainer = new Kalaha(0,0,null,null);
    	currentContainer = currentContainer.stepsForward(1);
    	Assert.assertEquals(4, currentContainer.getContent());
    }
    
    @Test
    public void sixthHoleContentFour() {
    	Container currentContainer = new Kalaha(0,0,null,null);
    	currentContainer = currentContainer.stepsForward(6);
    	Assert.assertEquals(4, currentContainer.getContent());
    }
    
    @Test
    public void secondKalahaContentZero() {
    	Container currentContainer = new Kalaha(0,0,null,null);
    	currentContainer = currentContainer.stepsForward(7);
    	Assert.assertEquals(0, currentContainer.getContent());
    }
    
	@Test
	public void correctNumbersOfStones() {
		Container currentContainer = new Kalaha(0,0,null,null);
		for(int i = 0; i < 21; i++) {
			if (i % 7 == 0) {
				Assert.assertEquals(0, currentContainer.getContent());
			}
			else {
				Assert.assertEquals(4, currentContainer.getContent());
			}
			currentContainer = currentContainer.getNextContainer();
		}
	}
	
	@Test
	public void correctTypesOfContainers() {
		Container currentContainer = new Kalaha(0,0,null,null);
		for(int i = 0; i < 21; i++) {
			if (i % 7 == 0) {
				assertThat(currentContainer, instanceOf(Kalaha.class));
			}
			else {
				assertThat(currentContainer, instanceOf(Hole.class));
			}
			currentContainer = currentContainer.getNextContainer();
		}
	}
	
}
