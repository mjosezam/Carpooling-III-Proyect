package Graph;

import Estructuras.ListaSimple;
import Estructuras.Nodo;

import java.util.List;


public class DiGraphTest {
    public static void main(String[] args) {

        DiGraph graph = new DiGraph();
        graph = graph.crearGrafo();

        List<String> path = graph.getPath("el_tejar", "TEC");
        ListaSimple lista = new ListaSimple();
        for (String each : path) {
            lista.add(each);
        }
        for (Nodo<String> s = lista.getPrimero(); s!=null;s = s.getSiguiente()){
            System.out.println(s.getValor());

        }
    }
}
