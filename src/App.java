import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    public static void main(String[] args) throws Exception {
            
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        //  String url = "https://api.nasa.gov/planetary/apod?api_key=FgDlOHdneCJYEpwMHFSDVuOE4YZfXoIJgBMjmxLc&start_date=2023-01-05&end_date=2023-01-08";
        //  ExtratorDeConteudo extrator = new ExtratorDeConteudoNasa();

        String url = "https://imdb-api/en/API/Top250Movies/k_xec8rrnx";
        ExtratorDeConteudo extrator = new ExtratorDeConteudImdb();
            	

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        

        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++) {
            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new  URL(conteudo.getUrlImage()).openStream();
            
            geradora.cria(inputStream, conteudo.getTitle());


 
            System.out.println("");
    }
}
}
