package application;

// p856
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox();		// Parent 하위 객체인 VBox 생성
			root.setPrefWidth(350);
			root.setPrefHeight(150);
			root.setAlignment(Pos.CENTER); // 컨트롤 중앙 정렬
			root.setSpacing(20);		// 컨트롤 수직 간격
			
			Label label = new Label();	// Label 컨트롤 생성
			label.setText("Hello, JavaFX");
			label.setFont(new Font(50));
			
			Button button = new Button();	// button 컨트롤 생성
			button.setText("확인");
			button.setOnAction(event -> Platform.exit());	// 클릭 이벤트 처리
			
			root.getChildren().add(label);	// VBox의 자식으로 Label 컨트롤 추가
			root.getChildren().add(button);	// VBox의 자식으로 Button 컨트롤 추가

			Scene scene = new Scene(root);	// VBox를 루트 컨테이너로 해서 Scene 생성
			
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
