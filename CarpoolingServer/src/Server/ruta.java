package Server;
import Estructuras.ListaSimple;
import Graph.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/ruta")
@Produces(MediaType.APPLICATION_JSON)
public class ruta {

    @GET
    @Path("/{desde}")
    public ListaSimple<String> ruta(DiGraph grafo, @PathParam("desde") String desde){
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
