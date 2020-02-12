package Restaurant.main;

import Restaurant.restaurantApp.RestaurantManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author: Jurgen Kervezee
 * Leerlijn: OOP, Object georiënteerd programmeren
 * Docent: Dennis Haverhals
 */

public class MainController implements Initializable {
    @FXML
    AnchorPane mainStage;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setStage(Parent root) {
        mainStage.getChildren().setAll(root);
    }
}
