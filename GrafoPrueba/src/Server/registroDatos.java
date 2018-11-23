package Server;

import Estructuras.Nodo;
import Estructuras.Usuario;
import Estructuras.ListaSimple;

public class registroDatos {

    public static ListaSimple pasajeros;
    public static  ListaSimple<Usuario> conductores;

    public registroDatos() {
        this.pasajeros = null;
        this.conductores = null;
    }

    public void agregarConductor(Usuario conductor) {
        if (conductores == null || valiconductor(conductor.getCarnet())) {
            conductores.add(conductor);
        } else {
            //enviar error
        }
    }

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

    public void agregarPasajero(Usuario pasajero) {
        if (pasajeros == null || valipasajero(pasajero.getCarnet())) {
            pasajeros.add(pasajero);
        } else {
            //enviar error
        }
    }

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

    public boolean agregaramigo(Usuario usuario, String carnetAmigo) {
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