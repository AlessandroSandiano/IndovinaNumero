package inizio.IndovinaNumero;

import java.net.URL;
import java.util.ResourceBundle;

import inizio.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController {
	
	Model model;

	private final int tmax=8, nmax=100;
	private int tRimasti, nEstratto, nScelto;
	
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
    	txtTentativi.setText(Integer.valueOf(tmax).toString());
    	tRimasti = tmax;
    	//castando un double in int si ottiene sempre la parte intera inferiore del numero in questione
    	nEstratto = (int)(Math.random()*nmax) + 1;
    	txtTentativi.setDisable(false);
    	ctrlStart.setDisable(false);
    	txtInput.setPromptText("Inserisci un numero tra 1 e " + nmax);
    	txtRisultato.clear();
    	txtInput.clear();
    }

    @FXML
    void handleProva(ActionEvent event) {
    	txtInput.setPromptText("Inserisci un numero tra 1 e " + nmax);
    	txtTentativi.setText(Integer.valueOf(tRimasti).toString());
    	if (txtInput.getText().length() == 0) {
    		txtRisultato.appendText("Non è stato inserito alcun numero\n");
    		txtInput.clear();
    		return;
    	}
    	try {
    		nScelto = Integer.parseInt(txtInput.getText());
    	}
    	catch (NumberFormatException nfe) {
    		txtRisultato.appendText("Errore di inserimento!\n");
    		txtInput.clear();
    		return;
    	}
    	if ((nScelto < 1) || (nScelto > nmax)) {
    		txtRisultato.appendText("Il numero inserito è fuori dall'intervallo 1-" + nmax + "\n");
    		txtInput.clear();
    		return;
    	}
    	tRimasti--;
    	txtTentativi.setText(Integer.valueOf(tRimasti).toString());
    	if (nScelto == nEstratto) {
    		txtRisultato.appendText("Hai vinto!\nTentativi efettuati: " + (tmax - tRimasti) + "\nClicca su Nuova Partita per cominciare di nuovo!\n");
    		ctrlStart.setDisable(true);
    		return;
    	}
    	
    	if (tRimasti == 0) {
    		txtRisultato.appendText("Hai perso. Il numero segreto era " + nEstratto + "\nClicca su Nuova Partita per rifarti!\n");
    		ctrlStart.setDisable(true);
    		return;
    	}
    	if (nScelto < nEstratto)
    		txtRisultato.appendText("Errato. Il numero inserito, " + nScelto + ", è MINORE di quello giusto.\n");
    	else
    		txtRisultato.appendText("Errato. Il numero inserito, " + nScelto + ", è MAGGIORE di quello giusto.\n");
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


