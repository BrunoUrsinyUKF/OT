package sk.ukf.zadanie2hw;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
public class HelloController {
    @FXML
    private Label vysledok;
    @FXML
    private TextField cislo;
    @FXML
    private ToggleGroup jednotky;
    @FXML
    protected void preved() {
        try{
            double a = Double.parseDouble(cislo.getText());
            RadioButton selected = (RadioButton) jednotky.getSelectedToggle();
            if (selected == null) {
                vysledok.setText("Chyba: nie je vybraná jednotka");
                return;
            }

            switch(selected.getText()) {
                case "mm":
                    vysledok.setText("kilometre = " + (a / 1000000) +
                            "\n metre = " + (a / 1000) +
                            "\n centimetre = " + (a / 10) +
                            "\n milimetre = " + a);
                    break;
                case "cm":
                    vysledok.setText("kilometre = " + (a / 100000) +
                            "\n metre = " + (a / 100) +
                            "\n centimetre = " + (a) +
                            "\n milimetre = " + a * 10);
                    break;
                case "m":
                    vysledok.setText("kilometre = " + (a / 1000) +
                            "\n metre = " + (a) +
                            "\n centimetre = " + (a * 100) +
                            "\n milimetre = " + a * 1000);
                    break;
                case "km":
                    vysledok.setText("kilometre = " + (a) +
                            "\n metre = " + (a * 1000) +
                            "\n centimetre = " + (a * 100000) +
                            "\n milimetre = " + a * 1000000);
                    break;

            }
        }catch (NumberFormatException e){
            vysledok.setText("Zadaj platné číslo");
        }
    }

}
