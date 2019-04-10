package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		/*
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
		
		
		List<Ficha> f1=new ArrayList<Ficha>();
		List<Ficha> f2=new ArrayList<Ficha>();
		
		Tablero tab=new Tablero();
		int[][] p=tab.getBase();
		
		
		for(int x=0;x<8;x++) {
			for(int y=0;y<8;y++) {
				if(Base[x][y]==1) {
					Ficha f=new Ficha(x, y, 1, false, false);
					f1.add(f);
				}else if(Base[x][y]==2) {
					Ficha f=new Ficha(x, y, 2, false, false);
					f2.add(f); 
				}
			}
		}
		System.out.println("F1");
		for(Ficha n:f1) {
			System.out.println(n.toString());
		}
		System.out.println("F2");
		for(Ficha n:f2) {
			System.out.println(n.toString());
		}
		
		*/
		Comportamiento prueba=new Comportamiento();
		for(Ficha n:prueba.f2) {
			System.out.println(n.toString());
		}
	}
	}
	
	
	