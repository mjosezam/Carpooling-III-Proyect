package Server;

import Estructuras.Nodo;
import Estructuras.Usuario;

import static Server.registroDatos.pasajeros;

public class acceder {

    public void valipasajero(String id) {
        Nodo actual = pasajeros.getPrimero();
        Usuario aux = (Usuario) actual;
        while (aux.getCarnet() != id) {
            if (actual.getValor() == null) {
                //retornar boolean a maria
            }
            actual.getSiguiente();
            aux = (Usuario)actual.getValor();
        }
        //return boolean a maria
    }
    public void valiconductor(String id) {
        Nodo actual = pasajeros.getPrimero();
        Usuario aux = (Usuario) actual;
        while (aux.getCarnet() != id) {
            if (actual.getValor() == null) {
                //retornar boolean a maria
            }
            actual.getSiguiente();
            aux = (Usuario)actual.getValor();
        }
        //return boolean a maria
    }
}
