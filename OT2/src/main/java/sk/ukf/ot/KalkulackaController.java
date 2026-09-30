package sk.ukf.ot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;

public class KalkulackaController {
    @FXML
    private TextField vstup;
    @FXML
    private Label vysledok;

    @FXML
    protected void initialize() {
        vysledok.setText("---");
    }

    @FXML
    private void premen(ActionEvent actionEvent) {
        String a = vstup.getText();

        if(a.isEmpty()){
            vysledok.setText("Zadajte platný vstup");
            return;
        }

        Button button = (Button) actionEvent.getSource();
        String operator = button.getText();

        switch (operator) {
            case "VEĽKÉ":
                a = a.toUpperCase();
                break;
            case "malé":
                a = a.toLowerCase();
                break;
            case "Počet znakov":
                a = String.valueOf(a.length());
                break;
            case "Prvé Veľké Písmeno Každého Slova":
                StringBuilder sb = new StringBuilder();
                boolean dalsieVelke = true;
                for (int i = 0; i < a.length(); i++) {
                    char c = a.charAt(i);
                    if (c == ' ') {
                        dalsieVelke = true;
                        sb.append(c);
                    } else if (dalsieVelke) {
                        sb.append(Character.toUpperCase(c));
                        dalsieVelke = false;
                    } else {
                        sb.append(c);
                    }
                }
                a = sb.toString();
                break;
            case "Počet Slov":
                int counter = 1;
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) == ' ') counter++;
                }
                a = String.valueOf(counter);
                break;
            case "Obráť text":
                a = new StringBuilder(a).reverse().toString();
                break;
            case "Vymaž":
                a = "---";
                break;
        }
        vysledok.setText(a);
    }

}