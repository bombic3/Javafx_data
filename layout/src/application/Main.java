package application;
//	p858
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			HBox hbox = new HBox();
			hbox.setPadding(new Insets(10));	// 안쪽 여백
			hbox.setSpacing(10);				// 컨트롤 간 수평 간격
			
			TextField textField = new TextField();
			textField.setPrefWidth(200);
			
			Button button = new Button();
			button.setText("확인");
			
			ObservableList list = hbox.getChildren();	// HBox의 ObservableList 얻기
			list.add(textField);						// TextField 컨트롤 배치
			list.add(button);							// Button 컨트롤 배치
			
			Scene scene = new Scene(hbox);
			
			primaryStage.setTitle("AppMain");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
