$(document).ready(function(){
    $("#form-login").submit(function(event){
        event.preventDefault();
        autenticarUsuario();        
    });
    
    $("#form-register").submit(function(event){
        event.preventDefault();
        registrarUsuario();        
    });
});

function autenticarUsuario(){
    let email = $("#email").val();
    let contrasena = $("#contrasena").val();
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            email: email,
            contrasena: contrasena
        }),
        success: function(result){
            let parsedResult = JSON.parse(result);
            
            if(parsedResult != false){
                $("#login-error").addClass("d-none");
                let email = parsedResult['email'];
                let idUser = parsedResult['idUsuario'];                
                document.location.href = "home.html?email=" + email + "&idUser=" + idUser;
                
            }else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}

function registrarUsuario() {

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

    alert(saldo);
    if (contrasena == contrasenaConfirmacion) {
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioRegister",
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
                saldo: saldo
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult != false) {
                    $("#register-error").addClass("d-none");
                    let email = parsedResult['email'];
                    document.location.href = "home.html?email=" + email + "&idUser=" + idUser;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }
}