package Modelo;

import java.util.ArrayList;
import java.util.List;

//en cada turno deberia recorrer el tablero para actualizar los boolean de cada ficha

public class Comportamiento {
	List<Ficha> f1=new ArrayList<>();
	List<Ficha> f2=new ArrayList<>();
	
	
	int[][] p=new int[8][8];
	
	public Comportamiento() {
		añadirFicha();
		turnoBlancas(f2);
		
		
	}

	public void añadirFicha() {
		for(int x=0;x<8;x++) {
			for(int y=0;y<8;y++) {
				p[y][x]=0;
				if(y<3 && (y+x)%2==0) {
					p[y][x]=1;
				}else if (y>4 && (y+x)%2==0) {
					p[y][x]=2;
				}
			}
		}
		
		for(int x=0;x<8;x++) {
			for(int y=0;y<8;y++) {
				if(p[x][y]==1) {
					Ficha f=new Ficha(x, y, 1, false, false);
					f1.add(f);
				}else if(p[x][y]==2) {
					Ficha f=new Ficha(x, y, 2, false, false);
					f2.add(f); 
				}
			}
		}
		
	}
	
	public void turnoBlancas (List<Ficha> f) {
		
		ActualizarBlancas(f);
		
		if(puedeComer(f)) {
			//llamamos al metodo comer
		}else { 
			if(puedeMover(f)) {
			//llamamos al metodo mover
			}else {
			//ganan las negras pues no puede ni comer ni mover
			}
		}
		
	}
	
	public void turnoNegras(List<Ficha> f){
		
		ActualizarNegras(f);
		
		if(puedeComer(f)) {
			//llamamos al metodo comer
		}else { 
			if(puedeMover(f)) {
			//llamamos al metodo mover
			}else {
			//ganan las negras pues no puede ni comer ni mover
			}
		}
	}
	
