/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion_agua;

/**
 *
 * @author Javier López Medina
 */
public class Gestion {
    Cliente [] clientes;
    
    public void Menu(){
        double recaudacion = 0.0;
        clientes = new Cliente[5];
        String clase;
        clientes[0] = new Cliente_tipo1("11111111A", "Pacomer", 37);
        clientes[1] = new Cliente("22222222B", "Sonia", 34);
        clientes[2] = new Cliente_tipo2("33333333C", "Miguel", 14);
        clientes[3] = new Cliente_tipo2("4444444D", "Ana", 62);
        clientes[4] = new Cliente_tipo1("5555555E", "Melisa", 54);
        
        for (Cliente cliente : clientes) {
            clase = mostrarTipo(cliente.getClass().toString());
            System.out.println("================================================================");
            System.out.println("Tipo de cliente: " + clase);
            cliente.Mostrar();
            recaudacion += cliente.calcular_Coste();
        }
        recaudacion = Math.round(recaudacion*100.0)/100.0;
        System.out.println("Recaudación total: " + recaudacion + " €");
    }
    
    public String mostrarTipo(String cliente){
        String clase = cliente.substring(cliente.indexOf("."));
        switch (clase) {
            case ".Cliente":
                clase = "Normal";
                break;
            case ".Cliente_tipo1":
                clase = "Tipo 1";
                break;
            case ".Cliente_tipo2":
                clase = "Tipo 2";
                break;
            default:
                clase = "Desconocido";
        }
        return clase;
    }
}
