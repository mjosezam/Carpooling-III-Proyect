package proyect.iii.carpooling.myapplication;

public class ListaSimple<T> implements Lista<T> {

    public NodoSimple<T> primero;
    public int size;


    public void add(T valor) {
        NodoSimple<T> nuevo = new NodoSimple<T>(valor);
        if (empty() == true) {
            this.primero = nuevo;
        } else {
            NodoSimple<T> temp = this.primero;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevo);
        }
        this.size++;
    }

    public boolean empty() {
        return this.primero == null;
    }

    public void delete(T valor) {
        if (primero.getValor() == valor) {
            this.primero = primero.getSiguiente();
        } else {
            NodoSimple<T> temp = this.primero;
            if (temp.getSiguiente() != null) {
                while (temp.getSiguiente().getValor() != valor) {
                    temp = temp.getSiguiente();
                }
                if (temp.getSiguiente() != null) {
                    NodoSimple<T> siguiente = temp.getSiguiente().getSiguiente();
                    temp.setSiguiente(siguiente);
                }
            }
        }
        this.size--;
    }

    public  Nodo<T> getNodo(int index){
        Nodo<T> current=primero;
        if (index<size){
            for (int j=0; j<size; j++){
                if (index==j){
                    return current;
                }
                else{
                    current=current.getSiguiente();
                }
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Nodo<T> getPrimero() {
        return primero;
    }

    @Override
    public Nodo<T> getUltimo() {
        NodoSimple<T> temp = this.primero;
        while (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
        }
        return temp;
    }
}