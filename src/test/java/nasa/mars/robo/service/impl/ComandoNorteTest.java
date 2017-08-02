package nasa.mars.robo.service.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import nasa.mars.robo.exception.LocalizacaoInvalidaException;
import nasa.mars.robo.model.Orientacao;
import nasa.mars.robo.model.Robo;
import nasa.mars.robo.service.LocalizacaoService;

/**
 * <p>Teste da classe ComandoNorte.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
@RunWith(SpringRunner.class)
public class ComandoNorteTest {

	@TestConfiguration
	static class ComandoNorteTestContextConfiguration {

		@Bean
		public ComandoNorte comandoNorte() {
			return new ComandoNorte();
		}

	}

	@Autowired
	private ComandoNorte comandoNorte;

	@MockBean
	private LocalizacaoService localizacaoService;

	@Test
	public void deveMoverNoEixoY() {
		Robo robo = new Robo();
		robo.setX(0);
		robo.setY(0);

		given(this.localizacaoService.localizacaoInvalida(0, 1)).willReturn(false);

		comandoNorte.mover(robo);

		assertThat(robo.getY(), equalTo(1));
		assertThat(robo.getX(), equalTo(0));
	}

	@Test(expected = LocalizacaoInvalidaException.class)
	public void deveLancarExceptionAoMoverParaPosicaoInvalida() {
		Robo robo = new Robo();
		robo.setX(0);
		robo.setY(5);

		given(this.localizacaoService.localizacaoInvalida(0, 6)).willReturn(true);

		comandoNorte.mover(robo);
	}

	@Test
	public void deveRotacionarParaOeste() {
		Robo robo = new Robo();
		robo.setOrientacao(Orientacao.NORTE);

		comandoNorte.rotacionarEsquerda(robo);

		assertThat(robo.getOrientacao(), equalTo(Orientacao.OESTE));
	}

	@Test
	public void deveRotacionarParaLeste() {
		Robo robo = new Robo();
		robo.setOrientacao(Orientacao.NORTE);

		comandoNorte.rotacionarDireita(robo);

		assertThat(robo.getOrientacao(), equalTo(Orientacao.LESTE));
	}

}
