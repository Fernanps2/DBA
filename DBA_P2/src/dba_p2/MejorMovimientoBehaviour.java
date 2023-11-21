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

public class MejorMovimientoBehaviour extends Behaviour{
    Entorno entorno;
    double mejorDistancia = 99999999;
    int filaMovimiento, colMovimiento;
    DBA_P2 miAgente;
    
    MovimientoNorte movNorte = new MovimientoNorte();
    MovimientoSur movSur = new MovimientoSur();
    MovimientoEste movEste = new MovimientoEste();
    MovimientoOeste movOeste = new MovimientoOeste();
    MovimientoNoreste movNoreste = new MovimientoNoreste();
    MovimientoNoroeste movNoroeste = new MovimientoNoroeste();
    MovimientoSureste movSureste = new MovimientoSureste();
    MovimientoSuroeste movSuroeste = new MovimientoSuroeste();
    
    public MejorMovimientoBehaviour(Entorno entornoAgente, DBA_P2 agente) {
        entorno = entornoAgente;
        miAgente = agente;
    }
    
    @Override
    public void action() {
        mejorDistancia = 99999999;
       //Comprobamos que movimiento es mejor
       
       //Comprobamos movimiento norte
       double norte = movNorte.calculaMovimiento(entorno, miAgente);
       if (norte != -1) {            
            if (norte < mejorDistancia) {
                mejorDistancia = norte;
                filaMovimiento = entorno.filAgente-1;
                colMovimiento = entorno.colAgente;
            }            
       }
       
       //Comprobamos movimiento Este
       double este = movEste.calculaMovimiento(entorno, miAgente);
       if(este != -1){
            if (este < mejorDistancia) {
                mejorDistancia = este;
                filaMovimiento = entorno.filAgente;
                colMovimiento = entorno.colAgente+1;
            }
        }
       
       //Comprobamos movimiento Sur
       double sur = movSur.calculaMovimiento(entorno, miAgente);
       if (sur != -1) {            
            if (sur < mejorDistancia) {
                mejorDistancia = sur;
                filaMovimiento = entorno.filAgente+1;
                colMovimiento = entorno.colAgente;
            }            
       }
       
       //Comprobamos movimiento Oeste
       double oeste = movOeste.calculaMovimiento(entorno, miAgente);
       if(oeste != -1){
            if (oeste < mejorDistancia) {
                mejorDistancia = oeste;
                filaMovimiento = entorno.filAgente;
                colMovimiento = entorno.colAgente-1;
            }
       }
       
       //Comprobamos movimiento Noreste
       double norEste = movNoreste.calculaMovimiento(entorno, miAgente);
       if(norEste != -1){
            if (norEste < mejorDistancia) {
                mejorDistancia = norEste;
                filaMovimiento = entorno.filAgente-1;
                colMovimiento = entorno.colAgente+1;
            }
       }
       
       //Comprobamos movimiento Noroeste
       double norOeste = movNoroeste.calculaMovimiento(entorno, miAgente);
       if(norOeste != -1){
            if (norOeste < mejorDistancia) {
                mejorDistancia = norOeste;
                filaMovimiento = entorno.filAgente-1;
                colMovimiento = entorno.colAgente-1;
            }
       }
       
       //Comprobamos movimiento Sureste
       double surEste = movSureste.calculaMovimiento(entorno, miAgente);
       if(surEste != -1){
            if (surEste < mejorDistancia) {
                mejorDistancia = surEste;
                filaMovimiento = entorno.filAgente+1;
                colMovimiento = entorno.colAgente+1;
            }
       }
       
       //Comprobamos movimiento Suroeste
       double surOeste = movSuroeste.calculaMovimiento(entorno, miAgente);
       if(surOeste != -1){
            if (surOeste < mejorDistancia) {
                mejorDistancia = surOeste;
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
