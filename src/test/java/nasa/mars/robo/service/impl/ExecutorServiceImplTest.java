package nasa.mars.robo.service.impl;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import nasa.mars.robo.dto.ParametroDTO;
import nasa.mars.robo.model.Robo;
import nasa.mars.robo.service.NavegacaoService;

/**
 * <p>Teste da classe ExecutorServiceImpl.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
@RunWith(SpringRunner.class)
public class ExecutorServiceImplTest {

	@TestConfiguration
	static class ExecutorServiceImplTestContextConfiguration {

		@Bean
		public ExecutorServiceImpl executorServiceImpl() {
			return new ExecutorServiceImpl();
		}

	}

	@Autowired
	private ExecutorServiceImpl executorServiceImpl;
	
	@MockBean
	private Robo robo;
	
	@MockBean
	private NavegacaoService navegacaoService;

	@Test
	public void deveExecutarNavegacaoComParametroMover() {
		ParametroDTO dto = new ParametroDTO();
		dto.setParam("M");
		
		doNothing().when(this.navegacaoService).mover(any(Robo.class));
		
		executorServiceImpl.executarNavegacao(dto);

		verify(this.navegacaoService, times(1)).mover(any(Robo.class));
	}

	@Test
	public void deveExecutarNavegacaoComMultiplosParametrosMover() {
		ParametroDTO dto = new ParametroDTO();
		dto.setParam("MMM");
		
		doNothing().when(this.navegacaoService).mover(any(Robo.class));
		
		executorServiceImpl.executarNavegacao(dto);

		verify(this.navegacaoService, times(3)).mover(any(Robo.class));
	}

	@Test
	public void deveExecutarNavegacaoComParametroRotacionarEsquerda() {
		ParametroDTO dto = new ParametroDTO();
		dto.setParam("L");
		
		doNothing().when(this.navegacaoService).rotacionarEsquerda(any(Robo.class));
		
		executorServiceImpl.executarNavegacao(dto);

		verify(this.navegacaoService, times(1)).rotacionarEsquerda(any(Robo.class));
	}

	@Test
	public void deveExecutarNavegacaoComMultiplosParametrosRotacionarEsquerda() {
		ParametroDTO dto = new ParametroDTO();
		dto.setParam("LLL");
		
		doNothing().when(this.navegacaoService).rotacionarEsquerda(any(Robo.class));
		
		executorServiceImpl.executarNavegacao(dto);

		verify(this.navegacaoService, times(3)).rotacionarEsquerda(any(Robo.class));
	}

	@Test
	public void deveExecutarNavegacaoComParametroRotacionarDireita() {
		ParametroDTO dto = new ParametroDTO();
		dto.setParam("R");
		
		doNothing().when(this.navegacaoService).rotacionarDireita(any(Robo.class));
		
		executorServiceImpl.executarNavegacao(dto);

		verify(this.navegacaoService, times(1)).rotacionarDireita(any(Robo.class));
	}

	@Test
	public void deveExecutarNavegacaoComMultiplosParametrosRotacionarDireita() {
		ParametroDTO dto = new ParametroDTO();
		dto.setParam("RRR");
		
		doNothing().when(this.navegacaoService).rotacionarDireita(any(Robo.class));
		
		executorServiceImpl.executarNavegacao(dto);

		verify(this.navegacaoService, times(3)).rotacionarDireita(any(Robo.class));
	}

	@Test
	public void deveNaoExecutarNavegacaoComParametroVazio() {
		ParametroDTO dto = new ParametroDTO();
		dto.setParam("");
		
		executorServiceImpl.executarNavegacao(dto);

		verify(this.navegacaoService, times(0)).mover(any(Robo.class));
		verify(this.navegacaoService, times(0)).rotacionarEsquerda(any(Robo.class));
		verify(this.navegacaoService, times(0)).rotacionarDireita(any(Robo.class));
	}
	
}
