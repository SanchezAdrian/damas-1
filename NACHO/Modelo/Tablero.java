package Modelo;

public class Tablero {
	int[][] Base= new int[7][7];
	
	public Tablero() {
		int[][] Base= new int[8][8];
		for(int x=0;x<8;x++) {
			for(int y=0;y<8;y++) {
				Base[y][x]=0;
				if(y<3 && (y+x)%2==0) {
					Base[y][x]=1;
				}else if (y>4 && (y+x)%2==0) {
					Base[y][x]=2;
				}
			}
		}
	}
	
	public int[][] getBase() {
		return Base;
	}

	public void setBase(int[][] base) {
		Base = base;
	}

	public void mostrarTablero() { //esto me sirve solo de guia
		System.out.println("  0 1 2 3 4 5 6 7 ");
		System.out.println("------------------");
		for(int x=0;x<8;x++) {
			
				System.out.print(x+ "|");
			
			for(int y=0;y<8;y++) {
				System.out.print(Base[x][y]);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
	
}
