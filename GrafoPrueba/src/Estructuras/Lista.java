package Estructuras;

public interface Lista<T> {

	void add(T valor);

	void delete(T valor);

	Nodo<T> getPrimero();

	Nodo<T> getUltimo();

}