import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.File;


public class FloodFila {
    private BufferedImage imagem;
    private int largura, altura;

    public FloodFila(BufferedImage img) {
        this.imagem = img;
        this.largura = img.getWidth();
        this.altura = img.getHeight();
    }

    public void preencher(int x, int y, Color novaCor) throws Exception {
        int corAlvo = imagem.getRGB(x, y);
        if (corAlvo == novaCor.getRGB()) return;

        Fila fila = new Fila(largura * altura);
        fila.enqueue(x, y);

        //Verifica se nao esta vazio
        while (!fila.isEmpty()) {
            int[] p = fila.dequeue();
            int px = p[0], py = p[1];

            if (dentro(px, py) && imagem.getRGB(px, py) == corAlvo) {
                imagem.setRGB(px, py, novaCor.getRGB());

                fila.enqueue(px + 1, py);
                fila.enqueue(px - 1, py);
                fila.enqueue(px, py + 1);
                fila.enqueue(px, py - 1);
            }
        }

        ImageIO.write(imagem, "png", new File("resultado_fila.png"));
    }

    //Verifica se nao exede os limites da imagem
    private boolean dentro(int x, int y) {
        return x >= 0 && x < largura && y >= 0 && y < altura;
    }
}
