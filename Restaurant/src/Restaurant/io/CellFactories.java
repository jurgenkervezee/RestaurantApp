package Restaurant.io;

import Restaurant.restaurantApp.Product;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;

public class CellFactories extends Application {

    @Override
    public void start(Stage stage) {

//        InMenuManger
        ObservableList<Product> productList = FXCollections.observableArrayList();
        //toevoegen van producten
        productList.add(new Product("BroodjeBal1", 1.00));
        productList.add(new Product("BroodjeBal2", 1.01));
        productList.add(new Product("BroodjeBal3", 1.02));

//        Omzetten met cellfactory
        ListView<Product> Menu = new ListView<>(productList);
        Menu.setCellFactory(param -> new ListCell<Product>() {
            @Override
            protected void updateItem(Product product, boolean empty) {
                super.updateItem(product, empty);

                if (empty || product == null || product.getDescription() == null || product.getPrice() == null) {
                    setText(null);
                } else {
                    setText(product.getDescription() + "  " + product.getPrice());
                }
            }
        });

//        ComboBox<Product> combox = new ComboBox<>();
//
//        combox.setItems(FXCollections.observableList(productList));
//        combox.getSelectionModel().selectFirst();
//        // list of values showed in combo box drop down
//        combox.setCellFactory(new Callback<ListView<Product>, ListCell<Product>>() {
//            @Override
//            public ListCell<Product> call(ListView<Product> l) {
//                return new ListCell<Product>() {
//                    @Override
//                    protected void updateItem(Product product, boolean empty) {
//                        super.updateItem(product, empty);
//                        if (product == null || empty) {
//                            setGraphic(null);
//                        } else {
//                            setText(product.getDescription());
//                        }
//                    }
//                };
//            }
//        });
//        //selected value showed in combo box
//        combox.setConverter(new StringConverter<Product>() {
//            @Override
//            public String toString(Product product) {
//                if (product == null) {
//                    return null;
//                } else {
//                    return product.getDescription();
//                }
//            }
//
//            @Override
//            public Product fromString(String userId) {
//                return null;
//            }
//        });


        ComboBox<Product> combox = new ComboBox<>();

        Callback<ListView<Product>, ListCell<Product>> cellFactory = new Callback<ListView<Product>, ListCell<Product>>() {

            @Override
            public ListCell<Product> call(ListView<Product> l) {
                return new ListCell<Product>() {

                    @Override
                    protected void updateItem(Product product, boolean empty) {
                        super.updateItem(product, empty);
                        if (product == null || empty) {
                            setGraphic(null);
                        } else {
                            setText(product.getDescription());
                        }
                    }
                };
            }
        };

// Just set the button cell here:
//        combox.setButtonCell(cellFactory.call(null));
//        combox.setCellFactory(cellFactory);
//
//        //voor tonen van de waarden
//        stage.setScene(new Scene(combox));
//        stage.show();

            //
//        ComboBox<Product> combo = new ComboBox<>(productList);
//        combo.setCellFactory(param -> new ListCell<Product>() {
//            @Override
//            protected void updateItem(Product product, boolean empty) {
//                super.updateItem(product, empty);
//
//                if (empty || product == null || product.getDescription() == null || product.getPrice() == null) {
//                    setText(null);
//                } else {
//                    setText(product.getDescription() + "  " + product.getPrice());
//                }
//            }
//        });

//        ChoiceBox<Product> choiceBox = new ChoiceBox<>();
//        choiceBox.setConverter(new StringConverter<Product>() {
//            @Override
//            public String toString(Product product) {
//                return product.getDescription();
//            }
//
//            @Override
//            public Product fromString(String string) {
//                return null;
//            }
//        });
//        ChoiceBox choiceBox = new ChoiceBox();
//        choiceBox.setItems(FXCollections.observableArrayList(productList));

        }
    public static void main (String[]args){
        launch(args);
    }
}