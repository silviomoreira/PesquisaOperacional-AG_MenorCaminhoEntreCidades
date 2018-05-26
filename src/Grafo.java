import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private float mat[][];  // peso
    private int numVertices;
    private int pos[];      // posição atual ao se percorrer os adjs de um vértice v
    private float fitness;

    public List<Vertice> lVertices = new ArrayList<Vertice>();
    public List<Vertice> getlVertices() {
		return lVertices;
	}
	public void setlVertices(List<Vertice> lVertices) {
		this.lVertices = lVertices;
	}
    public Vertice getVertice(int p) {
		return lVertices.get(p);
	}

	public List<Aresta> lArestas = new ArrayList<Aresta>(); 
    public List<Aresta> getlArestas() {
		return lArestas;
	}
	public void setlArestas(List<Aresta> lArestas) {
		this.lArestas = lArestas;
	}
    //Acoes acoes;

	public Grafo(int numVertices) { //, Acoes acoes) {
        this.mat = new float[numVertices][numVertices];
        this.pos = new int[numVertices];
        this.numVertices = numVertices;
        //this.acoes = acoes;
        /*
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                this.mat[i][j] = 0f;
            }
            this.pos[i] = -1;
        }*/
    }
    
    public Vertice insereVertice(int id, int x, int y) {
    	Vertice v = new Vertice(id, x, y);
    	lVertices.add(v);
    	return v;
    }
    
    public void insereAresta(Vertice v1, Vertice v2, float peso) {
    	Aresta a = new Aresta(v1, v2, peso);
    	lArestas.add(a);
    }

/*
    public void insereAresta(Vertice v1, Vertice v2, float peso) {
        this.mat[v1.id()][v2.id()] = peso;
    }

    public Aresta retiraAresta(Vertice v1, Vertice v2) {
        if (this.mat[v1.id()][v2.id()] == 0f) {
            return null; // Aresta não existe
        } else {
            Aresta aresta = new Aresta(v1, v2, 0f);
            this.mat[v1.id()][v2.id()] = 0f;
            return aresta;
        }
    }

    // Retorna se existe aresta
    public boolean existeAresta(Vertice v1, Vertice v2) {
        return (this.mat[v1.id()][v2.id()] > 0f);
    }
    
    public void imprime() {
        System.out.print("  ");
    }
*/
    
/*
    // Retorna a próxima aresta a partir do	conjunto-vizinhança de v | Retorna a próxima aresta que o vértice v tem participação ou null se a lista de adjacência de v estiver no final
    public Aresta proxAdj(Vertice v) {    
        this.pos[v.id()]++;
        while ((this.pos[v.id()] < this.numVertices)
                && (this.mat[v.id()][ this.pos[v.id()]] == 0f)) {
            this.pos[v.id()]++;
        }
        if (this.pos[v.id()] == this.numVertices) {
            return null;
        } else {
            //return new Aresta(v, this.pos[v.id()], this.mat[v.id()][ this.pos[v.id()]]);
        	// Alterar para:
            return new Aresta(v, grafo.get( this.pos[v.id()] ), this.mat[v.id()][ this.pos[v.id()]]);
        }
    }

	// Retorna a aresta com o primeiro adjacente de um vértice v | Retorna a primeira aresta que o vértice v tem participação ou null se a lista de adjacência de v for vazia
    public Aresta primeiraArestaListaAdj(int v) {
        this.pos[v] = -1;
        return this.proxAdj(v);
    }

	// Retorna true se não tiver adjacentes
    public boolean listaAdjVazia(Vertice v) { // OK
        for (int i = 0; i < this.numVertices; i++) {
            if (this.mat[v.id()][i] > 0f) {
                return false;
            }
        }
        return true;
    }

    public int[] conjVizinhanca( int v ) {
		int[] aux = null; int[] vizinhos = null; int i = 0;
		if ( !this.listaAdjVazia(v) ){
			aux = new int[this.numVertices];
			Aresta aresta = this.primeiraArestaListaAdj(v);
			while(aresta != null) {
				aux[i++] = aresta.v2().id(); aresta = this.proxAdj(v);
			}
		}
		if ( i > 0 ) { vizinhos = new int[i]; System.arraycopy(aux,0,vizinhos,0,i); }
		return vizinhos;
	}	

    public void imprime() { // OK
        System.out.print("  ");
        for (int i = 0; i < this.numVertices; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < this.numVertices; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < this.numVertices; j++) {
                System.out.print(this.mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void desenhaGrafo(Acoes acoes) throws InterruptedException{
    	Thread.sleep(1000);
        int i = 0;
        int j = 0;
        int intV = 0;
        Object matObj[];
        matObj = new Object[numVertices];        
        for (i = 0; i < mat.length; i++) {
        	Object vertex = acoes.impVertice(intV++, "white");
        	matObj[i] = vertex;
        	Thread.sleep(1000);
        }
        for (i = 0; i < mat.length; i++) {
            for (j = 0; j < mat.length; j++) {
                if (mat[i][j] != 0) {
                    //grafo.insereAresta(i, j, mat[i][j]);
                	acoes.impArestaELigaVertices(matObj[i], matObj[j], mat[i][j]);
                	Thread.sleep(800);
                }
            }
            j = 0;
        }
        System.out.println();
        System.out.println("Fim <desenhaGrafo()>");
    }
*/    
    public float[][] getMat() {
        return mat;
    }

    public void setMat(float[][] mat) {
        this.mat = mat;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public int[] getPos() {
        return pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

	public float getFitness() {
		return fitness;
	}

	public void setFitness(float fitness) {
		this.fitness = fitness;
	}  
	
	public int compareTo(Grafo grafo) {
		int iRetorno = 0;
		// Ordenação por Deadline (para o algoritmo LTG)
		if (this.getFitness() < grafo.fitness) {
			return -1;
		} else if (this.getFitness() > grafo.fitness) {
			return 1;
		}
		return iRetorno;
	}
	
}

