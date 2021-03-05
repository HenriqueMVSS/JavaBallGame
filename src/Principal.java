import javax.swing.JFrame;
import java.awt.Dimension;

public class Principal {
	public static final int LARGURA_TELA=640;
	public static final int ALTURA_TELA=480;
	
	public Principal() {
		JFrame janela = new JFrame("Jogo2D"); // representa a janela do jogo
		Game game = new Game(); // representa a tela de desenho do jogo
		game.setPreferredSize( new Dimension(LARGURA_TELA, ALTURA_TELA) ); //define o tamanho da tela desenho
		janela.getContentPane().add(game); // adiciono a tela dentro da janela
		janela.setResizable(false); // impedir o redimensionamento da janela
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// fechar a aplicao ao clicar no x
		janela.setLocation(100, 100); // define a posicãoo da janela na tela do computador
		janela.setVisible(true); // faz com que a janela seja exibida
		janela.pack();
	}
	
	public static void main(String[] args) {
		new Principal();
	}
	
}