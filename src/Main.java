import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        BufferedImage original = ImageIO.read(new File("color_stripes.png"));
        BufferedImage img = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
        Graphics g = img.getGraphics();
        g.drawImage(original, 0, 0, null);
        g.dispose();

        JFrame frame = new JFrame("Flood Fill - Fila");
        JLabel label = new JLabel(new ImageIcon(img));
        frame.getContentPane().add(label);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        FloodFill flood = new FloodFill(img, 0xFFFF0000, label);

        while(true) {
            System.out.println("Escolha o algoritmo (pilha/fila) ou 'sair' para encerrar:");
            String escolha = sc.nextLine().trim().toLowerCase();
            if(escolha.equals("sair")) break;

            flood.resetarImagem(original);

            if(escolha.equals("pilha")) {
                flood.preencherComPilha(50, 50);
            } else if(escolha.equals("fila")) {
                flood.preencherComFila(50, 50);
            } else {
                System.out.println("Opção inválida!");
            }
        }

        System.out.println("Programa encerrado.");
        sc.close();
        System.exit(0);
    }
}