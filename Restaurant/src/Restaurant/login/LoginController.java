package Restaurant.login;

import Restaurant.main.SceneManager;
import Restaurant.restaurantApp.RestaurantManager;
import Restaurant.users.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author: Jurgen Kervezee
 * Leerlijn: OOP, Object georiënteerd programmeren
 * Docent: Dennis Haverhals
 */

public class LoginController implements Initializable {

    @FXML
    private TextField userTextfield, passwordTextfield;

    @FXML
    private Label labelLogin;

    @FXML
    private ComboBox<String> roleComboBox;

    private Users currentUser;
    private boolean speed = false;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clearFields();
        labelLogin.setText("");
    }

    @FXML
    public void onClickLogin(ActionEvent actionEvent) {

        if (speed = true){//BIJ INLEVEREN SPEED OP FALSE ZETTEN!!!
            currentUser = UserManager.get().createUser("Owner","Henk");
            SceneManager.setScene(SceneManager.RESTAURANT);

        }else if (roleComboBox.getValue()== null || userTextfield.getText().isEmpty() || passwordTextfield.getText().isEmpty()) {
            labelLogin.setText("Not all fields are filled in");

        }else {
            currentUser = UserManager.get().createUser(roleComboBox.getValue(),userTextfield.getText());

            if (!currentUser.verifyPassword(passwordTextfield.getText())) {

                labelLogin.setText("Incorrect Password, please try again");
                passwordTextfield.clear();
            } else {
                SceneManager.setScene(SceneManager.RESTAURANT);
            }
        }
    }

    private void clearFields() {
        roleComboBox.getItems().setAll("Owner", "Waiter", "Chef");
        userTextfield.clear();
        passwordTextfield.clear();
    }
}
