package com.javalec.spring_pjt_board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.spring_pjt_board.command.BCommand;
import com.javalec.spring_pjt_board.command.BInsertCommand;
import com.javalec.spring_pjt_board.command.BSelectAllCommand;
import com.javalec.spring_pjt_board.command.BSelectCommand;

@Controller
public class BController {
	
	BCommand command;
	
	@RequestMapping("selectAll")
	public String list(Model model) {
		
		command = new BSelectAllCommand();
		command.execute(model);
		
		return "selectAll";
	}
	
	
	@RequestMapping("select")
	public String content(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BSelectCommand();
		command.execute(model);
		
		return "select";
	}
	
	
	@RequestMapping("insert_view")
	public String write_view(Model model) {
		
		return "insert_view";
	}
	
	@RequestMapping("insert")
	public String write(HttpServletRequest request, Model model)
	{
		model.addAttribute("request", request);
		
		command = new BInsertCommand();
		command.execute(model);
		
		return "redirect:selectAll";
	}

}
