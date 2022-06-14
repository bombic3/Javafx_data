package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Component;
// JavaFX는 풍부한 GUI를 가진 응용 프로그램을 빠르게 개발할 수 있는 것을 중시하고 새롭게 만들어진 GUI 라이브러리
// FXML은 JavaFX에 포함되어 있는 XML 기반의 GUI 기술 언어이다. "언어"라고 하지만 XML 기반의 마크 업 언어이기 때문에, Java 소스 코드를 작성하는 것보다 기술은 매우 간단하다. 이용하는 컨테이너 및 컨트롤의 내용을 XML 기반으로 기술하는 것만으로 GUI를 디자인 할 수 있다. 이후에는 Java 측에 이것을 읽어 표시하는 짧은 코드를 작성하는 것만으로 본격적인 GUI 애플리케이션을 만들 수 있다



public class ComDataController {
	
	private Component component;
	private Stage dialogStage;
	private int ReturnValue;
	
	@FXML private TextField cnameField;
	@FXML private TextField cnumberField;
	@FXML private TextField ccountField;
	@FXML private TextField clocField;
	@FXML private Button btn1;
	
	@FXML
	private void confirmAction() {
		if(valid()) {
			component.setComponentName(cnameField.getText());
			component.setComponentCode(cnumberField.getText());
			component.setComponentCount(Integer.valueOf(ccountField.getText()));
			component.setComponentPlace(clocField.getText());
			
			ReturnValue = 1;
			dialogStage.close();
		}
	}
	
	@FXML
	private void censerAction() {
		dialogStage.close();
	}
	
	private boolean valid() {
		String errorMessge = "";
		if( cnameField.getText() == null || cnameField.getText().equals("")) {
			errorMessge += "부품 이름을 입력하세요. \n";
		}
		if( cnumberField.getText() == null || cnumberField.getText().equals("")) {
			errorMessge += "부품 코드을 입력하세요. \n";
		}
		if( ccountField.getText() == null || ccountField.getText().equals("")) {
			errorMessge += "수량을 입력하세요. \n";
		}
		if( clocField.getText() == null || clocField.getText().equals("")) {
			errorMessge += "위치를 입력하세요. \n";
		}
		if( errorMessge.equals("")) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("오류 메시지");
			alert.setHeaderText("값을 제대로 입력하세요.");
			alert.setContentText(errorMessge);
			alert.showAndWait();
			return false;
		}
	}
	
	public Component getComponent() {
		return component;
	}
	public void setComponent(Component component) {
		this.component = component;
		cnameField.setText(component.getComponentName());
		cnumberField.setText(component.getComponentCode());
		ccountField.setText(String.valueOf(component.getComponentCount()));
		clocField.setText(component.getComponentPlace());

	}

	public Stage getDialogStage() {
		return dialogStage;
	}
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	public int getReturnValue() {
		return ReturnValue;
	}
	public void setReturnValue(int returnValue) {
		ReturnValue = returnValue;
	}
	

}
