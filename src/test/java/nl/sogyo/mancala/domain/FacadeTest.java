package nl.sogyo.mancala.domain;

import org.junit.Assert;
import org.junit.Test;

public class FacadeTest {
	
	@Test
	public void accessToActivePlayerInFirstKalaha() {
		Mancala mancala = new Mancala();
		Assert.assertNotNull(mancala.getActivePlayer());
	}

	@Test
	public void accessToOpponentInFirstKalaha() {
		Mancala mancala = new Mancala();
		Assert.assertNotNull(mancala.getActivePlayer().getOpponent());
	}
	
	@Test
	public void accessToRowContent() {
		Mancala mancala = new Mancala();
		Assert.assertNotNull(mancala.firstKalaha.findTotalRowContent());
	}
	
	@Test
	public void accessToOwnerOfHole() {
		Mancala mancala = new Mancala();
		Assert.assertNotNull(mancala.firstKalaha.stepsForward(2).getOwner());
	}
	
	@Test
	public void accessToOwnerOfFirstKalaha() {
		Mancala mancala = new Mancala();
		Assert.assertNotNull(mancala.firstKalaha.getOwner());
	}
	
	@Test
	public void accessToOpponentOfOwnerOfFirstKalaha() {
		Mancala mancala = new Mancala();
		Assert.assertNotNull(mancala.firstKalaha.getOwner().getOpponent());
	}
	
	@Test
	public void accessToOpponentOfOwnerOfHole() {
		Mancala mancala = new Mancala();
		Assert.assertNotNull(mancala.firstKalaha.stepsForward(2).getOwner().getOpponent());
	}
	
	@Test
	public void holeChoiceLeadsToCorrectSpread() {
		Mancala mancala = new Mancala();
		Container currentContainer = mancala.firstKalaha.getNextContainer().getNextContainer();
		
		for(int i = 0; i < 12; i++) {
			currentContainer.setContentToZero();
			currentContainer = currentContainer.getNextContainer();
		}
		
		mancala.chooseHole(1);
		Assert.assertEquals(mancala.firstKalaha.stepsForward(1).getContent(), 0);
		Assert.assertEquals(mancala.firstKalaha.stepsForward(2).getContent(), 1);
		Assert.assertEquals(mancala.firstKalaha.stepsForward(4).getContent(), 1);
		Assert.assertEquals(mancala.firstKalaha.stepsForward(5).getContent(), 0);
	}
	
	@Test
	public void playerWinsAfterFinalMove() {
		Mancala mancala = new Mancala();
		Container currentContainer = mancala.firstKalaha.getNextContainer().getNextContainer();
		
		for(int i = 0; i < 12; i++) {
			currentContainer.setContentToZero();
			currentContainer = currentContainer.getNextContainer();
		}
		
		mancala.chooseHole(1);
		Assert.assertNotNull(mancala.determineWinner());
	}

	@Test
	public void holeChoiceLeadsToCorrectWrongSideError() {
		Mancala mancala = new Mancala();
		
		String moveStatus = mancala.chooseHole(9);
		Assert.assertEquals("wrongside", moveStatus);
	}
	
	@Test
	public void holeChoiceLeadsToCorrectEmptyHoleError() {
		Mancala mancala = new Mancala();
		Container currentContainer = mancala.firstKalaha.getNextContainer().getNextContainer();
		
		for(int i = 0; i < 12; i++) {
			currentContainer.setContentToZero();
			currentContainer = currentContainer.getNextContainer();
		}
		
		String moveStatus = mancala.chooseHole(2);
		Assert.assertEquals("empty", moveStatus);
	}
	
	@Test
	public void getAllContentGetsCorrectContent() {
		Mancala mancala = new Mancala();
		Container currentContainer = mancala.firstKalaha;
		
		int[] allContent = mancala.getAllContent();
		int[] expected = {0,4,4,4,4,4,4,0,4,4,4,4,4,4};
		
		for(int i = 0; i < 14; i++) {
			Assert.assertEquals(expected[i], allContent[i]);
			currentContainer = currentContainer.getNextContainer();
		}
	}
	
	@Test
	public void findContentCorrectly() {
		Mancala mancala = new Mancala();
		mancala.chooseHole(2);
		
		Assert.assertEquals(4, mancala.findContent(1));
	}
	
}
