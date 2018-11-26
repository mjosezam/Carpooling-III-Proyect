package Server;

import Estructuras.Nodo;
import Estructuras.Usuario;
import Estructuras.ListaSimple;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Path("registroDatos")
public class registroDatos {

    public static ListaSimple pasajeros;
    public static  ListaSimple<Usuario> conductores;

    public registroDatos() {
        this.pasajeros = null;
        this.conductores = null;
    }

    @POST
    @Path("conductor")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    /**
     * Agregar conductor en la lista de registrados
     */
    public void agregarConductor( Usuario conductor) {
        if (conductores == null || valiconductor(conductor.getCarnet())) {
            conductores.add(conductor);
        } else {
            //enviar error
        }
    }

    /**
     * valida si el conductor ha sido registrado
     * @param id carnet del conductor
     * @return boolean
     */
    public boolean valiconductor(String id) {
        Nodo actual = conductores.getPrimero();
        Usuario aux = (Usuario)actual.getValor();
        while (aux.getCarnet() != id) {
            if (actual.getValor() == null) {
                return true;
            }
            actual.getSiguiente();
            aux = (Usuario)actual.getValor();
        }
        return false;
    }

    @POST
    @Path("pasajero")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    /**
     * Agrega pasajero ha lista de registrados
     *
     */
    public void agregarPasajero( Usuario pasajero) {
        if (pasajeros == null || valipasajero(pasajero.getCarnet())) {
            pasajeros.add(pasajero);
        } else {
            //enviar error
        }
    }

    /**
     * Valida si el pasajero ya se ha registrado
     * @param id carnet del pasajero
     * @return boolean
     */
    public boolean valipasajero(String id) {
        Nodo actual = pasajeros.getPrimero();
        Usuario aux = (Usuario)actual.getValor();
        while (aux.getCarnet() != id) {
            if (actual.getValor() == null) {
                return true;
            }
            actual.getSiguiente();
            aux = (Usuario)actual.getValor();
        }
        return false;
    }

    @POST
    @Path("{carnetamigo}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    /**
     * busca y agrega el amigo a la lista
     * @return boolean si ha sido agregado
     */
    public boolean agregaramigo( Usuario usuario,@PathParam("carnetamigo") String carnetAmigo) {
        if(!valipasajero(carnetAmigo)){
            Nodo actual = pasajeros.getPrimero();
            Usuario aux = (Usuario)actual.getValor();
            while (aux.getCarnet() != carnetAmigo) {
                actual.getSiguiente();
                aux = (Usuario)actual.getValor();
            }
            usuario.getListaAmigos().add(aux);
            return true;
        }else if(!valiconductor(carnetAmigo)){
            Nodo actual = conductores.getPrimero();
            Usuario aux = (Usuario)actual.getValor();
            while (aux.getCarnet() != carnetAmigo) {
                actual.getSiguiente();
                aux = (Usuario)actual.getValor();
            }
            usuario.getListaAmigos().add(aux);
            return true;
        }else{
            return false;
        }
    }
}