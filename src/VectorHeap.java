import java.util.Vector;

/**
 * @author Andy Castillo 18040
 * @author Cristina Bautista 161260
 * @version 03/04/2019
 * @param <E>
 * Esta es la clase de Vector Heap que obtuvimos de Canvas y editamos a conveniencia, esta
 * es la clase implementadora de Priority Queue
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    protected Vector<E> data; // the data, kept in heap order

    /**
     * Este metodo construye un vector
     */
    public VectorHeap() {
        // post: constructs a new priority queue
        data = new Vector<E>();
    }

    /**
     * Este es el contructor de un vector que esta desordenado y agrega aun heap
     * @param v
     */
    public VectorHeap(Vector<E> v){
        // post: constructs a new priority queue from an unordered vector
        int i;
        data = new Vector<E>(v.size()); // we know ultimate size
        for (i = 0; i < v.size(); i++){
            // add elements to heap
            add(v.get(i));
        }
    }

    /**
     * Este retorna el papa de un nodo en una ubicacion x
     * @param i
     * @return papa de un nodo en cierta ubicacion
     */
    protected static int parent(int i) {
        // pre: 0 <= i < size
        // post: returns parent of node at location i
        return (i-1)/2;
    }

    /**
     * Este retorna el indice del hijo izquierdo de una ubicacion x
     * @param i
     * @return indice del hijo izquierdo en cierta ubicacion
     */
    protected static int left(int i) {
        // pre: 0 <= i < size
        // post: returns index of left child of node at location i
        return 2*i+1;
    }

    /**
     * Este retorna el indice del hijo derecho de una ubicacion x
     * @param i
     * @return indice del hijo derecho en cierta ubicacion
     */
    protected static int right(int i) {
        // pre: 0 <= i < size
        // post: returns index of right child of node at location i
        return (2*i+1) + 1;
    }

    /**
     * Mueve el nodo en el indice de una hoja que seria su ubicacion correspondiente
     * @param leaf
     */
    protected void percolateUp(int leaf){
        // pre: 0 <= leaf < size
        // post: moves node at index leaf up to appropriate position
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf,value);
    }

    /**
     * Mueve un modo al indice de la raiz hacia abajo hacia su ubicacion correspondiente
     * @param root
     */
    protected void pushDownRoot(int root) {
        // pre: 0 <= root < size
        // post: moves node at index root down
        // to appropriate position in subtree
        int heapSize = data.size();
        E value = data.get(root);
        while(root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize) && ((data.get(childpos+1)).compareTo(data.get(childpos))<0)) {
                    childpos++;
                }
                // Assert: childpos indexes smaller of two children
                if ((data.get(childpos)).compareTo(value) < 0) {
                    data.set(root,data.get(childpos));
                    root = childpos; // keep moving down
                } else {
                    // found right location
                    data.set(root,value);
                    return;
                }
            } else {
                // at a leaf! insert and halt
                data.set(root,value);
                return;
            }
        }
    }

    /**
     * Para traer el primero
     * @return data que es un nuevo vector con el generico <E>
     */
    @Override
    public E getFirst() {

        return data.firstElement();
    }

    /**
     * Es para remover el valor minimo de la Queue y retornarlo
     * @return el valor mas pequeno
     */
    public E remove(){
        // pre: !isEmpty()
        // post: returns and removes minimum value from queue
        E minVal = getFirst();
        data.set(0,data.get(data.size()-1));
        data.setSize(data.size()-1);
        if (data.size()>1)
            pushDownRoot(0);
            return minVal;

    }

    /**
     * Es para agregar un valor al Queue
     * @param value
     */
    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size()-1);
    }

    /**
     * Para revisar si esta vacia la Queue
     * @return verdadero o falso dependiendo si hay contenido o no
     */
    @Override
    public boolean isEmpty() {
        if (data.size()==0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * El tamano del vector
     * @return el tamano del vector
     */
    @Override
    public int size() {

        return data.size();
    }


    @Override
    public void clear() {

    }


}
