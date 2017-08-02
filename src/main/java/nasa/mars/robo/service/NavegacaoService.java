package nasa.mars.robo.service;

import nasa.mars.robo.model.Robo;

/**
 * <p>Serviço responsável pela navegação do robo, conforme sua orientação.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
public interface NavegacaoService {

	/**
	 * Move o robo conforme sua orientação
	 * @param robo
	 */
	void mover(Robo robo);

	/**
	 * Rotaciona o robo para esquerda, conforme sua orientação
	 * @param robo
	 */
	void rotacionarEsquerda(Robo robo);

	/**
	 * Rotaciona o robo para direita, conforme sua orientação
	 * @param robo
	 */
	void rotacionarDireita(Robo robo);
}
