package nodes;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextArea;
public class writeonfile {
	  private String list;

	    public String getList() {
	        return list;
	    }

	    public void setList(String list) {
	        this.list = list;
	    }
	    public void write(String textArea)
	    {FileWriter fw;
	        try {
	            fw = new FileWriter("C:\\Users\\Oday Ali\\eclipse-workspace\\comp_project\\src\\text.txt");
	           list=textArea;
	           TextArea te=new TextArea();
	            fw.write(list);
	            fw.flush();
	            fw.close();}
	    catch (IOException ex) {
	           System.out.println(ex);
	        }
	    }

}
