package songbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import songbook.data.Album;
import songbook.data.Artist;
import songbook.data.Song;
import songbook.data.Songbook;

public class Controller implements Initializable{
	
	private DataSaver data = new DataSaver();

	private Stage stage;

	public Songbook przeczytane;

	private List<Artist> artists;
	
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
		przeczytane = data.readSongbook(is);

		if(file!=null) {
			System.out.println(file.getName());
			
		}
	}

	public void czytaj() {
		artists = przeczytane.getArtists();
		for(Artist artist:artists) {
			System.out.println("Nowy wykonawca: ");
			System.out.println(artist.getName());
			List<Album> albums = artist.getAlbums();
			for(Album album:albums) {
				System.out.println("Nazwa albumu: ");
				System.out.println(album.getName());
				List<Song> songs = album.getSongs();
				for(Song song:songs) {
					System.out.println("Nazwa utworu: ");
					System.out.println(song.getTitle());
					System.out.println(song.getLyrics());
					System.out.println("***");
				}
			}
			
		}
	}
	
	
	
}