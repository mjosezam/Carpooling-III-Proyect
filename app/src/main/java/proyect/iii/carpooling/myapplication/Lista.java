package proyect.iii.carpooling.myapplication;

public interface Lista<T> {

    void add(T valor);

    void delete(T valor);

    Nodo<T> getPrimero();

    Nodo<T> getUltimo();

    int getSize();

    Nodo<T> getNodo(int index);
}
