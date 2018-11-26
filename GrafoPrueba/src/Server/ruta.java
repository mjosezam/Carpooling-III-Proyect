package Server;
import Estructuras.ListaSimple;
import Estructuras.Nodo;
import Estructuras.Usuario;
import Graph.*;
import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static Server.registroDatos.pasajeros;

@Path("ruta")
@Produces(MediaType.APPLICATION_JSON)
public class ruta {

    @GET
    @Path("{desde}")
    /**
     * busca la ruta mas corta
     * @return camino encontrado
     */
    public ListaSimple<String> ruta(DiGraph grafo, @PathParam("desde") String desde){
        ListaSimple<String> camino = null;
        List<String> path;
        path =   grafo.getPath(desde ,"TEC");
        for (String each : path){
            camino.add(each);
        }
        return camino;
    }
    @GET
    @Path("grafo")
    /**
     *un nuevo grafo
     * @return grafo con las rutas existentes
     */
    public DiGraph solicitargrafo(){
        DiGraph grafo = new DiGraph();
        grafo = grafo.crearGrafo();
        return grafo;
    }

    /**
     * Verifica los usuarios que se encuentran en la ruta del conductor, hasta que el carro este lleno.
     * @param ruta, ruta que recorre el conductor.
     * @return lista de los lugares donde tiene que parar por estudiantes.
     */
   public ListaSimple verificarRuta(List<String> ruta){
        ListaSimple listaLugaresPersonas = null;

        for(int i=0;i<3;i++){
            for (Usuario u = (Usuario)pasajeros.getPrimero();u!= null;((Nodo) u).getSiguiente()){
                if(u.getEstado() == true){
                    for (String lugar:ruta){
                        if (u.getLugarDondeVive() == lugar){
                            listaLugaresPersonas.add(u.getLugarDondeVive());
                        }
                    }
                }
            }
       }
       return listaLugaresPersonas;
   }
}
