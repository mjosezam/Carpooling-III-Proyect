/* Generic Directed Weighted Graph with Dijkstra's Shortest Path Algorithm
 * by /u/Philboyd_Studge
 * for /r/javaexamples
 */

import java.util.List;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("unchecked")
/**
 * Creates a directed, weighted <tt>Graph</tt> for any Comparable type
 * <p> add Edge date with <code>add(T valueforVertexFrom, T valueForVertexTo, int cost)</code>
 * <p> use <code>getPath(T valueFrom, T valueTo)</code> to get the shortest path between
 * the two using Dijkstra's Algorithm
 * <p> If returned List has a size of 1 and a cost of Integer.Max_Value then no conected path
 * was found
 *
 * @author /u/Philboyd_Studge
 */
public class DiGraph<T extends Comparable<T>>
{
    public enum State { UNVISITED, VISITED, COMPLETE }

    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;

    /**
     * Constructor
     */
    public DiGraph()
    {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    /**
     * Crea un arco entre 2 valores con su costo
     * @param from Value for Vertex 1
     * @param to Value for Vertex 2
     * @param cost Cost or weight of edge
     */
    public void add(T from, T to, int cost)
    {
        Edge temp = findEdge(from, to);
        if (temp != null)
        {
            //No permite que se creen 2 arcos iguales entre los mismos nodos, en lugar actualiza el costo que tenia
            System.out.println("Edge " + from + "," + to + " already exists. Changing cost.");
            temp.cost = cost;
        }
        else
        {
            // Agrega el arco a la lista de arcos
            Edge e = new Edge(from, to, cost);
            edges.add(e);
        }
    }

    /**
     * Encuentra el vertice en el grafo de acuerdo a su valor
     * @param v valor
     * @return Vertice, vertice que se busca o null si no existe
     */
    private Vertex findVertex(T v)
    {
        for (Vertex each : vertices)//recorre los vertices
        {
            if (each.value.compareTo(v)==0) // si el valor de un vertice es el que se busca lo retorna
                return each;
        }
        return null; //si no lo encuentra devuelve null
    }

    /**
     * Busca un arco que una a dos vertices en especifico
     * @param v1 Vertice de origen
     * @param v2 Vertice al que se quiere llegar
     * @return Edge, arco que se busca o null si no existe
     */
    private Edge findEdge(Vertex v1, Vertex v2)
    {
        for (Edge each : edges)
        {
            if (each.from.equals(v1) && each.to.equals(v2)) //Si el arco tiene el punto de origen y el destino ingresados lo retorna
            {
                return each;
            }
        }
        return null;
    }

    /**
     * Encuentra un arco entre 2 valores
     * @param from Valor del origen
     * @param to Valor del destino
     * @return Edge, arco que coincida con los valores o null si no existe
     */
    private Edge findEdge(T from, T to)
    {
        for (Edge each : edges)
        {
            if (each.from.value.equals(from) && each.to.value.equals(to))
            {
                return each;
            }
        }
        return null;
    }

    /**
     * Pone los estados de todos los vertices como UNVISITED
     */
    private void clearStates()
    {
        for (Vertex each : vertices)
        {
            each.state = State.UNVISITED;
        }
    }

    /**
     * Verifica si Breath First o Depth First devolvieron un grafo conectado
     * @return true si esta conectado, false si no esta conectado
     */
    public boolean isConnected()
    {
        for (Vertex each : vertices)
        {
            if (each.state != State.COMPLETE)
                return false;
        }
        return true;
    }

    /**
     * Performs a recursive Depth First Search on the Realiza una busqueda Depth First a partir del primer vertice creado
     * @return true si esta conectado, false si no esta conectado
     */
    public boolean DepthFirstSearch()
    {
        if (vertices.isEmpty()){
            return false;
    }

        clearStates();
        //asigna el primer nodo creado como raiz

        Vertex root = vertices.get(0);
        if (root==null){
            return false;
        }

        //llama a la funcion de forma recursiva para seguir buscando en el grafo
        DepthFirstSearch(root);
        return isConnected();
    }

    /**
     * Aplica Depth First Search al nodo indicado
     * @param v vertice el cual se le va a aplicar la busqueda
     */
    private void DepthFirstSearch(Vertex v)
    {
        v.state = State.VISITED; //marca el nodo como visitado

        // busca en los hijos de forma recursiva
        for (Vertex each : v.outgoing)
        {
            if (each.state == State.UNVISITED)
            {
                DepthFirstSearch(each);
            }
        }
        v.state = State.COMPLETE; // Una vez que busco en los hijos pone el vertice como COMPLETE
    }

    /**
     * Realiza una busqueda Breadth First empezando en el primer vertice creado
     * @return true si esta conectado, false si no esta conectado
     */
    public boolean BreadthFirstSearch()
    {
        if (vertices.isEmpty()){
            return false;
        }
        clearStates(); // pone los estados de los vertices en UNVISITED

        Vertex root = vertices.get(0); // pone el primer nodo creado como raiz para empezar la busqueda
        if (root==null) {
            return false;
        }

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);
        root.state = State.COMPLETE;

        while (!queue.isEmpty())//revisa los niveles del grafo mediante el uso de una pila
        {
            root = queue.peek();
            for (Vertex each : root.outgoing)
            {

                if (each.state==State.UNVISITED)
                {
                    each.state = State.COMPLETE;
                    queue.add(each);
                }
            }
            queue.remove();
        }
        return isConnected();
    }

