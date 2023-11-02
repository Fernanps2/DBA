/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dba_p2;
import jade.core.Agent;
import static java.lang.System.exit;
import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

/**
 *
 * @author Fernando
 */
public class DBA_P2 extends Agent{

    /**
     * @param args the command line arguments
     */
   
    Mapa mapa;
    Entorno entorno;
   
    
    protected void setup() {
        // Inicializamos el agente
        mapa = new Mapa();
        String ruta = "../Pr1-maps/mapWithoutObstacle.txt";
        
        //Leemos el mapa
        mapa.leermapa(ruta);
        
        //Inicializamos el entorno del Agente
        entorno = new Entorno(mapa, 9, 9, 0, 0);
        entorno.mostrarEnTorno();
        
        
        addBehaviour(new MejorMovimientoBehaviour(entorno, this));

        
    }
    
    
    public static void main(String[] args){
        
        //Ejecutamos
        String host = "localhost";
        String containerName = "container-3";
        String agentName = "ignaciotd";
        
        try {
        jade.core.Runtime rt = jade.core.Runtime.instance();
        
        //Creamos un contenedor de agentes
        Profile p = new ProfileImpl();
        
        p.setParameter(Profile.MAIN_HOST, host);
        p.setParameter(Profile.CONTAINER_NAME, containerName);
        
        ContainerController cc = rt.createAgentContainer(p);
        
        //Creamos un nuevo agente y ejecutamos
        AgentController ac = cc.createNewAgent(agentName,
                DBA_P2.class.getCanonicalName(), null);
        
        ac.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }
}
   
