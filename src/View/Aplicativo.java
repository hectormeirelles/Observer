package View;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import models.Aluno;
import models.Secretaria;

public class Aplicativo {
    JFrame janela;
    JPanel painelPrincipal;
    JPanel painelAluno;
    JPanel painelMensagem;
    JLabel texto;
    JLabel texto2;
    JLabel texto3;
    JTextArea editArea;
    JButton menu;
    JButton menu2;
    JButton sair;
    JButton voltar;
    JFormattedTextField editTexto;
    JFormattedTextField editTexto2;
    int i = 0;
    Aluno[] aluno = new Aluno[50];
    Secretaria secretaria = new Secretaria();
    
    
    public void montaPainelMensagem() {
        preparaPainelMensagem();
        preparaMenuMensagem();
        mostraPainelMensagem();
    }

    private void preparaPainelMensagem() {
            painelMensagem = new JPanel();
            painelMensagem.setLayout(null);
            janela.add(painelMensagem);
        }

    private void preparaMenuMensagem(){
        texto = new JLabel("Digite a mensagem:", SwingConstants.CENTER); 
        texto.setBounds(0, 0, 500, 50); 
        texto2 = new JLabel("Mensagem:", SwingConstants.RIGHT);
        texto2.setBounds(0, 80, 100, 20);
        editArea = new JTextArea();
        editArea.setBounds(110, 80, 220, 300);
        menu = new JButton ("Enviar");
        menu.setBounds(350, 80, 100, 50); 
        sair = new JButton("Sair");
        sair.setBounds(400, 420, 70, 30);
        voltar = new JButton("Voltar");
        voltar.setBounds(320, 420, 70, 30);
        painelMensagem.add(texto2);
        painelMensagem.add(editArea);
        painelMensagem.add(texto);
        painelMensagem.add(menu);
        painelMensagem.add(sair);
        painelMensagem.add(voltar);
        menu.addActionListener((ActionEvent e) -> {
            secretaria.setMensagem(editArea.getText());
            i++;
            editArea.setText(null);
            JOptionPane.showMessageDialog(null, "Mensagem enviada com sucesso!");
                            
        });
        sair.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        voltar.addActionListener((ActionEvent e) -> {
            painelMensagem.setVisible(false);
            montaPainelPrincipal();
        });
    }

    private void mostraPainelMensagem() {
        painelMensagem.setVisible(true);
    }
    
    public void montaPainelAluno() {
        preparaPainelAluno();
        preparaMenuAluno();
        mostraPainelAluno();
    }
    
    private void preparaPainelAluno() {
            painelAluno = new JPanel();
            painelAluno.setLayout(null);
            janela.add(painelAluno);
        }

    private void preparaMenuAluno(){
        texto = new JLabel("Informe os dados do aluno:", SwingConstants.CENTER); 
        texto.setBounds(0, 0, 500, 50); 
        texto2 = new JLabel("Nome do aluno:", SwingConstants.RIGHT);
        texto2.setBounds(0, 80, 100, 20);
        editTexto = new JFormattedTextField();
        editTexto.setBounds(110, 80, 220, 20);
        texto3 = new JLabel("E-mail do aluno:", SwingConstants.RIGHT);
        texto3.setBounds(0, 100, 100, 20);
        editTexto2 = new JFormattedTextField();
        editTexto2.setBounds(110, 100, 220, 20);
        menu = new JButton ("Adicionar");
        menu.setBounds(350, 70, 100, 50); 
        sair = new JButton("Sair");
        sair.setBounds(400, 420, 70, 30);
        voltar = new JButton("Voltar");
        voltar.setBounds(320, 420, 70, 30);
        painelAluno.add(texto);
        painelAluno.add(menu);
        painelAluno.add(texto2);
        painelAluno.add(editTexto);
        painelAluno.add(texto3);
        painelAluno.add(editTexto2);
        painelAluno.add(sair);
        painelAluno.add(voltar);
        menu.addActionListener((ActionEvent e) -> {
            aluno[i] = new Aluno(secretaria, editTexto.getText(), editTexto2.getText());
            editTexto.setText(null);
            editTexto2.setText(null);
            JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso!");
        });
        sair.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        voltar.addActionListener((ActionEvent e) -> {
            painelAluno.setVisible(false);
            montaPainelPrincipal();
        });
    }
    
    private void mostraPainelAluno() {
        painelAluno.setVisible(true);
    }
    
    public void montaJanelaPrincipal(){
        janela = new JFrame();
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        montaPainelPrincipal();
    }
    
    public void montaPainelPrincipal() {
        preparaPainelPrincipal();
        preparaMenuPrincipal();
        mostraJanelaPrincipal();
    }
    
    private void preparaPainelPrincipal() {
        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(null);
        janela.add(painelPrincipal);
        janela.setTitle("Sistema de avisos");
    }

    
    private void preparaMenuPrincipal(){
        texto = new JLabel("Escolha um das opções abaixo:", SwingConstants.CENTER); 
        texto.setBounds(0, 0, 500, 50);
        menu = new JButton ("Adicionar aluno");
        menu.setBounds(150, 50, 200, 50); 
        menu2 = new JButton("Enviar mensagem");
        menu2.setBounds(150, 110, 200, 50); 
        sair = new JButton("Sair");
        sair.setBounds(400, 420, 70, 30);
        painelPrincipal.add(texto);
        painelPrincipal.add(menu);
        painelPrincipal.add(menu2);
        painelPrincipal.add(sair);
        menu.addActionListener((ActionEvent e) -> {
            painelPrincipal.setVisible(false);
            montaPainelAluno();
        });
        menu2.addActionListener((ActionEvent e) -> {
            painelPrincipal.setVisible(false);
            montaPainelMensagem();
        });
        sair.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }
    
    private void mostraJanelaPrincipal() {
        janela.setSize(500, 500);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }
    
    public void janelaPrincipal(){
        montaJanelaPrincipal();
    }
    
}