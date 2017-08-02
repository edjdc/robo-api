package nasa.mars.robo.exception;

/**
 * <p>Exception utilizada para informar uma localização inválida.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
public class LocalizacaoInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 2949409266410564986L;

	public LocalizacaoInvalidaException(Integer x, Integer y) {
		super("Localização inválida: (" + x + ", " + y + ")");
	}

}
