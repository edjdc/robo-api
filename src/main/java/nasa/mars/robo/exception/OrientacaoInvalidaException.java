package nasa.mars.robo.exception;

import nasa.mars.robo.model.Orientacao;

/**
 * <p>Exception utilizada para informar uma orientação inválida.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
public class OrientacaoInvalidaException extends RuntimeException {

	private static final long serialVersionUID = -6660026634790050934L;

	public OrientacaoInvalidaException(Orientacao orientacao) {
		super("Orientacao inválida: " + orientacao);
	}

}
