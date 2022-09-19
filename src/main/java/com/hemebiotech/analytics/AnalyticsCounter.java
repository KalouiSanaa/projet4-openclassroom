package com.hemebiotech.analytics;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author Kaloui sanaa
 */
public class AnalyticsCounter {
  private static List<String> listSymptoms;
  private static TreeMap<String, Integer> symptomsOccurence;

  /**
   * @param args
  
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    // creer une liste des symptomes.
    listSymptoms = reading("symptoms.txt");

    // Créer une liste de tri.
    symptomsOccurence = count(listSymptoms);

    // générer le remplissage avec tous les symptômes
    saving();

    // Regardez si le tri a fonctionné.
    showList();
  }
/**
   * creer une liste des symptomes et Transformer le fichier avec les symptomes a une listes(collections)
   */
  static List<String> reading(String fileName) {
    ReadSymptomDataFromFile create = new ReadSymptomDataFromFile(fileName);
    List<String> symptomsList = create.getSymptoms();
    return symptomsList;
  }

  /**
   * return une liste de tri par ordre alphanumérique
   */
  public static TreeMap<String, Integer> count(List<String> list) {

    symptomsOccurence = new TreeMap<>();

    for (String line : list) {
      symptomsOccurence.put(line, Collections.frequency(list, line));
    }
    return symptomsOccurence;
  }

  /**
   * L'affichage dans le shell si le tri a fonctionné.
   */

  public static void showList() {
    System.out.println("avant tri " + listSymptoms);
    System.out.println("apres tri : " + symptomsOccurence);
  }

 // générer le remplissage "result.out" avec tous les symptômes

  static void saving() {
    AnalyticsSortie file = new AnalyticsSortie(symptomsOccurence);
    file.sortie();
  }

}
