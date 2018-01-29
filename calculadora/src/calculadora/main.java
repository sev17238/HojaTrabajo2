/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author SDiego
 */
public class main {
    public static void main(String[] args) {
        Calculos calc = new Calculos();
        String e= "";
        
        double res = calc.Operar();
        System.out.println(res);
    }
    
}
