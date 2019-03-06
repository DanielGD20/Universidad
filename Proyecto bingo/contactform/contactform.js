jQuery(document).ready(function ($) {

  $('#botonSiguiente').hide();
  $('#botonFinal').hide();
  $("#botonUnico").hide();
  $('#contact').hide();
  $('#juego').hide();
  $('#ganador').hide();

  //Contact
  $('form.contactForm').submit(function () {
    var f = $(this).find('.form-group'),
      ferror = false,
      emailExp = /^[^\s()<>@,;:\/]+@\w[\w\.-]+\.[a-z]{2,}$/i;

    f.children('input').each(function () { // run all inputs

      var i = $(this); // current input
      var rule = i.attr('data-rule');

      if (rule !== undefined) {
        var ierror = false; // error flag for current input
        var pos = rule.indexOf(':', 0);
        if (pos >= 0) {
          var exp = rule.substr(pos + 1, rule.length);
          rule = rule.substr(0, pos);
        } else {
          rule = rule.substr(pos + 1, rule.length);
        }

        switch (rule) {
          case 'required':
            if (i.val() === '') {
              ferror = ierror = true;
            }
            break;

          case 'minlen':
            if (i.val().length < parseInt(exp)) {
              ferror = ierror = true;
            }
            break;

          case 'email':
            if (!emailExp.test(i.val())) {
              ferror = ierror = true;
            }
            break;

          case 'checked':
            if (!i.is(':checked')) {
              ferror = ierror = true;
            }
            break;

          case 'regexp':
            exp = new RegExp(exp);
            if (!exp.test(i.val())) {
              ferror = ierror = true;
            }
            break;
        }
        i.next('.validation').html((ierror ? (i.attr('data-msg') !== undefined ? i.attr('data-msg') : 'wrong Input') : '')).show('blind');
      }
    });
    f.children('textarea').each(function () { // run all inputs

      var i = $(this); // current input
      var rule = i.attr('data-rule');

      if (rule !== undefined) {
        var ierror = false; // error flag for current input
        var pos = rule.indexOf(':', 0);
        if (pos >= 0) {
          var exp = rule.substr(pos + 1, rule.length);
          rule = rule.substr(0, pos);
        } else {
          rule = rule.substr(pos + 1, rule.length);
        }

        switch (rule) {
          case 'required':
            if (i.val() === '') {
              ferror = ierror = true;
            }
            break;

          case 'minlen':
            if (i.val().length < parseInt(exp)) {
              ferror = ierror = true;
            }
            break;
        }
        i.next('.validation').html((ierror ? (i.attr('data-msg') != undefined ? i.attr('data-msg') : 'wrong Input') : '')).show('blind');
      }
    });
    if (ferror) return false;
    else var str = $(this).serialize();
    return false;
  });

  let personas = [];
  var i = 0;

  $('#submit').click(function () {

    var jugadores = {
      mail: $('#email').val(),
      nick: $('#name').val()
    };

    console.log(jugadores);
    $('#email').val('');
    $('#name').val('');

    personas.push(jugadores);

    var listaNicks = $("<li></li>").text(jugadores.nick);
    $("#listaJugadores").append(listaNicks);
    $("#botonUnico").show();
    $('#contact').show();
    console.log(personas);
  });


  /*-------------------------------------------------------------------------------------------------------*/
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
    var celdas = 1;
    var body = document.getElementById('tablas');
    var div = document.createElement('div');
    var nombrePersona = document.createElement("p");
    nombrePersona.innerHTML = nombre;
    nombrePersona.setAttribute('id', 'nombrePersona');
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
          celda.setAttribute("class", "bingo");
        } else {
          var numero = generarNumero(1, 90);
          jugador.push(numero);
          var textoCelda = document.createTextNode(numero.toString());
          celda.setAttribute("id", "celda"+celdas);
          celdas++;
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
    div.appendChild(nombrePersona);
    div.appendChild(tabla);

    body.appendChild(div);
    /*aqui se agrega el valor del jugador al arreglo de jugadores*/
    variosJugadores.push(jugador);
    jugador = [];
    guardado = [];
    // modifica el atributo "border" de la tabla y lo fija a "2";
    $(".bingo").css("background-color","skyblue");
    div.setAttribute('class', 'col-md-6 text-center');
    div.setAttribute('id', 'divTablas');
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
    $('#numeros').text(textoInterno);
  };



  $("#botonUnico").click(function () {
    for (var i = 0; i < personas.length; i++) {
      console.log("iteracion " + i);
      var persona = personas[i].nick;
      genera_tabla(persona);
    };
    $('#botonUnico').hide();
    $('#botonSiguiente').show();
    $('#works').hide();
    $('#trabajos').hide();
    $("#botonSiguiente").text("Primer Numero");
    $('#juego').show();
  });



  $("#botonSiguiente").click(function () {
    $("#botonSiguiente").text("Siguiente Numero");
    var numeroNuevo = generarNumero(1, 90);

    console.log(numeroNuevo);
    if (numeroNuevo != null) {

      mostrarNumero(numeroNuevo);

      for (var i = 0; i < variosJugadores.length; i++) {


        var found = variosJugadores[i].find(function (element) {
          return element == numeroNuevo;
        });


        if (found != undefined) {
          console.log("el valor " + found + " si se encuentra - tabla: " + (i + 1));
          variosJugadores[i].splice(variosJugadores[i].indexOf(found), 1);
          if (variosJugadores[i].length == 0) {
            $('#nombre').value = personas[i].nick;
            $('#ganador').show();
            $('#botonSiguiente').hide();
            $("#numeros").hide();
            $('#botonFinal').show();
          };
        } else {
          console.log("el valor " + found + " no se encuentra - tabla: " + (i + 1));
        };
      };
    } else {
      mostrarNumero("Game Over");
      $('#botonSiguiente').hide();
      $("#numeros").hide();
      $('#botonFinal').show();
    };
  });

  $('#botonFinal').click(function () {
    location.reload();
  });

  $('#celda1').click(function () {
    console.log("clicaste una celda");
    $("#celda1").css({"background-color":"green", "font-color":"blue"});
  });

});