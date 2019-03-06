/*aqui se guardan los numero que van apareciendo para que no se repitan*/
var guardado = new Array();
/*aqui estan los arreglos que se encargan de guardar las variables de cada jugador*/
var jugador = new Array();
var variosJugadores = new Array();
/*fin de los arreglos*/
Array.prototype.sortNumbers = function () {
    return this.sort(function (a, b) {
        return a - b;
    });
};

console.log(personas);
/*Funcion de la tabla*/
function genera_tabla(nombre) {
    // Obtener la referencia del elemento body
    var body = document.getElementById('tablas');
    var salto = document.createElement("br");
    var nombrePersona = document.createElement("h3").appendChild(document.createTextNode(nombre));
    var bingo = new Array();
    bingo.push("B");
    bingo.push("I");
    bingo.push("N");
    bingo.push("G");
    bingo.push("O");
    // Crea un elemento <table> y un elemento <tbody>
    var tabla = document.createElement("table");
    var tblBody = document.createElement("tbody");
    // Crea las celdas
    for (var i = 0; i < 6; i++) {
        // Crea las hileras de la tabla
        var hilera = document.createElement("tr");
        for (var j = 0; j < 5; j++) {
            // Crea un elemento <td> y un nodo de texto, haz que el nodo de
            // texto sea el contenido de <td>, ubica el elemento <td> al final
            // de la hilera de la tabla
            var celda = document.createElement("td");
            if (i == 0) {
                var textoCelda = document.createTextNode(bingo[j]);
            } else {
                var numero = generarNumero(1, 90);
                jugador.push(numero);
                var textoCelda = document.createTextNode(numero.toString());
            };
            celda.appendChild(textoCelda);
            hilera.appendChild(celda);
        };
        // agrega la hilera al final de la tabla (al final del elemento tblbody)
        tblBody.appendChild(hilera);
    };
    // posiciona el <tbody> debajo del elemento <table>
    tabla.appendChild(tblBody);
    // appends <table> into <body>
    body.appendChild(nombrePersona);
    body.appendChild(salto);
    body.appendChild(tabla);
    body.appendChild(salto);
    /*aqui se agrega el valor del jugador al arreglo de jugadores*/
    variosJugadores.push(jugador);
    jugador = [];
    guardado = [];
    // modifica el atributo "border" de la tabla y lo fija a "2";
    tabla.setAttribute("class", "tablas");
};

function repetido(num) {
    var repe = false;
    for (var i = 0; i < guardado.length; i++) {
        if (num == guardado[i]) {
            repe = true;
        };
    };
    return repe;
};

function generarNumero(min, max) {
    if (guardado.length != (max - min)) {
        while (repe != false) {
            var num = Math.floor(Math.random() * (max - min + 1)) + min;
            var repe = repetido(num);
        };
        guardado.push(num);
        return num;
    } else {
        return null;
    };
};

function mostrarNumero(textoInterno) {
    document.getElementById("numero").innerHTML = textoInterno;
};

$("#botonUnico").click(function () {
    $('#botonUnico').text('Siguiente Numero');
    for (var i = 0; i < personas.length; i++) {
        console.log("iteracion " + i);
        var persona = personas[i].nick;
        genera_tabla(persona);
    };
    $("#botonUnico").attr('id', 'botonSiguiente');
});



$("#botonSiguiente").click(function () {
    var numeroNuevo = generarNumero(1, 90);
    if (numeroNuevo != null) {
        mostrarNumero(numeroNuevo.toString());
        for (var i = 0; i < variosJugadores.length; i++) {
            var found = variosJugadores[i].find(function (element) {
                return element == numeroNuevo;
            });
            if (found != undefined) {
                console.log("el valor " + found + " si se encuentra - tabla: " + (i + 1));
                variosJugadores[i].splice(variosJugadores[i].indexOf(found), 1);
                if (variosJugadores[i].length == 0) {
                    console.log("Ganaste " + personas[i].nick);
                    alert("Ganaste " + personas[i].nick);
                    $('#botonUnico').text('Reiniciar Juego');
                    $("#botonUnico").attr('id', 'botonfinal');
                };
            } else {
                console.log("el valor " + found + " no se encuentra - tabla: " + (i + 1));
            };
        };
    } else {
        mostrarNumero("Game Over");
    };
});

$('#botonFinal').click(function () {
    jugador = [];
    guardado = [];
    $('#listaJugadores').remove('li');
});