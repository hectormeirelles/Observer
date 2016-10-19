# Trabalho de Engenharia de Software II
# Observer
O Observer é um padrão de projeto de software que define uma dependência um-para-muitos entre objetos de modo que quando um objeto muda o estado, todos seus dependentes são notificados e atualizados automaticamente. Permite que objetos interessados sejam avisados da mudança de estado ou outros eventos ocorrendo num outro objeto. O padrão Observer é também chamado de Publisher-Subscriber, Event Generator e Dependents.

###Links
  - Diagrama de classes
![diagrama](https://cloud.githubusercontent.com/assets/22509030/19501819/395104a8-9587-11e6-89d5-54ec0a9b7ccc.png)

- Diagrama de classes (Padrão do Observer)
  ![padraoobserver_java1 jpg](https://cloud.githubusercontent.com/assets/22509030/19502919/c26e3a6a-958e-11e6-8f33-9777c2b6375b.png)

- Exemplo de código

```java
import java.util.Observable;
import java.util.Observer;

public class RevistaInformatica extends Observable {

	private int edicao;

	public void setNovaEdicao(int novaEdicao) {
		this.edicao = novaEdicao;
		
		setChanged();
		notifyObservers();
	}
	
	public int getEdicao() {
		return this.edicao;
	}
	
	public static void main(String[] args) {
		//poderia receber a nova edicao atraves de um recurso externo
		int novaEdicao = 3;
		RevistaInformatica revistaInformatica = new RevistaInformatica();		
		Assinante1 assinante1 = new Assinante1(revistaInformatica);
		
		revistaInformatica.setNovaEdicao(novaEdicao);
	}

}

class Assinante1 implements Observer {
	
	Observable revistaInformatica;
	
	int edicaoNovaRevista;
	
	public Assinante1(Observable revistaInformatica) {
		this.revistaInformatica = revistaInformatica;
		revistaInformatica.addObserver(this);
	}
	
	@Override
	public void update(Observable revistaInfSubject, Object arg1) {
		if (revistaInfSubject instanceof RevistaInformatica) {
			RevistaInformatica revistaInformatica = (RevistaInformatica) revistaInfSubject;
			edicaoNovaRevista = revistaInformatica.getEdicao();
			System.out.println("Atenção, já chegou a mais uma edição da Revista Informatica. " +
					"Esta é a sua edição número: " + edicaoNovaRevista);
		}
	}	
}
``` 
