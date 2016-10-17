package models;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class Aluno implements java.util.Observer {
	
	private Observable secretaria;
        private String email;
        private String nome;
	
	public Aluno(Observable secretaria, String nome, String email) {
		this.secretaria = secretaria;
                this.nome = nome;
                this.email = email;
		secretaria.addObserver(this);
	}
	
	@Override
	public void update(Observable contaInfSubject, Object arg1) {
            if (contaInfSubject instanceof Secretaria) {
                try {
                    Secretaria secretaria = (Secretaria) contaInfSubject;
                    String novaMensagem = secretaria.getMensagem();
                    enviaEmail(novaMensagem);
                } catch (EmailException ex) {
                    Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
	}
        
        private void enviaEmail(String mensagem) throws EmailException {
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
                email.setSmtpPort(465);
		email.addTo(this.email, this.nome); //destinatário
		email.setFrom("hector.meirelles.8@gmail.com", "Secretaria Senac"); // remetente
		email.setSubject("Novidades no Senac"); // assunto do e-mail
		email.setMsg(mensagem); //conteudo do e-mail
		email.setAuthentication("hector.meirelles.8@gmail.com", "hgmlor888");
		email.setSSL(true);
		email.setTLS(true);
		email.send();
	}
}
