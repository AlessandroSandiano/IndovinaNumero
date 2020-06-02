package inizio.IndovinaNumero;

import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ResourceBundle;

import inizio.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController {
	
	Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTentativi;

    @FXML
    private HBox ctrlStart;

    @FXML
    private TextField txtInput;

    @FXML
    private TextArea txtRisultato;

    @FXML
    void handleNuovaPartita(ActionEvent event) {
    	model.settRimasti(model.getTmax());
    	txtTentativi.setText(Integer.valueOf(model.getTmax()).toString());
    	txtTentativi.setDisable(false);
    	ctrlStart.setDisable(false);
    	txtInput.setPromptText("Inserisci un numero tra 1 e " + model.getNmax());
    	txtRisultato.clear();
    	txtInput.clear();
    }

    @FXML
    void handleProva(ActionEvent event) {
    	int tentativo;
    	txtInput.setPromptText("Inserisci un numero tra 1 e " + model.getNmax());
    	txtTentativi.setText(Integer.valueOf(model.gettRimasti()).toString());
    	if (txtInput.getText().length() == 0) {
    		txtRisultato.appendText("Non è stato inserito alcun numero\n");
    		txtInput.clear();
    		return;
    	}
    	try {
    		model.setnScelto(Integer.parseInt(txtInput.getText()));
    	}
    	catch (NumberFormatException nfe) {
    		txtRisultato.appendText("Errore di inserimento!\n");
    		txtInput.clear();
    		return;
    	}
    	try {tentativo = model.tentativo();
    	}
    	catch (InvalidParameterException ipe) {
    		txtRisultato.appendText(ipe.getMessage());
    		txtInput.clear();
    		return;
    	}
    	
    	if (tentativo == -1)
    		txtRisultato.appendText("Errato. Il numero inserito, " + model.getnScelto() + ", è MINORE di quello giusto.\n");
    	
    	if (tentativo == 1)
    		txtRisultato.appendText("Errato. Il numero inserito, " + model.getnScelto() + ", è MAGGIORE di quello giusto.\n");
    	
    	txtTentativi.setText(Integer.valueOf(model.gettRimasti()).toString());
    	
    	if (tentativo == 0) {
    		txtRisultato.appendText("Hai vinto!\nTentativi efettuati: " + (model.getTmax() - model.gettRimasti()) + "\nClicca su Nuova Partita per cominciare di nuovo!\n");
    		ctrlStart.setDisable(true);
    		return;
    	}
    	
    	try {model.terminata();
    	}
    	catch (IllegalStateException ise) {
    		txtRisultato.appendText(ise.getMessage());
    		ctrlStart.setDisable(true);
    		return;
    	}
    	
    	txtInput.clear();
    }

    @FXML
    void initialize() {
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert ctrlStart != null : "fx:id=\"ctrlStart\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel (Model model) {
    	this.model = model;
    }
    
}


