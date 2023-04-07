import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void cria (InputStream urlEntry, String outputNameString) throws Exception {
       
        // InputStream inputStream = new FileInputStream("entrada/filme.jpg");

        //leitura de imagem

        BufferedImage imagemOriginal = ImageIO.read(urlEntry);

        //cria nova imagem em memoria com transparencia e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        //Copiar a imagem original para nova imagem (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        //escrever frase iconica na nova imagem
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // Configurar fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        FontMetrics metrics = graphics.getFontMetrics(fonte);

        graphics.setFont(fonte);
        graphics.setColor(Color.RED);

        //Escrever a imagem nova em um arquivo
        String writeText = "Teste";
        graphics.drawString(writeText, largura/2 - metrics.stringWidth(writeText)/2, novaAltura - 100);
     
        ImageIO.write(novaImagem, "png", new File("saida/"+ outputNameString +".png"));
    }
    

}
 