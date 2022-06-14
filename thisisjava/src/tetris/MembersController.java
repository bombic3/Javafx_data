package tetris;


import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class MembersController implements Initializable{
	@FXML private AnchorPane login;
	@FXML private TextField name;
	@FXML private TextField id;
    @FXML private PasswordField pwd;
    @FXML private Button membersBtn;
    @FXML private Button cancelBtn;
    
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cancelBtn.setOnAction(e->cancelAction(e));
		membersBtn.setOnAction(e->membersAction(e));
	}
    
	public void cancelAction(ActionEvent e){
		StackPane root = (StackPane) cancelBtn.getScene().getRoot();
		root.getChildren().remove(login);
	}
	
	public void membersAction(ActionEvent event){
		String uName = name.getText();
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
		  
		  String sql = "";
		  int num = 0;
		  new MembersController();
		  String name = uName;
		  String id = uId;
		  String pwd = uPwd;
		  
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
		  StackPane root = (StackPane) cancelBtn.getScene().getRoot();
			root.getChildren().remove(login);
			
	 }
	
	
}
