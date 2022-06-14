package tetris;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class FirstController implements Initializable{
    @FXML private TextField id;
    @FXML private PasswordField pwd;
    @FXML private Button membersBtn;
    @FXML private Button loginBtn;
    @FXML private Button exit;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		membersBtn.setOnAction(e->membersAction(e));
		loginBtn.setOnAction(e->loginAction(e));
	}
    
	
	public void membersAction(ActionEvent event){
		try{
		Parent members = FXMLLoader.load(getClass().getResource("members.fxml"));
		StackPane root = (StackPane) membersBtn.getScene().getRoot();
		root.getChildren().add(members);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void handleBtnAction(ActionEvent e){
		Platform.exit();
	}
	
	public void loginAction(ActionEvent event){
		String uId = id.getText();
		String uPwd = pwd.getText();
		 // MySQL 접속 경로, 기본 포트는 3306, DB명 
		  String jdbcUrl = "jdbc:mysql://localhost:3306/tetris";
		  // MySQL 계정
		  String dbId = "root";
		  // MySQL 계정 비밀번호
		  String dbPw = "1234";	  
		  Connection conn = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  String sql = ""; 
		  
		  try {
			   Class.forName("com.mysql.jdbc.Driver");
			   // 디비 연결
			   conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);	     
			  
			     sql = "select id,pwd from tetris_members where id = ? and pwd = ?";
			     pstmt = conn.prepareStatement(sql);
			     pstmt.setString(1, uId);
			     pstmt.setString(2, uPwd);
			     rs = pstmt.executeQuery(); 
			     if(rs.next()){			     
			     if(rs.getString("id").equals(uId) && rs.getString("pwd").equals(uPwd)){
			     Parent mainPage = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
					StackPane root = (StackPane) loginBtn.getScene().getRoot();
					root.getChildren().add(mainPage);
			     }
			     }
		  }
		 catch (Exception e) {
			   e.printStackTrace();
			  } finally{
			   if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			   if(conn!=null) try{conn.close();}catch(SQLException ex){}
			  }
		  
	}
}
