package songbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller implements Initializable{
	
	private DataSaver data;

	private Stage stage;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void init(Stage stage) {
		this.stage = stage;
		
	}
	
	public void openFile() throws IOException {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("Text Files", "*.txt")
				);
		
		File file = fileChooser.showOpenDialog(stage);
		InputStream is = new FileInputStream(file);
		//data.readSongbook(is);

		if(file!=null) {
			System.out.println(file.getName());
			System.out.println(is.read());
			System.out.println(is.read());
			System.out.println(is.read());
			System.out.println(is.read()); //sprawdzi³am z ASCII, dobrze czyta zawartoœæ, ale w bajtach
			




		}
	}

	
	
	
}
