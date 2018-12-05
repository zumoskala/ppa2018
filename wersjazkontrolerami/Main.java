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

//okno modalne to odpowiednik starego wyœwietlania komunikatów
//w momencie kiedy wyœwietli³o siê, to nie widaæ jeszcze trzeciego oznaczenia
// dopiero po klikniêciu ok coœ sie wykona³o

//¿eby zrobiæ 5x5 trzeba zmnieniæ rozmiar planszy i zmieniæ GRIDPANE w fxml ->tictactoe.fxml (ale problem, bo narysowaliœmy rêcznie)
//nikomu np by siê nie chcia³o robiæ planszy 19x19