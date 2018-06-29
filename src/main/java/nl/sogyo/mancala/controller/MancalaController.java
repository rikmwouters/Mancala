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
		PlayersDTO playersDTO = new PlayersDTO(nameP1, nameP2, mancalaGame);
		session.setAttribute("Players", playersDTO);
		
		
	    
	    MessageDTO messageDTO = new MessageDTO();
	    messageDTO.pushPlayerTurnMessage(playersDTO.getActivePlayerName());
	    session.setAttribute("Message", messageDTO);
	    
	    return "./Mancala.jsp";
	}
	
	private String processMakeMove(HttpServletRequest request) {
		
		HttpSession session = request.getSession(); 
		Mancala mancalaGame = (Mancala)session.getAttribute("MancalaGame");
		MessageDTO messageDTO = (MessageDTO)session.getAttribute("Message");
		PlayersDTO playersDTO = (PlayersDTO)session.getAttribute("Players");
		
		String moveStatus = mancalaGame.chooseHole(Integer.parseInt(request.getParameter("MakeMove")));
		if(mancalaGame.determineWinner() != null) {
			processEndGame(request, mancalaGame);
		} else if(moveStatus.equals("correct")) {
			messageDTO.pushPlayerTurnMessage(playersDTO.getActivePlayerName());
		} else if(moveStatus.equals("empty")) {
			messageDTO.pushEmptyHoleMessage();
		} else if(moveStatus.equals("wrongside")) {
			messageDTO.pushWrongSideMessage();
		}
		
		session.setAttribute("Message", messageDTO);
		
		BoardDTO boardDTO = new BoardDTO(mancalaGame.getAllContent());
		session.setAttribute("MancalaGame", mancalaGame);
		session.setAttribute("Board", boardDTO);
		
		
		return "./Mancala.jsp";
	}
	
	private void processEndGame(HttpServletRequest request, Mancala mancalaGame) {
		
		HttpSession session = request.getSession(); 
		PlayersDTO playersDTO = (PlayersDTO)session.getAttribute("Players");
		String winner = playersDTO.getPlayerNameFromObject(mancalaGame.determineWinner());
		
		MessageDTO messageDTO = (MessageDTO)session.getAttribute("Message");
		messageDTO.pushPlayerWinMessage(winner);
		session.setAttribute("Message", messageDTO);

	}
	
	
}
