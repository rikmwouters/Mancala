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
import nl.sogyo.mancala.controller.dto.PlayersDTO;
import nl.sogyo.mancala.domain.Mancala;

/**
 * Servlet implementation class MancalaHttpServlet
 */
@WebServlet("/MancalaHttpServlet")
public class MancalaHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardDTO boardDTO;
       
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
		
		//String action = request.getParameter("action");
		
		/*String resource = null;
		if ("newGame".equalsIgnoreCase(action)) {
			resource = this.processNewGame(request);
		} else if ("makeMove".equalsIgnoreCase(action)) {
			resource = this.processMakeMove(request);
		}*/
		
		if(request.getParameter("nameP1") != null && request.getParameter("nameP2") != null) {
			processNewGame(request);
        } else {
            processMakeMove(request);
        }
		
		RequestDispatcher rd = request.getRequestDispatcher("./Session.jsp");
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
		boardDTO = new BoardDTO();
	    session.setAttribute("Board", boardDTO);
	    
	    return "./Session.jsp";
	}
	
	private String processMakeMove(HttpServletRequest request) {
		
		if (request.getParameter("hole1") != null) {
            boardDTO.getMancalaGame().chooseHole(1);
        } else if (request.getParameter("hole2") != null) {
        	boardDTO.getMancalaGame().chooseHole(2);
        } else if (request.getParameter("hole3") != null) {
        	boardDTO.getMancalaGame().chooseHole(3);
        } else if (request.getParameter("hole4") != null) {
        	boardDTO.getMancalaGame().chooseHole(4);
        } else if (request.getParameter("hole5") != null) {
        	boardDTO.getMancalaGame().chooseHole(5);
        } else if (request.getParameter("hole6") != null) {
        	boardDTO.getMancalaGame().chooseHole(6);
        } else if (request.getParameter("hole7") != null) {
        	boardDTO.getMancalaGame().chooseHole(8);
        } else if (request.getParameter("hole8") != null) {
        	boardDTO.getMancalaGame().chooseHole(9);
        } else if (request.getParameter("hole9") != null) {
        	boardDTO.getMancalaGame().chooseHole(10);
        } else if (request.getParameter("hole10") != null) {
        	boardDTO.getMancalaGame().chooseHole(11);
        } else if (request.getParameter("hole11") != null) {
        	boardDTO.getMancalaGame().chooseHole(12);
        } else if (request.getParameter("hole12") != null) {
        	boardDTO.getMancalaGame().chooseHole(13);
        }
		return "./Session.jsp";
	}
	
	
}
