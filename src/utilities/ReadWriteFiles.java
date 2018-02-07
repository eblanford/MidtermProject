package utilities;
import java.io.*;
import java.nio.file.*;
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
	public static void readFromFile(String dirString, String filePath) {
		Path readFile = Paths.get(dirString, filePath);
		
		File file = readFile.toFile();
		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			while(line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}
	}
}
