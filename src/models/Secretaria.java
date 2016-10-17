package models;

import java.util.Observable;


public class Secretaria extends Observable {
    
	private String mensagem;

        public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
		setChanged();
		notifyObservers();
	}
	
	public String getMensagem() {
		return this.mensagem;
	}
	
	

}

