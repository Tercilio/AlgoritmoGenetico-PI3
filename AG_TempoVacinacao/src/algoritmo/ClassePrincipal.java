package algoritmo;

import java.util.ArrayList;
import java.util.List;

import entidades.AgenteSaude;
import entidades.AlgoritmoGenetico;
import entidades.Individuo;
import entidades.UBS;

public class ClassePrincipal {

	public static void main(String[] args) {

		// Criando uma Lista de Agentes de Sa�de:
		List<AgenteSaude> ListaAgentes = new ArrayList<>();

		// Atribuindo valores para a lista de Agentes:
		// M�todo para gerar aleatoriamente os valores
		ListaAgentes.add(new AgenteSaude("Agente 01", 100.0, 8.00));
		ListaAgentes.add(new AgenteSaude("Agente 02", 90.0, 8.00));
		ListaAgentes.add(new AgenteSaude("Agente 03", 89.0, 8.00));
		ListaAgentes.add(new AgenteSaude("Agente 04", 88.0, 8.00));
		ListaAgentes.add(new AgenteSaude("Agente 05", 92.0, 8.00));
		ListaAgentes.add(new AgenteSaude("Agente 06", 93.0, 8.00));
		ListaAgentes.add(new AgenteSaude("Agente 07", 89.0, 8.00));
		ListaAgentes.add(new AgenteSaude("Agente 08", 83.0, 8.00));
		ListaAgentes.add(new AgenteSaude("Agente 09", 87.0, 8.00));
		ListaAgentes.add(new AgenteSaude("Agente 10", 95.0, 8.00));
		ListaAgentes.add(new AgenteSaude("Agente 11", 92.0, 8.00));
		ListaAgentes.add(new AgenteSaude("Agente 12", 86.0, 8.00));
		ListaAgentes.add(new AgenteSaude("Agente 13", 84.0, 8.00));
		ListaAgentes.add(new AgenteSaude("Agente 14", 93.0, 8.00));
		ListaAgentes.add(new AgenteSaude("Agente 15", 85.0, 8.00));
		ListaAgentes.add(new AgenteSaude("Agente 16", 93.0, 8.00));
		ListaAgentes.add(new AgenteSaude("Agente 17", 98.0, 8.00));
		ListaAgentes.add(new AgenteSaude("Agente 18", 90.0, 8.00));
		ListaAgentes.add(new AgenteSaude("Agente 19", 86.0, 8.00));
		ListaAgentes.add(new AgenteSaude("Agente 20", 90.0, 8.00));
		
		
		List nomes = new ArrayList<>();
		List qtdPessoasVacinaDia = new ArrayList<>();
		List qtsHorasTrabalhaDia = new ArrayList<>();
		for (AgenteSaude agenteSaude : ListaAgentes) {
			nomes.add(agenteSaude.getNome());
			qtdPessoasVacinaDia.add(agenteSaude.getQtdPessoasVacinaDia());
			qtsHorasTrabalhaDia.add(agenteSaude.getQtsHorasTrabalhaDia());
		}
		
		
		List<UBS> listaUBS = new ArrayList<>();
		
		
		listaUBS.add(new UBS(234,"UBS 01", 250));
		listaUBS.add(new UBS(235,"UBS 02", 200));
		listaUBS.add(new UBS(236,"UBS 03", 200));
		
		
		
		List populacao = new ArrayList<>();
		
		for (UBS ubs: listaUBS) {
			populacao.add(ubs.getPopulacaoAtendida());
			
		}
		
//		
//		Double Pessoas = 900.00;
//		
//		
//		int tamanhoPopulacao = 20;
//		Double taxaMutacao = 0.01;
//		int numeroGeracoes = 100;
//		AlgoritmoGenetico ag = new AlgoritmoGenetico(tamanhoPopulacao);
//		
//		List resultado = ag.resolver(taxaMutacao, numeroGeracoes, qtdPessoasVacinaDia, qtsHorasTrabalhaDia, Pessoas);
//	    
//		System.out.println("\nAgentes que foram escolhidos: ");
//		for(int i=0; i < ListaAgentes.size(); i++) {
//			if(resultado.get(i).equals("1")) {
//				
//				System.out.println("Nome: " + ListaAgentes.get(i).getNome());
//			}
//		}
	}
}
