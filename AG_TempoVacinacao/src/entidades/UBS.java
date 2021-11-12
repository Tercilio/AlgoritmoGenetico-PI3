package entidades;

public class UBS {

	private Integer numUBS;
	private String nome;
	private Integer populacaoAtendida;
	
	
	public UBS(Integer numUBS, String nome, Integer populacaoAtendida) {
		super();
		this.numUBS = numUBS;
		this.nome = nome;
		this.populacaoAtendida = populacaoAtendida;
	}


	public Integer getNumUBS() {
		return numUBS;
	}


	public void setNumUBS(Integer numUBS) {
		this.numUBS = numUBS;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getPopulacaoAtendida() {
		return populacaoAtendida;
	}


	public void setPopulacaoAtendida(Integer populacaoAtendida) {
		this.populacaoAtendida = populacaoAtendida;
	}
	
	
	
	
}
