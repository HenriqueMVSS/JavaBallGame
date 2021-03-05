import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Bola {
	// atributos --------------------------------------------------------	
	public BufferedImage parada;
	public BufferedImage direita_baixo;
	public BufferedImage direita_cima;
	public BufferedImage esquerda_baixo;
	public BufferedImage esquerda_cima;
	public int posX;
	public int posY;
	public int velX;
	public int velY;
	public int raio;
	
	// construtor ------------------------------------------------------
	public Bola() {
		try {
			parada = ImageIO.read(getClass().getResource("imgs/parada.gif"));
			direita_baixo = ImageIO.read(getClass().getResource("imgs/direita_baixo.gif"));
			direita_cima = ImageIO.read(getClass().getResource("imgs/direita_cima.gif"));
			esquerda_baixo = ImageIO.read(getClass().getResource("imgs/esquerda_baixo.gif"));
			esquerda_cima = ImageIO.read(getClass().getResource("imgs/esquerda_cima.gif"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		posX= 200;
		posY = 200;
		velX = 3;
		velY = 3;
		raio=50;
	}
	
	public BufferedImage obterImagem() {
		if(velX < 0) {
			if(velY < 0) {
				return esquerda_cima;
			}else {
				return esquerda_baixo;
			}
		}else {
			if(velY < 0) {
				    return direita_cima;
				}else {
					return direita_baixo;
				}
		}
	}
}
