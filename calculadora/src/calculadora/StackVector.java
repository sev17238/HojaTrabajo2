
package calculadora;
import java.util.ArrayList;

/**
 *
 * @author Guillermo Sandoval
 * @author Diego Sevilla
 */
public class StackVector<E> implements Stack<E>{
    protected ArrayList<E> datos;
    
    public StackVector()
	// post: constructs a new, empty stack
	{
		datos = new ArrayList<E>();
	}

    @Override
	public void push(E item)
	// post: the value is added to the stack
	//          will be popped next if no intervening push
	{
		datos.add(item);
	}

    @Override
	public E pop()
	// pre: stack is not empty
	// post: most recently pushed item is removed and returned
	{
		return datos.remove(size()-1);
	}

	public E peek()
	// pre: stack is not empty
	// post: top value (next to be popped) is returned
	{
		return datos.get(size() - 1);
	}
	
	public int size()
	// post: returns the number of elements in the stack
	{
		return datos.size();
	}
  
	public boolean empty()
	// post: returns true if and only if the stack is empty
	{
		return size() == 0;
	}
}
