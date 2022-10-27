package juegocartas;
/***********************************************
* JuegoCartas.java
* Yellsmy - Eddison - Roberto - Wilson
*
* Main ejecuta el método para elegir el tipo de juego el cual ejecuta 
* las funciones necesarias para jugar.
***********************************************/

//Libreria para ingresar valores por la consola
import java.util.Scanner;

public class JuegoCartas 
{
    
    //inicializamos objeto que permite el ingreso de valores 
    Scanner op = new Scanner(System.in);
    //**************************************************************
    
    /* Ejecuta las funciones que construyen el juego
     * @param tipoMazo: tipo de mazo que se necesita para el juego
     */
    public void jugar(int tipoMazo)
    {
        
        //Instancia de la clase juego
        Juego jugar = new Juego();
        boolean salir = false;
        int opcion;
        while(!salir)
        {
            //Mesaje de juego segun el tipo de mazo 
            if(tipoMazo==1)
            {
                System.out.println("");
                System.out.println("|---------------**BIENVENIDO**-------------|"); 
                System.out.println("|        **JUEGO CARTAS 10 Y MEDIO**        |");
                System.out.println("|  1. Start                                |");
                System.out.println("|  0. Regresar                             |");
                System.out.println("| ----------Selecciona la opción---------- |");
            }
            else if (tipoMazo==2)
            {
                System.out.println("");
                System.out.println("|---------------**BIENVENIDO**-------------|"); 
                System.out.println("|        **JUEGO CARTAS 7 Y MEDIO**        |");
                System.out.println("|  1. Start                                |");
                System.out.println("|  0. Regresar                             |");
                System.out.println("| ----------Selecciona la opción---------- |");
            }
            else
            {
                System.out.println("El valor ingresado es incorrecto");
                break;
            }
            // Variables que almacenan el dato ingresado por consola
            opcion = op.nextInt();
            op.nextLine();

            switch(opcion)
            {
                case 1:
                    //Creacion de la baraja
                    jugar.llenarMazo(tipoMazo);
                    //Barajear cartas
                    jugar.barajear(tipoMazo);

                    //asignacion de jugadores dinamica
                    System.out.println("Cuántos jugadores? ");
                    int cantidadJugadores = op.nextInt();

                    if(cantidadJugadores > 10)// validamos una cantidad minima de jugadores 
                    {
                        System.out.println("Lo sentimos, la cantidad máxima de jugadores es 10");
                        salir = true;
                    }
                    else
                    {
                        op.nextLine();
                        jugar.jugadores(cantidadJugadores);
                        for (int i=0; i < cantidadJugadores; i++)
                        {
                            jugar.registrar(i+1,tipoMazo);  //registramos los jugadores y asignamos la primera carta y puntos de forma aleatoria
                        }
                        
                        jugar.turnoJugadores(tipoMazo);// inician los turnos segun el registro de jugadores
                        try{//si en caso no existe ganador capturamos el error para no detener el juego
                            Jugador ganador =jugar.ganador();// buscamos si existe ganador dentro de los jugadores
                            System.out.println("\033[32mFELICIDADES JUGADOR "+ganador.getId());
                            System.out.println("\033[32mHas ganado con \033[33m"+ganador.getPuntos()+ " \033[32mpuntos");
                            System.out.println("\033[31mFIN DE PARTIDA");

                        }catch(IndexOutOfBoundsException error){
                            System.out.println("\033[31mFIN DE PARTIDA");
                        }
                    }
                    salir = true;
                    break;
                case 0:
                    salir = true;               
                    break;
                default:
                    System.out.println("La opción ingresada es incorrecta");          
            } 
        }    
    }
    
    //**************************************************************
    
    // Elección del tipo de juego que el jugador quiere jugar
    public void tipoDeJuego() 
    {

        boolean salir = false;
        while(!salir){
            System.out.println("\033[37m");
            System.out.println("|------------**BIENVENIDO**------------|"); 
            System.out.println("| ¿Qué tipo de juego deseas jugar?     |");
            System.out.println("|  1. 10 y medio                       |");
            System.out.println("|  2. 7 y medio                        |");
            System.out.println("|  0. SALIR                            |");
            System.out.println("| --------Selecciona la opción-------- |");
            int opcion = op.nextInt();
            op.nextLine();
            if( opcion == 0)
            {
                salir = true;
            }
            else
            {
                jugar(opcion);
            }
        }
    }
    
    //**************************************************************
    
    public static void main(String[] args)  
    {
        // Instancia de la clase JuegoCartas
        JuegoCartas juego = new JuegoCartas();
        
        // Inicio del juego
        juego.tipoDeJuego();
        
    }//End main

}//End clase JuegoCartas

