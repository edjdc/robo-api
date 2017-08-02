package nasa.mars.robo.service.impl;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
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

import nasa.mars.robo.model.Orientacao;
import nasa.mars.robo.model.Robo;
import nasa.mars.robo.service.Comando;

/**
 * <p>Teste da classe NavegacaoServiceImpl.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
@RunWith(SpringRunner.class)
public class NavegacaoServiceImplTest {


	@TestConfiguration
	static class NavegacaoServiceImplTestContextConfiguration {

		@Bean
		public NavegacaoServiceImpl mavegacaoServiceImpl() {
			return new NavegacaoServiceImpl();
		}

	}
	
	@MockBean
	private ComandoNorte comandoNorte;
	
	@MockBean
	private ComandoSul comandoSul;
	
	@MockBean
	private ComandoLeste comandoLeste;
	
	@MockBean
	private ComandoOeste comandoOeste;
	
	@Autowired
	private NavegacaoServiceImpl navegacaoServiceImpl;
	
	@Test
	public void deveMoverRoboConformeSuaOrientacao() {
		Robo robo = new Robo();
		robo.setOrientacao(Orientacao.NORTE);
		
		doNothing().when(this.comandoNorte).mover(any(Robo.class));
		
		navegacaoServiceImpl.mover(robo);

		verify(this.comandoNorte, times(1)).mover(any(Robo.class));
		verify(this.comandoSul, times(0)).mover(any(Robo.class));
		verify(this.comandoLeste, times(0)).mover(any(Robo.class));
		verify(this.comandoOeste, times(0)).mover(any(Robo.class));
	}

	@Test
	public void deveRotacionarParaEsquerdaConformeOrientacao() {
		Robo robo = new Robo();
		robo.setOrientacao(Orientacao.NORTE);
		
		doNothing().when(this.comandoNorte).rotacionarEsquerda(any(Robo.class));
		
		navegacaoServiceImpl.rotacionarEsquerda(robo);

		verify(this.comandoNorte, times(1)).rotacionarEsquerda(any(Robo.class));
		verify(this.comandoSul, times(0)).rotacionarEsquerda(any(Robo.class));
		verify(this.comandoLeste, times(0)).rotacionarEsquerda(any(Robo.class));
		verify(this.comandoOeste, times(0)).rotacionarEsquerda(any(Robo.class));
	}

	@Test
	public void deveRotacionarParaDireitaConformeOrientacao() {
		Robo robo = new Robo();
		robo.setOrientacao(Orientacao.NORTE);
		
		doNothing().when(this.comandoNorte).rotacionarDireita(any(Robo.class));
		
		navegacaoServiceImpl.rotacionarDireita(robo);

		verify(this.comandoNorte, times(1)).rotacionarDireita(any(Robo.class));
		verify(this.comandoSul, times(0)).rotacionarDireita(any(Robo.class));
		verify(this.comandoLeste, times(0)).rotacionarDireita(any(Robo.class));
		verify(this.comandoOeste, times(0)).rotacionarDireita(any(Robo.class));
	}
	
	@Test
	public void deveRetornarComandoNorteQuandoOrientacaoNorte() {
		Comando comando = navegacaoServiceImpl.getComandoPorOrientacao(Orientacao.NORTE);
		assertThat(comando, instanceOf(ComandoNorte.class));
	}
	
	@Test
	public void deveRetornarComandoSulQuandoOrientacaoSul() {
		Comando comando = navegacaoServiceImpl.getComandoPorOrientacao(Orientacao.SUL);
		assertThat(comando, instanceOf(ComandoSul.class));
	}

	@Test
	public void deveRetornarComandoLesteQuandoOrientacaoLeste() {
		Comando comando = navegacaoServiceImpl.getComandoPorOrientacao(Orientacao.LESTE);
		assertThat(comando, instanceOf(ComandoLeste.class));
	}

	@Test
	public void deveRetornarComandoOesteQuandoOrientacaoOeste() {
		Comando comando = navegacaoServiceImpl.getComandoPorOrientacao(Orientacao.OESTE);
		assertThat(comando, instanceOf(ComandoOeste.class));
	}

}
