/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dba_p2;

import jade.core.behaviours.OneShotBehaviour;

/**
 *
 * @author ignaciotd
 */
public class MovimientoBehaviour extends OneShotBehaviour {
    
    Entorno entorno;
    int filaMovimiento;
    int colMovimiento;
    
    public MovimientoBehaviour(Entorno entornoAgente, int fila, int columna) {
        entorno = entornoAgente;
        filaMovimiento = fila;
        colMovimiento = columna;
        
    }
    
    public void action() {
        if (entorno.movimientoPosible(filaMovimiento,colMovimiento)) {
        entorno.filAgente = filaMovimiento;
        entorno.colAgente = colMovimiento;
        }
        
        entorno.mostrarEnTorno();
      
    }
}
