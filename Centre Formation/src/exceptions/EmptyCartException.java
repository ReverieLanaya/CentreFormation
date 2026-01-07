package exceptions;

public class EmptyCartException extends FormationException {

	
	//This part is here only because it gives me an error otherwise
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public EmptyCartException() {
        super("Le panier est vide, ajoutez des articles pour continuer");
    }
}
