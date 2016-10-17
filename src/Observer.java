
import View.Aplicativo;
import models.Aluno;
import models.Secretaria;

public class Observer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		/*poderia receber a nova edicao atraves de um recurso externo
		double valor = 100.00;
		Secretaria secretaria = new Secretaria();		
		Aluno aluno = new Aluno(secretaria, "Hector", "hect.8@hotmail.com");
		
		secretaria.informar("Texto");*/
                Aplicativo aplicativo = new Aplicativo();
                aplicativo.janelaPrincipal();
	}
    
}
