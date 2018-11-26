package Server;

import Estructuras.Nodo;
import Estructuras.Usuario;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static Server.registroDatos.pasajeros;

@Path("/acceder")
@Produces(MediaType.APPLICATION_JSON)
public class acceder {

    @GET
    @Path("/pasajero/{pasajeroid}")
    /**
     * verifica si el pasajero ha sido registrado
     * @return boolean si fue encontrado
     */
    public boolean valipasajero(@PathParam("pasajeroid")String id) {
        Nodo actual = pasajeros.getPrimero();
        Usuario aux = (Usuario) actual;
        while (aux.getCarnet() != id) {
            if (actual.getValor() == null) {
                return  true;
            }
            actual.getSiguiente();
            aux = (Usuario)actual.getValor();
        }
        return false;
    }

    @GET
    @Path("/conductor/{conductorid}")
    /**
     * verifica si el conductor ha sido registrado
     * @return boolean si fue encontrado
     */
    public boolean valiconductor(@PathParam("conductorid")String id) {
        Nodo actual = pasajeros.getPrimero();
        Usuario aux = (Usuario) actual;
        while (aux.getCarnet() != id) {
            if (actual.getValor() == null) {
                return  false;
            }
            actual.getSiguiente();
            aux = (Usuario)actual.getValor();
        }
        return true;
    }
}
