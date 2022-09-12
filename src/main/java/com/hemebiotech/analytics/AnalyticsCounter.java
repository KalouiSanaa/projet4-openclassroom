package com.hemebiotech.analytics;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author Kaloui sanaa
 */
public class AnalyticsCounter {
    /**
     *
     */
    private static List<String> list;
     private static TreeMap<String, Integer> symptomsOccurence;

 	/**
 	 * @param args
 	 * @throws Exception
 	 */
 	public static void main(String[] args) throws Exception {

		
		//creer une listes des symptomes.
		
	 ReadSymptomDataFromFile create = new ReadSymptomDataFromFile("symptoms.txt");

		 list = create.GetSymptoms();
                
                symptomsOccurence = count(list);
                
               showList();
                
                AnalyticsSortie file = new AnalyticsSortie(symptomsOccurence);
                
		                     file.Sortie();

               		//Créer une liste de tri.
    }
        
        /**
         * @param list
         * @return
         */
        public static TreeMap<String, Integer> count(List<String> list) {
            
   symptomsOccurence = new TreeMap<>();

    for (String line : list) {
      symptomsOccurence.put(line, Collections.frequency(list, line));
    }
    return symptomsOccurence;
  }
        /**
         * 
         */
        public static void showList() {
		System.out.println("avant tri " + list);
		System.out.println("apres tri : " + symptomsOccurence);
	}

}
