#include <stdlib.h>
#include <stdio.h>
#include <string.h> //se utiliza para las cadenas de texto
#include <windows.h> //sirve para alterar la estructura de usuario

#define tamaño 15

//la primera funcion es una secuencia de procedimientos por lo que no devuelve ningun valor
void hashing(char palabra[tamaño], char matriz[tamaño][tamaño]);

//la segunda funcion nos devuelve el valor de la columna en la que se encuentra
int buscar(char matriz[tamaño][tamaño], char clave);

void main() {
	//esta funcion sirve para agregar el nombre a la consola
	SetConsoleTitle("Tabla Hash");

	//esta funcion sirve para editar la interfaz de usuario con colores
	system("color 70");

	//se inicializa la palabra
	char palabra[] = "Electroencefalografia";
	char matriz[tamaño][tamaño] = { { NULL } };
	char clave;
	int resultado = 0, tamaño_palabra = 0, busqueda = 1;
	

	//print de la interfaz 
	printf("\t\t\t\t\t\tTABLA HASH\n\n");
	printf("Una tabla hash nos permite agregar valores dentro de una matriz para facilitar su busqueda\n\n");
	
	printf("Palabra dentro de la tabla hash: %s \n\n", palabra);

	printf("\t\t\t\t\tPRESIONE ENTER PARA CONTINUAR...\n");
	_getch();

	//encerado de la matriz

	for (int i = 0; i < tamaño; i++) {
		for (int k = 0; k < tamaño; k++) {
			matriz[i][k] = '0';
		}
	}
	
	//funcion de hashing
	printf("Matriz Hash \n\n");
	hashing(palabra, matriz);


	printf("\n\n");
		
		//aplicacion de la funcion para la busqueda de valores

		printf("INGRESE UN VALOR A BUSCAR DENTRO DE LA TABLA HASH: ");
		scanf_s("%c", &clave);
		resultado = buscar(matriz, clave);
		printf("SE ENCUENTRA EN LA COLUMNA: %d\n\n\n", resultado);

	// creditos finales

printf("\t\t\t\tAnthony Villegas 2018 - advillegas@uees.edu.ec\n");
	_getch();
}

//inicio de la funcion procedimiento

void hashing(char palabra[tamaño], char matriz[tamaño][tamaño]) {
	int clave = 0;
	//se generan 2 for que controlen los puntos X y Y de la matriz
	for (int i = 0; i < tamaño; i++) {
		clave = palabra[i] % tamaño; //clave pasa a ser un valor numerico que determina la posicion donde se pondra la letra
		for (int k = 0; k < tamaño; k++) {

			//si la matriz de puntos clave,k es igual a '0' entra si no es asi se repite el for para asignar otra posicion
			if (matriz[clave][k] == '0') {
				matriz[clave][k] = palabra[i];
				break;
			}
		}
	}
	//print de la tabla hash

	for (int i = 0; i < tamaño; i++) {
		for (int k = 0; k < tamaño; k++) {
			printf("%c\t", matriz[i][k]);
		}
		printf("\n");
	}
}


//funcion para buscar dentro de la tabla hash

int buscar(char matriz[tamaño][tamaño], char clave) {

	for (int i = 0; i < tamaño; i++) {
		for (int k = 0; k < tamaño; k++) {
			if (matriz[i][k] == clave) { //si dentro de la matriz i,k existe la clave enviada del main se retorna la posicion de k+1
										//asi se sabe que esta en esa columnna sin contar desde 0
				return k+1;
			}
		}
	}

	//si por el contrario no se encuentra la letra dentro de la matriz se retornara -1
	return -1;
}