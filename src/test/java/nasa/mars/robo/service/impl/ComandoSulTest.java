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
 * <p>Teste da classe ComandoSul.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
@RunWith(SpringRunner.class)
public class ComandoSulTest {

	@TestConfiguration
	static class ComandoSulTestContextConfiguration {

		@Bean
		public ComandoSul comandoSul() {
			return new ComandoSul();
		}

	}

	@Autowired
	private ComandoSul comandoSul;

	@MockBean
	private LocalizacaoService localizacaoService;

	@Test
	public void deveMoverNoEixoY() {
		Robo robo = new Robo();
		robo.setX(0);
		robo.setY(2);

		given(this.localizacaoService.localizacaoInvalida(0, 1)).willReturn(false);

		comandoSul.mover(robo);

		assertThat(robo.getY(), equalTo(1));
		assertThat(robo.getX(), equalTo(0));
	}

	@Test(expected = LocalizacaoInvalidaException.class)
	public void deveLancarExceptionAoMoverParaPosicaoInvalida() {
		Robo robo = new Robo();
		robo.setX(0);
		robo.setY(0);

		given(this.localizacaoService.localizacaoInvalida(0, -1)).willReturn(true);

		comandoSul.mover(robo);
	}

	@Test
	public void deveRotacionarParaLeste() {
		Robo robo = new Robo();
		robo.setOrientacao(Orientacao.SUL);

		comandoSul.rotacionarEsquerda(robo);

		assertThat(robo.getOrientacao(), equalTo(Orientacao.LESTE));
	}

	@Test
	public void deveRotacionarParaOeste() {
		Robo robo = new Robo();
		robo.setOrientacao(Orientacao.SUL);

		comandoSul.rotacionarDireita(robo);

		assertThat(robo.getOrientacao(), equalTo(Orientacao.OESTE));
	}

}
