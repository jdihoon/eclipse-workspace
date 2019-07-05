package com.javalec.ex.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.command.BCommand;
import com.javalec.ex.command.BDeleteCommand;
import com.javalec.ex.command.BInsertCommand;
import com.javalec.ex.command.BSelectAllCommand;
import com.javalec.ex.command.BSelectCommand;
import com.javalec.ex.command.BUpdateCommand;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = uri.substring(contextPath.length());
		
		BCommand command = null;
		String viewPage = null;
		
		// selectAll ¸ðµç ÄÁÅÙÃ÷¸¦ °¡Á®¿Â´Ù.
		if(com.equals("/selectAll.do")) {
			
			command = new BSelectAllCommand();
			command.execute(request, response);
			viewPage = "list.jsp";			

		// select ÇÏ³ªÀÇ ÄÁÅÙÃ÷¸¸ °¡Á®¿Â´Ù.
		} else if (com.equals("/select.do")) {
			
			command = new BSelectCommand();
			command.execute(request, response);
			viewPage = "content.jsp";

		// ÄÁÅÙÃ÷¸¦ ÀÔ·ÂÇÑ´Ù.
		} else if(com.equals("/insert.do")) {
			
			command = new BInsertCommand();
			command.execute(request, response);
			viewPage = "selectAll.do";
		
		// ÄÁÅÙÃ÷¸¦ ¼öÁ¤ÇÑ´Ù.
		} else if(com.equals("/update.do")) {
			
			command = new BUpdateCommand();
			command.execute(request, response);
			viewPage = "selectAll.do";
			
		// ÄÁÅÙÃ÷¸¦ »èÁ¦ÇÑ´Ù.
		} else if(com.equals("/delete.do")) {
						
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "selectAll.do";
			
		}			
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
