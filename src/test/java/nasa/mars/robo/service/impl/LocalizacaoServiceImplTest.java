package nasa.mars.robo.service.impl;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>Teste da classe LocalizacaoServiceImpl.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
@RunWith(SpringRunner.class)
public class LocalizacaoServiceImplTest {

	@TestConfiguration
	static class LocalizacaoServiceImplTestContextConfiguration {

		@Bean
		public LocalizacaoServiceImpl localizacaoServiceImpl() {
			return new LocalizacaoServiceImpl();
		}

	}

	@Autowired
	private LocalizacaoServiceImpl localizacaoServiceImpl;
	
	@Test
	public void localizacaoInvalidaQuandoXForMenorQueZero() {
		Boolean localizacaoInvalida = localizacaoServiceImpl.localizacaoInvalida(-1, 0);
		assertThat(localizacaoInvalida, equalTo(true));
	}

	@Test
	public void localizacaoInvalidaQuandoXForMaiorQueCinco() {
		Boolean localizacaoInvalida = localizacaoServiceImpl.localizacaoInvalida(6, 0);
		assertThat(localizacaoInvalida, equalTo(true));
	}

	@Test
	public void localizacaoInvalidaQuandoYForMenorQueZero() {
		Boolean localizacaoInvalida = localizacaoServiceImpl.localizacaoInvalida(0, -1);
		assertThat(localizacaoInvalida, equalTo(true));
	}

	@Test
	public void localizacaoInvalidaQuandoYForMaiorQueCinco() {
		Boolean localizacaoInvalida = localizacaoServiceImpl.localizacaoInvalida(0, 6);
		assertThat(localizacaoInvalida, equalTo(true));
	}
}
