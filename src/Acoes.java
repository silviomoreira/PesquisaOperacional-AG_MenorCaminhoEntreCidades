//import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import com.mxgraph.util.mxConstants;
//import com.mxgraph.view.mxStylesheet;




import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;


public class Acoes extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static mxGraph graph = new mxGraph();
	private mxGraphComponent graphCompo;
	private JTextField txtStatus;
	private int iCriterioParada = 40;
	private int iParametrosNo = 1;   // Utilizar parâmetros N: população -> 200 | 800
	private int iNumeroCidades = 30; // lê arquivo de acordo com este parâmetro
	private int iTamanhoPopulacao = 0;
	private float iTxCrossover = 0; 
	private float iTxMutacao = 0;
	// Parâmetros 1
	private int iTamanhoPopulacao_1 = 200;
	private float iTxCrossover_1 = 0.75f; 
	private float iTxMutacao_1 = 0.1f;
	// Parâmetros 2
	private int iTamanhoPopulacao_2 = 800;
	private float iTxCrossover_2 = 0.85f; 
	private float iTxMutacao_2 = 0.15f;
	/*
	private JButton btnAdd;
	private JButton btnDel;
    private JButton btnAddAresta;
    private JButton btnAlteraCorVertice;
	private Object cell;
	private int intX = 0;
	private int intY = 0;
	private int intIteracao = -1; 
	private int intIdAresta = 0;
	private static List<List<Integer>> lPosicoesVertices = new ArrayList<List<Integer>>();
	*/        
	//private static List<List<Float>> lRotas = new ArrayList<List<Float>>(); 
	List<Grafo> lCromossomos = new ArrayList<Grafo>();	
	
	public static mxGraph getGraph(){
		return graph;
	}
	public Acoes(){
		super("Algoritmo Genético p/ Busca de menor caminho entre Cidades");
		initGUI();
	}
	
	private void initGUI(){
		setSize(800,600);
		setLocationRelativeTo(null);
		graph = new mxGraph();
		graphCompo = new mxGraphComponent(graph);
		graphCompo.setPreferredSize(new Dimension(400,400));		
		getContentPane().add(graphCompo);
		
		// Componentes de interatividade c/ usuário
		txtStatus = new JTextField();
		getContentPane().add(txtStatus);
		txtStatus.setPreferredSize(new Dimension(520,21));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		txtStatus.setText("Pronto para iniciar...");
		
		// Criando lista inicial de rotas aleatórias
		int iCidade;
		float fX;
		float fY;
		
		for (int i = 1; i < iNumeroCidades; i++){
			txtStatus.setText("Cidade "+i);
		}
		
	}

	/**
	 * @param bCalculaDistancia
	 * @param bTotalizaFitness
	 * @param grafo
	 * @param vAtual
	 * @param vAnt
	 */
	public void insereAresta_CalculaDistancia(boolean bCalculaDistancia,
			boolean bTotalizaFitness, Grafo grafo, Vertice vAtual, Vertice vAnt) {
		float peso;
		if (bCalculaDistancia){
			peso = Utils.distancia_eucl(vAnt.x(), vAnt.y(), vAtual.x(), vAtual.y()); 
		} else
			peso = 0f;
		grafo.insereAresta(vAnt, vAtual, peso);
		if (bTotalizaFitness && bCalculaDistancia) 
			grafo.setFitness(grafo.getFitness()+peso);
	}
	
