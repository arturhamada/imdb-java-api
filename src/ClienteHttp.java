import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;



public class ClienteHttp {

    /**
    * @url Adicione a url a ser solicitada
    * @return Retorna o body da url solicitada
    */
    public String buscaDados(String url) {
        
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        try {
        URI adress = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder(adress)    
                .GET()
                .build();

        HttpResponse<String>  response = client.send(request, BodyHandlers.ofString());
        return response.body();

        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        } 

    }
}
