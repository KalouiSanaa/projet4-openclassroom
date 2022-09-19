package com.hemebiotech.analytics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Transformer le fichier avec les symptomes a une listes(collections) des symptomes. 
  */
public class  ReadSymptomDataFromFile implements ISymptomReader  {
	
	private static final ArrayList<String> list = new ArrayList<>();
	
	private static String filepath;

	public  ReadSymptomDataFromFile(String path) {

		ReadSymptomDataFromFile.filepath = path;
	}

	/** renvoie une Arraylist avec tous les symptômes du fichier. 
	 * Attraper une exception si le chemin du fichier est erroné.
	 */

	public ArrayList<String> getSymptoms() {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(filepath));
			String line = reader.readLine();

			while (line != null) {
				list.add(line);
				line = reader.readLine();
			}

			reader.close();

		} catch (IOException e) {
			System.out.println("The indicated path to the symptoms file is wrong");
		}

		return list;
	}

}