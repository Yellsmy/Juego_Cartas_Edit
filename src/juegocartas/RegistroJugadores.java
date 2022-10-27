package juegocartas;
import java.util.ArrayList;
import java.util.List;
/***********************************************
* RegistroJugadores.java
* Yellsmy - Eddison - Roberto - Wilson
*
* Registra todos los jugadores que son parte del juego
***********************************************/

public class RegistroJugadores
{
    // Declaración de una lista que almacenará todos los jugadores
    List<Jugador> registroJugadores = new ArrayList<Jugador>();

    //**************************************************************
    
    // Constructor vacío
    public RegistroJugadores()
    {
    }

    //**************************************************************
    
    // Método get y set de la clase RegistroJugadores
    public List<Jugador> getRegistroJugadores()
    {
        return registroJugadores;
    }

    public void setRegistroJugadores(List<Jugador> registroJugadores)
    {
        this.registroJugadores = registroJugadores;
    }
    
    //**************************************************************
    
    // Método para agregar un jugador al registro
    // @param Jugador: Recibe un jugador
    public void addJugadoresRegistro (Jugador jugador)
    {
        registroJugadores.add(jugador);
    }

    //**************************************************************
    
    // Muestra un jugador de la lista
    @Override
    public String toString()
    {
        return "RegistroJugadores{" + "registroJugadores=" + registroJugadores + '}';
    }
}
