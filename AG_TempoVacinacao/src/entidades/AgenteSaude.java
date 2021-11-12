package entidades;


public class AgenteSaude {

	private String nome; 
	private Double qtdPessoasVacinaDia;  //Quantas pessoas ele vacina, em média, por dia
	private Double qtsHorasTrabalhaDia;  
	
	
	public AgenteSaude(String nome, Double qtdPessoasVacinaDia, Double qtsHorasTrabalhaDia) {
		this.nome = nome;
		this.qtdPessoasVacinaDia = qtdPessoasVacinaDia;
		this.qtsHorasTrabalhaDia = qtsHorasTrabalhaDia;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getQtdPessoasVacinaDia() {
		return qtdPessoasVacinaDia;
	}


	public void setQtdPessoasVacinaDia(Double qtdPessoasVacinaDia) {
		this.qtdPessoasVacinaDia = qtdPessoasVacinaDia;
	}


	public Double getQtsHorasTrabalhaDia() {
		return qtsHorasTrabalhaDia;
	}


	public void setQtsHorasTrabalhaDia(Double qtsHorasTrabalhaDia) {
		this.qtsHorasTrabalhaDia = qtsHorasTrabalhaDia;
	}

	
}
