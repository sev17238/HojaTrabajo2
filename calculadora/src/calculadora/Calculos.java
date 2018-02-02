
package calculadora;

import javax.swing.JOptionPane;

/**
 * Clase que realiza los calculos al interpretar una linea en formato postfix
 * @author Guillermo Sandoval
 * @author Diego Sevilla
 */
public class Calculos implements Calculadora{
    
    public Calculos(){
        
    }
    /**
     * Con este metodo se pueden interpretar las operaciones PostFix en una linea de un archivo .txt
     * @param linea El parametro recibido sera una linea del archivo leido en la clase principal
     * @return El resultado generado por la operacion de la linea postfix
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
                    }
                    //Si por el contrario el usuario ingresa algun operando de los 
                    //Basicos deberia de efectuar tal operacion y lo hace con una 
                    //comparacion de Strings
                    //Cabe notar que en los Stacks solamente se puede sacar el 
                    //Ultimo valor asi que para operar se guarda este valor de forma
                    //Temporal en una variable para que asi de esta forma
                    //se pueda operar el ultimo elemento despues del antepenultimo
                    //en la operacion, de tal forma que obtiene un valor a y un valor b
                    //pero los opera como b (signo)a                    
                    else if(caracter.contentEquals("+")){                        
                        result = suma(Double.parseDouble(vector.pop()),Double.parseDouble(vector.pop()));
                        vector.push(Double.toString(result));
                        //result = Double.parseDouble(vector.pop());
                        //double num2 = Double.parseDouble(vector.pop());
                        //result = suma(num2,result);
                        //vector.push(Double.toString(result));
                    }else if(caracter.contentEquals("-")){
                        result = suma(-Double.parseDouble(vector.pop()),Double.parseDouble(vector.pop()));
                        vector.push(Double.toString(result));
                        //result = Double.parseDouble(vector.pop());
                        //double num2 = Double.parseDouble(vector.pop());
                        //result = resta(num2,result);
                        //vector.push(Double.toString(result));
                    }else if(caracter.contentEquals("*")){
                        result = producto(Double.parseDouble(vector.pop()), Double.parseDouble(vector.pop()));
                        vector.push(Double.toString(result));
                        //result = Double.parseDouble(vector.pop());
                        //double num2 = Double.parseDouble(vector.pop());
                        //result = producto(result,num2);
                        //vector.push(Double.toString(result));
                    }else if(caracter.contentEquals("/")){
                        //La division tiene una condicion en la cual si el 
                        //Ultimo valor del vector es igual a 0 definitivamente no
                        //sera capaz de efectuar la division por lo que tirara
                        //al usuario una alerta de que es invalido dividir entre 0.
                        result = Double.parseDouble(vector.peek());
                        if(result == 0){
                            JOptionPane.showMessageDialog(null, "No se puede dividir entre cero"
                                , "Division entre cero", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                        result = producto(1/Double.parseDouble(vector.pop()), Double.parseDouble(vector.pop()));
                        vector.push(Double.toString(result));    
                        //result = Double.parseDouble(vector.pop());
                        //double num2 = Double.parseDouble(vector.pop());
                        //result = division(num2,result);
                        //vector.push(Double.toString(result));
                        }       
                    }            
                }
            //System.out.println(result);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Revise su formato PostFix, \n"
                    + "es posible que tenga signos repetidos.", "Signos repetidos", JOptionPane.ERROR_MESSAGE);
        }                    
        return result;        
    }
    /**
     * Este metodo suma dos numeros.
     * @param a primer numero
     * @param b segundo numero
     * @return el resultado de la suma de ambos numeros
     */
    protected double suma(double a,double b){
        //El metodo que suma dos valores en estilo Infix
        double result = a + b;
        return result;
    }
    /**
     * Este metodo multiplica dos numeros.
     * @param a primer numero
     * @param b segundo numero
     * @return el resultado del producto de ambos numeros
     */
    protected double producto(double a,double b){
        //El metodo que multiplica los dos valores ingresados y regresa su resultado
        double result = a * b;
        return result;
    }
    
}
