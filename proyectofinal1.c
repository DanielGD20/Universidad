#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <time.h> //para generar numeros aleatorios
#include <windows.h> //para alterar la interfaz de usuario

#define tamaño 8
#define turnos 2

//esta funcion retorna un valor entero que es la suma y por consiguiente debe ser asignado a una variable
int laberinto(int tabla[tamaño][tamaño], int *prtposF, int *ptrposC, int *ptrchacal);

//esta funcion solo es una procedimiento por lo que no retorna ningun valor
void aleatorio(int tabla[tamaño][tamaño]);

void main() {
	//asignacion de color 
	system("color 70");

	int total1, total2, posF = 0, posC = 0, chacal = 0, jugador = 0, repetir = 1, a;
	int *prtposF, *ptrposC, *ptrchacal;
	
	//asignacion de los punteros
	prtposF = &posF;
	ptrposC = &posC;
	ptrchacal = &chacal;
	
	int tabla[tamaño][tamaño] = { {0} };
	srand(time(NULL));

	//añadir un nombre a la consola
	SetConsoleTitle("Juego Chacales");



	//Funcion por turnos
	do {

		printf("\t\t\t\t\t\t\t\t\tBIENVENIDO\n\n");
		printf("El juego consiste en una generacion de numeros aleatorios, se gana obteniendo el mayor puntaje de la suma de los mismos, la unica condicion es que si dentro de los numeros existen tres 0, la cuenta se detendra y se sumaran los puntos hasta el tercer cero... SUERTE!!\n\n");
		printf("Jugadores disponibles: [1][2]\n\n");
		printf("\t\t\t\t\t\t\t\tPRESIONE ENTER PARA CONTINUAR...\n\n");
		_getch();
		system("cls");

		for (int f = 1; f <= turnos; f++) {

			if (f == 1) {

				//inicio para el jugador 1

				printf("\n");
				printf("\t\t\t\t\t\t\t\t\t  Jugador [%d]", f);
				printf("\n");
				printf("\t\t\t\t\t\t\t\t\t[Presione enter]\n\n");
				_getch();

				//Asignacion de valores aleatorios para el jugador 1

				aleatorio(tabla);

				//Print de la matriz del jugador 1
				printf("SU MATRIZ ES: \n\n");
				for (int i = 0; i < tamaño; i++) {
					for (int k = 0; k < tamaño; k++) {
						printf("%d\t", tabla[i][k]);
					}
					printf("\n");
				}
				//Inicio de la funcion para el jugador 1
				printf("\n\n");
				total1 = laberinto(tabla, prtposF, ptrposC, ptrchacal);

				//Resultados finales del jugador 1
				printf("\t\t\t\t\t\t\t\t\t  Resultados: \n\n");
				printf("La suma total es: %d \n\n", total1);
				printf("Se finalizo en: \n\n");
				printf("[A] Fila: %d \n", posF);
				printf("[B] Columna: %d \n\n", posC);
				printf("El numero de ceros es: %d \n", chacal);
				printf("\n\n");
				_getch();
				//borrado de pantalla
				system("cls");

			}
			else {
				if (f == 2) {

					//inicio del jugador 2

					printf("\n");
					printf("\t\t\t\t\t\t\t\t\t  Jugador [%d]", f);
					printf("\n");
					printf("\t\t\t\t\t\t\t\t\t[Presione enter]\n\n");
					_getch();

					//asignacion de valores aleatorios para la matriz del jugador 2

					aleatorio(tabla);

					//print de la matriz para el jugador 2

					printf("SU MATRIZ ES: \n\n");
					for (int i = 0; i < tamaño; i++) {
						for (int k = 0; k < tamaño; k++) {
							printf("%d\t", tabla[i][k]);
						}
						printf("\n");
					}

					//Inicio de la funcion para el jugador 2

					printf("\n\n");
					total2 = laberinto(tabla, prtposF, ptrposC, ptrchacal);

					//Resultados finales del jugador 2
					printf("\t\t\t\t\t\t\t\t\t  Resultados: \n\n");
					printf("La suma total es: %d \n\n", total2);
					printf("Se finalizo en: \n\n");
					printf("[A] Fila: %d \n", posF);
					printf("[B] Columna: %d \n\n", posC);
					printf("El numero de ceros es: %d \n", chacal);
					printf("\n\n");
					_getch();
					//borrado de pantalla
					system("cls");
				}
			}
		}

		//Print de el ganador con una comparacion entre la suma total de los 2 jugadores
		printf("\t\t\t\t\t\t\t\t\t  EL GANADOR ES...\n\n");
		if (total1 > total2) {
			printf("El jugador numero [1]\n");
			_getch();
		}
		else {
			if (total1 < total2) {
				printf("El jugador numero [2]\n\n");
				_getch();
			}
		}
		
		//Menu de juego

		printf("\t\t\t\t\t\t\t\tPara volver a jugar ingrese [1]\n\n");
		printf("\t\t\t\t\t\t\t\tPara salir ingrese [0]\n\n");

		//escaneo de la opcion

		scanf_s("%d", &a);
		printf("\n\n");
		repetir = a;
		if (repetir == 1) {
			//borrado de pantalla
			system("cls");
		}
		//Si en usuario ingresa 0 se deja de cumplir la funcion del while y por ende sale del mismo
	} while (repetir != 0);

	//Titulos finales y creditos

	printf("\t\t\t\t\t\t\t\t\t[GRACIAS POR JUGAR]\n\n");
	printf("\n\n\n\nAnthony Villegas 2018 - advillegas@uees.edu.ec\n");
	_getch();
}



