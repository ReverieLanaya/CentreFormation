package exceptions;

public class NoProductException extends FormationException {

	
	//This part is here only because it gives me an error otherwise
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public NoProductException() {
        super("Aucun produit à afficher");
    }
}
