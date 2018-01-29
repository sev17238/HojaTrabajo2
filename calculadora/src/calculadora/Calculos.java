
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
                    }else if(caracter.contentEquals("+")){
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
                        result = Double.parseDouble(vector.pop());
                        double num2 = Double.parseDouble(vector.pop());
                        result = division(num2,result);
                        vector.push(Double.toString(result));
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
