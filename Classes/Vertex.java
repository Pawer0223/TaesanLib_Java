package Classes;

public class Vertex {
	
	// 현재 정점
	private int vertex;
	// 가중치 값
	private int value;
	
	public Vertex(int vertex, int value) {
		this.vertex = vertex;
		this.value = value;
	}
	
	public int getVertex() {
		return vertex;
	}

	public void setVertex(int nextV) {
		this.vertex = nextV;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public String toString() {
		return "vertex : " + vertex +", value : " + value;
	}
}
