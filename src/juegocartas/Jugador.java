package juegocartas;
/***********************************************
* Jugador.java
* Yellsmy - Eddison - Roberto - Wilson
*
* Contiene un jugador y todos sus atributos
***********************************************/

public class Jugador
{
    // Declaración del id del jugador
    private int id;
    // Declaración de los puntos del jugador
    private double puntos;

    //**************************************************************
    
    // Constructor de la clase 
    public Jugador(int id, double puntos)
    {
        this.id = id;
        this.puntos = puntos;
    }
    
    //**************************************************************

    // Metodos getter setter de la clase Jugadores
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public double getPuntos()
    {
        return puntos;
    }

    public void setPuntos(double puntos)
    {
        this.puntos = puntos;
    }

    //**************************************************************
    
    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", puntos=" + puntos + '}';
    }
}