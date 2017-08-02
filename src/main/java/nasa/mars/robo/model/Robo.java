package nasa.mars.robo.model;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * <p>Bean utilizado para representar o modelo de um Robo.</p>
 * <p>O escopo request é utilizado para que ele matenha seu estado durante apenas a requisição.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Robo implements Serializable {

	private static final long serialVersionUID = -7272206597091202377L;

	private Integer x;
	private Integer y;
	private Orientacao orientacao;

	public Robo() {
		x = 0;
		y = 0;
		orientacao = Orientacao.NORTE;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Orientacao getOrientacao() {
		return orientacao;
	}

	public void setOrientacao(Orientacao orientacao) {
		this.orientacao = orientacao;
	}
	
	@Override
	public String toString() {
		return "(" + this.getX() + ", " +  this.getY() + ", " + this.getOrientacao().getSigla() + ")";
	}

}
