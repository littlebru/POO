package br.com.fatec.app;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class ClienteSocket extends JFrame implements ActionListener {
    // parte que controla a recepção de mensagens do cliente
    private Socket conexao;
    
    Socket socket ;
    
	JTextArea areaTexto;
	
	JTextField msg;
	  
    JButton btnEnviar;
    JButton btnSair;
	    
	JLabel rotulo;
	
	PrintStream saida;
	
	BufferedReader entrada;
	
    @SuppressWarnings("deprecation")
	public ClienteSocket() {
    	super("CRIPTOCHAT");	//Titulo da pagina
	   	 
	    Container tela = getContentPane();
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    BorderLayout layout = new BorderLayout();
	    tela.setLayout(layout);
	    
	    rotulo = new JLabel("");
	    
	    btnEnviar = new JButton("Enviar");
	    btnEnviar.addActionListener(this);
	    

	    btnSair = new JButton("Sair");
	    btnSair.addActionListener(this);
	    
	    msg = new JTextField(20);
	    
	    areaTexto = new JTextArea(15, 30);
	    JScrollPane painelRolagem = new JScrollPane(areaTexto);
	    painelRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    painelRolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    
	    JPanel pSuperior = new JPanel();
	    pSuperior.setLayout(new FlowLayout(FlowLayout.LEFT));
	    pSuperior.add(rotulo);
	    
	    JPanel pCentro = new JPanel();
	    pCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
	    pCentro.add(painelRolagem);
	    
	    JPanel pInferior = new JPanel();
	    pInferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    pInferior.add(msg);
	    pInferior.add(btnEnviar);
	    pInferior.add(btnSair);
	    
	    tela.add(BorderLayout.NORTH, pSuperior);
	    tela.add(BorderLayout.CENTER, pCentro);
	    tela.add(BorderLayout.SOUTH, pInferior);
	    
	    pack();
	    setVisible(true);  
	}

    void executa()
    {
        try {
        	socket = new Socket("127.0.0.1", 5555);
            //Instancia do atributo saida, obtem os objetos que permitem controlar o fluxo de comunicação
            saida = new PrintStream(socket.getOutputStream());
            String meuNome = JOptionPane.showInputDialog("Digite seu nome ");
            rotulo.setText("Bem Vindo(a) " + meuNome);
            //envia o nome digitado para o servidor
            saida.println(meuNome.toUpperCase());
            //instancia a thread para ip e porta conectados e depois inicia ela
            Recebedor r = new Recebedor(socket.getInputStream());  
            
            String[] opcoes = {"Sim, me ajuda", "Não, ja conheço o sistema"};
            
            int resposta = JOptionPane.showOptionDialog(null, "Olá "+meuNome+"!\nÉ a sua primeira vez aqui?\n\n\n", "OLÁ "+meuNome.toUpperCase()+"!",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
            if(resposta == 0) {
            	String[] texto = {"OK"};
            	
            	JOptionPane.showOptionDialog(null, "-[°u°]-\nBem vindo(a) ao CriptoChat "+meuNome+"!\n\nVou te passar algumas dicas para o uso do chat\n", "TUTORIAL", JOptionPane.INFORMATION_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, texto, texto[0]);
            	JOptionPane.showOptionDialog(null, "-[°u°]-\nPara mandar uma mensagem no privado informe desta maneira\n    SUA MENSAGEM : NOME DO CONTATO", "TUTORIAL", JOptionPane.INFORMATION_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, texto, texto[0]);
            	JOptionPane.showOptionDialog(null, "-[°u°]-\nPara sair do chat é só clicar no botão sair\n ou \nclicar no X da tela do chat", "TUTORIAL", JOptionPane.INFORMATION_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, texto, texto[0]);
            	JOptionPane.showOptionDialog(null, "-[°u°]-\nEssas foram as instruções\n\nEspero que tire bom proveito da plataforma "+meuNome+"\nAté a próxima!", "TUTORIAL", JOptionPane.INFORMATION_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, texto, texto[0]);
                
            }else {
            	JOptionPane.showMessageDialog(null, "-[°u°]-\nÉ muito bom poder te ver denovo por aqui "+ meuNome);
            }
            
            new Thread(r).start();  
        } catch (IOException e) {
            System.out.println("Falha na Conexao... .. ." + " IOException: " + e);
        }
    }
    
    public static void main(String[] args) {
		ClienteSocket cliente = new ClienteSocket();
        WindowListener ls = new WindowAdapter()  
        {  
                public void WindowsEvent(WindowEvent e)  
                {  
                        System.exit(0);  
                }  
        }; 
		cliente.addWindowListener(ls);
		cliente.executa();
	}
    
    // execução da thread
    public void run()
    {
        try {
            //recebe mensagens de outro cliente através do servidor
            BufferedReader entrada = new BufferedReader(new InputStreamReader(this.conexao.getInputStream()));
            //cria variavel de mensagem
            String msg;
            while (true)
            {
                // pega o que o servidor enviou
                msg = entrada.readLine();
                //se a mensagem contiver dados, passa pelo if, caso contrario cai no break e encerra a conexao
                if (msg == null) {
                    System.out.println("Conexão encerrada!");
                    System.exit(0);
                }
                areaTexto.append(msg + "\n");
            }
        } catch (IOException e) {
            // caso ocorra alguma exceção de E/S, mostra qual foi.
            System.out.println("Ocorreu uma Falha... .. ." + " IOException: " + e);
        }
    }
    
    class Recebedor implements Runnable {  
        
        private InputStream servidor;  
         
        public Recebedor(InputStream servidor) {  
        	this.servidor = servidor;  
        }

		@Override
		public void run() {
	        try {
	            //recebe mensagens de outro cliente através do servidor
	            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            //cria variavel de mensagem
	            String msg;
	            while (true)
	            {
	                // pega o que o servidor enviou
	                msg = entrada.readLine();
	                //se a mensagem contiver dados, passa pelo if, caso contrario cai no break e encerra a conexao
	                if (msg == null) {
	                    System.out.println("Conexão encerrada!");
	                    System.exit(0);
	                }
	                areaTexto.append(msg + "\n");
	            }
	        } catch (IOException e) {
	            // caso ocorra alguma exceção de E/S, mostra qual foi.
	            System.out.println("Ocorreu uma Falha... .. ." + " IOException: " + e);
	        }
		}  
    }

	@Override
	public void actionPerformed(ActionEvent event) {
		Object fonte = event.getSource();  
        
		CriptografiaCesar cript = new CriptografiaCesar();
		
        if (fonte == btnEnviar) //Envia informacao pelo socket  
        {  
                String text = msg.getText();
                text = cript.encriptar(text); //encriptar a mensagem enviada
                saida.println(text); 
                msg.setText(new String("")); //recebe do servidor  
        }  
        if(fonte == btnSair) {
        	String opcoes[] = {"SIM","NÃO"};
        	
        	int resposta  = JOptionPane.showOptionDialog(null, "-[°u°]-\nQuer mesmo sair do Chat?", "SAIR", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        	
        	if(resposta == 0) {
        		String[] texto = {"Até logo!"};
        		JOptionPane.showOptionDialog(null, "-[°u°]-\nAté a proxima então", "SAIR", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, texto, texto[0]);
        		System.exit(0);
        	}
        }
	}
}