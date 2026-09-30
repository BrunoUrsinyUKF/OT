package sk.ukf.ot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class KalkulackaController {
    @FXML
    private TextField prveCislo;
    @FXML
    private TextField druheCislo;
    @FXML
    private Label vysledok;
    @FXML
    protected void initialize() {
        vysledok.setText("---");
    }
    @FXML
    private void vypocitaj(ActionEvent actionEvent){
        try{
            double a = Double.parseDouble(prveCislo.getText());
            double b = Double.parseDouble(druheCislo.getText());

            Button button = (Button) actionEvent.getSource();
            String operator = button.getText();

            double result;

            switch (operator){
                case "Sčítanie":
                    result = a + b; break;
                case "Odčítanie":
                    result = a - b; break;
                case "Násobenie":
                    result = a * b; break;
                case "Delenie":
                    if(b == 0){
                        vysledok.setText("Chyba: delenie nulou."); return;
                    }
                    result = a / b; break;
                default:
                    vysledok.setText("Neplatná operácia"); return;
            }

            vysledok.setText("" + result);
        }

        catch (NumberFormatException e){
            vysledok.setText("Zadajte platné čísla.");
        }
    }
}
