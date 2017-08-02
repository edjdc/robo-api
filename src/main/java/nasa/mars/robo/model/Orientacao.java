package nasa.mars.robo.model;


/**
 * <p>Enum utilizada para representar as possíveis orientações de um Robo.</p>
 * 
 * @author Edivilson Dalacosta
 * @since 01/08/2017
 */
public enum Orientacao {

	NORTE("N"), SUL("S"), LESTE("E"), OESTE("W");
	
	private String sigla;
	

	private Orientacao(String sigla) {
		this.sigla = sigla;
	}
	
	public String getSigla() {
		return this.sigla;
	}
}
