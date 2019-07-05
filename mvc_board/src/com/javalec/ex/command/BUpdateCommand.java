package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.BDao;

public class BUpdateCommand implements BCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bId = request.getParameter("bId");
		
		BDao dao = new BDao();
		dao.update(bTitle, bContent, bId);
		
	}
}
