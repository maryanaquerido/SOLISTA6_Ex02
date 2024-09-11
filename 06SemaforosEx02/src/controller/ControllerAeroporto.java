package controller;
import java.util.concurrent.*;
import java.util.Random;

public class ControllerAeroporto extends Thread {
	
	Semaphore semaforoDecolagem = new Semaphore (1);
	Semaphore semaforoAreaDec = new Semaphore (2);
	Random random = new Random();
	private int tidAviao;
	private int quantidade = 0;
	
	public ControllerAeroporto (Semaphore semaforoDecolagem, int tidAviao) {
		this.semaforoDecolagem = semaforoDecolagem;
		this.tidAviao = tidAviao;
	}
	
	public void run () {
		Calc ();
	}
	
	public void Calc () {
		int pista = (random.nextInt(2)+1);
		while (quantidade <= 2) {
			AreaDecolagem ();
			try {
				semaforoAreaDec.acquire();
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
			semaforoDecolagem.release();
		}
	}
	
	public void AreaDecolagem () {
		quantidade ++;
		Decolagem(600, 800);
		try {
			semaforoDecolagem.acquire();
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		semaforoDecolagem.release();
		Manobrar(300,700);
		Taxiar(500, 1000);
		Afastamento(300, 800);
	}
	
	
	public void Manobrar (double tempInicial, double tempFinal) {
		
	}
	
	public void Taxiar (double tempInicial, double tempFinal) {
		
	}
	
	public void Decolagem (double tempInicial, double tempFinal)  {
		
		
	}
	
	public void Afastamento (double tempInicial, double tempFinal) {
		
	}
	

}
