package entidades;

import java.util.ArrayList;
import java.util.List;

// Uma popula��o � um conjunto de Indiv�duos (Os Indiv�duos representam as Solu��es)
// Obetivo �: Selecionar os indiv�duos com as melhores Solu��es 
    // (Fazer o Somat�rio da QtdPessoa que cada agente vacina por dia, 
    //essa qtd tem que ser, pelo menos, de 90% do tamanho da popula��o a ser vacinada)
//OBJETIVO SELECIONAR OS AGENTES QUE VACINAR�O TODAS AS PESSOAS DAQUELE DIA
public class Individuo implements Comparable<Individuo> {

	private List qtdPessoasVacinaDia = new ArrayList<>(); //private List espa�os = ESPA�OS
	private List qtsHorasTrabalhaDia = new ArrayList<>(); //private List valores
	private Double qtdPessoasParaVacinar;// Capacidade M�xima que o caminh�o carrega
	private Double notaAvaliacao; //medir qual a qtd total que o individuo vai carregar
	private Double PessoasVacinadas; //Espa�oUsado (dentro do cromossomo)
	private Integer geracao;
	private List cromossomo = new ArrayList<>();
	private boolean dizimado;
	
	
	public Individuo(List qtdPessoasVacinaDia, List qtsHorasTrabalhaDia, Double qtdPessoasParaVacinar) {
		this.qtdPessoasVacinaDia = qtdPessoasVacinaDia;
		this.qtsHorasTrabalhaDia = qtsHorasTrabalhaDia;
		this.qtdPessoasParaVacinar = qtdPessoasParaVacinar;
		this.notaAvaliacao = 0.0;
		this.PessoasVacinadas = 0.0;  
		this.geracao = 0;
		this.dizimado = false;

		//Criando o Cromossomo
		for (int i = 0; i < this.qtdPessoasVacinaDia.size(); i++) { //Pega cada agente de saude e v� se ele vai ou n�o
			if(java.lang.Math.random() < 0.5) { // 50% de probabilidade
				this.cromossomo.add("0");
			} else {
				this.cromossomo.add("1"); //Probabilidade maior que 50% 
			}
		}
	}


	public List getQtdPessoasVacinaDia() {
		return qtdPessoasVacinaDia;
	}


	public void setQtdPessoasVacinaDia(List qtdPessoasVacinaDia) {
		this.qtdPessoasVacinaDia = qtdPessoasVacinaDia;
	}


	public List getQtsHorasTrabalhaDia() {
		return qtsHorasTrabalhaDia;
	}
	
	
	public boolean isDizimado() {
		return dizimado;
	}


	public void setDizimado(boolean dizimado) {
		this.dizimado = dizimado;
	}


	public Double getPessoasVacinadas() {
		return PessoasVacinadas;
	}


	public void setPessoasVacinadas(Double pessoasVacinadas) {
		PessoasVacinadas = pessoasVacinadas;
	}


	public void setQtsHorasTrabalhaDia(List qtsHorasTrabalhaDia) {
		this.qtsHorasTrabalhaDia = qtsHorasTrabalhaDia;
	}


	public Double getQtdPessoasParaVacinar() {
		return qtdPessoasParaVacinar;
	}


	public void setQtdPessoasParaVacinar(Double qtdPessoasParaVacinar) {
		this.qtdPessoasParaVacinar = qtdPessoasParaVacinar;
	}


	public Double getNotaAvaliacao() {
		return notaAvaliacao;
	}


	public void setNotaAvaliacao(Double notaAvaliacao) {
		this.notaAvaliacao = notaAvaliacao;
	}


	public Integer getGeracao() {
		return geracao;
	}


	public void setGeracao(Integer geracao) {
		this.geracao = geracao;
	}


	public List getCromossomo() {
		return cromossomo;
	}


	public void setCromossomo(List cromossomo) {
		this.cromossomo = cromossomo;
	}
	
	
	@Override
	public int compareTo(Individuo o) {
		if(this.notaAvaliacao > o.getNotaAvaliacao()) {
			return -1;
		}
		
		if(this.notaAvaliacao < o.getNotaAvaliacao()) {
			return 1;
		}
		
		return 0;
	}
	
	
	// Fun��o FITNESS
	public void avaliacao() {
		
		Double nota = 0.0;
		Double somaPessoasVacinadas = 0.0; //SomaEspacos = PessoasVacinadas
		
		for(int i = 0; i < this.cromossomo.size(); i++) {
			if(this.cromossomo.get(i).equals("1")) {
				nota += (Double) this.qtsHorasTrabalhaDia.get(i);
				somaPessoasVacinadas += (Double) this.qtdPessoasVacinaDia.get(i);
				
			}
		}
		
		//Se o somat�rio de pessoas a serem vacinadas for MENOR que o TOTAL a vacinar...Essa solu��o N�o ser� BOA
		if(somaPessoasVacinadas < qtdPessoasParaVacinar || 
				somaPessoasVacinadas > qtdPessoasParaVacinar * 1.30 ||
				somaPessoasVacinadas < (qtdPessoasParaVacinar * 0.9)) {
			nota = 1.0; //Rebaixa a nota, para ele n�o ser USADO
		} 
		//N�o podemos colocar 0.0, pois n�o queremos descartar NENHUM indiv�duo, por isso ser� = 1.0
	
	
		this.notaAvaliacao = nota;
		this.PessoasVacinadas  = somaPessoasVacinadas;
	}
	
	
	//CROSS-OVER (REPRODU��O)
	public List crossover (Individuo outroIndividuo) {
		int corte = (int) Math.round(Math.random()* this.cromossomo.size());
		
		List filho1 = new ArrayList<>();
		filho1.addAll(outroIndividuo.getCromossomo().subList(0, corte));
		filho1.addAll(this.cromossomo.subList(corte, this.cromossomo.size()));
		
		List filho2 = new ArrayList<>();
		filho2.addAll(this.cromossomo.subList(0, corte));
		filho2.addAll(outroIndividuo.getCromossomo().subList(corte, this.cromossomo.size()));
		
		List<Individuo> filhos = new ArrayList<>();
		filhos.add(new Individuo(this.qtdPessoasVacinaDia, this.qtsHorasTrabalhaDia, this.qtdPessoasParaVacinar));
		filhos.add(new Individuo(this.qtdPessoasVacinaDia, this.qtsHorasTrabalhaDia, this.qtdPessoasParaVacinar));
		
		filhos.get(0).setCromossomo(filho1);
		filhos.get(0).setGeracao(this.geracao+1);
		filhos.get(1).setCromossomo(filho2);
		filhos.get(1).setGeracao(this.geracao+1);
		
		return filhos;
	}
	
	
	//MUTA��O:
	public Individuo mutacao(Double taxaMutacao) {
		//System.out.println("\nAntes da Muta��o: " + this.cromossomo );
		for(int i=0; i < this.cromossomo.size(); i++) {
			if(Math.random() < taxaMutacao) {
				if(this.cromossomo.get(i).equals("1")) {
					this.cromossomo.set(i, "0");
				}else {
					this.cromossomo.set(i, "1");
				}
			}
		}
		
		//System.out.println("Depois da Muta��o: " + this.cromossomo);
		
		return this;
	}

}
