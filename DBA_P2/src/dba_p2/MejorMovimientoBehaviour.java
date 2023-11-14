package dba_p2;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import java.lang.Thread;
import java.util.ArrayList;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ignaciotd
 */
/*
enum Movimientos {
    NORTE,
    SUR,
    ESTE,
    OESTE;
}
*/

public class MejorMovimientoBehaviour extends Behaviour {
    Entorno entorno;
    int mejorDistancia = 99999999;
    int filaMovimiento, colMovimiento;
    DBA_P2 miAgente;
    
    public MejorMovimientoBehaviour(Entorno entornoAgente, DBA_P2 agente) {
        entorno = entornoAgente;
        miAgente = agente;
    }
    
    @Override
    public void action() {
        mejorDistancia = 99999999;
       //Comprobamos que movimiento es mejor
       //Comprobamos movimiento norte
       if (entorno.movimientoPosible(entorno.filAgente-1,entorno.colAgente)) {
            int distanciaNorte = CalcularDistancia(entorno.filAgente-1,entorno.colAgente, miAgente.caminoRecorrido);
            if (distanciaNorte < mejorDistancia) {
                mejorDistancia = distanciaNorte;
                filaMovimiento = entorno.filAgente-1;
                colMovimiento = entorno.colAgente;
            }
            
       }
       
       //Comprobamos movimiento Este
       if (entorno.movimientoPosible(entorno.filAgente,entorno.colAgente+1)) {
            int distanciaEste = CalcularDistancia(entorno.filAgente,entorno.colAgente+1, miAgente.caminoRecorrido);
            if (distanciaEste < mejorDistancia) {
                mejorDistancia = distanciaEste;
                filaMovimiento = entorno.filAgente;
                colMovimiento = entorno.colAgente+1;
            }
        }
       
       //Comprobamos movimiento Sur
       if (entorno.movimientoPosible(entorno.filAgente+1,entorno.colAgente)) {
            int distanciaSur = CalcularDistancia(entorno.filAgente+1,entorno.colAgente, miAgente.caminoRecorrido);
            if (distanciaSur < mejorDistancia) {
                mejorDistancia = distanciaSur;
                filaMovimiento = entorno.filAgente+1;
                colMovimiento = entorno.colAgente;
            }
       }
       
       //Comprobamos movimiento Oeste
       if (entorno.movimientoPosible(entorno.filAgente,entorno.colAgente-1)) {
            int distanciaOeste = CalcularDistancia(entorno.filAgente,entorno.colAgente-1, miAgente.caminoRecorrido);
            if (distanciaOeste < mejorDistancia) {
                mejorDistancia = distanciaOeste;
                filaMovimiento = entorno.filAgente;
                colMovimiento = entorno.colAgente-1;
            }
       }
       
       try {
           Thread.sleep(500);
       } catch (InterruptedException e) {
           System.out.print(e);
       }
       
       ArrayList<Integer> posicion = new ArrayList<Integer>();
       posicion.add(filaMovimiento);
       posicion.add(colMovimiento);
       
       miAgente.caminoRecorrido.add(posicion);
       //Llamamos al comportamiento del movimiento
       //miAgente.addBehaviour(new MovimientoBehaviour(entorno, filaMovimiento, colMovimiento));
       
    }
    
    @Override
    public boolean done() {
        if (entorno.filAgente == entorno.filMeta && entorno.colAgente == entorno.colMeta)
            return true;
        else
            return false;
    }
    
    
    private int CalcularDistancia(int fila, int columna, ArrayList<ArrayList<Integer>> caminoRecorrido) {
        int distancia_y = Math.abs(entorno.filMeta - fila);
        int distancia_x = Math.abs(entorno.colMeta - columna);
        
        ArrayList<Integer> posicion = new ArrayList<Integer>();
        posicion.add(fila);
        posicion.add(columna);
        
        int castigo = 0;
        int indicePos = caminoRecorrido.lastIndexOf(posicion);
        
        if (indicePos != -1)
            castigo = 10 - (caminoRecorrido.size() - indicePos);
            
        return (distancia_y + distancia_x + castigo);
    }
}
