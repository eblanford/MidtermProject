/*
 * Class of file methods
 */

package utilities;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import products.Product;
public class ReadWriteFiles {

	// Generic directory creation method (unused)
	public static void createDirectory(String dirString) {
		Path dirPath = Paths.get(dirString);
		System.out.println(dirPath.toAbsolutePath());
		if (Files.notExists(dirPath)) {
			try {
				Files.createFile(dirPath);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Unknown error. Please contact customer service");
			}
		}
	}

	// Generic file creation method (unused)
	public static void createFile(String dirString, String fileString) {
		Path filePath = Paths.get(dirString, fileString);
		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("File created successfully!");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Unknown error. Please contact customer service");
			}
		}

	}

	// Generic write to file method (unused, modified below)
	public static void writeToFile(String dirString, String fileString) {
		Path writeFile = Paths.get(dirString, fileString);
		
		File file = writeFile.toFile();
		
		try {
			
			PrintWriter printOut = new PrintWriter(new FileOutputStream(file, true));
			printOut.println("Writing to files");//insert what to print in here
			printOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Reads list of products from ProductList.txt and returns an
	// ArrayList<Products>
	public static ArrayList<Product> readFromFile() {
		Path readFile = Paths.get("resources/productList.txt");
		ArrayList<Product> productList = new ArrayList<Product>();
		File file = readFile.toFile();
		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			
			// loops through each line and creates a string array of items separated by ,
			// converts price to an int and stores as a new product
			// adds each new product to an ArrayList
			while(line != null) {
				String[] list = line.split(",");
				int result = Integer.parseInt(list[3]);
				Product product = new Product(list[0], list[1], list[2],result);
				productList.add(product);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}return productList;
	} 

	// A write to file that prints from receipt to orderHistory.txt all of the
	// information to save for logging purposes
	public static void writeToFile(ArrayList<Product> order, int subTotal, double taxTotal, double grandTotal,
			String customer) {
		Path writeFile = Paths.get("resources/orderHistory.txt");

		File file = writeFile.toFile();

		try {
			PrintWriter printOut = new PrintWriter(new FileOutputStream(file, true));
			printOut.println(order); // prints each product in an array
			printOut.println(customer + "," + subTotal + "," + taxTotal + "," + grandTotal); // prints name & cost info
			printOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
