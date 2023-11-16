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
    double mejorDistancia = 99999999;
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
            double distanciaNorte = CalcularDistancia(entorno.filAgente-1,entorno.colAgente, miAgente.caminoRecorrido);
            if (distanciaNorte < mejorDistancia) {
                mejorDistancia = distanciaNorte;
                filaMovimiento = entorno.filAgente-1;
                colMovimiento = entorno.colAgente;
            }
            
       }
       
       //Comprobamos movimiento Este
       if (entorno.movimientoPosible(entorno.filAgente,entorno.colAgente+1)) {
            double distanciaEste = CalcularDistancia(entorno.filAgente,entorno.colAgente+1, miAgente.caminoRecorrido);
            if (distanciaEste < mejorDistancia) {
                mejorDistancia = distanciaEste;
                filaMovimiento = entorno.filAgente;
                colMovimiento = entorno.colAgente+1;
            }
        }
       
       //Comprobamos movimiento Sur
       if (entorno.movimientoPosible(entorno.filAgente+1,entorno.colAgente)) {
            double distanciaSur = CalcularDistancia(entorno.filAgente+1,entorno.colAgente, miAgente.caminoRecorrido);
            if (distanciaSur < mejorDistancia) {
                mejorDistancia = distanciaSur;
                filaMovimiento = entorno.filAgente+1;
                colMovimiento = entorno.colAgente;
            }
       }
       
       //Comprobamos movimiento Oeste
       if (entorno.movimientoPosible(entorno.filAgente,entorno.colAgente-1)) {
            double distanciaOeste = CalcularDistancia(entorno.filAgente,entorno.colAgente-1, miAgente.caminoRecorrido);
            if (distanciaOeste < mejorDistancia) {
                mejorDistancia = distanciaOeste;
                filaMovimiento = entorno.filAgente;
                colMovimiento = entorno.colAgente-1;
            }
       }
       
       //Comprobamos movimiento Noreste
       if (entorno.movimientoPosibleDiagonal(entorno.filAgente-1,entorno.colAgente+1, DIRECCIONES.NORESTE)) {
            double distanciaOeste = CalcularDistancia(entorno.filAgente-1,entorno.colAgente+1, miAgente.caminoRecorrido);
            if (distanciaOeste < mejorDistancia) {
                mejorDistancia = distanciaOeste;
                filaMovimiento = entorno.filAgente-1;
                colMovimiento = entorno.colAgente+1;
            }
       }
       
       //Comprobamos movimiento Noroeste
       if (entorno.movimientoPosibleDiagonal(entorno.filAgente-1,entorno.colAgente-1, DIRECCIONES.NOROESTE)) {
            double distanciaOeste = CalcularDistancia(entorno.filAgente-1,entorno.colAgente-1, miAgente.caminoRecorrido);
            if (distanciaOeste < mejorDistancia) {
                mejorDistancia = distanciaOeste;
                filaMovimiento = entorno.filAgente-1;
                colMovimiento = entorno.colAgente-1;
            }
       }
       
       //Comprobamos movimiento Sureste
       if (entorno.movimientoPosibleDiagonal(entorno.filAgente+1,entorno.colAgente+1, DIRECCIONES.SURESTE)) {
            double distanciaOeste = CalcularDistancia(entorno.filAgente+1,entorno.colAgente+1, miAgente.caminoRecorrido);
            if (distanciaOeste < mejorDistancia) {
                mejorDistancia = distanciaOeste;
                filaMovimiento = entorno.filAgente+1;
                colMovimiento = entorno.colAgente+1;
            }
       }
       
       //Comprobamos movimiento Suroeste
       if (entorno.movimientoPosibleDiagonal(entorno.filAgente+1,entorno.colAgente-1, DIRECCIONES.SUROESTE)) {
            double distanciaOeste = CalcularDistancia(entorno.filAgente+1,entorno.colAgente-1, miAgente.caminoRecorrido);
            if (distanciaOeste < mejorDistancia) {
                mejorDistancia = distanciaOeste;
                filaMovimiento = entorno.filAgente+1;
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
    
    
    private double CalcularDistancia(int fila, int columna, ArrayList<ArrayList<Integer>> caminoRecorrido) {
        int distancia_y = Math.abs(entorno.filMeta - fila);
        int distancia_x = Math.abs(entorno.colMeta - columna);
        double distancia = Math.sqrt(distancia_y*distancia_y + distancia_x*distancia_x);
        
        ArrayList<Integer> posicion = new ArrayList<Integer>();
        posicion.add(fila);
        posicion.add(columna);
        
        int castigo = 0;
        int indicePos = caminoRecorrido.lastIndexOf(posicion);
        
        if (indicePos != -1)
            castigo = 99 - (caminoRecorrido.size() - indicePos);
            
        return (distancia + castigo);
    }
}
