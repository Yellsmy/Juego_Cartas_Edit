package juegocartas;
import java.util.Scanner;
/***********************************************
* Juego.java
* Yellsmy - Eddison - Roberto - Wilson
*
* Contiene todas las funciones que construyen el juego
* Hereda y hace uso de la clase Baraja
***********************************************/

public class Juego  extends Baraja
{
    // Instancia de la clase RegistroJugadores
    RegistroJugadores listaJugadores = new RegistroJugadores();
    Scanner sc = new Scanner(System.in);
    // Creación de array que contiene el índice de los jugadores
    Integer[] indiceJugador;

    //**************************************************************
    
    // Constructor vacío
    public Juego()
    {
    }
    
    //**************************************************************
    
    // Registra un jugador y los ingresa en la lista de registro
    // @param idJugador: Recibe el id del jugador para registrarlo en la lista
    public void registrar(int idJugador)
    { 
        Carta carta = repartirCarta();// primera carta a asignar
        double puntosCarta= valorCartaRepartida(carta.getIdentificadorCarta()); //obtenemos el valor de la carta asignada
        Jugador jugadorX = new Jugador(idJugador,puntosCarta ); // generamos un nuevo jugador y sus puntos 
        listaJugadores.addJugadoresRegistro(jugadorX); // agregamor el jugador 
        //generamos informacion asignada 
        System.out.println("\033[32m¡Hola Jugador "+idJugador+"!");
        System.out.println("\033[33mTu carta inicial es "+carta);
        System.out.println("\033[33mTus puntos iniciales son: "+ puntosCarta);
        System.out.println("");
    }
    
    //**************************************************************
    
    /* Asigna un valor a cada carta dependiendo de su id
     * @param cartaRepartida: Carta del jugador para asignarle un valor
     * @param tipoMazo: Tipo de mazo dependiendo del tipo de juego elegido al inicio
     * @method contains: devuelve verdadero si @cartaRepartida contiene el valor evaluado en el IF
     * si la evaluacion IF anidado es verdaera retorna el valor asignado a la carta
     */
    public double valorCartaRepartida(String idenCartaRepartida)
    {
        if(idenCartaRepartida == "As")
        {
            return 1;
        }

        else if (idenCartaRepartida == "J" || idenCartaRepartida == "K" || idenCartaRepartida =="Q")
        {
            return 0.5;
        }
        else 
        {
            return Double.parseDouble(idenCartaRepartida);

        }
            
        //return 0;
    }
    
    //**************************************************************
    
    // Reparte una carta al jugador
    public Carta repartirCarta()
    {
        
        Carta cartaRepartida=null;//almacena una carta asignada de forma aleatoria

        for (int i = 0; i < 1; i++)//realizaa la asignacion de carta una vez por jugador
        {
            if(i >= mazoBarajeadoD.size())// validamos que el valor tamaño del mazo sea almenos de 1 carta para poder asignarla 
            {
                //capturar error de cartas insuficientes
                try
                {
                    
                    cartaRepartida=mazoBarajeadoD.stream().findFirst().get(); //obtenemos una carta del mazo
                    System.out.println("\033[36mBANCA REPARTE LA CARTA "+cartaRepartida); // la Banca muestra la carta a los jugadores 
                    mazoBarajeadoD.remove(cartaRepartida);//Eliminamos la carta para que no pueda ser asignada nuevamente 
                }
                catch(ArrayIndexOutOfBoundsException error)
                {
                    System.out.println("Lo sientimos Cantidad de cartas insuficiente para el ultimo jugador inicia de nuevo");
                    break;
                }
            }
            else
            {
                cartaRepartida=mazoBarajeadoD.stream().findFirst().get();  //obtenemos una carta del mazo
                System.out.println("\033[36mBANCA REPARTE LA CARTA "+cartaRepartida); // la Banca muestra la carta a los jugadores 
                mazoBarajeadoD.remove(cartaRepartida); //Eliminamos la carta para que no pueda ser asignada nuevamente 
            }
        }
        //retornamos el nombre de carta y su valor en la variable @cartaRepartida
        return cartaRepartida;
    }
    
    //**************************************************************
    
    /* Suma los puntos acumulados + los puntos de la carta repartida al jugador
     * @param id Jugador: Recibe el id del jugador para asignarle los puntos
     * @param puntosCarta: Recibe los puntos de la carta repartida al jugador
     * @method get: obtener el valor de la clase utilizada
     * @method size: obtener el tamaño de un listado
     * @method set: asignacion de valor para punto
     */
    public double agregarCartaJugador(int idJugador, double puntosCarta)
    {
        double totalPuntos = 0;
        for (int i = 0; i <listaJugadores.registroJugadores.size(); i++)
        {
            if(listaJugadores.registroJugadores.get(i).getId()==idJugador)// valida que la suma se realice si el id del jugador es igual al indice del jugador 
            {
                double puntosAcumulados=listaJugadores.registroJugadores.get(i).getPuntos();//obtenemos los puntos del jugador
                totalPuntos = puntosCarta+puntosAcumulados; // acumulamos los puntos
                listaJugadores.registroJugadores.get(i).setPuntos(totalPuntos); // asignamos los nuevos puntos 
            }
        }
        return totalPuntos;// retornamos el valor de los puntos 
    }   
    
