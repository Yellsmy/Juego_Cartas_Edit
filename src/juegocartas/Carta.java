package juegocartas;
/***********************************************
* Carta.java
* Yellsmy - Eddison - Roberto - Wilson
*
* Metodos para asignar, obtener carta, concatenacion de identificador de carta y palo de carta
***********************************************/

public class Carta 
{
    String palo;
    char simboloAscii;
    String identificadorCarta;

    //**************************************************************
    //Metodo constructor
    public Carta(String palo,char simboloAscii, String identificadorCarta)
    {
        this.palo = palo;
        this.simboloAscii = simboloAscii;
        this.identificadorCarta = identificadorCarta;
    }

    //**************************************************************
    // Metodos getter setter de la clase cartas
    public String getPalo() 
    {
        return palo;
    }

    public void setPalo(String palo) 
    {
        this.palo = palo;
    }

    public String getIdentificadorCarta() 
    {
        return identificadorCarta;
    }

    public void setIdentificadorCarta(String identificadorCarta) 
    {
        this.identificadorCarta = identificadorCarta;
    }

    //**************************************************************
    @Override
    public String toString() 
    {
        // return identificadorCarta + " " + simboloAscii+ " "+ palo ;
        String carta=String.format("\nCarta de tipo %s \n|-----| \n|%s %s %s| \n|_____|",palo, simboloAscii,identificadorCarta, simboloAscii);
        return carta;
    }
}
