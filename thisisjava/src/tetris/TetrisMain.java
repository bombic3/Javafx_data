package tetris;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TetrisMain extends Application{
	@Override
	public void start(Stage primaryStage)throws Exception{
		  primaryStage.setTitle("??Ʈ????JavaFX");  
		  Parent root = FXMLLoader.load(getClass().getResource("firstPage.fxml"));
    	  Scene scene = new Scene(root);    	  
    	  primaryStage.setScene(scene); 
    	  primaryStage.setWidth(1000);
    	  primaryStage.setHeight(850);
    	  primaryStage.setResizable(false);
    	  primaryStage.show();
      }
	public static void main(String args[]){
		launch(args);
	}
	
	
}
