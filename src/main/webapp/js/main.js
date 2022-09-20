var email = new URL(location.href).searchParams.get("email");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle = "tooltip"]').tooltip;
    });


    getUsuario().then(function () {
        $("#mi-perfil-btn").attr("href", "profile.html?email=" + email);
        $("#user-saldo").html("$" + user.saldo.toFixed(2)); 
        getVehiculos(false, "ASC");
//        $("#oredenar-genero").click(ordenarPelicula);

    });

});

async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            email: email
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                user = parsedResult;                
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}

function getVehiculos(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletVehiculoListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarVehiculos(parsedResult);
            } else {
                console.log("Error recuperando los datos de los vehículos");
            }
        }
    });
}

function mostrarVehiculos(vehiculos) {

    let contenido = "";

    $.each(vehiculos, function (index, vehiculo) {

        vehiculo = JSON.parse(vehiculo);        

        contenido += '<tr><th scope="row">' + vehiculo.idVehiculo + '</th>' +
                '<td>' + vehiculo.marca + '</td>' +
                '<td>' + vehiculo.modelo + '</td>' +
                '<td>' + vehiculo.idDescripcion + '</td>' +
                '<td>' + vehiculo.idTarifa + '</td>';

//        contenido += '></td>' +
//                '<td>' + precio + '</td>' +
//                '<td><button onclick="alquilarVehiculo(' + vehiculo.idVehiculo + ',' + precio + ');" class="btn btn-success" ';
//        if (user.saldo < precio) {
//            contenido += ' disabled ';
//        }

        contenido += '>Reservar</button></td></tr>'


    });
    $("#vehiculos-tbody").html(contenido);
}