package Restaurant.restaurantApp;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import Restaurant.io.MenuManager;
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
    private ChoiceBox choiceBoxMenu;

    @FXML
    private Label lableCurrentUser, labelShowCurrentTable, labelError;

    //MenuTab
    @FXML
    ListView listViewMenu, listViewOrders;
    private ObservableList<String> items = FXCollections.observableArrayList();
    private ObservableList<String> ordersList = FXCollections.observableArrayList();

    private Users currentUser;
    private Table currentTable;
    private RestaurantManager restaurantManager;
    private ArrayList<Product> menuItem;
    private ArrayList<String> orders;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentUser = UserManager.getCurrent();
        lableCurrentUser.setText(currentUser.getName());
        setTabAuthorisation();
        restaurantManager= new RestaurantManager();
        menuItem = RestaurantManager.get().getMenu();
        for (Product product : menuItem) {
            items.add(product.getDescription() + " " + product.getPrice());
        }
    }


    public void handleTableClick(ActionEvent actionEvent) {

        Button clickedButton = (Button)actionEvent.getSource();
        currentTable = restaurantManager.getTable(clickedButton.getId());
        tabPane.getSelectionModel().select(tabOrders);
        labelShowCurrentTable.setText(currentTable.getName());
        //Populate Menu Box and ListViewBox
        if(currentTable.getOrders().size()==0){
            choiceBoxMenu.setItems(items);
            listViewOrders.getItems().clear();
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
        listViewMenu.setItems(items);
    }


    public void onClickSaveMenu(ActionEvent actionEvent){
        //TODO
    }

    public void ButtonAddProduct(ActionEvent actionEvent) {
        if(choiceBoxMenu.getSelectionModel().getSelectedItem()==null) {
            labelError.setText("Choose a product");
        }else {
            currentTable.addOrders((String) choiceBoxMenu.getSelectionModel().getSelectedItem());
            displayCurrentOrders();
        }
    }

    private void displayCurrentOrders() {
        listViewOrders.getItems().clear();
        ordersList.clear();
        orders = currentTable.getOrders();
        ordersList.addAll(orders);
        listViewOrders.setItems(ordersList);
    }

    private void setTabAuthorisation() {
        tabRestaurant.setDisable(currentUser.authorization("Restaurant"));
        tabOrders.setDisable(currentUser.authorization("Orders"));
        tabMenu.setDisable(currentUser.authorization("Menu"));
    }

    public void createBill(ActionEvent actionEvent) {
        if(orders.size()!=0){
            orders = currentTable.getOrders();
            System.out.println(orders);
            currentTable.clearTable();
            displayCurrentOrders();
        }
    }
}