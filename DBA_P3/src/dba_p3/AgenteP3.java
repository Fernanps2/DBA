/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dba_p3;

import static java.lang.System.exit;
import jade.core.Agent;

import java.util.ArrayList;

/**
 *
 * @author ignaciotd
 */
public class AgenteP3 extends Agent{
     Mapa mapa;
    Entorno entorno;
    public ArrayList<ArrayList<Integer>> caminoRecorrido;
   
    
    protected void setup() {
        // Inicializamos el agente
        mapa = new Mapa();
        //String ruta = "./Pr1-maps/mapWithDiagonalWall.txt";
        //String ruta = "./Pr1-maps/mapWithComplexObstacle1.txt";
        String ruta = "./Pr1-maps/mapWithComplexObstacle1.txt";
        
        caminoRecorrido = new ArrayList<ArrayList<Integer>>();
        
        //Leemos el mapa
        mapa.leermapa(ruta);
        
        //Inicializamos el entorno del Agente
        //entorno = new Entorno(mapa, 3, 9, 1, 9);
        entorno = new Entorno(mapa, 0, 6, 9, 6);
        //entorno = new Entorno(mapa, 0, 6, 9, 6);
        entorno.mostrarEnTorno();
        
        
        addBehaviour(new MejorMovimientoBehaviour(entorno, this));
        addBehaviour(new MovimientoBehaviour(entorno, this));
    }
    
    public void takeDown() {
        System.out.println("El agente ha resuelto el mapa en " + caminoRecorrido.size() + " pasos");
    }
}
