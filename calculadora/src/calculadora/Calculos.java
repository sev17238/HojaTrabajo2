
package calculadora;

/**
 *
 * @author Guillermo Sandoval
 * @author Diego Sevilla
*/
public class Calculos implements Calculadora{
    
    
    public Calculos(){
        
    }
    
    @Override
    public double Operar(String e){
        
        double result;
        return result;
    }
    
    private double suma(double a,double b){
        double result = a + b;
        return result;
    }
    private double resta(double a,double b){
        double result = a - b;
        return result;
    }
    private double producto(double a,double b){
        double result = a * b;
        return result;
    }
    private double division(double a,double b){
        double result = a/b;
        return result;
    }
   
    
}