    //**************************************************************
    
    /* Busca al jugador con el punteo más cercano al límite de puntos dependiendo del
     * tipo de juego que esté en ejecución 
    */
    public Jugador ganador(){
        Jugador jugador = listaJugadores.registroJugadores.get(0);
        //comparamos los puntos de los jugadores segun su id
        for (int i = 0; i <listaJugadores.registroJugadores.size(); i++)
        {
            if(listaJugadores.registroJugadores.get(i).getPuntos()> jugador.getPuntos()){
                jugador = listaJugadores.registroJugadores.get(i);
            }
        }
        return jugador;
    }
    
    //**************************************************************
    
    // Llena el array con los índices de cada jugador, recibe la cantidad de jugadores
    public void jugadores(int jugadores )
    {
        indiceJugador=new Integer[jugadores];//instanciamos la variable global @indiceJugador
        for(int i = 0; i < jugadores; i++)
        {
            indiceJugador[i] = i+1;// asignamos el valor del indice del arreglo mas uno segun la cantidad de jugadores ingresadas 
        }
    }
    
    //**************************************************************
    
    // Establece el límite de puntos para ganar, dependiendo del tipo de juego elegido al inicio
    public double limitePuntos(int tipoMazo)
    {
        if(tipoMazo ==1){
            return 10.5;
        }
        else if(tipoMazo == 2){
            return 7.5;
        }
        return 0;
    }
    
    //**************************************************************
    
    /* Da un turno a cada jugador para que elija si toma una carta o no
     * Si en una ronda todos los jugadores deciden no tomar una carta, finaliza el juego
     * Y llama a los métodos auxiliares para elegir al jugador ganador
     * @param tipoMazo: Recibe el tipo de mazo dependiendo el tipo de juego elegido al inicio
    */
    public int turnoJugadores(int tipoMazo)
    {
        /* 
        * @param cartaRepartida: almacena la carta asignada de forma aleatoria
        * @param continuar: control para el ciclo WHILE para seguir los turnos hasta que se cambie el valor a falso
        * @param valorCarta: almacena el valor flotante de la carta para pasar a la suma de puntos acumulados
        * @param No: vairable de control para paso de turnos se evalua con respecto a la cantidad de jugadores segun @indiceJugador
        */
        Carta cartaRepartida;
        boolean continuar = true;
        double valorCarta;
        int No;

        while(continuar){
            No=0;//la variable se resetea si alguno de los jugadores pidio carta 
            
            for (int i = 0; i < indiceJugador.length; i++)
            {
                System.out.println("");
                
                System.out.println("\033[33mJugador "+indiceJugador[i]+" \033[31mPedir una carta? \033[32m1=Si \033[37m- \033[31m2=No");
                int pedirCarta = sc.nextInt();// capturamos el valor segun la seleccion del jugador
                if(pedirCarta==1)// validacion si la opcion es 1 
                {
                    cartaRepartida=repartirCarta(); //asignacion de carta aleatoria
                    valorCarta=valorCartaRepartida(cartaRepartida.getIdentificadorCarta()); //obtenemos el valor de la carta asignada
                    double puntos = agregarCartaJugador((i+1),valorCarta);// Realizamos acumulacion de puntos segun carta asginada, puntos de jugador y id de jugador

                    System.out.println("\033[33mJugador "+indiceJugador[i]+" \033[35mcarta repartida \033[33m"+cartaRepartida+" \033[35mpuntos de Carta \033[33m"+valorCarta);
                    System.out.println("\033[35mPuntos acumulados: \033[33m"+puntos);
                    double limitePuntos = limitePuntos(tipoMazo);//recuperamos 10.5 o 7.5 segun tipo de Mazo
                    
                    
                    if(puntos== limitePuntos){//validamos puntos de jugador para asignar ganador
                        System.out.println("\033[32m¡FELICIDADES JUGADOR "+indiceJugador[i]+"!");
                        System.out.println("       \033[32mHAS GANADO       ");
                        return 0;
                    }
                    else if(puntos> limitePuntos){//validamos puntos de jugador para asignar perdedor
                        System.out.println("\033[31mLo sentimos Jugador "+indiceJugador[i]);
                        System.out.println(" \033[31mHas perdido");
                        listaJugadores.registroJugadores.remove(i);
                        return 0;
                    } 
                    

                }
                else if(pedirCarta==2)
                {
                    No +=1;// aunto-incrementa segun los jugadores que pasen turno
                    System.out.println("\033[33mJugador "+indiceJugador[i]+" \033[31mPASO TURNO");
                }
                else
                {
                    
                    System.out.println("Error opcion invalida");
                    continuar = false;
                }
                // Si la variable @NO tiene el mismo valor que la cantidad de jugadores segun el indice
                // indica que todos los jugadores pasaron turno por lo que se detiene el ciclo
                if(No == indiceJugador.length )
                {
                    continuar = false;
                }
            }
        }
        return 0;
    }
     
}