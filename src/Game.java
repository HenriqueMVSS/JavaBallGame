import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Game extends JPanel{
	// atributos --------------------------------------------------------
	ArrayList<Bola>listaBolas;
	Random random = new Random();
	// construtor ------------------------------------------------------
	public Game() {
		listaBolas = new ArrayList<Bola>();
		
		for (int i = 0; i < 10; i++) {
			Bola novaBola = new Bola();
			//define a posição aleatoria						
			novaBola.posX = random.nextInt(Principal.LARGURA_TELA -(novaBola.raio*2));
			novaBola.posY = random.nextInt(Principal.ALTURA_TELA -(novaBola.raio*2));
			
			//define a velocidade aleatoria
			
			int num = random.nextInt();
			if(num % 2 ==0) 
				novaBola.velX =3;
			 else 
				novaBola.velX =-3;
			num = random.nextInt();
			if(num % 2 == 0) 
				novaBola.velY =3;
			 else 
				novaBola.velY =-3;
								
			listaBolas.add(novaBola);
		}
		
		new Thread( new Runnable() {
			@Override
			public void run() {
				gameloop();
			}
		} ).start();
		
		setLayout(null); // não utilizaremos layouts
		setFocusable(true); // tem a capacidade de escutar os eventos (pressionamento de teclas, cliques, etc...)
	}
	// metodos gameloop --------------------------------------------------------
	public void gameloop() {
		while(true) { // loop infinito
			handlerEvents();
			update();
			render();
			try {
				Thread.sleep(17); // 60 fps
			} catch (InterruptedException e) {}

		}
	}
	
	public void handlerEvents() { // 1ª função basica
		
	}
	public void update() { // 2ª função basica
		for (int i = 0; i < 10; i++) {
		Bola bola = listaBolas.get(i);	
		bola.posX += bola.velX; // altera a posição horizontal
		bola.posY += bola.velY; // altera a posição vertical
		testeColisoes();
		}
	}
	public void render() { // 3ª função basica
		repaint();
	}
	
	// métodos --------------------------------------------------------
	
	public void testeColisoes() {
		
		for (int i = 0; i < 10; i++) {
		Bola bola = listaBolas.get(i);	
		
		// testa colisão com a parte inferior e superior
		if(bola.posY+(bola.raio*2) >= Principal.ALTURA_TELA || bola.posY <= 0 ) {
			bola.velY *= -1; //inversão de velocidade vertical
		}
		
		// testa colisão com a parte direita e esquerda
		if(bola.posX+(bola.raio*2) >= Principal.LARGURA_TELA || bola.posX <= 0) {
			bola.velX *= -1;  //inversão de velocidade horizontal
		}
		}
					
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // invocar a versão original
		setBackground(Color.WHITE);
//		g.setColor(new Color(150,250,50));//altera cor da bola
//		g.fillOval(bola.posX,bola.posY,bola.raio*2,bola.raio*2);
		for (int i = 0; i < 10; i++) {
			Bola bola = listaBolas.get(i);
			g.drawImage(bola.obterImagem(), bola.posX, bola.posY, null);

		}
		
	}
}
