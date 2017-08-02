package nasa.mars.robo.service;

/**
 * <p>Serviço responsável pela localização do robo.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
public interface LocalizacaoService {

	/**
	 * Verifica se a posição informada é inválida.
	 * @param x
	 * @param y
	 * @return
	 */
	Boolean localizacaoInvalida(Integer x, Integer y);
	
}
