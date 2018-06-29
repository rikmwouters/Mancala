package nl.sogyo.mancala.controller.dto;

public class BoardDTO {

	private int[] allContent;
	
	public BoardDTO(int[] allContent) {
		this.allContent = allContent;
	}
	
	public BoardDTO() {
		
	}
	
	public int getHole1Content() {
		return allContent[1];
	}
	
	public int getHole2Content() {
		return allContent[2];
	}
	
	public int getHole3Content() {
		return allContent[3];
	}
	
	public int getHole4Content() {
		return allContent[4];
	}
	
	public int getHole5Content() {
		return allContent[5];
	}
	
	public int getHole6Content() {
		return allContent[6];
	}
	
	public int getKalaha1Content() {
		return allContent[7];
	}
	
	public int getHole7Content() {
		return allContent[8];
	}
	
	public int getHole8Content() {
		return allContent[9];
	}
	
	public int getHole9Content() {
		return allContent[10];
	}
	
	public int getHole10Content() {
		return allContent[11];
	}
	
	public int getHole11Content() {
		return allContent[12];
	}
	
	public int getHole12Content() {
		return allContent[13];
	}
	
	public int getKalaha2Content() {
		return allContent[0];
	}
}
