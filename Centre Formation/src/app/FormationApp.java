package app;

import java.util.List;
import java.util.Scanner;

import modele.DescriptionFormation;
import service.FormationService;

public class FormationApp {

    /**
     * <p>This is the main function of the program, will ask the user what he wants to do in the list of choices
     * </p>
     * @param Takes no parameter
     * @return Returns nothing, void function 
     */
    public static void main(String[] args) {

        FormationService service = new FormationService();

        try (Scanner sc = new Scanner(System.in)) {
            boolean quitter = false; // this variable will be used to keep the program running until the user leave
            
            //while the variable "quitter" is false, we run the program
            while (!quitter) {
            	System.out.println("\n--- Centre de formation ---"); 
            	System.out.println("1. Afficher toutes les formations disponible"); 
            	System.out.println("2. Afficher les formations en présentiel"); 
            	System.out.println("3. Afficher les formations en télétravail"); 
            	System.out.println("4. Rechercher des formations par mot-clés"); 
            	System.out.println("5. Consulter son panier"); 
            	System.out.println("6. Créer un compte"); 
            	System.out.println("7. Quitter"); 
            	System.out.print("Choix : ");

                int choix = sc.nextInt();
                sc.nextLine();

                try {
                    switch (choix) {
                        case 1:
                            System.out.println("");
                            System.out.println("Voici la liste des formations disponibles :");

                            List<DescriptionFormation> formations = service.checkAllFormations();
                            
                            //we print each elements 1 by 1 from the list with this foreach
                            for (DescriptionFormation c : formations) {
                                System.out.println(
                                    "Titre: " + c.getNom() +
                                    " | Description: " + c.getDescription() +
                                    " | Durée : " + c.getLength() + " jours" +
                                    " | Lieu : " + c.getWorkplace() +
                                    " | Prix : " + c.getPrice() + "€"
                                );
                            }
                            break;
                            
                        case 2: //Deuxieme choix : formation présentiel
                        	
                            System.out.println("");
                        	System.out.println("Voici la liste des formations en présentiel :");
                        	
                            List<DescriptionFormation> formationsPre = service.checkFormationWorkplace("Présentiel");
                            
                            //we print each elements 1 by 1 from the list with this foreach
                            for (DescriptionFormation c : formationsPre) {
                                System.out.println(
                                    "Titre: " + c.getNom() +
                                    " | Description: " + c.getDescription() +
                                    " | Durée : " + c.getLength() + " jours" +
                                    " | Lieu : " + c.getWorkplace() +
                                    " | Prix : " + c.getPrice() + "€"
                                );
                            }
                            break;
                            
                        case 3: //Troisième choix : formation télétravail
                        	
                            System.out.println("");
                        	System.out.println("Voici la liste des formations en télétravail :");
                        	
                            List<DescriptionFormation> formationsTele = service.checkFormationWorkplace("Distanciel");

                            //we print each elements 1 by 1 from the list with this foreach
                            for (DescriptionFormation c : formationsTele) {
                                System.out.println(
                                    "Titre: " + c.getNom() +
                                    " | Description: " + c.getDescription() +
                                    " | Durée : " + c.getLength() + " jours" +
                                    " | Lieu : " + c.getWorkplace() +
                                    " | Prix : " + c.getPrice() + "€"
                                );
                            }
                            break;
                            
                        	case 4: //quatrième choix : Chercher par mot clé
                                System.out.println("");
                        		System.out.println("Quel mot clé voulez-vous utiliser ?");
                        		String keyword = sc.nextLine();
                        		
                        		//we only search with Strings for now
                        		if (!keyword.matches("[a-zA-ZÀ-ÿ ]+")) {
                        		    System.out.println("Veuillez utiliser uniquement des lettres.");
                        		    break;
                        		} else {
                        			System.out.println("Voici les formations trouvées :");
                                	
                                    List<DescriptionFormation> formationsKeyWord = service.checkFormationKeyword(keyword);
                                    //we print each elements 1 by 1 from the list with this foreach
                                    for (DescriptionFormation c : formationsKeyWord) {
                                        System.out.println(
                                            "Titre: " + c.getNom() +
                                            " | Description: " + c.getDescription() +
                                            " | Durée : " + c.getLength() + " jours" +
                                            " | Lieu : " + c.getWorkplace() +
                                            " | Prix : " + c.getPrice() + "€"
                                        );
                                    }
                                    break;
                        		}
                        		
                        //Case 5 and 6 are not ready as of now so we just print a message and go back to the main menu
                        case 5:
                            System.out.println("");
                            System.out.println("Cette fonctionnalité n'est pas encore disponible");
                            break;
                        case 6:
                            System.out.println("");
                            System.out.println("Cette fonctionnalité n'est pas encore disponible");
                            break;
          
                        case 7:
                        	//case 7 means the user wants to leave the program
                        	//we change the value of the "quitter" variable to "true" to end the loop and end the program
                            System.out.println("");
                            quitter = true; 
                            System.out.println("Au revoir !!");
                            break;

                        default:
                            System.out.println("Option invalide.");
                    }
                } catch (Exception e) {
                    System.err.println("ERREUR : " + e.getMessage());
                }
            }
        }
    }

}
