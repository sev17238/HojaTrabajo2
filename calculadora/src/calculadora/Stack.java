
package calculadora;

/**
 * Interfaz con el comportamiento y los metodos utilizados en la clase StackVector.
 * @author Guillermo Sandoval 17577
 * @author Diego Sevilla 17238
 */
public interface Stack<E>{
   public void push(E item);
   
   public E pop();

   public E peek();
 
   public boolean empty();

   public int size();
  
}
