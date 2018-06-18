package nl.sogyo.mancala;

import org.junit.Assert;
import org.junit.Test;

public class MancalaTest {
	
	@Test
	public void firstKalahaOwnerNotNull() {
		Container currentContainer = new Kalaha(0,0,null,null);
		currentContainer.getOwner().connectPlayers(currentContainer);
		Player player1 = currentContainer.getOwner();
		Assert.assertNotNull(player1);
	}
	
	@Test
	public void secondKalahaOwnerNotNull() {
		Container currentContainer = new Kalaha(0,0,null,null);
		currentContainer.getOwner().connectPlayers(currentContainer);
		int stepsUntilNextKalaha = 7;
		currentContainer = currentContainer.stepsForward(stepsUntilNextKalaha);
		Player player2 = currentContainer.getOwner();
		Assert.assertNotNull(player2);
	}
	
	@Test
	public void kalahaOwnersNotTheSame() {
		Container currentContainer = new Kalaha(0,0,null,null);
		currentContainer.getOwner().connectPlayers(currentContainer);
		Player player1 = currentContainer.getOwner();
		int stepsUntilNextKalaha = 7;
		currentContainer = currentContainer.stepsForward(stepsUntilNextKalaha);
		Player player2 = currentContainer.getOwner();
		Assert.assertNotEquals(player1, player2);
	}
	
	@Test
	public void playersKnowEachOther() {
		Container currentContainer = new Kalaha(0,0,null,null);
		currentContainer.getOwner().connectPlayers(currentContainer);
		Player player1 = currentContainer.getOwner();
		Player player2 = player1.getOpponent();
		Assert.assertEquals(player1, player2.getOpponent());
	}
	
	@Test
	public void correctWithdrawal() {
		Container currentContainer = new Kalaha(0,0,null,null);
		currentContainer.getOwner().connectPlayers(currentContainer);
		int chosenHole = 3;
		currentContainer = currentContainer.stepsForward(chosenHole);
		((Hole) currentContainer).processHoleChoice();
		Assert.assertEquals(0, currentContainer.getContent());
	}
	
	//Used by various tests, no test on itself
	public void checkNumbersOfStonesInContainers(Container currentContainer, int[] expectedValues, int originalContent) {
		int extraMoves = 0;
		for(int i = 0; i < originalContent+extraMoves; i++) {
			currentContainer = currentContainer.stepsForward(1);
			Assert.assertEquals(expectedValues[i], currentContainer.getContent());
			if(currentContainer.getClass() == Kalaha.class && currentContainer.getOwner().isActive() == false) {
				extraMoves++;
			}

		}
	}
	
	@Test
	public void checkIfStonesAreDepositedInOwnKalaha() {
		Container currentContainer = new Kalaha(0,0,null,null);
		currentContainer.getOwner().connectPlayers(currentContainer);
		int chosenHole = 3;
		currentContainer = currentContainer.stepsForward(chosenHole);
		int originalContent = currentContainer.getContent();
		((Hole) currentContainer).processHoleChoice();
		
		int[] expectedValues = {5,5,5,1,4};
		checkNumbersOfStonesInContainers(currentContainer, expectedValues, originalContent);
	}
	
	@Test
	public void checkIfStonesAreNotDepositedInOtherKalaha() {
		Container currentContainer = new Kalaha(0,0,null,null);
		currentContainer.getOwner().connectPlayers(currentContainer);
		int chosenHole = 3;
		currentContainer = currentContainer.stepsForward(chosenHole);
		currentContainer.setContent(16);
		int originalContent = currentContainer.getContent();
		((Hole) currentContainer).processHoleChoice();
		
		int[] correctValues = {6,6,6,1,5,5,5,5,5,5,0,5,5,1,6,6,6};
		checkNumbersOfStonesInContainers(currentContainer, correctValues, originalContent);
	}
	
	@Test
	public void checkIfHoleFindsCorrectOppositeHole() {
		Container currentContainer = new Kalaha(0,0,null,null);
		currentContainer.getOwner().connectPlayers(currentContainer);
		currentContainer = currentContainer.stepsForward(1);
		Assert.assertEquals(currentContainer, ((Hole) ((Hole) currentContainer).findOpposite()).findOpposite());
	}
	
	@Test
	public void correctStonePlacementWithStrike() {
		Container currentContainer = new Kalaha(0,0,null,null);
		currentContainer.getOwner().connectPlayers(currentContainer);
		currentContainer = currentContainer.stepsForward(6);
		currentContainer.setContent(0);
		currentContainer = currentContainer.stepsForward(8);
		int chosenHole = 2;
		currentContainer = currentContainer.stepsForward(chosenHole);
		int originalContent = currentContainer.getContent();
		((Hole) currentContainer).processHoleChoice();
		
		int[] correctValues = {5,5,5,0,5,0};
		checkNumbersOfStonesInContainers(currentContainer, correctValues, originalContent);
	}
	
	@Test
	public void correctActivePlayerAtStartTurn() {
		Container currentContainer = new Kalaha(0,0,null,null);
		currentContainer.getOwner().connectPlayers(currentContainer);
		Assert.assertFalse(currentContainer.getOwner().isActive());
	}
	
	@Test
	public void workingSwitchOfActivePlayerMethod() {
		Container currentContainer = new Kalaha(0,0,null,null);
		currentContainer.getOwner().connectPlayers(currentContainer);
		Assert.assertFalse(currentContainer.getOwner().isActive());
		currentContainer.getOwner().changeActive(currentContainer);
		Assert.assertTrue(currentContainer.getOwner().isActive());
	}
	
	@Test
	public void checkIfActivePlayerChangesAfterMove() {
		Container currentContainer = new Kalaha(0,0,null,null);
		currentContainer.getOwner().connectPlayers(currentContainer);
		currentContainer = currentContainer.stepsForward(1);
		Assert.assertTrue(currentContainer.getOwner().isActive());
		((Hole) currentContainer).processHoleChoice();
		
		Assert.assertFalse(currentContainer.getOwner().isActive());
	}
	
	@Test
	public void correctRepeatTurnAfterLandingInOwnKalaha() {
		Container currentContainer = new Kalaha(0,0,null,null);
		currentContainer.getOwner().connectPlayers(currentContainer);
		currentContainer = currentContainer.stepsForward(1);
		currentContainer.setContent(6);
		Assert.assertTrue(currentContainer.getOwner().isActive());
		((Hole) currentContainer).processHoleChoice();
		
		Assert.assertTrue(currentContainer.getOwner().isActive());
	}
	
	@Test
	public void checkForEmptySideIsWorking() {
		Container currentContainer = new Kalaha(0,0,null,null);
		currentContainer.getOwner().connectPlayers(currentContainer);
		
		for(int i=0; i<6; i++) {
			currentContainer = currentContainer.stepsForward(1);
			currentContainer.setContent(0);
		}
		currentContainer = currentContainer.stepsForward(1);
		currentContainer.setContent(99);
		
		currentContainer.getOwner().checkIfGameOver(currentContainer);
		
		Assert.assertTrue(currentContainer.getOwner().hasWon());
	}
}
