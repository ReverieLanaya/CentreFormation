package modele;
import exceptions.FormationException;

public class DescriptionFormation {
    private String numero; // FR-XXXX-XXXX 
    private String titulaire;
    private double solde;
    private double plafond; 

    public CompteBancaire(String numero, String titulaire, double solde, double plafond) throws BankException {
        if (!numero.matches("^FR-\\d{4}-\\d{4}$")) { 
            throw new BankException("Format invalide ");
        }
        this.numero = numero;
        this.titulaire = titulaire;
        this.solde = solde;
        this.plafond = plafond;
    }

    // Getters
    public String getNumero() { return numero; }
    public String getTitulaire() { return titulaire; }
    public double getSolde() { return solde; }
    public double getPlafond() { return plafond; }
}
