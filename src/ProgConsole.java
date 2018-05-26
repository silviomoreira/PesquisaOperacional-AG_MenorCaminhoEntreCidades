import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;

public class ProgConsole {
	
	public static void main(String[] args) {
		acompanhamentoViaConsole();
		// 1 - carregaArqTxt();
        // 2 - Tela windows
		// 3 - Reproducao gr�fica do grafo via windows
	}

	private static void acompanhamentoViaConsole()
	{
		int iCriterioParada = 40;
		int iParametrosNo = 1;   // Utilizar par�metros N: popula��o -> 200 | 800
		
		int iTamanhoPopulacao = 80;
		float iTxCrossover = 0; 
		float iTxMutacao = 0;
		// Par�metros 1
		int iTamanhoPopulacao_1 = 200;
		float iTxCrossover_1 = 0.75f; 
		float iTxMutacao_1 = 0.1f;
		// Par�metros 2
		int iTamanhoPopulacao_2 = 800;
		float iTxCrossover_2 = 0.85f; 
		float iTxMutacao_2 = 0.15f;
		
		List<Grafo> lCromossomos = new ArrayList<Grafo>();

		Acoes acoes = new Acoes();
		acoes.setVisible(true);
		//
		int iNumeroCidades = 30;  // 30 cidades, 100 cidades 
	    File arq;
	    arq = new File(iNumeroCidades+"CIT.txt");
					
		LeArquivo leArquivo = new LeArquivo(arq);
		Grafo rotaBase = leArquivo.carregaGrafo(true, true, acoes);
        // Seta par�metros principais gerais
		if (iParametrosNo == 1) {
			iTamanhoPopulacao = iTamanhoPopulacao_1;
			iTxCrossover = iTxCrossover_1;
			iTxMutacao = iTxMutacao_1;
		} else {
			iTamanhoPopulacao = iTamanhoPopulacao_2;
			iTxCrossover = iTxCrossover_2;
			iTxMutacao = iTxMutacao_2;		
		}
		System.out.println(" ");
		System.out.println("Iniciando gera��o da popula��o...");
		// 1. Gerar popula��o inicial
		iTamanhoPopulacao = 80;
		for (int i = 0; i < iTamanhoPopulacao; i++){
			System.out.print("Cromossomo "+i);
			if (i == 0) {
				lCromossomos.add(rotaBase); // 1a rota
				System.out.println(". Fitness: "+lCromossomos.get(0).getFitness());
			} else {
	            Grafo cromossomo = new Grafo(iNumeroCidades);			
	            Vertice vAtual = null;
	            Vertice vAnt = null;   // V�rtice anterior 
	            int id = 0; // id da Cidade
	            int x;      // Coord. X
	            int y;      // Coord. Y
				List<Integer> lCidadesJaIncluidas = new ArrayList<Integer>();
				for (int c = 0; c < iNumeroCidades; c++){
					// Busca cidade ainda n�o inclu�da
					int n = -1;
					int index = 0;
					while (index >= 0){
						n = Utils.retornaRandom(0, iNumeroCidades-1);
						// Vejo se j� foi incluso
						index = Collections.binarySearch(lCidadesJaIncluidas, n);  
					}
					// Carrega novo cromossomo
					vAtual = rotaBase.getVertice(n);
	                x = vAtual.x();
	                y = vAtual.y();
	                vAtual = cromossomo.insereVertice(vAtual.id(), x, y);            
	                if (c > 0){
	                    acoes.insereAresta_CalculaDistancia(true, true, cromossomo, vAtual, vAnt);
	                }
              	
	                vAnt = vAtual;			
					lCidadesJaIncluidas.add(n);					
				}
	            // Liga a ultima cidade com a primeira(Origem)
	            if (id > 0){
	            	Vertice verticeO = cromossomo.getVertice(0);
	            	acoes.insereAresta_CalculaDistancia(true, true, cromossomo, verticeO, vAtual);
	            }
	            lCromossomos.add(cromossomo);
	            System.out.println(". Fitness: "+cromossomo.getFitness());
			} // Fim <if>			
			
		} // Fim <for> populacao
		
		// .2.Comparar os fitness(sort) e separar os 2 melhores p/ criar os filhos(1a sele��o para crossover/muta��o)
		// - separando os 2 melhores 
		float fitness1 = lCromossomos.get(0).getFitness();
		for (int i = 1; i < 80; i++) {
			if (fitness1 > lCromossomos.get(i).getFitness()) {
				fitness1 = lCromossomos.get(i).getFitness();
			}
		}
		float fitness2 = lCromossomos.get(1).getFitness();
		for (int i = 1; i < 80; i++) {
			if ((fitness2 > lCromossomos.get(i).getFitness()) && (fitness2 >= fitness1)) {
				fitness2 = lCromossomos.get(i).getFitness();
			}
		}
		
		// 3. Verificar se atingiu crit�rio de parada(inicio de loop -> enquanto rodada < 40 fa�a)
		   // 4. Se rodada > 1, realizar a sele��o utilizando o m�todo roleta

		   // 5. Crossover e Muta��o
		  
		   // 6. Avalia��o da popula��o (executar m�todo 2)

		   // 7. Elimina��o dos menos aptos:
		   //... sort e elimina os 2(???) �ltimos
		// Fim Loop
	}	
}
