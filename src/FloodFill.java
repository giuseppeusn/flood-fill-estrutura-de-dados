import javax.swing.*;
import java.awt.image.BufferedImage;

class FloodFill {
    private BufferedImage img;
    private int novaCor;
    private int corFundo;
    private JLabel label;

    public FloodFill(BufferedImage img, int novaCor, JLabel label) {
        this.img = img;
        this.novaCor = novaCor;
        this.label = label;
    }

    private boolean valido(int x, int y) {
        return x >= 0 && x < img.getWidth() &&
                y >= 0 && y < img.getHeight() &&
                img.getRGB(x, y) == corFundo;
    }

    public void preencherComPilha(int xi, int yi) throws InterruptedException {
        corFundo = img.getRGB(xi, yi);
        if(corFundo==novaCor) return;

        Pilha pilha = new Pilha(img.getWidth()*img.getHeight());
        pilha.empilhar(new Pixel(xi, yi));

        while(!pilha.estaVazia()) {
            Pixel p = pilha.desempilhar();
            if(valido(p.x,p.y)) {
                img.setRGB(p.x,p.y,novaCor);
                atualizarLabel();
                Thread.sleep(5);

                pilha.empilhar(new Pixel(p.x+1,p.y));
                pilha.empilhar(new Pixel(p.x-1,p.y));
                pilha.empilhar(new Pixel(p.x,p.y+1));
                pilha.empilhar(new Pixel(p.x,p.y-1));
            }
        }
    }

    public void preencherComFila(int xi, int yi) throws InterruptedException {
        corFundo = img.getRGB(xi, yi);
        if(corFundo==novaCor) return;

        Fila fila = new Fila(img.getWidth()*img.getHeight());
        fila.enfileirar(new Pixel(xi, yi));

        while(!fila.estaVazia()) {
            Pixel p = fila.desenfileirar();
            if(valido(p.x,p.y)) {
                img.setRGB(p.x,p.y,novaCor);
                atualizarLabel();
                Thread.sleep(5);

                fila.enfileirar(new Pixel(p.x+1,p.y));
                fila.enfileirar(new Pixel(p.x-1,p.y));
                fila.enfileirar(new Pixel(p.x,p.y+1));
                fila.enfileirar(new Pixel(p.x,p.y-1));
            }
        }
    }

    private void atualizarLabel() {
        label.setIcon(new ImageIcon(img));
        label.repaint();
    }

    public void resetarImagem(BufferedImage novaImg) {
        for(int i=0;i<img.getWidth();i++)
            for(int j=0;j<img.getHeight();j++)
                img.setRGB(i,j,novaImg.getRGB(i,j));
    }
}