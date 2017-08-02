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
 * <p>Teste da classe ComandoLeste.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
@RunWith(SpringRunner.class)
public class ComandoLesteTest {

	@TestConfiguration
	static class ComandoLesteTestContextConfiguration {

		@Bean
		public ComandoLeste comandoLeste() {
			return new ComandoLeste();
		}

	}

	@Autowired
	private ComandoLeste comandoLeste;

	@MockBean
	private LocalizacaoService localizacaoService;

	@Test
	public void deveMoverNoEixoX() {
		Robo robo = new Robo();
		robo.setX(0);
		robo.setY(0);

		given(this.localizacaoService.localizacaoInvalida(1, 0)).willReturn(false);

		comandoLeste.mover(robo);

		assertThat(robo.getX(), equalTo(1));
		assertThat(robo.getY(), equalTo(0));
	}

	@Test(expected = LocalizacaoInvalidaException.class)
	public void deveLancarExceptionAoMoverParaPosicaoInvalida() {
		Robo robo = new Robo();
		robo.setX(5);
		robo.setY(0);

		given(this.localizacaoService.localizacaoInvalida(6, 0)).willReturn(true);

		comandoLeste.mover(robo);
	}

	@Test
	public void deveRotacionarParaNorte() {
		Robo robo = new Robo();
		robo.setOrientacao(Orientacao.LESTE);

		comandoLeste.rotacionarEsquerda(robo);

		assertThat(robo.getOrientacao(), equalTo(Orientacao.NORTE));
	}

	@Test
	public void deveRotacionarParaSul() {
		Robo robo = new Robo();
		robo.setOrientacao(Orientacao.LESTE);

		comandoLeste.rotacionarDireita(robo);

		assertThat(robo.getOrientacao(), equalTo(Orientacao.SUL));
	}

}
