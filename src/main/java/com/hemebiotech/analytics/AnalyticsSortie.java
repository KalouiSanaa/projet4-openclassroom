package com.hemebiotech.analytics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Cette classe est utilisée pour générer un nouveau fichier appelé "result.out" ou directement blanc dessus tous les symptômes
 * avec leur décompte, si le fichier existe déjà.


 */

public class AnalyticsSortie {

	private File fileOut = new File("results.out");
	private TreeMap<String, Integer> list;

	public  AnalyticsSortie (TreeMap<String, Integer> list) {
		this.list = list;
	}


/** 
 * Cette fonction va générer le remplissage "result.out" avec tous les symptômes.	
 */
	public void Sortie() {

		if (!fileOut.exists()) { 										//create file
			try {
				fileOut.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {														//write in fine
				FileWriter writer = new FileWriter(fileOut);				
				BufferedWriter bw = new BufferedWriter(writer);

				for (Entry<String, Integer> element : list.entrySet()) {
					bw.write(element.getKey() + " = " + element.getValue());
					bw.newLine();
				}

				bw.close();
				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else

		{
			try {
				FileWriter writer = new FileWriter(fileOut);
				BufferedWriter bw = new BufferedWriter(writer);

				for (Entry<String, Integer> element : list.entrySet()) {
					bw.write(element.getKey() + " = " + element.getValue());
					bw.newLine();
				}

				bw.close();
				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
