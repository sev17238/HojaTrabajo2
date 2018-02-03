
package calculadora;
import java.util.ArrayList;

/**
 * Esta clase usa genericos para crear un vector utilizando la clase ArrayList implementando a la 
 * interfaz Stack.
 * @author Guillermo Sandoval 17577
 * @author Diego Sevilla 17238
 * @param <E> El tipo de dato que se guardara en el vector (String, Integer, Double, etc)
 */
public class StackVector<E> implements Stack<E>{
    protected ArrayList<E> datos;
    /**
     * Constructor que crea un nuevo stack vacio.
     */
    public StackVector()
	{
		datos = new ArrayList<>();
	}
    /**
     * Metodo para ingresar un valor al stack.
     * @param item sera el elemento que se estara ingresando al stack
     */
    @Override
	public void push(E item)
	{
		datos.add(item);
	}
        /**
         * Metodo que remueve el dato ingresado mas recientemente al stack
         * @return el dato removido en el tope del stack
         */
    @Override
	public E pop()
	{
		return datos.remove(size()-1);
	}
        /**
         * Metodo que devuelve el dato en el tope del stack en cuestion.
         * @return el dato en el tope
         */
    @Override
	public E peek()
	{
		return datos.get(size() - 1);
	}
	/**
         * Metodoq ue devuelve el numero de elementos en el stack.
         * @return el numero de elementosd el stack
         */
    @Override
	public int size()
	{
		return datos.size();
	}
        /**
         * Metodo que ayuda a verificar si el stack esta vacio o no por medio de booleanos.
         * @return true si el stack esta vacio o false si no lo esta
         */
    @Override
	public boolean empty()
	{
		return size() == 0;
	}
}
