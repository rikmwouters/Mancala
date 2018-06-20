package nl.sogyo.mancala;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.sogyo.helloworld.controller.dto.HelloDTO;

/**
 * Servlet implementation class MancalaHttpServlet
 */
@WebServlet("/MancalaHttpServlet")
public class MancalaHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MancalaHttpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		String resource = null;
		if ("newGame".equalsIgnoreCase(action)) {
			resource = this.processNewGame(request);
		} else if ("makeMove".equalsIgnoreCase(action)) {
			resource = this.processMakeMove(request);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("viewBoard.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String processNewGame(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String playerName = request.getParameter("name");
		session.setAttribute("PlayerName", playerName);
		BoardDTO boardDTO = new BoardDTO();
	    session.setAttribute("Mancala", boardDTO.getMancalaGame());
	    
	    return "./viewBoard.jsp";
	}
	
	private void processMakeMove() {
		
	}

}
