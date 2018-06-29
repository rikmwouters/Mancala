package nl.sogyo.mancala.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.sogyo.mancala.controller.dto.BoardDTO;
import nl.sogyo.mancala.controller.dto.MessageDTO;
import nl.sogyo.mancala.controller.dto.PlayersDTO;
import nl.sogyo.mancala.domain.Mancala;
import nl.sogyo.mancala.domain.Player;

@WebServlet("/MancalaController")
public class MancalaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		String resource = "./Mancala.jsp";
		if ("NewGame".equalsIgnoreCase(action)) {
			resource = this.processNewGame(request);
		} else if ("MakeMove".equalsIgnoreCase(action)) {
			resource = this.processMakeMove(request);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(resource);
	    rd.forward(request, response);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	private String processNewGame(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Mancala mancalaGame = new Mancala();
		
		BoardDTO boardDTO = new BoardDTO(mancalaGame.getAllContent());
	    session.setAttribute("Board", boardDTO);
	    session.setAttribute("MancalaGame", mancalaGame);
		
		String nameP1 = request.getParameter("nameP1");
		String nameP2 = request.getParameter("nameP2");
		PlayersDTO playersDTO = new PlayersDTO(nameP1, nameP2);
		session.setAttribute("Players", playersDTO);
		
	    MessageDTO messageDTO = new MessageDTO();
	    messageDTO.pushPlayerTurnMessage(getActivePlayerName(request));
	    session.setAttribute("Message", messageDTO);
	    
	    return "./Mancala.jsp";
	}
	
	private String processMakeMove(HttpServletRequest request) {
		
		HttpSession session = request.getSession(); 
		Mancala mancalaGame = (Mancala)session.getAttribute("MancalaGame");
		MessageDTO messageDTO = (MessageDTO)session.getAttribute("Message");
		
		String moveStatus = mancalaGame.chooseHole(Integer.parseInt(request.getParameter("MakeMove")));
		if(moveStatus.equals("correct")) {
			messageDTO.pushPlayerTurnMessage(getActivePlayerName(request));
		} else if(moveStatus.equals("empty")) {
			messageDTO.pushEmptyHoleMessage();
		} else if(moveStatus.equals("wrongside")) {
			messageDTO.pushWrongSideMessage();
		}
		if(mancalaGame.determineWinner() != null) {
			processEndGame(request, mancalaGame);
		}
		session.setAttribute("Message", messageDTO);
		
		BoardDTO boardDTO = new BoardDTO(mancalaGame.getAllContent());
		session.setAttribute("MancalaGame", mancalaGame);
		session.setAttribute("Board", boardDTO);
		
		return "./Mancala.jsp";
	}
	
	private void processEndGame(HttpServletRequest request, Mancala mancalaGame) {
		
		HttpSession session = request.getSession(); 
		String winner = getPlayerNameFromObject(request, mancalaGame.determineWinner());
		
		MessageDTO messageDTO = (MessageDTO)session.getAttribute("Message");
		messageDTO.pushPlayerWinMessage(winner);
		session.setAttribute("Message", messageDTO);
	}
	
	private String getPlayerNameFromObject(HttpServletRequest request, Player player) {
		
		HttpSession session = request.getSession(); 
		Mancala mancalaGame = (Mancala)session.getAttribute("MancalaGame");
		PlayersDTO playersDTO = (PlayersDTO)session.getAttribute("Players");
		
		if(player == mancalaGame.getPlayer1()) {
			return playersDTO.getNameP1();
		} else if(player == mancalaGame.getPlayer2()) {
			return playersDTO.getNameP2();
		} else if(player != null) {
			//An unknown player is given in case of a stalemate and is hereby changed into a marker string
			return "#Stalemate";
		} else {
			return null;
		}
	}
	
	private String getActivePlayerName(HttpServletRequest request) {
		
		HttpSession session = request.getSession(); 
		Mancala mancalaGame = (Mancala)session.getAttribute("MancalaGame");
		
		Player activePlayer = mancalaGame.getActivePlayer();
		return getPlayerNameFromObject(request, activePlayer);
	}
}
