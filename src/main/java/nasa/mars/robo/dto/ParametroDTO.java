package nasa.mars.robo.dto;

import java.io.Serializable;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;

/**
 * <p>DTO utilizado para armazenar o parâmetro recebido no request.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
public class ParametroDTO implements Serializable {

	private static final long serialVersionUID = -3020897940537274444L;

	@NotBlank 
	@Pattern(regexp = "(M|L|R)*") 
	private String param;

	public ParametroDTO() {

	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

}
