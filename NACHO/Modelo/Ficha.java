package Modelo;

public class Ficha {
	private int x;
	private int y;
	private int n;
	private boolean mover;
	private boolean comer;
	private boolean damas;
	 
	public Ficha() {

	}
	public Ficha(int x, int y, int n, boolean mover, boolean comer) {
		this.x = x;
		this.y = y;
		this.n = n;
		this.mover=mover;
		this.comer=comer;
		this.damas=false; //nunca una ficha puede empezar siendo dama
	}

	public boolean isDamas() {
		return damas;
	}
	public void setDamas(boolean damas) {
		this.damas = damas;
	}
	public boolean isMover() {
		return mover;
	}
	public void setMover(boolean mover) {
		this.mover = mover;
	}
	public boolean isComer() {
		return comer;
	}
	public void setComer(boolean comer) {
		this.comer = comer;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	@Override
	public String toString() {
		return "Ficha [x=" + x + ", y=" + y + ", n=" + n + ", mover=" + mover + ", comer=" + comer + ", damas=" + damas
				+ "]";
	}
	
	

	
	
	
}
