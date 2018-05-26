
public class Aresta {
	private Vertice v1, v2;
	float peso;
	
	public Aresta(Vertice v1, Vertice v2, float peso) {
		this.v1 = v1; this.v2 = v2; this.peso = peso; }
	
	public float peso( ) { return this.peso; }
	public Vertice v1( ) { return this.v1; }
	public Vertice v2( ) { return this.v2; }
    public void setV1(Vertice v1) {
        this.v1 = v1;
    }
    public void setV2(Vertice v2) {
        this.v2 = v2;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
}
