/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dba_p3;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;
/**
 *
 * @author antonio
 */
public class MensajeRudolph extends Behaviour {
    
    private int step = 0;
    private boolean finish = false;
    private String contrasenia = "FuckNavidad";
    ArrayList<int[]> listaRenos = new ArrayList<>();
    
    
    public MensajeRudolph(ArrayList<int[]> Renos) {
        listaRenos = Renos;
    }
    
    @Override
    public void action() {
      switch(this.step){
        case 0 -> {
            ACLMessage msg = myAgent.blockingReceive();
            System.out.println(msg);
            if(msg.getPerformative() == ACLMessage.REQUEST)
            {
                if(msg.getContent().equals(contrasenia)){
                     ACLMessage replay = msg.createReply(ACLMessage.AGREE);
                  
                      int[] valores = listaRenos.get(0);
                      String contenidoMensaje = valores[0] + "," + valores[1] + " Esa es la posicion del siguiente reno";
                  
                      replay.setContent(contenidoMensaje);
                      this.myAgent.send(replay);
                      this.step = 1;
                }else{
                      ACLMessage replay = msg.createReply(ACLMessage.REFUSE);
                      replay.setContent("Esa no es la contraseña");
                }   
            }else{
                  System.out.println("Error en el protocolo - step" + 1);
            }    
        }
        case 1 -> {
            ACLMessage msg = myAgent.blockingReceive();
            System.out.println(msg);
            
            if(msg.getPerformative() == ACLMessage.REQUEST){
                // debe comprobar la posicion del agente con la posicion del reno
                
                ACLMessage replay = msg.createReply(ACLMessage.AGREE);
                  
                int[] valores = listaRenos.get(1);
                String contenidoMensaje = valores[0] + "," + valores[1] + " Esa es la posicion del siguiente reno";
                  
                replay.setContent(contenidoMensaje);
                this.myAgent.send(replay);
                this.step = 2;
            }else{
                System.out.println("Error en el protocolo - step" + 2);
            }
        }
        
        case 2 -> {
            ACLMessage msg = myAgent.blockingReceive();
            System.out.println(msg);
            
            if(msg.getPerformative() == ACLMessage.REQUEST){
                /* debe comprobar la posicion del agente con la posicion del reno
                    if(listaRenos.get(1).get(0) == )
                */
                ACLMessage replay = msg.createReply(ACLMessage.AGREE);
                  
                int[] valores = listaRenos.get(2);
                String contenidoMensaje = valores[0] + "," + valores[1] + " Esa es la posicion del siguiente reno";
                  
                replay.setContent(contenidoMensaje);
                this.myAgent.send(replay);
                this.step = 3;
            }else{
                System.out.println("Error en el protocolo - step" + 3);
            }
        }
        
        case 3 -> {
            ACLMessage msg = myAgent.blockingReceive();
            System.out.println(msg);
            
            if(msg.getPerformative() == ACLMessage.REQUEST){
                /* debe comprobar la posicion del agente con la posicion del reno
                    if(listaRenos.get(1).get(0) == )
                */
                ACLMessage replay = msg.createReply(ACLMessage.AGREE);
                  
                int[] valores = listaRenos.get(3);
                String contenidoMensaje = valores[0] + "," + valores[1] + " Esa es la posicion del siguiente reno";
                  
                replay.setContent(contenidoMensaje);
                this.myAgent.send(replay);
                this.step = 4;
            }else{
                System.out.println("Error en el protocolo - step" + 4);
            }
        }
        
        case 4 -> {
            ACLMessage msg = myAgent.blockingReceive();
            System.out.println(msg);
            
            if(msg.getPerformative() == ACLMessage.REQUEST){
                /* debe comprobar la posicion del agente con la posicion del reno
                    if(listaRenos.get(1).get(0) == getPosicionx() && listaRenos.get(1).get(1) == getPosiciony())
                */
                ACLMessage replay = msg.createReply(ACLMessage.AGREE);
                  
                int[] valores = listaRenos.get(4);
                String contenidoMensaje = valores[0] + "," + valores[1] + " Esa es la posicion del siguiente reno";
                  
                replay.setContent(contenidoMensaje);
                this.myAgent.send(replay);
                this.step = 5;
            }else{
                System.out.println("Error en el protocolo - step" + 4);
            }
        }
        
        case 5 -> {
            ACLMessage msg = myAgent.blockingReceive();
            System.out.println(msg);
            
            if(msg.getPerformative() == ACLMessage.REQUEST){
                /* debe comprobar la posicion del agente con la posicion del reno
                    if(listaRenos.get(1).get(0) == )
                */
                ACLMessage replay = msg.createReply(ACLMessage.AGREE);
                  
                int[] valores = listaRenos.get(5);
                String contenidoMensaje = valores[0] + "," + valores[1] + " Esa es la posicion del siguiente reno";
                  
                replay.setContent(contenidoMensaje);
                this.myAgent.send(replay);
                this.step = 6;
            }else{
                System.out.println("Error en el protocolo - step" + 5);
            }
        }
        
        case 6 -> {
            ACLMessage msg = myAgent.blockingReceive();
            System.out.println(msg);
            
            if(msg.getPerformative() == ACLMessage.REQUEST){
                /* debe comprobar la posicion del agente con la posicion del reno
                    if(listaRenos.get(1).get(0) == )
                */
                ACLMessage replay = msg.createReply(ACLMessage.AGREE);
                  
                int[] valores = listaRenos.get(6);
                String contenidoMensaje = valores[0] + "," + valores[1] + " Esa es la posicion del siguiente reno";
                  
                replay.setContent(contenidoMensaje);
                this.myAgent.send(replay);
                this.step = 7;
            }else{
                System.out.println("Error en el protocolo - step" + 6);
            }
        }
        
        case 7 -> {
            ACLMessage msg = myAgent.blockingReceive();
            System.out.println(msg);
            
            if(msg.getPerformative() == ACLMessage.REQUEST){
                /* debe comprobar la posicion del agente con la posicion del reno
                    if(listaRenos.get(1).get(0) == )
                */
                ACLMessage replay = msg.createReply(ACLMessage.AGREE);
                  
                int[] valores = listaRenos.get(7);
                String contenidoMensaje = valores[0] + "," + valores[1] + " Esa es la posicion del siguiente reno";
                  
                replay.setContent(contenidoMensaje);
                this.myAgent.send(replay);
                this.step = 8;
            }else{
                System.out.println("Error en el protocolo - step" + 7);
            }
        }
        case 8 -> {
            ACLMessage msg = myAgent.blockingReceive();
            System.out.println(msg);
            
            if(msg.getPerformative() == ACLMessage.REQUEST){
                /* debe comprobar la posicion del agente con la posicion del reno
                    if(listaRenos.get(1).get(0) == )
                */
                ACLMessage replay = msg.createReply(ACLMessage.REFUSE);
                String contenidoMensaje = "Has econtrado a todos los renos";
                  
                replay.setContent(contenidoMensaje);
                this.myAgent.send(replay);
                this.finish = true;
            }else{
                System.out.println("Error en el protocolo - step" + 8);
            }
        
        }
      }
    }
    
    @Override
    public boolean done() {
         if (finish) {
            myAgent.doDelete();
            return true;
        }
        else
            return false;
    }
}

