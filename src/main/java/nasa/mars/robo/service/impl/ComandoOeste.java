package nasa.mars.robo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nasa.mars.robo.exception.LocalizacaoInvalidaException;
import nasa.mars.robo.model.Orientacao;
import nasa.mars.robo.model.Robo;
import nasa.mars.robo.service.Comando;
import nasa.mars.robo.service.LocalizacaoService;

@Service
public class ComandoOeste implements Comando {

	@Autowired
	private LocalizacaoService localizacaoService;
	
	@Override
	public void mover(Robo robo) {
		Integer y = robo.getY();
		Integer x = robo.getX() - 1;
		
		if (localizacaoService.localizacaoInvalida(x, y)) {
			throw new LocalizacaoInvalidaException(x, y);
		}
		
		robo.setX(x);
	}

	@Override
	public void rotacionarEsquerda(Robo robo) {
		robo.setOrientacao(Orientacao.SUL);
	}

	@Override
	public void rotacionarDireita(Robo robo) {
		robo.setOrientacao(Orientacao.NORTE);
	}

}
