package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author Kaloui sanaa
 */
public class AnalyticsCounter {
    private static List<String> list;
     private static TreeMap<String, Integer> symptomsOccurence;

 	public static void main(String[] args) throws Exception {

		
		//creer une liste des symptomes.
		
	 ReadSymptomDataFromFile create = new ReadSymptomDataFromFile("symptoms.txt");

		 list = create.GetSymptoms();
                 
                 
                //Créer une liste de tri.
                
                symptomsOccurence = count(list);
                
                //Regardez si le tri a fonctionné.
                
               showList();
               
               //Générer un fichier avec les résultats.
                
                AnalyticsSortie file = new AnalyticsSortie(symptomsOccurence);
                
		file.Sortie();
                
                
               		//Créer une liste de tri.
    }
        
        public static TreeMap<String, Integer> count(List<String> list) {
            
   symptomsOccurence = new TreeMap<>();

    for (String line : list) {
      symptomsOccurence.put(line, Collections.frequency(list, line));
    }
    return symptomsOccurence;
    /** return une liste de tri par ordre alphanumérique
 */
  }
        /**
L'affichage dans le shell si le tri a fonctionné. */
        
        public static void showList() {
		System.out.println("avant tri " + list);
		System.out.println("apres tri : " + symptomsOccurence);
	}

}
