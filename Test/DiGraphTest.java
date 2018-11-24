/*import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;


public class Graph.DiGraphTest {
    @Test

    public void test (){
        Graph.DiGraph grafo = new Graph.DiGraph();

        grafo.add("San Ramon", "Palmares", 6);
        grafo.add("San Ramon", "Sarchi", 8);
        grafo.add("Sarchi", "San Ramon", 9);
        grafo.add("Palmares", "Naranjo", 2);
        grafo.add("Naranjo", "San Ramon", 7);

        List<String> path = grafo.getPath("Sarchi", "Naranjo");


        String [] resultado = new String[3];
        String [] resultadoEsperado = new String[] {"San Ramon","Palmares","Sarchi"};
        int i = 0;
        for (String each : path){
            resultado[i] = each;
            System.out.println(path.size());
            i++;
        }
        assertArrayEquals(resultadoEsperado,resultado);
    }
    }

*/