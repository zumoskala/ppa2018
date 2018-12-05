package wersjazkontrolerami;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("calosc.fxml"));
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(new Scene(root, 188, 94));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//okno modalne to odpowiednik starego wy�wietlania komunikat�w
//w momencie kiedy wy�wietli�o si�, to nie wida� jeszcze trzeciego oznaczenia
// dopiero po klikni�ciu ok co� sie wykona�o

//�eby zrobi� 5x5 trzeba zmnieni� rozmiar planszy i zmieni� GRIDPANE w fxml ->tictactoe.fxml (ale problem, bo narysowali�my r�cznie)
//nikomu np by si� nie chcia�o robi� planszy 19x19