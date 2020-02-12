package Restaurant.restaurantApp;

import java.net.URL;
import java.util.ResourceBundle;
import Restaurant.main.SceneManager;
import Restaurant.users.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;



/**
 * @Author: Jurgen Kervezee
 * Leerlijn: OOP, Object georiënteerd programmeren
 * Docent: Dennis Haverhals
 */

public class RestaurantController implements Initializable {

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tabRestaurant, tabOrders, tabMenu;

    //OrdersTab
    @FXML
    private ChoiceBox<Product> choiceBoxMenu;

    @FXML
    private Label lableCurrentUser, labelShowCurrentTable, labelError;

    //MenuTab
    @FXML
    ListView<Product> listViewMenu, listViewOrders;
    private ObservableList<Product> menuItem = FXCollections.observableArrayList();
    private ObservableList<Product> listCurrentOrders = FXCollections.observableArrayList();

    private Users currentUser;
    private Tables currentTable;
//    private RestaurantManager restaurantManager;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentUser = UserManager.getCurrent();
        lableCurrentUser.setText(currentUser.getName());
        setTabAuthorisation();
        menuItem = RestaurantManager.get().getMenu();

    }


    public void handleTableClick(ActionEvent actionEvent) {

        Button clickedButton = (Button)actionEvent.getSource();
        currentTable = RestaurantManager.get().getTable(clickedButton.getId());;
        tabPane.getSelectionModel().select(tabOrders);
        labelShowCurrentTable.setText(currentTable.getName());

        //Populate Menu Box and ListViewBox
        if(currentTable.getOrders().size()==0){
            choiceBoxMenu.setItems(menuItem);
            listViewOrders.setItems(currentTable.getOrders());
            choiceBoxMenu.getSelectionModel().clearSelection();
        }else{
            displayCurrentOrders();
            choiceBoxMenu.getSelectionModel().clearSelection();
        }
    }


    public void onClickLogOut(ActionEvent actionEvent) {
        currentUser = null;
        SceneManager.setScene(SceneManager.LOGIN);
    }

    public void onClickLoadMenu(ActionEvent actionEvent){
        listViewMenu.getItems().clear();
        listViewMenu.setItems(menuItem);
    }


    public void onClickSaveMenu(ActionEvent actionEvent){
        //TODO
    }

    public void ButtonAddProduct(ActionEvent actionEvent) {
        if(choiceBoxMenu.getSelectionModel().getSelectedItem()==null) {
            labelError.setText("Choose a product");
        }else {
            currentTable.addToOrder(choiceBoxMenu.getSelectionModel().getSelectedItem());
            displayCurrentOrders();
        }
    }

    private void displayCurrentOrders() {
        listCurrentOrders = currentTable.getOrders();
        listViewOrders.setItems(listCurrentOrders);
    }

    private void setTabAuthorisation() {
        tabRestaurant.setDisable(currentUser.authorization("Restaurant"));
        tabOrders.setDisable(currentUser.authorization("Orders"));
        tabMenu.setDisable(currentUser.authorization("Menu"));
    }

    public void createBill(ActionEvent actionEvent) {
        double billTotal;
        if(listCurrentOrders.size()!=0){
            listCurrentOrders = currentTable.getOrders();
            billTotal = currentTable.payBill();
            System.out.println(billTotal);
            currentTable.clearTable();
            displayCurrentOrders();
        }
    }
}