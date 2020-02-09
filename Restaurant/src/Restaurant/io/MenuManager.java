package Restaurant.io;

import Restaurant.restaurantApp.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: Jurgen Kervezee
 * Leerlijn: OOP, Object georiënteerd programmeren
 * Docent: Dennis Haverhals
 */

public class MenuManager {

        private final ArrayList<Product> menu = new ArrayList<Product>();
        //SetFile
        private File file = new File("Menu.txt");


        //ReadMenu
        public  ArrayList<Product> readMenuFile() {

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
                    menu.add(product);
                }

            } catch (FileNotFoundException e) {
                try {
                    file.createNewFile();

                } catch (IOException ex) {
                    System.out.println("Error during File Creation, in readMenuFile");
                    ex.printStackTrace();
                }
            }
            return menu;
        }


    //informatie bewerken

    public void saveMenu() {


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
                System.out.println("Error during File Creation in Save Menu");
                ex.printStackTrace();
            }
        }
    }
}
