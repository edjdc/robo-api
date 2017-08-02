package nasa.mars.robo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nasa.mars.robo.dto.ParametroDTO;
import nasa.mars.robo.model.Robo;
import nasa.mars.robo.service.ExecutorService;
import nasa.mars.robo.service.NavegacaoService;

/**
 * <p>Serviço responsável por executar comandos do robo.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
@Service
public class ExecutorServiceImpl implements ExecutorService {

	@Autowired
	private Robo robo;
	
	@Autowired
	private NavegacaoService navegacaoService;
	
	/**
	 * Executa comandos de navegação conforme os parametros enviados.
	 * @param parametro
	 * @return
	 */
	@Override
	public String executarNavegacao(ParametroDTO dto) {
		String param = dto.getParam();
		String[] comandos = param.split("");
		
		for (String comando : comandos) {
			if (comando.equals("M")) {
				navegacaoService.mover(robo);
			}
			if (comando.equals("R")) {
				navegacaoService.rotacionarDireita(robo);
			}
			if (comando.equals("L")) {
				navegacaoService.rotacionarEsquerda(robo);
			}
		}
		
		return robo.toString();
	}
	
	
}
