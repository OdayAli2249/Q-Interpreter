package nodes;

import java.io.FileNotFoundException;

import compiler.MyNewGrammar;
import compiler.ParseException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Input extends Application {
	String tefi;
	
	public String getTefi() {
		return tefi;
	}
	public void setTefi(String tefi) {
		this.tefi = tefi;
	}
	public void start(Stage primaryStage) {
		 HBox brother = new HBox();
		final TextField fild=new TextField();
		 Button btn = new Button();
	        btn.setText("Ok");
	        btn.setOnAction(new EventHandler<ActionEvent>() {

	            @Override
	            public void handle(ActionEvent event) {
	            	
	            	try {
	            		tefi=fild.getText();
					} finally {
					}
	            }
	        });
	        
	        HBox.setHgrow(fild, Priority.ALWAYS);
	        VBox.setVgrow(brother, Priority.ALWAYS);
	        brother.getChildren().add(fild);
	        brother.getChildren().add(btn);
	        Scene scene = new Scene(brother, 200, 50);

	        primaryStage.setTitle("Hello World!");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	}
	public static void main(String[] args) {
        launch(args);

    }
}
