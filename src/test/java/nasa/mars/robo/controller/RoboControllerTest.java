package nasa.mars.robo.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import nasa.mars.robo.exception.LocalizacaoInvalidaException;
import nasa.mars.robo.service.ExecutorService;

/**
 * <p>Teste da classe RoboController.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
@RunWith(SpringRunner.class)
@WebMvcTest(RoboController.class)
public class RoboControllerTest {

	@Autowired
	private MockMvc mockMovc;

	@MockBean
	private ExecutorService executorService;

	@Test
	public void deveRetornar200() throws Exception {
		given(this.executorService.executarNavegacao(any())).willReturn("(2, 0, S)");

		mockMovc.perform(post("/rest/mars/MMRMMRMM")).andExpect(status().isOk())
				.andExpect(content().string("(2, 0, S)"));
	}

	@Test
	public void deveRetornar400AoEnviarComandosInvalidos() throws Exception {
		mockMovc.perform(post("/rest/mars/AAA")).andExpect(status().isBadRequest());
		
		verify(this.executorService, never()).executarNavegacao(any());
	}

	@Test
	public void deveRetornar400EmPosicoesInvalidas() throws Exception {
		given(this.executorService.executarNavegacao(any())).willThrow(LocalizacaoInvalidaException.class);

		mockMovc.perform(post("/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM")).andExpect(status().isBadRequest());
	}

}
