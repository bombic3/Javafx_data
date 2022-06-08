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
			VBox root = new VBox();		// Parent ���� ��ü�� VBox ����
			root.setPrefWidth(350);
			root.setPrefHeight(150);
			root.setAlignment(Pos.CENTER); // ��Ʈ�� �߾� ����
			root.setSpacing(20);		// ��Ʈ�� ���� ����
			
			Label label = new Label();	// Label ��Ʈ�� ����
			label.setText("Hello, JavaFX");
			label.setFont(new Font(50));
			
			Button button = new Button();	// button ��Ʈ�� ����
			button.setText("Ȯ��");
			button.setOnAction(event -> Platform.exit());	// Ŭ�� �̺�Ʈ ó��
			
			root.getChildren().add(label);	// VBox�� �ڽ����� Label ��Ʈ�� �߰�
			root.getChildren().add(button);	// VBox�� �ڽ����� Button ��Ʈ�� �߰�

			Scene scene = new Scene(root);	// VBox�� ��Ʈ �����̳ʷ� �ؼ� Scene ����
			
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
