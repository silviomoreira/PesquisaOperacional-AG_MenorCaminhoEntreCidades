
public class Vertice {
	private int id, x ,y;
	
	public Vertice(int id, int x, int y) {
		this.id = id; this.x = x; this.y = y;
	}
	
	public int id() { return this.id; }
	public int x()  { return this.x; }
	public int y()  { return this.y; }
	public void setId(int id) {
		this.id = id;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}	
}