// initGUI() - outras inicializações:
/*
		btnAdd = new JButton("Adicionar");
		getContentPane().add(btnAdd);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt0) {
	 	        //String style = "rounded=1;strokeColor=black;fillColor="+colors[colorRelation]+";verticalAlign=top;fontStyle=1;fontColor=black"); 
	        	//graph.refresh();
                //AdicionarGrafo adicionarGrafo = new AdicionarGrafo(txtStatus.getText());
            	String style = "rounded=1;strokeColor=black;verticalAlign=top;fillColor=gray";
        		graph.getModel().beginUpdate();
        		Object parent = graph.getDefaultParent();
        		//                 Object  String id Object value            x   y   width height
        		graph.insertVertex(parent, null,     txtStatus.getText(), 30, 80, 15,  15, style);
        		graph.getModel().endUpdate();           	
            }
        });
		//
		btnDel = new JButton("Deletar");
		getContentPane().add(btnDel);
        btnDel.addActionListener(new java.awt.event.ActionListener() {
        	@Override
        	public void actionPerformed(java.awt.event.ActionEvent evt1) {
            	graph.getModel().remove(cell);
            }
        });
        
        graphCompo.getGraphControl().addMouseListener(new MouseAdapter() {
        	public void mouseReleased(MouseEvent evt2){
        		cell = graphCompo.getCellAt(evt2.getX(), evt2.getY());
        	}
		});
		//
		btnAddAresta = new JButton("Adicionar aresta");
		getContentPane().add(btnAddAresta);
        btnAddAresta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt0) {
            	impArestaComVertices(0, 1, 4);
            }
        });
		//
		btnAlteraCorVertice = new JButton("Altera cor do vértice");
		getContentPane().add(btnAlteraCorVertice);
        btnAlteraCorVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt0) {
            	String strV = JOptionPane.showInputDialog("Digite o vértice que deseja alterar a cor: ");
            	String strCor = "gray";
            	strCor = JOptionPane.showInputDialog("Digite a cor: ");
            	int intV = Integer.parseInt(strV);
            	alteraCorVertice(intV, strCor, 0, 0);
            }
        });
*/
// Rotinas relacionadas ao desenho do grafo
/*
	public void alteraCorVertice(int intV, String strCor, int intTempDescoberta, int intTempFinalizacao){
		graph.getModel().beginUpdate();
		try
		{ 
		   int intX = lPosicoesVertices.get(intV).get(1);
		   int intY = lPosicoesVertices.get(intV).get(2);		
		   String strStyle = "rounded=1;strokeColor=white;fontColor=yellow;verticalAlign=top;fillColor="+strCor;
		   Object parent = graph.getDefaultParent();
		   graph.insertVertex(parent, Integer.toString(intV), Integer.toString(intV)+"("+Integer.toString(intTempDescoberta)+"/"+Integer.toString(intTempFinalizacao)+")", intX, intY, 45, 15, strStyle);
		}
		finally
		{
		   // Atualiza o display
		   graph.getModel().endUpdate();
		}  
	}
	
    public Object impVertice(int intV, String strCor) {
    	Object vertex;
		String strStyle = "rounded=1;strokeColor=black;verticalAlign=top;fillColor="+strCor;
		graph.getModel().beginUpdate();
		try
		{ 
			Object parent = graph.getDefaultParent();
			incrementaIteracao();
			//                          Object  String id               Object value            x     y     width height
			vertex = graph.insertVertex(parent, Integer.toString(intV), Integer.toString(intV), intX, intY, 45, 15, strStyle);
			lPosicoesVertices.add(registraPosicaoVertice(intV,intX,intY)); 
		}
		finally
		{
			graph.getModel().endUpdate();
		}
		return vertex;
    }

	public void impArestaELigaVertices(Object vertex1, Object vertex2, int intPeso){
		graph.getModel().beginUpdate();
		try
		{ 
		   Object parent = graph.getDefaultParent();
		   graph.insertEdge(parent, Integer.toString(++intIdAresta), Integer.toString(intPeso), vertex1, vertex2);
		}
		finally
		{
		   // Atualiza o display
		   graph.getModel().endUpdate();
		}  
	}
	public void impArestaComVertices(int intV1, int intV2, int intPeso){
		// Adiciona células ao modelo
		graph.getModel().beginUpdate();
		try
		{ 
		   String strStyle = "rounded=1;strokeColor=black;verticalAlign=top;fillColor=white";
		   Object parent = graph.getDefaultParent();
		   incrementaIteracao();
		   Object vertex1 = graph.insertVertex(parent, Integer.toString(intV1), Integer.toString(intV1), intX, intY, 15, 15, strStyle);
		   lPosicoesVertices.add(registraPosicaoVertice(intV1,intX,intY)); 
		   incrementaIteracao();
		   Object vertex2 = graph.insertVertex(parent, Integer.toString(intV2), Integer.toString(intV2), intX, intY, 15, 15, strStyle);
		   lPosicoesVertices.add(registraPosicaoVertice(intV2,intX,intY)); 
		   graph.insertEdge(parent, Integer.toString(++intIdAresta), Integer.toString(intPeso), vertex1, vertex2);
		}
		finally
		{
		   // Atualiza o display
		   graph.getModel().endUpdate();
		}  
	}

	// Adequa para armazenar em uma linha só de lPosicoesVertices
	private List<Integer> registraPosicaoVertice(int intV, int intX, int intY) {
		List<Integer> listaPosicaoVertice = new ArrayList<Integer>();
		   listaPosicaoVertice.add(intV);
		   listaPosicaoVertice.add(intX);
		   listaPosicaoVertice.add(intY);
		return listaPosicaoVertice;
	}
	private void incrementaIteracao(){
		if (++intIteracao==0){
			intX = 30;
			intY = 30;
		}else if (intIteracao%3==0){
			intX = 30;
			intY = intY + 70;
		}else{
			intX = intX + 90;
		}	
	}
*/	
}
