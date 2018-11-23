import Estructuras.ListaSimple;
import org.junit.Test;

import static org.junit.Assert.*;

public class listaSimpleTest {
    @Test
    public void test(){

        ListaSimple test = new ListaSimple();
        test.add(4);
        test.add(5);
        test.add(10);

        assertEquals(4,test.getPrimero().getValor());
        assertEquals(5,test.getPrimero().getSiguiente().getValor());
        assertEquals(10,test.getUltimo().getValor());

        }
    }
