import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.net.http.HttpResponse.BodyHandlers;

public class App {
    public static void main(String[] args) throws Exception {

        String url = "https://imdb-top-100-movies.p.rapidapi.com/";
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest
        .newBuilder(URI.create(url))    
		.header("X-RapidAPI-Key", "6ea98a8221mshe5762898272903cp14a0f2jsna7424c3fafa6")
		.header("X-RapidAPI-Host", "imdb-top-100-movies.p.rapidapi.com")
        .GET()
        .build();

        HttpResponse<String> resposta = cliente.send(requisicao, BodyHandlers.ofString());
        
        System.out.println(resposta.body() );                 


    }
}
