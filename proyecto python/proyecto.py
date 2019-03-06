    #Juego de Hipodromo
#consiste en un pista de carreras de una distancia entre 1/4 de milla y 1
#milla.  En la pista pueden correr hasta 4 caballos a la vez.
#La aplicaci�n en todo momento debe mostrar un tabl�n donde se muestre la
#posici�n de cada caballo.  La carrera termina cuando cuando llega
#el primer caballo.  Cada caballo tiene un nombre y un jinete.  El avance del
#caballo depende de los siguientes 4 par�metros.
#1.  Una velocidad aleatoria 30Km/h y 40Km/h.
#2.  El peso del jinete resta 1% a la velocidad por cada 5Kg de peso.
#3.  Un retraso aleatorio entre 1s y 5s al inicio de la carrera.
#4.  Un evento aleatorio en cualquier momento que puede teminar, retrasar o
#acelerar la velocidad del caballo.
#Implementar al menos 2 eventos.  Ej.  lluvia, jinete se cae, etc.


#1/4 de milla = 0.40 km = 400 m
#1 milla = 1.6 km = 1600 m

#velocidad del caballo = 40km/h = 11.11111m/s (Redondeado a 11) y 30km/h = 8.333333m/s (redondeado a 8)

#El jockey promedio tiene una construcción ligera pero atlética y un peso que, por lo general, oscila entre 45 y 55 kg

import random
import turtle


class pista:

    def __init__(self):

        self.distancia = 0

    def mostrarPistas(self):
        print("Los tipos de pista son los siguientes: \n")
        print("[1]. Pista de carrera corta\n")
        print("[2]. Pista de carrera media\n")
        print("[3]. Pista de carrera larga\n")

        print("Seleccionando pista....\n")

    def seleccionarPistaAlAzar(self):
        pistaAlAzar = random.randint(1,3)
        if(pistaAlAzar == 1):
            distancia = 400
        elif(pistaAlAzar == 2):
            distancia = 800
        elif(pistaAlAzar == 3):
            distancia = 1600
        self.distancia = distancia


        pistaAlAzarStr = str(pistaAlAzar)
        print("La pista seleccionada para esta carrera es: [ " + pistaAlAzarStr + " ] \n")

    def mostrarAtributosPista(self):
        pistaString = str(self.distancia)
        print("La distancia de la pista seleccionada es: " + pistaString + " m")


class caballos:

    def __init__(self):

        self.nombre = ''
        self.velocidad = None
        self.jinete = []
        self.colorCaballo = ''

    def mostrarCaballos(self):


        nombre = ['Rayito','Makuin','Franchesco','Toromax','Peter','Spiderman','Sonic']
        print("Los caballos disponibles son: \n")
        for i in range(0,6):

            valor = str(i+1)
            print("["+ valor + "]. " + nombre[i] + " \n")

        print("Seleccione El caballo que se vaya a utilizar: \n")    

    def seleccionarCaballo(self,seleccion):
        seleccionInt = int(seleccion)
        nombre = ['Rayito','Makuin','Franchesco','Toromax','Peter','Spiderman','Sonic']
        for x in range(0,6):
            if(x == (seleccionInt-1)):
                self.nombre = nombre[x]

    def generarVelocidad (self,pesoJinete):
        floatPesoJinete = float(pesoJinete)
        velocidadGenerada = random.randint(8,11)
        floatVelocidadGenerada = float(velocidadGenerada)
        velocidadFinal = floatVelocidadGenerada - (floatVelocidadGenerada*((floatPesoJinete/5.0)/100.0))
        self.velocidad = velocidadFinal    

    def mostrarAtributosCaballo(self):

        print("Nombre del Caballo: "+self.nombre)
        velocidadString = str(self.velocidad)
        print("Velocidad del Caballo: " + velocidadString +" m/s")
        print("Color del caballo: " + self.colorCaballo)


    def generarColorAleatorio(self):

        color = ['blue','cyan','red','green','orange','purple','yellow','black','grey','brown','rose','pink']
        colorAleatorio = random.randint(0,11)
        self.colorCaballo = color[colorAleatorio]


class jinete:

    def __init__(self):

        self.nombre = ''
        self.peso = 0

    def seleccionarJineteAleatorio (self):
        nombresJinetes = ['Juan','Daniel','Peter','Ricardo','Steven']
        nombreAleatorio = random.randint(0,4)
        self.nombre = nombresJinetes[nombreAleatorio]

    def generarPesoAleatorio (self):
        pesoGenerado = random.randint(49,54)
        self.peso = pesoGenerado
        return pesoGenerado

    def mostrarAtributosJinete(self):
        print("Nombre del Jinete: " + self.nombre)
        pesoString = str(self.peso)
        print("Peso del Jinete: "+ pesoString + " Kg")    


