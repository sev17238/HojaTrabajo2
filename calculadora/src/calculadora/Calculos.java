
package calculadora;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author Guillermo Sandoval
 * @author Diego Sevilla
 */
public class Calculos implements Calculadora{
    
    public Calculos(){
        
    }
    /**
     * Con este metodo se puede leer cada linea de un archivo de texto asi como cada letra de 
     * cada linea del arcivo.
     * @param linea
     * @return 
     */
    @Override
    public double Operar(String linea){
        double result = 0;
        StackVector<String> vector = new StackVector<String>();                                              
        try{
            for(int i =1;i<linea.length();i++){
                    String caracter = linea.substring((i-1), i);                                      
                                                                    
                    if(caracter.contentEquals("1")||caracter.contentEquals("2")||caracter.contentEquals("3")
                      ||caracter.contentEquals("4")||caracter.contentEquals("5")||caracter.contentEquals("6")
                      ||caracter.contentEquals("7")||caracter.contentEquals("8")||caracter.contentEquals("9")){
                        vector.push(caracter);
                    //int num = Double.parseDouble(caracter);
                    //if (num>=0 && num<=9){
                        //vector.push(caracter);
                    }
                    //Si por el contrario el usuario ingresa algun operando de los 
                    //Basicos deberia de efectuar tal operacion y lo hace con una 
                    //comparacion de Strings
                    //Cabe notar que en los Stacks solamente se puede sacar el 
                    //Ultimo valor asi que para operar se guarda este valor de forma
                    //Temporal en una variable para que asi de esta forma
                    //
                    else if(caracter.contentEquals("+")){
                        result = Double.parseDouble(vector.pop());
                        double num2 = Double.parseDouble(vector.pop());
                        result = suma(num2,result);
                        vector.push(Double.toString(result));
                    }else if(caracter.contentEquals("-")){
                        result = Double.parseDouble(vector.pop());
                        double num2 = Double.parseDouble(vector.pop());
                        result = resta(num2,result);
                        vector.push(Double.toString(result));
                    }else if(caracter.contentEquals("*")){
                        result = Double.parseDouble(vector.pop());
                        double num2 = Double.parseDouble(vector.pop());
                        result = producto(result,num2);
                        vector.push(Double.toString(result));
                    }else if(caracter.contentEquals("/")){
                        //La division tiene una condicion en la cual si el 
                        //Ultimo valor del vector es igual a 0 definitivamente no
                        //sera capaz de efectuar la division por lo que tirara
                        //al usuario una alerta de que es invalido dividir entre 0.
                        result = Double.parseDouble(vector.peek());
                        if(result == 0){
                            System.out.println("Error, no se puede dividir entre 0");
                        }
                        else {
                        result = Double.parseDouble(vector.pop());
                        double num2 = Double.parseDouble(vector.pop());
                        result = division(num2,result);
                        vector.push(Double.toString(result));
                        }       
                    }else{
                        //System.out.println(caracter);
                    }            
                }
            //System.out.println(result);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Revise su formato PostFix, \n"
                    + "es posible que tenga un error.", "Error PostFix", JOptionPane.ERROR_MESSAGE);
        }
                    
        return result;
        
    }
    
    private double suma(double a,double b){
        //El metodo que suma dos valores en estilo Infix
        double result = a + b;
        return result;
    }
    private double resta(double a,double b){
        //El metodo que se ocupa de restar los dos valores ingresados en el orden
        //en el que fueron ingresados
        double result = a - b;
        return result;
    }
    private double producto(double a,double b){
        //El metodo que multiplica los dos valores ingresados y regresa su resultado
        double result = a * b;
        return result;
    }
    private double division(double a,double b){
        //Este metodo se ocupa de dividir, sin embargo su defensa de dividir cualquier
        //numero entre 0 se encuentra directamente en el el metodo antes de utilizar
        //Esta operacion, de tal manera no llega a esta linea con ese problema
        double result = a/b;
        return result;
    }
    
    
    
}
