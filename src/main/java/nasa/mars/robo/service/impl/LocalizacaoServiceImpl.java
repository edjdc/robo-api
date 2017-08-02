package nasa.mars.robo.service.impl;

import org.springframework.stereotype.Service;

import nasa.mars.robo.service.LocalizacaoService;

/**
 * <p>Serviço responsável pela localização do robo.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
@Service
public class LocalizacaoServiceImpl implements LocalizacaoService {

	/**
	 * Verifica se a posição informada é inválida.
	 * @param x
	 * @param y
	 * @return
	 */
	@Override
	public Boolean localizacaoInvalida(Integer x, Integer y) {
		boolean xInvalido = x < 0 || x > 5;
		boolean yInvalido = y < 0 || y > 5;

		boolean localizacaoInvalida = xInvalido || yInvalido;
		return localizacaoInvalida;
	}

}
