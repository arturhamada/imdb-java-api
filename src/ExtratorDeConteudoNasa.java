import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoNasa implements ExtratorDeConteudo {
    public List<Conteudo> extraiConteudos(String json) {
        
        var parser = new JsonParser();
        List<Map<String, String>> listaAtributos = parser.parse(json);

        List<Conteudo> conteudos  = new ArrayList<>() ;

        for (Map<String, String> atributos : listaAtributos ) {
            String title = atributos.get("title");
            String urlImage = atributos.get("url");

            Conteudo conteudo = new Conteudo(title, urlImage);

            conteudos.add(conteudo);

        }
        return conteudos;
    }
}
