package nasa.mars.robo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nasa.mars.robo.exception.OrientacaoInvalidaException;
import nasa.mars.robo.model.Orientacao;
import nasa.mars.robo.model.Robo;
import nasa.mars.robo.service.Comando;
import nasa.mars.robo.service.NavegacaoService;

/**
 * <p>Serviço responsável pela navegação do robo, conforme sua orientação.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
@Service
public class NavegacaoServiceImpl implements NavegacaoService {

	@Autowired
	private ComandoNorte comandoNorte;
	
	@Autowired
	private ComandoSul comandoSul;
	
	@Autowired
	private ComandoLeste comandoLeste;
	
	@Autowired
	private ComandoOeste comandoOeste;

	/**
	 * Move o robo conforme sua orientação
	 * @param robo
	 */
	@Override
	public void mover(Robo robo) {
		Comando comando = getComandoPorOrientacao(robo.getOrientacao());
		comando.mover(robo);
	}

	/**
	 * Rotaciona o robo para esquerda, conforme sua orientação
	 * @param robo
	 */
	@Override
	public void rotacionarEsquerda(Robo robo) {
		Comando comando = getComandoPorOrientacao(robo.getOrientacao());
		comando.rotacionarEsquerda(robo);
	}

	/**
	 * Rotaciona o robo para direita, conforme sua orientação
	 * @param robo
	 */
	@Override
	public void rotacionarDireita(Robo robo) {
		Comando comando = getComandoPorOrientacao(robo.getOrientacao());
		comando.rotacionarDireita(robo);
	}

	/**
	 * Retorna o comando a ser executado, conforme a orientação informada.
	 * @param orientacao
	 * @return
	 */
	public Comando getComandoPorOrientacao(Orientacao orientacao) {

		switch (orientacao) {
			case NORTE:
				return comandoNorte;
	
			case SUL:
				return comandoSul;
	
			case LESTE:
				return comandoLeste;
	
			case OESTE:
				return comandoOeste;
		}

		throw new OrientacaoInvalidaException(orientacao);
	}

}
