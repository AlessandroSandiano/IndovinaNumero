package inizio.IndovinaNumero;

public class Main {
	public static void main(String[] args) {
        EntryPoint.main(args);
    }
}

/*

void handleNuovaPartita(ActionEvent event) {
	
}

@FXML
void handleProva(ActionEvent event) {
	txtTentativi.setPromptText("Inserisci un numero tra 0 e " + nmax);
	txtTentativi.setText(Integer.valueOf(tRimasti).toString());
	if (inputNumero.getText().length() == 0) {
		risultato.setText("Non è stato inserito alcun numero");
		return;
	}
	try {
		nScelto = Integer.parseInt(inputNumero.getText());
	}
	catch (NumberFormatException nfe) {
		risultato.setText("Errore di inserimento!");
		return;
	}
	tRimasti--;
	if (nScelto == nEstratto) {
		risultato.setText("Hai vinto!\nTentativi efettuati: " + (tmax - tRimasti) + "\nClicca su Nuova Partita per cominciare di nuovo!");
		//disabilitare hbox
		return;
	}
	
	if (tRimasti == 0) {
		risultato.setText("Hai perso.\nClicca su Nuova Partita per rifarti!");
		//disabilitare hbox
		return;
	}
	txtTentativi.setText(Integer.valueOf(tRimasti).toString());
	if (nScelto < nEstratto)
		risultato.setText("Errato, il numero inserito è minore di quello giusto.\nTentativi rimasti: " + tRimasti);
	else
		risultato.setText("Errato, il numero inserito è maggiore di quello giusto.\nTentativi rimasti: " + tRimasti);
	txtTentativi.clear();
}*/