package nasa.mars.robo.service;

import nasa.mars.robo.dto.ParametroDTO;

/**
 * <p>Serviço responsável por executar comandos do robo.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
public interface ExecutorService {

	/**
	 * Executa comandos de navegação conforme os parametros enviados.
	 * @param parametro
	 * @return
	 */
	String executarNavegacao(ParametroDTO parametro);

}
