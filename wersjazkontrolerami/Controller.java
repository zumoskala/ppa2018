package wersjazkontrolerami;

import java.util.Optional;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import wersjazkontrolerami.event.GameWonEvent;
import wersjazkontrolerami.event.RequestNewGameEvent;

public class Controller {

    protected ApplicationController mainController;


    public void setMainController(ApplicationController mainController) {
        this.mainController = mainController;
        mainController.registerHandler(RequestNewGameEvent.class, event -> startNewGame());
        mainController.registerHandler(RequestNewGameEvent.class, event -> ustawWybor(event.jakiWybor()));
    }

    @FXML
    protected GridPane grid;

    protected boolean gameEnded;
    protected Board board;
    private String wybor;

    public void initialize() {
        for (Node child : grid.getChildren()) {
            Integer row = Optional.ofNullable(GridPane.getRowIndex(child)).orElse(0);
            Integer column = Optional.ofNullable(GridPane.getColumnIndex(child)).orElse(0);
            child.setOnMouseClicked(event -> handleMove(row, column));
        }
        //startNewGame(); // jak siê to odkomentuje, to dzia³a od pocz¹tku, ale przy 1 rundzie nie da siê wybraæ
    }
    
    private void ustawWybor(String wybor) {
    	this.wybor = wybor;
    }

    private void handleMove(Integer row, Integer column) {
   
        if (!gameEnded) {
            if (board.canYouMakeAMove(row, column)) {
                board.makeMove(row, column);
                if (wybor=="komputer") {
                 if(!checkVictoryShowAndRegister()) {
                    board.makeComputerMove();
                }
            }
            drawBoard();
            if (!gameEnded) {
                checkVictoryShowAndRegister();
            }
        }
    }}
    

    private boolean checkVictoryShowAndRegister() {
        Player wins = board.checkVictory();
        if (wins != null) {
            gameEnded = true;
            showVictoryMessage(wins);
            mainController.handleEvent(new GameWonEvent(wins));
            return true;
        }
        return false;
    }

    private void drawBoard() {
        for (Node child : grid.getChildren()) {
            Integer row = Optional.ofNullable(GridPane.getRowIndex(child)).orElse(0);
            Integer column = Optional.ofNullable(GridPane.getColumnIndex(child)).orElse(0);
            Pane pane = (Pane) child;
            pane.getChildren().clear();
            Player inCell = board.getPlayerForField(row, column);
            if (inCell != null) {
                Label label = new Label(inCell.getSign());
                label.setPrefWidth(30.0);
                label.setPrefHeight(30.0);
                label.setAlignment(Pos.CENTER);
                pane.getChildren().add(label);
            }
        }
    }

    private void showVictoryMessage(Player wins) {
        Alert alert = new Alert(AlertType.WARNING, "Player " + wins + " wins!", ButtonType.OK);
        alert.showAndWait();
    }

  /*  private void pokazPytanie () {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("WYBIERZ PRZECIWNIKA");
    	alert.setHeaderText("Zdecyduj, przeciw komu chcesz graæ:");
    	alert.setContentText(" ");
    	ButtonType b1 = new ButtonType("cz³owiek");
    	ButtonType b2 = new ButtonType("komputer");  
    	
    	alert.getButtonTypes().setAll(b1, b2);
    	    	
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == b1){
    	    wybor = "czlowiek";
    	} else if (result.get() == b2) {
    	    wybor = "komputer";
    	} 
    }*/
    
    private void startNewGame() {
        gameEnded = false;
        board = new Board();
        drawBoard();
        
        // np tutaj mo¿emy sobie zrobiæ planszê wiêksz¹
        //tworzê sobie nowy gridpane
    }
}