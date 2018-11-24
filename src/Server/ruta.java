package Server;
import Estructuras.ListaSimple;
import Graph.*;
import java.util.List;

public class ruta {

    public ListaSimple<String> ruta(DiGraph grafo, String desde){
        ListaSimple<String> camino = null;
        List<String> path;
        path =   grafo.getPath(desde ,"TEC");
        for (String each : path){
            camino.add(each);
        }
        return camino;
    }
   /* public solicitargrafo(){

    }*/
}
