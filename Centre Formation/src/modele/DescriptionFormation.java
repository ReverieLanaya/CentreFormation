package modele;
import exceptions.FormationException;

public class DescriptionFormation {
    private String nom; 
    private String description;
    private int length;
    private String workplace;
    private double price;

    public DescriptionFormation(String nom, String description, int length, String workplace, double price ) throws FormationException {
        
        this.nom = nom;
        this.description = description;
        this.length = length;
        this.workplace = workplace;
        this.price = price;
    }

    // Getters
    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public int getLength() { return length; }
    public String getWorkplace() { return workplace; }
    public double getPrice() { return price; }
}
