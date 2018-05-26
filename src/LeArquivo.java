import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class LeArquivo {
    File filArq;
    
    public LeArquivo(File filArquivo){
    	filArq = filArquivo;
    }
    
    public Grafo carregaGrafo(boolean bCalculaDistancia, boolean bTotalizaFitness, Acoes acoes) {
        String linha = null;
        String[] arrStrTmp = null;
        int intNumLinhas = 0;
        Grafo grafo = null;
        try {
            // arquivo txt  
            FileReader fileReader = new FileReader(filArq);
            BufferedReader arqTxt = new BufferedReader(fileReader);
            if ((linha = arqTxt.readLine()) != null)
            	intNumLinhas = Integer.parseInt(linha);
            System.out.println("Inicio <carregaGrafo()> Rota Base(Grafo) p/ criar cromossomos | * Número de cidades(vértices): "+intNumLinhas);
            grafo = new Grafo(intNumLinhas);
            Vertice vAtual = null;
            Vertice vAnt = null;   // Vértice anterior 
            int id = 0; // id da Cidade
            int x;      // Coord. X
            int y;      // Coord. Y
            while ((linha = arqTxt.readLine()) != null) {

                System.out.print(linha+" ");
                arrStrTmp = linha.split("\\ ");
                x = Integer.parseInt(arrStrTmp[0]);
                y = Integer.parseInt(arrStrTmp[1]);
                vAtual = grafo.insereVertice(id, x, y);            
                if (id > 0){
                    acoes.insereAresta_CalculaDistancia(bCalculaDistancia,
							bTotalizaFitness, grafo, vAtual, vAnt);
                }
              	
                vAnt = vAtual;
                id++;
            } // fim <while>
            // Liga a ultima cidade com a primeira(Origem)
            if (id > 0){
            	Vertice verticeO = grafo.getVertice(0);
            	acoes.insereAresta_CalculaDistancia(bCalculaDistancia, bTotalizaFitness, grafo, verticeO, vAtual);
            }
            arqTxt.close();
            fileReader.close();
            System.out.println();
            System.out.println("-Fitness aproximado da rota base: "+grafo.getFitness());
            System.out.println("Fim <carregaGrafo()>");
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }         
        return grafo;      
    }
   
}
