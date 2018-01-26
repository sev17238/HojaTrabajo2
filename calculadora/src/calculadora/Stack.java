
package calculadora;

/**
 *
 * @author Guillermo Sandoval
 * @author Diego Sevilla
 */
public interface Stack<E>{
   public void push(E item);
   
   public E pop();

   public E peek();
 
   public boolean empty();

   public int size();
  
}
