package nasa.mars.robo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import nasa.mars.robo.dto.ParametroDTO;
import nasa.mars.robo.service.ExecutorService;

/**
 * <p>Controller na comunicação rest.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
@RestController
public class RoboController {

	@Autowired
	private ExecutorService executorService;

	@PostMapping("/rest/mars/{param}")
	public ResponseEntity<String> navegacao(@Valid ParametroDTO dto, BindingResult result) {

		if (result.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		String posicaoAtual = executorService.executarNavegacao(dto);

		return new ResponseEntity<>(posicaoAtual, HttpStatus.OK);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleException() {
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
}
