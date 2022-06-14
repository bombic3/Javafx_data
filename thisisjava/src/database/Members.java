package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tetris.MembersController;
public class Members {
	MembersController mc = new MembersController();
 public static void menu() {  
	 // MySQL 접속 경로, 기본 포트는 3306, DB명 
	  String jdbcUrl = "jdbc:mysql://localhost:3306/tetris";
	  // MySQL 계정
	  String dbId = "root";
	  // MySQL 계정 비밀번호
	  String dbPw = "1234";	  
	  Connection conn = null;
	  PreparedStatement pstmt = null;
	  
	  String sql = "";
	  int num = 0;
	  new MembersController();
	  String name = null;
	  String id = null;
	  String pwd = null;
	  
	  try {
	   Class.forName("com.mysql.jdbc.Driver");
	   // 디비 연결
	   conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);	     
	     sql = "insert into tetris_members values(?,?,?,?)";
	     pstmt = conn.prepareStatement(sql);
	     pstmt.setInt(1, num);
	     pstmt.setString(2, name);
	     pstmt.setString(3, id);
	     pstmt.setString(4, pwd);
	     pstmt.executeUpdate();	     
	  }
 catch (Exception e) {
	   e.printStackTrace();
	  } finally{
	   if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
	   if(conn!=null) try{conn.close();}catch(SQLException ex){}
	  }
 }
}