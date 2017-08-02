package nasa.mars.robo.service;

import nasa.mars.robo.model.Robo;

/**
 * <p>Interface responsável por definir os tipos de comandos.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
public interface Comando {

	/**
	 * Move o robo em uma determinada direção.
	 * @param robo
	 */
	void mover(Robo robo);

	/**
	 * Rotaciona o robo para a esquerda.
	 * @param robo
	 */
	void rotacionarEsquerda(Robo robo);
	
	/**
	 * Rotaciona o robo para a direita.
	 * @param robo
	 */
	void rotacionarDireita(Robo robo);
	
}
