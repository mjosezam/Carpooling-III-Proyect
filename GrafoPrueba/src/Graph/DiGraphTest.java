package Graph;

import Estructuras.ListaSimple;
import Estructuras.Nodo;

import java.util.List;


public class DiGraphTest {
    public static void main(String[] args) {

        DiGraph graph = new DiGraph();
        graph = graph.crearGrafo();

        //button + findViewbyId(R.d.);
        List<String> path = graph.getPath("el_tejar", "TEC");
        ListaSimple lista = new ListaSimple();
        String valor = null;
        for (String each : path) {
            String palabra = each;
            String[] parts = palabra.split(",");
            String part1 = parts[0];
            String part2 = parts[1];
            valor = part2;
            lista.add(part1);
        }
        lista.add(valor);
        for (Nodo<String> s = lista.getPrimero(); s!=null;s = s.getSiguiente()){
            System.out.println(s.getValor());

        }
    }
}