	public boolean puedeComer(List<Ficha> f) { //devuelve true si alguna ficha puede comer false si no
		for(Ficha n: f) {
			if(n.isComer()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean puedeMover(List<Ficha> f) { //devuelve true si alguna ficha puede mover false si no
		for(Ficha n: f) {
			if(n.isMover()) {
				return true;
			}
		}
		return false;
	}

	public void ActualizarBlancas(List<Ficha> f) { //en este metodo se cambiaran los valores a true o false 
		int posx;
		int posy;
		boolean actualizarmover=true;
		
		for(Ficha n: f) { //se ponen valores por defecto
			n.setComer(false);
			n.setMover(false);
		}
		
		//actualizamos los valores de comer
		for(int i=0;i<f.size();i++) {
			posx=f.get(i).getX();
			posy=f.get(i).getY();
			
			if(!f.get(i).isDamas()) {
				if(posx==1 ||posx==0) {
					//no puede comer
	
				}else {
					if((posy!=0&&posy!=7)&&(posy!=1&&posy!=6)) {
						if((p[posx-1][posy-1]==1)&&(p[posx-2][posy-2]==0)||(p[posx-1][posy+1]==1)&&(p[posx-2][posy+2]==0)) {
							//puede comer
							f.get(i).setComer(true);
							actualizarmover=false;
	
						}else {
							//no puede comer
	
						}
					}else {
						if(posy==6||posy==7){
							if((p[posx-1][posy-1]==1)&&(p[posx-2][posy-2]==0)) {
								//puede comer
								f.get(i).setComer(true);
								actualizarmover=false;
	
							}else {
								//no puede comer
	
							}
						}else { //posy=0 o posy=1
							if((p[posx-1][posy+1]==1)&&(p[posx-2][posy+2]==0)) {
								//puede comer
								f.get(i).setComer(true);
								actualizarmover=false;
	
							}else {
								//no puede comer
	
							}
						}
					}
				}
			}else {
				if(posx>1&&posx<6&&posy>10&&posy<6) {// 3 4 5 6 
					if((p[posx-1][posy-1]==2&&p[posx-2][posy-2]==0)
					 ||(p[posx-1][posy+1]==2&&p[posx-2][posy+2]==0)
					 ||(p[posx+1][posy+1]==2&&p[posx+2][posy+2]==0)
					 ||(p[posx+1][posy-1]==2&&p[posx+2][posy-2]==0)) {
						//puede comer
						f.get(i).setComer(true);
						actualizarmover=false;
					}
					
				}else {
					if(posx==0) {
						if(posy==6) {
							if(p[posx+1][posy-1]==2&&p[posx+2][posy-2]==0){
								//puede comer
								f.get(i).setComer(true);
								actualizarmover=false;
							}
						}else {
							if(posy==0) {
								if(p[posx+1][posy+1]==2&&p[posx+2][posy+2]==0) {
									//puede comer
									f.get(i).setComer(true);
									actualizarmover=false;
								}
							}else {
								if((p[posx+1][posy+1]==2&&p[posx+2][posy+2]==0)||(p[posx+1][posy-1]==2&&p[posx+2][posy-2]==0)){
									//puede comer
									f.get(i).setComer(true);
									actualizarmover=false;
								}
							}
						}
					}else {
						if(posx==1) {
							if(posy==7) {
								if(p[posx+1][posy-1]==2&&p[posx+2][posy-2]==0){
									//puede comer
									f.get(i).setComer(true);
									actualizarmover=false;
								}
							}else {
								if(posy==1) {
									if(p[posx+1][posy+1]==2&&p[posx+2][posy+2]==0) {
										//puede comer
										f.get(i).setComer(true);
										actualizarmover=false;
									}
								}else {
									if((p[posx+1][posy+1]==2&&p[posx+2][posy+2]==0)||(p[posx+1][posy-1]==2&&p[posx+2][posy-2]==0)){
										//puede comer
										f.get(i).setComer(true);
										actualizarmover=false;
									}
								}
							}
						}else {
							if(posx==7) {
								if(posy==7) {
									if(p[posx-1][posy-1]==2&&p[posx-2][posy-2]==0){
										//puede comer
										f.get(i).setComer(true);
										actualizarmover=false;
									}
								}else {
									if(posy==1) {
										if(p[posx-1][posy+1]==2&&p[posx-2][posy+2]==0) {
											//puede comer
											f.get(i).setComer(true);
											actualizarmover=false;
										}
									}else {
										if((p[posx-1][posy+1]==2&&p[posx-2][posy+2]==0)||(p[posx-1][posy-1]==2&&p[posx-2][posy-2]==0)){
											//puede comer
											f.get(i).setComer(true);
											actualizarmover=false;
										}
									}
								}
							}else {
								if(posx==6) {
									if(posy==0) {
										if(p[posx-1][posy+1]==2&&p[posx-2][posy+2]==0) {
											//puede comer
											f.get(i).setComer(true);
											actualizarmover=false;
										}
									}else {
										if(posy==6) {
											if(p[posx-1][posy-1]==2&&p[posx-2][posy-2]==0){
												//puede comer
												f.get(i).setComer(true);
												actualizarmover=false;
											}
										}else {
											if((p[posx-1][posy+1]==2&&p[posx-2][posy+2]==0)||(p[posx-1][posy-1]==2&&p[posx-2][posy-2]==0)){
												//puede comer
												f.get(i).setComer(true);
												actualizarmover=false;
											}
										}
									}
								}else {
									if(posy==0||posy==1) {
										if((p[posx-1][posy+1]==2&&p[posx-2][posy+2]==0)||(p[posx+1][posy+1]==2&&p[posx+2][posy+2]==0)) {
											//puede comer
											f.get(i).setComer(true);
											actualizarmover=false;
										}
									}else {
										if(posy==6||posy==7) {
											if((p[posx-1][posy-1]==2&&p[posx-2][posy-2]==0)||(p[posx+1][posy-1]==2&&p[posx+2][posy-2]==0)) {
												//puede comer
												f.get(i).setComer(true);
												actualizarmover=false;
											}
										}
									}
								}
							}	
						}
					}
				}
			}
			
		}
		
		//actualizamos los valores de mover
		if(actualizarmover==true) { //si no puede comer veamos si puede mover
			for(int i=0;i<f.size();i++) {//hablando SOLO de las 2
				posx=f.get(i).getX();
				posy=f.get(i).getY();
				if(!f.get(i).isDamas()) {
					if((posx!=0&&posy!=7)&&(posy!=0)) { //no se tiene en cuenta posy  (habría que distingir entre blancas y negras me da a mi que lo suyo son 2 metodos
						if(p[posx-1][posy-1]==0||p[posx-1][posy+1]==0) {
							//puede mover
							f.get(i).setMover(true);
						}else {
							//entonces tiene fichas delante ya sea 1 (incomible) o 2
							//no puede mover
						}
					}else 
						if(posx==0){ //vamos con las excepciones 0 y 7
							//es coronada no podria haber ninguna ahí
						}else {
							if(posy==7){
								if(p[posx-1][posy-1]==0) {
									 //puede mover
									f.get(i).setMover(true);
								}else {
									//entonces tiene fichas delante ya sea 1 (incomible) o 2
								}
						
							
							}else { //posy==0
								if(p[posx-1][posy+1]==0) {
									//puede mover
									f.get(i).setMover(true);
								}else {
									//entonces tiene fichas delante ya sea 1 (incomible) o 2
								}
							}
						}
					
				}else {
					MoverDama(f.get(i));
				}
			}
		}
		
	}
	
	public void ActualizarNegras(List<Ficha> f) {
		int posx;
		int posy;
		boolean actualizarmover=true;
		
		for(Ficha n: f) { //se ponen valores por defecto
			n.setComer(false);
			n.setMover(false);
		}
		
		//actualizamos valores de comer
		for(int i=0;i<f.size();i++) {
			posx=f.get(i).getX();
			posy=f.get(i).getY();
			
			if(!f.get(i).isDamas()) { //si no es dama
			if(posx==6 ||posx==7) {
				//no puede comer

			}else {
				if((posy!=0&&posy!=7)&&(posy!=1&&posy!=6)) {
					if((p[posx+1][posy-1]==2)&&(p[posx+2][posy-2]==0)||(p[posx+1][posy+1]==2)&&(p[posx+2][posy+2]==0)) {
						//puede comer
						f.get(i).setComer(true);
						actualizarmover=false;

					}else {
						//no puede comer
					}
				}else {
					if(posy==6||posy==7){
						if((p[posx+1][posy-1]==2)&&(p[posx+2][posy-2]==0)) {
							//puede comer
							f.get(i).setComer(true);
							actualizarmover=false;

						}else {
							//no puede comer
							

						}
					}else { //posy=0 o posy=1
						if((p[posx+1][posy+1]==2)&&(p[posx+2][posy+2]==0)) {
							//puede comer
							f.get(i).setComer(true);
							actualizarmover=false;

						}else {
							//no puede comer

						}
					}
				}
			}
			
			}else { //si es dama
				if(posx>1&&posx<6&&posy>10&&posy<6) {// 3 4 5 6 
					if((p[posx-1][posy-1]==2&&p[posx-2][posy-2]==0)
					 ||(p[posx-1][posy+1]==2&&p[posx-2][posy+2]==0)
					 ||(p[posx+1][posy+1]==2&&p[posx+2][posy+2]==0)
					 ||(p[posx+1][posy-1]==2&&p[posx+2][posy-2]==0)) {
						//puede comer
						f.get(i).setComer(true);
						actualizarmover=false;
					}
					
				}else {
					if(posx==0) {
						if(posy==6) {
							if(p[posx+1][posy-1]==2&&p[posx+2][posy-2]==0){
								//puede comer
								f.get(i).setComer(true);
								actualizarmover=false;
							}
						}else {
							if(posy==0) {
								if(p[posx+1][posy+1]==2&&p[posx+2][posy+2]==0) {
									//puede comer
									f.get(i).setComer(true);
									actualizarmover=false;
								}
							}else {
								if((p[posx+1][posy+1]==2&&p[posx+2][posy+2]==0)||(p[posx+1][posy-1]==2&&p[posx+2][posy-2]==0)){
									//puede comer
									f.get(i).setComer(true);
									actualizarmover=false;
								}
							}
						}
					}else {
						if(posx==1) {
							if(posy==7) {
								if(p[posx+1][posy-1]==2&&p[posx+2][posy-2]==0){
									//puede comer
									f.get(i).setComer(true);
									actualizarmover=false;
								}
							}else {
								if(posy==1) {
									if(p[posx+1][posy+1]==2&&p[posx+2][posy+2]==0) {
										//puede comer
										f.get(i).setComer(true);
										actualizarmover=false;
									}
								}else {
									if((p[posx+1][posy+1]==2&&p[posx+2][posy+2]==0)||(p[posx+1][posy-1]==2&&p[posx+2][posy-2]==0)){
										//puede comer
										f.get(i).setComer(true);
										actualizarmover=false;
									}
								}
							}
						}else {
							if(posx==7) {
								if(posy==7) {
									if(p[posx-1][posy-1]==2&&p[posx-2][posy-2]==0){
										//puede comer
										f.get(i).setComer(true);
										actualizarmover=false;
									}
								}else {
									if(posy==1) {
										if(p[posx-1][posy+1]==2&&p[posx-2][posy+2]==0) {
											//puede comer
											f.get(i).setComer(true);
											actualizarmover=false;
										}
									}else {
										if((p[posx-1][posy+1]==2&&p[posx-2][posy+2]==0)||(p[posx-1][posy-1]==2&&p[posx-2][posy-2]==0)){
											//puede comer
											f.get(i).setComer(true);
											actualizarmover=false;
										}
									}
								}
							}else {
								if(posx==6) {
									if(posy==0) {
										if(p[posx-1][posy+1]==2&&p[posx-2][posy+2]==0) {
											//puede comer
											f.get(i).setComer(true);
											actualizarmover=false;
										}
									}else {
										if(posy==6) {
											if(p[posx-1][posy-1]==2&&p[posx-2][posy-2]==0){
												//puede comer
												f.get(i).setComer(true);
												actualizarmover=false;
											}
										}else {
											if((p[posx-1][posy+1]==2&&p[posx-2][posy+2]==0)||(p[posx-1][posy-1]==2&&p[posx-2][posy-2]==0)){
												//puede comer
												f.get(i).setComer(true);
												actualizarmover=false;
											}
										}
									}
								}else {
									if(posy==0||posy==1) {
										if((p[posx-1][posy+1]==2&&p[posx-2][posy+2]==0)||(p[posx+1][posy+1]==2&&p[posx+2][posy+2]==0)) {
											//puede comer
											f.get(i).setComer(true);
											actualizarmover=false;
										}
									}else {
										if(posy==6||posy==7) {
											if((p[posx-1][posy-1]==2&&p[posx-2][posy-2]==0)||(p[posx+1][posy-1]==2&&p[posx+2][posy-2]==0)) {
												//puede comer
												f.get(i).setComer(true);
												actualizarmover=false;
											}
										}
									}
								}
							}	
						}
					}
				}	
			}
			
		}
		
		//actualizamos los valores de mover
		if(actualizarmover==true) { //si no puede comer veamos si puede mover
			
			for(int i=0;i<f.size();i++) {//hablando SOLO de las 1
				posx=f.get(i).getX();
				posy=f.get(i).getY();
				if(!f.get(i).isDamas()) {
					if((posx!=7||posy!=0)||(posy!=7)) { 
						if(p[posx+1][posy-1]==0||p[posx+1][posy+1]==0) {
							//puede mover
							f.get(i).setMover(true);
						}else {
							//entonces tiene fichas delante ya sea 2 (incomible) o 1
							//no puede mover
						}
					}else { 
						if(posx==7){ 
							//es coronada no podria haber ninguna ahí
						}else {
							if(posy==7){
								if(p[posx+1][posy-1]==0) {
									 //puede mover
									f.get(i).setMover(true);
								}else {
									//entonces tiene fichas delante ya sea 1 (incomible) o 2
								}
						
							
							}else { //posy==0
								if(p[posx+1][posy+1]==0) {
									//puede mover
									f.get(i).setMover(true);
								}else {
									//entonces tiene fichas delante ya sea 1 (incomible) o 2
								}
							}
						}
					}
				}else {
					MoverDama(f.get(i));
				}
			}
			
			
		
		}
		
	}
	
	public void MoverDama(Ficha f) {
		int posx;
		int posy;
		
		posx=f.getX();
		posy=f.getY();
		if(posx!=0&&posx!=7&&posy!=0&&posy!=7) { //tanto para blancas como para negras 
			if(p[posx-1][posy-1]==0||p[posx-1][posy+1]==0||p[posx+1][posy+1]==0||p[posx+1][posy-1]==0) {
				//puede mover
				f.setMover(true);
			}
		}else {//posx==0 posx==7 posy==0  posy==7
			if(posy==7) {
				if(posx==7) {
					if(p[6][6]==0) { //esquinas controladas
						//puede mover
						f.setMover(true);
					}
				}else {
					if(posx<7) {
						if(p[posx+1][posy-1]==0||p[posx-1][posy-1]==0) {
							//puede mover
							f.setMover(true);
						}
					}
				}
			}else {
				if(posy==0) {
					if(posx==0) {
						if(p[1][1]==0) { //esquinas controladas
							//puede mover
							f.setMover(true);
						}
					}else {
						if(posx>0) {
							if(p[posx+1][posy+1]==0||p[posx-1][posy+1]==0) {
								//puede mover
								f.setMover(true);
							}
						}
					}
					
				}else {
					if(posx==0) {
							if(posy>0) {
								if(p[posx+1][posy+1]==0||p[posx+1][posy-1]==0) {
									//puede mover
									f.setMover(true);
								}
							}
					}else { //solo puede ser posx=7
						if(posy<7) {
							if(p[posx-1][posy+1]==0||p[posx-1][posy-1]==0) {
								//puede mover
								f.setMover(true);
							}
						}
					}
						
				}
			}
		}
	}
	
	public List<Ficha> getF1() { //devuelve la lista de fichas 1
		return f1;
	}

	public void setF1(List<Ficha> f1) {
		this.f1 = f1;
	}

	public List<Ficha> getF2() { //devuelve la lista de fichas 2
		return f2;
	}

	public void setF2(List<Ficha> f2) {
		this.f2 = f2;
	}

	

	public int[][] getP() {  //devuelve el tablero en el estado actual
		return p;
	}

	public void setP(int[][] p) {
		this.p = p;
	}
	//esto hay que borrarlo mas tarde
	/*
	public void CondicionesDamas(List<Ficha> f) {
		int posx;
		int posy;
		boolean actualizarmover=false;
		//mover (falta comprobarlo)
		for(int i=0;i<f.size();i++) {
			
			if(f.get(i).isDamas()) {
				posx=f.get(i).getX();
				posy=f.get(i).getY();
				if(posx!=0&&posx!=7&&posy!=0&&posy!=7) { //tanto para blancas como para negras 
					if(p[posx-1][posy-1]==0||p[posx-1][posy+1]==0||p[posx+1][posy+1]==0||p[posx+1][posy-1]==0) {
						//puede mover
						f.get(i).setMover(true);
					}
				}else {//posx==0 posx==7 posy==0  posy==7
					if(posy==7) {
						if(posx==7) {
							if(p[6][6]==0) { //esquinas controladas
								//puede mover
								f.get(i).setMover(true);
							}
						}else {
							if(posx<7) {
								if(p[posx+1][posy-1]==0||p[posx-1][posy-1]==0) {
									//puede mover
									f.get(i).setMover(true);
								}
							}
						}
					}else {
						if(posy==0) {
							if(posx==0) {
								if(p[1][1]==0) { //esquinas controladas
									//puede mover
									f.get(i).setMover(true);
								}
							}else {
								if(posx>0) {
									if(p[posx+1][posy+1]==0||p[posx-1][posy+1]==0) {
										//puede mover
										f.get(i).setMover(true);
									}
								}
							}
							
						}else {
							if(posx==0) {
									if(posy>0) {
										if(p[posx+1][posy+1]==0||p[posx+1][posy-1]==0) {
											//puede mover
											f.get(i).setMover(true);
										}
									}
							}else { //solo puede ser posx=7
								if(posy<7) {
									if(p[posx-1][posy+1]==0||p[posx-1][posy-1]==0) {
										//puede mover
										f.get(i).setMover(true);
									}
								}
							}
								
						}
					}

				}	
			}
						
		}
		
		//comer negras
		for(int i=0;i<f.size();i++) {
			posx=f.get(i).getX();
			posy=f.get(i).getY();
			
			if(posx>1&&posx<6&&posy>10&&posy<6) {// 3 4 5 6 
				if((p[posx-1][posy-1]==2&&p[posx-2][posy-2]==0)
				 ||(p[posx-1][posy+1]==2&&p[posx-2][posy+2]==0)
				 ||(p[posx+1][posy+1]==2&&p[posx+2][posy+2]==0)
				 ||(p[posx+1][posy-1]==2&&p[posx+2][posy-2]==0)) {
					//puede comer
				}
				
			}else {
				if(posx==0) {
					if(posy==6) {
						if(p[posx+1][posy-1]==2&&p[posx+2][posy-2]==0){
							//puede comer
						}
					}else {
						if(posy==0) {
							if(p[posx+1][posy+1]==2&&p[posx+2][posy+2]==0) {
								//puede comer
							}
						}else {
							if((p[posx+1][posy+1]==2&&p[posx+2][posy+2]==0)||(p[posx+1][posy-1]==2&&p[posx+2][posy-2]==0)){
								//puede comer
							}
						}
					}
				}else {
					if(posx==1) {
						if(posy==7) {
							if(p[posx+1][posy-1]==2&&p[posx+2][posy-2]==0){
								//puede comer
							}
						}else {
							if(posy==1) {
								if(p[posx+1][posy+1]==2&&p[posx+2][posy+2]==0) {
									//puede comer
								}
							}else {
								if((p[posx+1][posy+1]==2&&p[posx+2][posy+2]==0)||(p[posx+1][posy-1]==2&&p[posx+2][posy-2]==0)){
									//puede comer
								}
							}
						}
					}else {
						if(posx==7) {
							if(posy==7) {
								if(p[posx-1][posy-1]==2&&p[posx-2][posy-2]==0){
									//puede comer
								}
							}else {
								if(posy==1) {
									if(p[posx-1][posy+1]==2&&p[posx-2][posy+2]==0) {
										//puede comer
									}
								}else {
									if((p[posx-1][posy+1]==2&&p[posx-2][posy+2]==0)||(p[posx-1][posy-1]==2&&p[posx-2][posy-2]==0)){
										//puede comer
									}
								}
							}
						}else {
							if(posx==6) {
								if(posy==0) {
									if(p[posx-1][posy+1]==2&&p[posx-2][posy+2]==0) {
										//puede comer
									}
								}else {
									if(posy==6) {
										if(p[posx-1][posy-1]==2&&p[posx-2][posy-2]==0){
											//puede comer
										}
									}else {
										if((p[posx-1][posy+1]==2&&p[posx-2][posy+2]==0)||(p[posx-1][posy-1]==2&&p[posx-2][posy-2]==0)){
											//puede comer
										}
									}
								}
							}else {
								if(posy==0||posy==1) {
									if((p[posx-1][posy+1]==2&&p[posx-2][posy+2]==0)||(p[posx+1][posy+1]==2&&p[posx+2][posy+2]==0)) {
										//puede comer
									}
								}else {
									if(posy==6||posy==7) {
										if((p[posx-1][posy-1]==2&&p[posx-2][posy-2]==0)||(p[posx+1][posy-1]==2&&p[posx+2][posy-2]==0)) {
											//puede comer
										}
									}
								}
							}
						}	
					}
				}
			}	
		}
		
		//comer blancas
		for(int i=0;i<f.size();i++) {
				posx=f.get(i).getX();
				posy=f.get(i).getY();
				
				if(posx>1&&posx<6&&posy>10&&posy<6) {// 3 4 5 6 
					if((p[posx-1][posy-1]==1&&p[posx-2][posy-2]==0)
					 ||(p[posx-1][posy+1]==1&&p[posx-2][posy+2]==0)
					 ||(p[posx+1][posy+1]==1&&p[posx+2][posy+2]==0)
					 ||(p[posx+1][posy-1]==1&&p[posx+2][posy-2]==0)) {
						//puede comer
					}
					
				}else {
					if(posx==0) {
						if(posy==6) {
							if(p[posx+1][posy-1]==1&&p[posx+2][posy-2]==0){
								//puede comer
							}
						}else {
							if(posy==0) {
								if(p[posx+1][posy+1]==1&&p[posx+2][posy+2]==0) {
									//puede comer
								}
							}else {
								if((p[posx+1][posy+1]==1&&p[posx+2][posy+2]==0)||(p[posx+1][posy-1]==1&&p[posx+2][posy-2]==0)){
									//puede comer
								}
							}
						}
					}else {
						if(posx==1) {
							if(posy==7) {
								if(p[posx+1][posy-1]==1&&p[posx+2][posy-2]==0){
									//puede comer
								}
							}else {
								if(posy==1) {
									if(p[posx+1][posy+1]==1&&p[posx+2][posy+2]==0) {
										//puede comer
									}
								}else {
									if((p[posx+1][posy+1]==1&&p[posx+2][posy+2]==0)||(p[posx+1][posy-1]==1&&p[posx+2][posy-2]==0)){
										//puede comer
									}
								}
							}
						}else {
							if(posx==7) {
								if(posy==7) {
									if(p[posx-1][posy-1]==1&&p[posx-2][posy-2]==0){
										//puede comer
									}
								}else {
									if(posy==1) {
										if(p[posx-1][posy+1]==1&&p[posx-2][posy+2]==0) {
											//puede comer
										}
									}else {
										if((p[posx-1][posy+1]==1&&p[posx-2][posy+2]==0)||(p[posx-1][posy-1]==1&&p[posx-2][posy-2]==0)){
											//puede comer
										}
									}
								}
							}else {
								if(posx==6) {
									if(posy==0) {
										if(p[posx-1][posy+1]==1&&p[posx-2][posy+2]==0) {
											//puede comer
										}
									}else {
										if(posy==6) {
											if(p[posx-1][posy-1]==1&&p[posx-2][posy-2]==0){
												//puede comer
											}
										}else {
											if((p[posx-1][posy+1]==1&&p[posx-2][posy+2]==0)||(p[posx-1][posy-1]==1&&p[posx-2][posy-2]==0)){
												//puede comer
											}
										}
									}
								}else {
									if(posy==0||posy==1) {
										if((p[posx-1][posy+1]==1&&p[posx-2][posy+2]==0)||(p[posx+1][posy+1]==1&&p[posx+2][posy+2]==0)) {
											//puede comer
										}
									}else {
										if(posy==6||posy==7) {
											if((p[posx-1][posy-1]==1&&p[posx-2][posy-2]==0)||(p[posx+1][posy-1]==1&&p[posx+2][posy-2]==0)) {
												//puede comer
											}
									}
								}
							}	
						}
					}
				}	
			}
		}
	}
	*/
	
}
