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
 * <p>Teste da classe ComandoOeste.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
@RunWith(SpringRunner.class)
public class ComandoOesteTest {

	@TestConfiguration
	static class ComandoOesteTestContextConfiguration {

		@Bean
		public ComandoOeste comandoOeste() {
			return new ComandoOeste();
		}

	}

	@Autowired
	private ComandoOeste comandoOeste;

	@MockBean
	private LocalizacaoService localizacaoService;

	@Test
	public void deveMoverNoEixoX() {
		Robo robo = new Robo();
		robo.setX(2);
		robo.setY(0);

		given(this.localizacaoService.localizacaoInvalida(1, 0)).willReturn(false);

		comandoOeste.mover(robo);

		assertThat(robo.getX(), equalTo(1));
		assertThat(robo.getY(), equalTo(0));
	}

	@Test(expected = LocalizacaoInvalidaException.class)
	public void deveLancarExceptionAoMoverParaPosicaoInvalida() {
		Robo robo = new Robo();
		robo.setX(0);
		robo.setY(0);

		given(this.localizacaoService.localizacaoInvalida(-1, 0)).willReturn(true);

		comandoOeste.mover(robo);
	}

	@Test
	public void deveRotacionarParaSul() {
		Robo robo = new Robo();
		robo.setOrientacao(Orientacao.OESTE);

		comandoOeste.rotacionarEsquerda(robo);

		assertThat(robo.getOrientacao(), equalTo(Orientacao.SUL));
	}

	@Test
	public void deveRotacionarParaNorte() {
		Robo robo = new Robo();
		robo.setOrientacao(Orientacao.OESTE);

		comandoOeste.rotacionarDireita(robo);

		assertThat(robo.getOrientacao(), equalTo(Orientacao.NORTE));
	}

}
