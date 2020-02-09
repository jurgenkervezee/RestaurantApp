package Restaurant.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author: Jurgen Kervezee
 * Leerlijn: OOP, Object georiënteerd programmeren
 * Docent: Dennis Haverhals
 */

public class SceneManager {

    public static final String MAIN = "Main";
    public static final String LOGIN = "Login";
    public static final String RESTAURANT = "RestaurantApp";

    private static MainController mainController;

    public static void setMainController(MainController mainController) {
        SceneManager.mainController = mainController;
    }

    public static void setScene(String fxml) {
        try {
            Parent root = FXMLLoader.load(SceneManager.class.getResource("/Restaurant/resources/" + fxml + ".fxml"));

            mainController.setStage(root);
        } catch (IOException ex) {
            System.out.println("HELP");
            Logger.getLogger(SceneManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}