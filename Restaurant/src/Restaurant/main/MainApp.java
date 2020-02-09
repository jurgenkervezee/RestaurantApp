package Restaurant.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @Author: Jurgen Kervezee
 * Leerlijn: OOP, Object georiënteerd programmeren
 * Docent: Dennis Haverhals
 */

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream("/Restaurant/resources/" + SceneManager.MAIN + ".fxml"));
        MainController maincontroller = loader.getController();

        SceneManager.setMainController(maincontroller);
        SceneManager.setScene(SceneManager.LOGIN);

        Scene scene = new Scene(root);

        primaryStage.setTitle("RestaurantApp");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void stop() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}