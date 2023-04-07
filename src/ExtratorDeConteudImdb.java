import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudImdb implements ExtratorDeConteudo {
    
    public List<Conteudo> extraiConteudos(String json) {
        var parser = new JsonParser();
        List<Map<String, String>> listaAtributos = parser.parse(json);

        List<Conteudo> conteudos  = new ArrayList<>() ;

        for (Map<String, String> atributos : listaAtributos ) {
            
            String title = atributos.get("title").replace(":", " ");
            String urlImage = atributos.get("image");

            Conteudo conteudo = new Conteudo(title, urlImage);

            conteudos.add(conteudo);

        }
        return conteudos;
    
    }
}
