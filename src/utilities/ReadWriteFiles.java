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

	public static ArrayList<Product> readFromFile() {
		Path readFile = Paths.get("resources/ProductList.txt");
		ArrayList<Product> productList = new ArrayList<Product>();
		File file = readFile.toFile();
		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			
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
}
