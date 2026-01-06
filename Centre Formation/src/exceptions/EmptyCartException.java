package exceptions;

public class EmptyCartException extends FormationException { 
	public EmptyCartException() { 
		super("Erreur: Plafond de retrait dépassé."); 
		}

}