    /**
     * Realiza la busqueda Breadth First en el vertice indicado
     * @param v1 Valor del nodo inicial
     * @return true si esta conectado, false si no esta conectado o si esta vacio
     */
    public boolean BreadthFirstSearch(T v1)
    {
        if (vertices.isEmpty()) {
            return false;
        }
        clearStates();// pone los estados de los vertices en UNVISITED

        Vertex root = findVertex(v1); //Pone la raiz como el nodo buscado

        if (root == null) {
            return false;
        }

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);
        root.state = State.COMPLETE;

        while (!queue.isEmpty())
        {
            root = queue.peek();
            for (Vertex each : root.outgoing)//revisa cada vertice que sale de la raiz y lo agrega a la cola
            {

                if (each.state==State.UNVISITED)
                {
                    each.state = State.COMPLETE;
                    queue.add(each);
                }
            }
            queue.remove();
        }
        return isConnected();
    }

    /**
     * Crea el camino del grafo utilizando Dijkstra
     * Asigna la informacion en los veritices a partir del inicial
     * @param v1 Valor del vertice inicial
     * @return true si tiene exito, false si esta vacio o no se encuentra
     */
    private boolean Dijkstra(T v1)
    {
        if (vertices.isEmpty()){
            return false;
        }

        // Reinicia los caminos de los vertices
        resetDistances();

        // Verifica que el vertice no sea nulo
        Vertex source = findVertex(v1);
        if (source==null){
            return false;
        }

        // Pone la distancia de la raiz en 0 y lo agrega a la cola
        source.minDistance = 0;
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(source);

        while (!pq.isEmpty())
        {
            //Asigna el elemento superior de la cola y lo elimina de esta
            Vertex u = pq.poll();


            for (Vertex v : u.outgoing)// Revisa los nodos adyacentes
            {
                // Encuentra los arcos entre los vertices y deja el que tiene la menor distancia
                Edge e = findEdge(u, v);
                if (e == null) {
                    return false;
                }

                int totalDistance = u.minDistance + e.cost;
                if (totalDistance < v.minDistance)
                {
                    // El nuevo costo mas pequeno lo asigna y agrega a la cola
                    pq.remove(v);
                    v.minDistance = totalDistance;
                    v.previous = u;
                    pq.add(v);
                }
            }
        }
        return true;
    }

    /**
     * Revisa el arbol creado con Dijkstra
     * @param target Vertice al que se quiere llegar
     * @return string Lista de los vertices con sus costos
     */
    private List<String> getShortestPath(Vertex target)
    {
        List<String> path = new ArrayList<String>();

        // Revisa si no existen caminos
        if (target.minDistance==Integer.MAX_VALUE)
        {
            path.add("Camino no encontrado");
            return path;
        }

        // Revisa los vertices del destino
        for (Vertex v = target; v !=null; v = v.previous)
        {
            path.add(v.value + " : cost : " + v.minDistance);
        }

        // invierte la lista
        Collections.reverse(path);
        return path;
    }

    /**
     * Reinicia todos los caminos del grafo recorrido con Dijkstra
     */
    private void resetDistances()
    {
        for (Vertex each : vertices)
        {
            each.minDistance = Integer.MAX_VALUE;
            each.previous = null;
        }
    }

    /**
     * PUBLIC WRAPPER FOR PRIVATE FUNCTIONS
     * Llama al metodo Dijkstra para que construya el arbol de caminos para los vertices
     * indicados, luego llama al metodo getShortestPath para que devuelva la lista con
     * la ruta que contiene el camino mas corto al destino
     * @param from Valor del nodo inicial
     * @param to Valor del nodo al que se quiere llegar
     * @return ArrayList de strings con la ruta a seguir
     */
    public List<String> getPath(T from, T to)
    {
        boolean test = Dijkstra(from);
        if (test==false) {
            return null;
        }
        List<String> path = getShortestPath(findVertex(to));
        return path;
    }

    /**
     * @return String con los vertices
     */
    @Override
    public String toString()
    {
        String retval = "";
        for (Vertex each : vertices)
        {
            retval += each.toString() + "\n";
        }
        return retval;
    }

    /**
     * Lista todos los arcos en un String
     * @return String con los datos de los arcos
     */
    public String edgesToString()
    {
        String retval = "";
        for (Edge each : edges)
        {
            retval += each + "\n";
        }
        return retval;
    }

    /**
     * Clase Vertex
     */
    class Vertex implements Comparable<Vertex>
    {
        T value;

        // variables para el arbol que crea Dijkstra
        Vertex previous = null;
        int minDistance = Integer.MAX_VALUE;

        List<Vertex> incoming;
        List<Vertex> outgoing;
        State state; //estado del vertice

        /**
         * Constructor de un vertice con el valor ingresado
         * @param value valor del vertice
         */
        public Vertex(T value)
        {
            this.value = value;
            incoming = new ArrayList<>();
            outgoing = new ArrayList<>();
            state = State.UNVISITED;
        }

        /**
         * @param other Vertice con el que se va a comparar
         */
        @Override
        public int compareTo(Vertex other)
        {
            return Integer.compare(minDistance, other.minDistance);
        }

        /**
         * Agrega el vertice a la lista incoming
         * @param vert vertice que se agrega
         */
        public void addIncoming(Vertex vert)
        {
            incoming.add(vert);
        }

        /**
         * Agrega el vertice a la lista outgoing
         * @param vert vertice que se agrega
         */
        public void addOutgoing(Vertex vert)
        {
            outgoing.add(vert);
        }

        /**
         * String de un vertice con sus vertices incoming y outgoing
         * @return string con los datos del vertice y los que van hacia este y los que salen
         */
        @Override
        public String toString()
        {
            String retval = "";
            retval += "Vertex: " + value + " : ";
            retval += " In: ";
            for (Vertex each : incoming) retval+= each.value + " ";
            retval += "Out: ";
            for (Vertex each : outgoing) retval += each.value + " ";
            return retval;
        }
    }

    /**
     * clase Edge
     */
    class Edge
    {
        Vertex from;
        Vertex to;
        int cost;

        /**
         * @param v1 vertice del que sale el arco
         * @param v2 vertice al que llega el arco
         * @param cost valor del arco
         */
        public Edge(T v1, T v2, int cost)
        {
            from = findVertex(v1);
            if (from == null)
            {
                from = new Vertex(v1);
                vertices.add(from);
            }
            to = findVertex(v2);
            if (to == null)
            {
                to = new Vertex(v2);
                vertices.add(to);
            }
            this.cost = cost;

            from.addOutgoing(to);
            to.addIncoming(from);
        }

        /**
         * @return devuelve como string el arco
         */
        @Override
        public String toString()
        {
            return "Edge From: " + from.value + " to: " + to.value + " cost: " + cost;
        }
    }
}