class tablon:

    def __init__(self):

        self.posicion = None

class jugadores:

    def __init__(self):

        self.nombre = ''

    def setNombre(self,nombre):

        self.nombre = nombre

    def mostrarAtributosJugador(self):
        print("El nombre de este jugador es: " + self.nombre)    


#Aqui empieza la ejecucion del juego
print("Bienvenido a el juego de carreras y apuestas\n")
print("Las reglas son faciles\n")
print("Se designa al azar una pista con diferentes distancias, se selecciona un caballo al cual se va a apostar y este sera asignado con un jinete aleatorio\n")
print("La cantidad maxima por carrera es de 4 jugadores y la minima de 2")
print("Ganara el primer caballo que llegue a la meta\n")
print("Estas listo?... Presiona enter para continuar..\n")

enter = input()

print("{1}. Seleccionando el tipo de pista.... \n")
print("Nota: Si la pista es mas larga, puede que afecte mas en el comportamiento y rendimiento de los caballos\n")
    
#-------------------Aqui se debe seleccionar el tipo de pista a utilizar-----------
    
pistaPrincipal = pista()

pistaPrincipal.mostrarPistas()
pistaPrincipal.seleccionarPistaAlAzar()

pistaPrincipal.mostrarAtributosPista() #Este comando solo se utiliza para mostrar los atributos de la pista

#------------------------------Fin de el tipo de pista------------------------------
    
    
#------------------------------Inicio de jugadores----------------------------------

print("{2}. Ingrese el nombre de los jugadores que van a participar: \n")
print("Nota: Recuerde que pueden participar un maximo de 4 jugadores y un minimo de 2 por carrera\n")

#Aqui se escribe el nombre del jugador y acontinuacion pasa a realizar su apuesta

opcion = 1
jugador = 1

listaJugadores = []#Arreglo de jugadores
jinetes = []#Arreglo de jinetes
caballosJuego = [] #Arreglo de caballos

while(opcion > 0):
    if(jugador < 5):
        jugadorStr = str(jugador)
        print("Nombre del Jugador [ " + jugadorStr + " ]: ")
        
        nombre = input()
        jugadorUnitario = jugadores()
        jugadorUnitario.setNombre(nombre)
        listaJugadores.append(jugadorUnitario)

        print("Generando un jinete al azar\n")
        jineteUnitario = jinete()
        jineteUnitario.seleccionarJineteAleatorio()
        pesoJinete = jineteUnitario.generarPesoAleatorio()

        jineteUnitario.mostrarAtributosJinete() #Este comando solo se utiliza para mostrar los atributos de los jinetes
        
        jinetes.append(jineteUnitario)

        print("Seleccione a que caballo le desearia apostar: \n")
        
        #Seccion de seleccion
        caballoUnitario = caballos()
        caballoUnitario.mostrarCaballos()

        seleccion = input()

        caballoUnitario.seleccionarCaballo(seleccion)
        caballoUnitario.generarVelocidad(pesoJinete)
        caballoUnitario.mostrarAtributosCaballo() #Este comando solo se utiliza para mostrar los atributos de los caballos
        
        caballosJuego.append(caballoUnitario)

        if(jugador == 1):
            jugador += 1
        elif(jugador >= 2):
            print("Si desea ingresar otro jugador ingrese [1] si desea continuar ingrese [0] \n")
            opcion = input()
            opcion = int(opcion)
            if(opcion == 1):
                jugador+=1
    else:
        print("Limite de jugadores alcanzado \n")
        break

print("Los jugadores a participar con sus respectivos caballos y jinetes son: \n")

for i in range (0,len(listaJugadores)):
    listaJugadores[i].mostrarAtributosJugador()
    jinetes[i].mostrarAtributosJinete()
    caballosJuego[i].mostrarAtributosCaballo()
    print("\n\n")

print("Vamos a dar comienzo a la carrera de caballos! \n")

#----------------------------Fin de la seccion jugadores-----------------------------

#--------------------------inicio de la seccion de procceso--------------------------

caballosEnPartida = []

for i in range (0,len(listaJugadores)):
    caballoMovimiento = turtle.Turtle()
    caballosEnPartida.append(caballoMovimiento)

valorY = 0

for x in range (0,len(listaJugadores)):

    caballosEnPartida[x].setx(500)
    caballosEnPartida[x].sety(300-valorY)
    caballosEnPartida[x].pensize(60)
    caballosEnPartida[x].color(caballosJuego[x].color)

    valorY = 170






turtle.done()


