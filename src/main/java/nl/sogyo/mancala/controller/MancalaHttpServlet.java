package nl.sogyo.mancala.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.sogyo.mancala.controller.dto.BoardDTO;
import nl.sogyo.mancala.controller.dto.PlayersDTO;
import nl.sogyo.mancala.domain.Mancala;

/**
 * Servlet implementation class MancalaHttpServlet
 */
@WebServlet("/MancalaHttpServlet")
public class MancalaHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    /*public MancalaHttpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		String resource = "./Session.jsp";
		if ("newNames".equalsIgnoreCase(action)) {
			resource = this.processNewGame(request);
		} else if (request.getParameter("button") != null) {
			resource = this.processMakeMove(request);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(resource);
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
private String processNewGame(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String nameP1 = request.getParameter("nameP1");
		String nameP2 = request.getParameter("nameP2");
		PlayersDTO playersDTO = new PlayersDTO(nameP1, nameP2);
		session.setAttribute("Players", playersDTO);
		Mancala mancalaGame = new Mancala();
		BoardDTO boardDTO = new BoardDTO(mancalaGame);
	    session.setAttribute("Board", boardDTO);
	    session.setAttribute("MancalaGame", mancalaGame);
	    
	    return "./Session.jsp";
	}
	
	private String processMakeMove(HttpServletRequest request) {
		
		HttpSession session = request.getSession(); 
		BoardDTO boardDTO = (BoardDTO)session.getAttribute("Board");
		Mancala mancalaGame = (Mancala)session.getAttribute("MancalaGame");
		
		mancalaGame.chooseHole(Integer.parseInt(request.getParameter("button")));
		
		boardDTO = new BoardDTO(mancalaGame);
		session.setAttribute("MancalaGame", mancalaGame);
		session.setAttribute("Board", boardDTO);
		
		
		return "./Session.jsp";
	}
	
	
}
