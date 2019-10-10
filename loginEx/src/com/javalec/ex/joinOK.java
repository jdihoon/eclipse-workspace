package com.javalec.ex;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class joinOK
 */
@WebServlet("/joinOK")
public class joinOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinOK() {
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
	
	
	/**
	 *	회원가입을 실행하는 메소드
	 */
	
	private Connection connection;
	private Statement statement;

	//private ResultSet resultSet;
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("EUC-KR");
		
		int result = 0;
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String gender = request.getParameter("gender");
		
		String sql = "insert into member(name, id, pw, phone1, phone2, phone3, gender) values(";
		sql += "'" + name + "'";
		sql += ", '" + id + "'";
		sql += ", '" + pw + "'";
		sql += ", '" + phone1 + "'";
		sql += ", '" + phone2 + "'";
		sql += ", '" + phone3 + "'";
		sql += ", '" + gender + "'";
		sql += ")";
		
		// response.getWriter().append(sql);
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@10.0.2.15:1521:xe", "scott", "tiger");
			statement = connection.createStatement();
			result = statement.executeUpdate(sql);
			
			if(result == 1) {
				response.getWriter().append("<h2> 입력이 성공하였습니다. </h2><br /><br />");
				
				response.getWriter().append("<a href = 'login.html'>로그인");
			}
			else if(result == 0) response.getWriter().append("<h2> 입력에 실패하였습니다. </h2>");
			
		} catch (Exception e) {
			
			response.getWriter().append(e.getMessage());
			
		} finally {
			try {
				
				if(connection != null) connection.close();
				if(statement != null) statement.close();
				
			} catch(Exception e2) {
				
				response.getWriter().append(e2.getMessage());
				
			}
		}
		
	}

}
