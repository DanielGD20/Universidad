
var personas = new Array();
let i: number = 0;

function abrirNuevaVentana(){
    let url = 'tabla.html';
    let nuevaVentana = window.open(url,"Bienvenidos Jugadores");
}

document.getElementById('boton1').onclick = function () {

    let correo = (<HTMLInputElement>document.getElementById('email')).value;
    let nickname = (<HTMLInputElement>document.getElementById('nick')).value;

    var jugadores: object = {
        mail: correo,
        nick: nickname,
    };

    console.log(jugadores);

    (<HTMLInputElement>document.getElementById('email')).value = '';
    (<HTMLInputElement>document.getElementById('nick')).value = '';

    personas.push(jugadores);

    let nuevoNick = document.createElement('LI').appendChild(document.createTextNode(jugadores.nick));
    let lista = document.getElementById('lista');
    let salto = document.createElement('br')
    lista.insertBefore(nuevoNick, lista.childNodes[i]);
    i++;
    lista.insertBefore(salto, lista.childNodes[i]);
    i++;
};

document.getElementById('boton1').onauxclick = function () {
    console.log(personas);
};

document.getElementById('boton2').onclick = function () {

    localStorage.setItem("personas", JSON.stringify(personas));

    for (let i: number = 0; i < personas.length; i++) {
        console.log(personas[i]);
    };

    abrirNuevaVentana();
};

