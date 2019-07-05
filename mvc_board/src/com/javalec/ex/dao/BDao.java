package com.javalec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.javalec.ex.dto.BDto;

public class BDao {

	DataSource datasource;
	
	public BDao() {
		// TODO Auto-generated constructor stub
		try {			
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle18g"); 
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<BDto> selectAll() {
		
		Connection connection = null;
		PreparedStatement preparestatement = null;
		ResultSet result = null;
		
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		
		try {
			connection = datasource.getConnection();
			preparestatement = connection.prepareStatement(query);
			result = preparestatement.executeQuery();
			
			while(result.next()) {
				int bId = result.getInt("bId");
				String bName = result.getString("bName");
				String bTitle = result.getString("bTitle");
				String bContent = result.getString("bContent");
				Timestamp bDate = result.getTimestamp("bDate");
				int bHit = result.getInt("bHit");
				int bGroup = result.getInt("bGroup");
				int bStep = result.getInt("bStep");
				int bIndent = result.getInt("bIndent");
				
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				
				dtos.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		} finally {
			try {
				if(connection != null) connection.close();
				if(preparestatement != null) preparestatement.close();
				if(result != null) result.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return dtos;
	}
	
	
	public BDto select(int bId) {
		
		// 읽은 숫자 증가
		increaseOneHit(bId);
		
		BDto dto = null;
		Connection connection = null;
		PreparedStatement preparestatement = null;
		ResultSet result = null;		
		
		try {
			String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board where bId = " + bId;
			
			connection = datasource.getConnection();
			preparestatement = connection.prepareStatement(query);
			result = preparestatement.executeQuery();
			
			while(result.next()) {
				
				int bId1 = result.getInt("bId");
				String bName = result.getString("bName");
				String Title = result.getString("bTitle");
				String bContent = result.getString("bContent");
				Timestamp bDate = result.getTimestamp("bDate");
				int bHit = result.getInt("bHit");
				int bGroup = result.getInt("bGroup");
				int bStep = result.getInt("bStep");
				int bIndent = result.getInt("bIndent");
				
				dto = new BDto(bId1, bName, Title, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) connection.close();
				if(preparestatement != null) preparestatement.close();
				if(result != null) result.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		
		return dto;
	}
	
	
	private void increaseOneHit(int bId) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		try {
			
			String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
			
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, bId);
			result = preparedStatement.executeUpdate();			
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			
			try {
				
				connection.close();
				preparedStatement.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void insert(String bName, String bTitle, String bContent)
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		try {
			
			String query  = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) ";
				   query += "values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";				   
			
			connection = datasource.getConnection();			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			result = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			
			try {
				connection.close();
				preparedStatement.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void update(String bTitle, String bContnet, String bId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		try {
			
			String query  = "update mvc_board set bTitle = ?, bContent = ? where bId = ?";   
			
			connection = datasource.getConnection();			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bTitle);
			preparedStatement.setString(2, bContnet);
			preparedStatement.setString(3, bId);
			result = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			
			try {
				connection.close();
				preparedStatement.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void delete(String bId)
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		try {
			
			String query  = "delete from mvc_board where bId = ?";   
			
			connection = datasource.getConnection();			
			preparedStatement = connection.prepareStatement(query);			
			preparedStatement.setString(1, bId);
			result = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			
			try {
				connection.close();
				preparedStatement.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