//Funcion para ingresar numeros aleatorios dentro de la tabla principal

void aleatorio(int tabla[tamaño][tamaño]) {
	for (int i = 0; i < tamaño; i++) {
		for (int k = 0; k < tamaño; k++) {
			if (i == k) {
				tabla[i][k] = (rand() % 10);
			}
			else {
				if (k == tamaño - 1) {
					tabla[i][k] = (rand() % 10);
				}
			}
		}
	}
}

//Funcion para recorrer los numeros aleatorios generados en la tabla

int laberinto(int tabla[tamaño][tamaño], int *prtposF, int *ptrposC, int *ptrchacal) {
	int chacal = 0;
	int suma = 0;
	printf("\n\n");

	//recorrido de la diagonal

	for (int i = 0; i < tamaño; i++) {
		for (int k = 0; k < tamaño; k++) {
			//si i es igual a k se sabe que nos encontramos en la primera parte de la diagonal
			if (i == k) {
				//si tabla de i y k es 0 significa que se ha encontrado un chacal y por ende hay que sumarlo
				if (tabla[i][k] == 0) {
					chacal++;
					//si se encuentran 3 chacales la funcion debe devolver la posicion donde se encuentra y finalizar el for
					if (chacal == 3) {
						*prtposF = i;
						*ptrposC = k;
						*ptrchacal = chacal;
						break;
					}
					else {
						//si por el contrario chacal solo llega de 0 a 2 entonces se devuelve la ultima posicion de la suma
						if (chacal == 0 || chacal == 1 || chacal == 2) {
							*prtposF = i;
							*ptrposC = k;
							*ptrchacal = chacal;
						}
					}
				}
				else {
					//si tabla de i y k no es 0 entonces se procede a hacer una suma acumulativa
					if (tabla[i][k] != 0) {
						suma = suma + tabla[i][k];
					}
				}
			}
		}
	}
	//recorrido de la ultima fila
	//se sabe que la ultima fila es tamaño definido arriba menos 2 para no sumar el ultimo digito de la diagonal otra vez
	//por lo que debemos situarnos en ese punto para el primer for

	for (int i = tamaño - 2; i < tamaño; i--) {

		//en el segundo for necesitamor restar 1 del tamaño para obtener el valor de la ultima columna y realizar el recorrido

		for (int k = tamaño - 1; k == tamaño - 1; k++) {

			//se efectua la condicion que sirve para saber los chacales de esta columna
			//esta condicion se aplica sabiendo que el for va a restar i y por consiguiente en un futuro nos dara numeros negativos
			//que si llegan a aplicarse nos daria error

			if (i >= 0) {
				if (tabla[i][k] == 0) {
					chacal++;
					//se hace la comparativa para saber si se ha llegado o no a los chacales correspondientes y asi
					//devolver las posiciones

					if (chacal == 3) {
						*prtposF = i + 1;
						*ptrposC = k + 1;
						*ptrchacal = chacal;
						break;
					}
				}
				else {
					if (tabla[i][k] != 0) {
						suma = suma + tabla[i][k];
					}
						//si por el contrario los chacales no llegan a 3 se debe enviar la ultima posicion de la suma
						//y los chacales encontrados hasta el momento

					if ((chacal == 0 || chacal == 1 || chacal == 2) && i >= 0) {
						*prtposF = i + 1;
						*ptrposC = k + 1;
						*ptrchacal = chacal;
					}
				}
			}
			else {
				break;
			}
		}
		//se sabia que i bajaria hasta numeros negativos por lo que esta condicion nos ayudara a controlar el for

		if (i < 0) {
			break;
		}
	}
	//finalmente se retorna la suma de todos los digitos de la diagona y la vertical
	return suma;
}