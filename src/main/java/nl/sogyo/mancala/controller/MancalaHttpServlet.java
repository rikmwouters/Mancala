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
		} else if (request.getParameter("hole1") != null) {
            //BoardDTO.getMancalaGame().chooseHole(1);
        } else if (request.getParameter("hole2") != null) {
        	//mancalaGame.chooseHole(2);
        } else if (request.getParameter("hole3") != null) {
        	//mancalaGame.chooseHole(3);
        } else {
            // ???
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
		PlayersDTO playersDTO = new PlayersDTO();
		playersDTO.setNameP1(nameP1);
		playersDTO.setNameP2(nameP2);
		session.setAttribute("Players", playersDTO);
		BoardDTO boardDTO = new BoardDTO();
	    session.setAttribute("Mancala", boardDTO.getMancalaGame());
	    
	    return "./Session.jsp";
	}
	
	private String processMakeMove(HttpServletRequest request) {
		return null;
	}
	
	
}
