package Restaurant.io;

import Restaurant.restaurantApp.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: Jurgen Kervezee
 * Leerlijn: OOP, Object georiënteerd programmeren
 * Docent: Dennis Haverhals
 */

public class MenuManager {

        //private final ArrayList<Product> menuList = new ArrayList<Product>();
        private final ObservableList<Product> productList = FXCollections.observableArrayList();
        //SetFile
        private File file = new File("Restaurant/Menu.txt");


        //ReadMenu
        public  ObservableList<Product> readMenuFile() {

            try {
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String productInfo = scanner.nextLine();

                    String[] productInformation = productInfo.split(",");

                    //Extract Description of the Product
                    String productDescription = productInformation[0];
                    //Extract Price of the product
                    Double price = Double.valueOf((productInformation[1]));

                    //Save the products in the ArrayList
                    Product product = new Product(productDescription, price);
                    productList.add(product);
                }

            } catch (FileNotFoundException e) {
                try {
                    file.createNewFile();

                } catch (IOException ex) {
                    System.out.println("Error: FileNotFound Exception" + ex);
                    ex.printStackTrace();
                }
            }
            return productList;
        }

    //informatie bewerken
    public void saveMenu(ObservableList<Product> menu) {


        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Product product : menu) {
                bufferedWriter.write(product.getDescription() + "," + product.getPrice() + "\n");
            }
            //To Close the Writer after Use
            bufferedWriter.close();

        } catch (IOException e) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error: FileCouldNot be Created Exception" + ex);
                ex.printStackTrace();
            }
        }
    }
}

