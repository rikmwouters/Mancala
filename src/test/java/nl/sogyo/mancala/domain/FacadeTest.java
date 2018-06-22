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
}
