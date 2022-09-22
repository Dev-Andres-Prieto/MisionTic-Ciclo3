var email = new URL(location.href).searchParams.get("email");
var idUser = new URL(location.href).searchParams.get("idUser");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle = "tooltip"]').tooltip;
    });


    getUsuario().then(function () {
        $("#mi-perfil-btn").attr("href", "profile.html?email=" + email);
        $("#user-saldo").html("$" + user.saldo.toFixed(2)); 
        getVehiculos(false, "ASC");
//        $("#oredenar-genero").click(ordenarVehiculos);

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
        let precio = vehiculo.idTarifa;
        
        contenido += '<tr><th scope="row">' + vehiculo.idVehiculo + '</th>' +
                '<td>' + vehiculo.marca + '</td>' +
                '<td>' + vehiculo.modelo + '</td>' +
                '<td>' + vehiculo.idDescripcion + '</td>' +
                '<td>' + vehiculo.idTarifa + '</td>';

        contenido += '></td>' +
                //'<td>' + precio + '</td>' +
                '<td><button onclick="alquilarVehiculo(' + vehiculo.idVehiculo + ',' + precio + ',' + idUser + ');" class="btn btn-success" ';
        if (user.saldo < precio) {
            contenido += ' disabled ';
        }

        contenido += '>Reservar</button></td></tr>';


    });
    $("#vehiculos-tbody").html(contenido);
}

    function ordenarVehiculos() {
        if ($("#icono-ordenar").hasClass("fa-sort")) {
            getVehiculos()(true, "ASC");
            $("#icono-ordenar").removeClass("fa-sort");
            $("#icono-ordenar").addClass("fa-sort-down");
        } else if ($("#icono-ordenar").hasClass("fa-sort-down")) {
            getVehiculos()(true, "DESC");
            $("#icono-ordenar").removeClass("fa-sort-down");
            $("#icono-ordenar").addClass("fa-sort-up");
        } else if ($("#icono-ordenar").hasClass("fa-sort-up")) {
            getVehiculos(false, "ASC");
            $("#icono-ordenar").removeClass("fa-sort-up");
            $("#icono-ordenar").addClass("fa-sort");
        }
    }

    function alquilarVehiculo(idVehiculo, precio, idUser) {
         console.log("IdUser: " + idUser, "precio: "+precio, "idVehiculo: "+idVehiculo);
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletVehiculoAlquilar",
            data: $.param({
                id: idVehiculo,
                email: email,
                precio: precio,
                idUser: idUser
            }),
            
            success: function (result) {
                let parsedResult = JSON.parse(result);
                console.log("parsedResult desde alquilar vehículo: " +parsedResult);
                if (parsedResult != false) {
                    console.log(parsedResult);
                    restarDinero(precio).then(function () {
                        location.reload();
                    });

                } else {
                    console.log("Error en la reserva del vehículo");
                }
            }
        });

    }

    async function restarDinero(precio) {
        console.log("precio desde restar dinero: " +precio);
        await $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioRestarDinero",
            data: $.param({                
                idUser: idUser,
                saldo: parseFloat(user.saldo - precio)
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);
                if (parsedResult != false) {
                    console.log("Saldo actualizado");
                } else {
                    console.log("Error en el proceso de pago");
                }
            }
        });
    }