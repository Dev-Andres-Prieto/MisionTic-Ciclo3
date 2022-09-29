var email = new URL(location.href).searchParams.get("email");
var idUser = new URL(location.href).searchParams.get("idUser");
var user;

$(document).ready(function () {


    fillUsuario().then(function () {

        $("#user-saldo").html("$" + user.saldo.toFixed());

        getReservas(user.email);
    });

    $("#reservar-btn").attr("href", `home.html?email=${email}&idUser=${idUser}`);

    $("#form-modificar").on("submit", function (event) {

        event.preventDefault();
        modificarUsuario();
    });

    $("#aceptar-eliminar-cuenta-btn").click(function () {

        eliminarCuenta().then(function () {
            location.href = "index.html";
        });
    });

});

async function fillUsuario() {
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
                
                $("#input-nombre").val(parsedResult.nombre);
                $("#input-apellidos").val(parsedResult.apellido);
                $("#input-tipo-documento").val(parsedResult.idTipoDocumento);
                $("#input-num-documento").val(parsedResult.numDocumento);
                $("#input-tipo-persona").val(parsedResult.idTipoPersona);
                $("#input-telefono").val(parsedResult.telefono);
                $("#input-direccion").val(parsedResult.direccion);
                $("#input-contrasena").val(parsedResult.password);
                $("#input-email").val(parsedResult.email);
                $("#input-saldo").val(parsedResult.saldo.toFixed(2));

            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}

function getReservas(email) {


    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletReservaListar",
        data: $.param({
            email: email
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {

                mostrarHistorial(parsedResult);

            } else {
                console.log("Error recuperando los datos de las reservas");
            }
        }
    });
}

function mostrarHistorial(vehiculos) {

    let contenido = "";
    
    if (vehiculos.length >= 1) {

        $.each(vehiculos, function (index, vehiculo) {

            vehiculo = JSON.parse(vehiculo);
            
            contenido += '<tr><th scope="row">' + vehiculo.idVehiculo + '</th>' +
                    '<td>' + vehiculo.modelo + '</td>' +
                    '<td>' + vehiculo.marca + '</td>';


            contenido += '></td><td>' + vehiculo.fechaRecepcion + '</td>' +
                    '<td><button id="devolver-btn" onclick= "devolverVehiculo(' + vehiculo.idVehiculo
                    + ', ' + vehiculo.idReserva + ');" class="btn btn-danger">Devolver vehículo</button></td></tr>';

        });
        $("#historial-tbody").html(contenido);
        $("#historial-table").removeClass("d-none");
        $("#historial-vacio").addClass("d-none");

    } else {
        $("#historial-vacio").removeClass("d-none");
        $("#historial-table").addClass("d-none");
    }
}


function devolverVehiculo(idVehiculo, idReserva) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletVehiculoDevolver",
        data: $.param({
            idUser: idUser,
            idVehiculo: idVehiculo,
            idReserva: idReserva
        }),
        success: function (result) {

            if (result != false) {

                location.reload();

            } else {
                console.log("Error devolviendo el vehículo");
            }
        }
    });

}

function modificarUsuario() {

    let nombre = $("#input-nombre").val();
    let apellidos = $("#input-apellidos").val();
    let idTipoDocumento = $("#input-tipo-documento").val();
    let numDocumento = $("#input-num-documento").val();
    let idTipoPersona = $("#input-tipo-persona").val();
    let telefono = $("#input-telefono").val();
    let direccion = $("#input-direccion").val();
    let contrasena = $("#input-contrasena").val();
    let contrasenaConfirmacion = $("#input-contrasena-repeat").val();
    let email = $("#input-email").val();
    let saldo = $("#input-saldo").val();


    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioModificar",
        data: $.param({
            nombre: nombre,
            apellidos: apellidos,
            idTipoDocumento: idTipoDocumento,
            numDocumento: numDocumento,
            idTipoPersona: idTipoPersona,
            telefono: telefono,
            direccion: direccion,
            contrasena: contrasena,
            email: email,
            saldo: saldo,
            idUser: idUser
        }),
        success: function (result) {

            if (result != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });

}

async function eliminarCuenta() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioEliminar",
        data: $.param({
            idUser: idUser
        }),
        success: function (result) {

            if (result != false) {

                console.log("Usuario eliminado")

            } else {
                console.log("Error eliminando el usuario");
            }
        }
    });
}
