package wersjazkontrolerami;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import wersjazkontrolerami.event.GameWonEvent;
import wersjazkontrolerami.event.RequestNewGameEvent;

/**
 * Created by pwilkin on 15-Nov-18.
 */
public class Stats {

    int krzyzykWins = 0;
    int kolkoWins = 0;

    protected ApplicationController mainController;

    public void setMainController(ApplicationController mainController) {
        this.mainController = mainController;
        mainController.registerHandler(GameWonEvent.class, event -> updateWins(event.getWhoWon()));
    }

    @FXML
    protected Label krzyzyk;

    @FXML
    protected Label kolko;

    public void newGame(ActionEvent actionEvent) {
    	String wybor = null;
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
        mainController.handleEvent(new RequestNewGameEvent(wybor));
    }

    private void updateWins(Player wins) {
        if (wins == Player.CROSS) {
            krzyzykWins++;
        } else {
            kolkoWins++;
        }
        updateLabels();
    }

    private void updateLabels() {
        krzyzyk.setText("Gracz X: " + krzyzykWins);
        kolko.setText("Gracz O: " + kolkoWins);
    }
}