package nodes;

import java.io.FileNotFoundException;

import compiler.MyNewGrammar;
import compiler.ParseException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Oday Ali
 */
public class Windows_IO extends Application {
String liststring;
	public String getListstring() {
	return liststring;
}

public void setListstring(String liststring) {
	this.liststring = liststring;
}

	@Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Start");
        VBox root = new VBox();
        final TextArea textArea = new TextArea();
       final TextArea textArea2 = new TextArea();
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            	String [] b={"dsf","efe"};
            	try {
            		writeonfile wr=new writeonfile();
            		wr.write(textArea.getText());
            		liststring=MyNewGrammar.main(b);
            		System.out.println("hei");
				} catch (FileNotFoundException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               textArea2.setText(liststring);
            }
        });
        HBox titleb = new HBox();
        HBox fild = new HBox();
        fild.getChildren().add(textArea);
        fild.getChildren().add(textArea2);
        fild.setAlignment(Pos.CENTER);
        HBox.setHgrow(textArea, Priority.ALWAYS);
        HBox.setHgrow(textArea2, Priority.ALWAYS);
        VBox.setVgrow(fild, Priority.ALWAYS);
        titleb.getChildren().add(btn);
        titleb.setAlignment(Pos.TOP_LEFT);
        titleb.setStyle("-fx-background-color:#FFFFFF;");
        root.getChildren().add(titleb);
        root.getChildren().add(fild);
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
