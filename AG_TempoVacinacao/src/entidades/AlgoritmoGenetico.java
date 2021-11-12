package entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlgoritmoGenetico {

	private int tamanhoPopulacao;
	private List<Individuo> populacao = new ArrayList<>();
	private int geracao;
	private Individuo melhorSolucao;

	public AlgoritmoGenetico(int tamanhoPopulacao) {
		this.tamanhoPopulacao = tamanhoPopulacao;
	}

	public int getTamanhoPopulacao() {
		return tamanhoPopulacao;
	}

	public void setTamanhoPopulacao(int tamanhoPopulacao) {
		this.tamanhoPopulacao = tamanhoPopulacao;
	}

	public List<Individuo> getPopulacao() {
		return populacao;
	}

	public void setPopulacao(List<Individuo> populacao) {
		this.populacao = populacao;
	}

	public int getGeracao() {
		return geracao;
	}

	public void setGeracao(int geracao) {
		this.geracao = geracao;
	}

	public Individuo getMelhorSolucao() {
		return melhorSolucao;
	}

	public void setMelhorSolucao(Individuo melhorSolucao) {
		this.melhorSolucao = melhorSolucao;
	}

	public void inicializaPopulacao(List qtdPessoasVacinaDia, List qtsHorasTrabalhaDia, Double qtdPessoasParaVacinar) {
		for (int i = 0; i < tamanhoPopulacao; i++) {
			this.populacao.add(new Individuo(qtdPessoasVacinaDia, qtsHorasTrabalhaDia, qtdPessoasParaVacinar));
		}
		this.melhorSolucao = this.populacao.get(0);
	}

	public void ordenaPopulacao() {
		Collections.sort(this.populacao);
	}

	public void melhorIndividuo(Individuo individuo) {
		if (individuo.getNotaAvaliacao() > this.melhorSolucao.getNotaAvaliacao()) {
			this.melhorSolucao = individuo;
		}
	}

	public Double somaAvaliacoes() {
		Double soma = 0.0;
		for (Individuo individuo : this.populacao) {
			soma += individuo.getNotaAvaliacao();
		}
		return soma;
	}

	public void Dizimacao() {

		for (int i = 0; i < this.populacao.size(); i++) {
			if (this.populacao.get(i).getNotaAvaliacao() == 1) {
				// System.out.println(this.populacao.get(i).getNotaAvaliacao());
				this.populacao.remove(i);
			}
		}

	}

	public void Dizimacao2() {
		this.populacao.get(this.populacao.size() - 1).setDizimado(true);
		this.populacao.get(this.populacao.size() - 2).setDizimado(true);
	}

	public int selecionaPai(Double somaAvaliacao) {
		int pai = -1;
		Double valorSorteado = Math.random() * somaAvaliacao;
		Double soma = 0.0;
		int i = 0;
		while (i < this.populacao.size() && soma < valorSorteado) {
			soma += this.populacao.get(i).getNotaAvaliacao();
			pai += 1;
			i += 1;
		}
		return pai;
	}

	public void visualizaGeracao() {
		Individuo melhor = this.populacao.get(0);
		
		System.out.println("G: " + melhor.getGeracao() +
				" Valor: " + melhor.getNotaAvaliacao() +
				" Vacinados: " + melhor.getPessoasVacinadas() +
				" Cromossomo: " + melhor.getCromossomo()
				);
		
	}

	public List resolver(Double taxaMutacao, int numeroGeracoes, List qtdPessoasVacinaDia, List qtsHorasTrabalhaDia,
			Double limiteEspaco) {

		this.inicializaPopulacao(qtdPessoasVacinaDia, qtsHorasTrabalhaDia, limiteEspaco);
		for (Individuo ind : this.populacao) {
			ind.avaliacao();
		}
		this.ordenaPopulacao();
		this.visualizaGeracao();

		// Critério de para..melhor solução..ele roda até achar o que vc definir..
		for (int geracao = 0; geracao < numeroGeracoes; geracao++) {
			Double somaAvaliacao = this.somaAvaliacoes();
			List<Individuo> novaPopulacao = new ArrayList<>();

			for (int i = 0; i < this.populacao.size() / 2; i++) {
				int pai1 = this.selecionaPai(somaAvaliacao);
				int pai2 = this.selecionaPai(somaAvaliacao);

				List<Individuo> filhos = this.getPopulacao().get(pai1).crossover(this.getPopulacao().get(pai2));
				novaPopulacao.add(filhos.get(0).mutacao(taxaMutacao));
				novaPopulacao.add(filhos.get(1).mutacao(taxaMutacao));

			}

			this.setPopulacao(novaPopulacao);
			for (Individuo ind : this.getPopulacao()) {
				ind.avaliacao();
			}

			this.ordenaPopulacao();
			this.visualizaGeracao();
			Individuo melhor = this.populacao.get(0);
			this.melhorIndividuo(melhor);
		}

		System.out.println();
		System.out.println("Melhor Solução --> " + this.melhorSolucao.getGeracao() +
				" Valor: " + this.melhorSolucao.getNotaAvaliacao() +
				" Vacinadas: " + this.melhorSolucao.getPessoasVacinadas() +
				" Cromossomo: " + this.melhorSolucao.getCromossomo()		
				);
		
		return this.melhorSolucao.getCromossomo();
	}

}
