package app;

import java.util.List;
import java.util.Scanner;

import modele.DescriptionFormation;
import service.FormationService;

public class FormationApp {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        FormationService service = new FormationService();

        try (Scanner sc = new Scanner(System.in)) {
            boolean quitter = false;

            while (!quitter) {
            	System.out.println("\n--- Centre de formation ---"); 
            	System.out.println("1. Afficher toutes les formations disponible"); 
            	System.out.println("2. Afficher les formations en présentiel"); 
            	System.out.println("3. Afficher les formations en télétravail"); 
            	System.out.println("4. Rechercher des formations par mot-clés"); 
            	System.out.println("5. Consulter son panier"); 
            	System.out.println("6. Créer un compte"); 
            	System.out.println("7. Quitter"); System.out.print("Choix : ");

                int choix = sc.nextInt();
                sc.nextLine();

                try {
                    switch (choix) {
                        case 1:
                            System.out.println("Voici la liste des formations disponibles :");

                            List<DescriptionFormation> formations = service.checkAllFormations();

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
                        	
                        	
                        	System.out.println("Voici la liste des formations en présentiel :");
                        	
                            List<DescriptionFormation> formationsPre = service.checkFormationWorkplace("Présentiel");

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
                        	
                        	
                        	System.out.println("Voici la liste des formations en télétravail :");
                        	
                            List<DescriptionFormation> formationsTele = service.checkFormationWorkplace("Distanciel");

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
                        		System.out.println("Quel mot clé voulez-vous utiliser ?");
                        		String keyword = sc.nextLine();
                        		
                        		//we only search with Strings for now
                        		if (!keyword.matches("[a-zA-ZÀ-ÿ ]+")) {
                        		    System.out.println("Veuillez utiliser uniquement des lettres.");
                        		    break;
                        		} else {
                        			System.out.println("Voici les formations trouvées :");
                                	
                                    List<DescriptionFormation> formationsKeyWord = service.checkFormationKeyword(keyword);

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

                        	
                        	
                            
                            
                        case 7:
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
