package nasa.mars.robo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nasa.mars.robo.exception.LocalizacaoInvalidaException;
import nasa.mars.robo.model.Orientacao;
import nasa.mars.robo.model.Robo;
import nasa.mars.robo.service.Comando;
import nasa.mars.robo.service.LocalizacaoService;

@Service
public class ComandoNorte implements Comando {

	@Autowired
	private LocalizacaoService localizacaoService;
	
	@Override
	public void mover(Robo robo) {
		Integer y = robo.getY() + 1;
		Integer x = robo.getX();
		
		if (localizacaoService.localizacaoInvalida(x, y)) {
			throw new LocalizacaoInvalidaException(x, y);
		}
		
		robo.setY(y);
	}

	@Override
	public void rotacionarEsquerda(Robo robo) {
		robo.setOrientacao(Orientacao.OESTE);
	}

	@Override
	public void rotacionarDireita(Robo robo) {
		robo.setOrientacao(Orientacao.LESTE);
	}

}
