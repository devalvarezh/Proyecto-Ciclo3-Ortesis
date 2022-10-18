//Mostrar las tablas al iniciar la página
function cargarTablas() {
    traerInformacion();
    traerInfoClientes();
    traerMensajes();
}


//Llamado AJAX de tipo GET para traer la información de todos los productos
function traerInformacion() {
    $.ajax({
        url: "144.22.36.106:8080/api/Ortopedic/all",
        type: "GET",
        datatype: "JSON",
        crossDomain: true,
        contentType: "application/json",
        success: function (response) {
            console.log(response);
            mostrarInformacion(response.items);
        }
    });
}


//Mostrar el resultado del llamado de todos los productos
function mostrarInformacion(items) {
    $("#resultadoOrtesis").empty();
    let tablaProductos = "<table>";
    tablaProductos += "<tr>";
    tablaProductos += "<th>Código</th>";
    tablaProductos += "<th>Producto</th>";
    tablaProductos += "<th>Marca</th>";
    tablaProductos += "<th>Modelo</th>";
    tablaProductos += "<th>Categoría</th>";
    tablaProductos += "</tr>";
    for (index = 0; index < items.length; index++) {
        tablaProductos += "<tr>";
        tablaProductos += "<td>" + items[index].id + "</td>";
        tablaProductos += "<td>" + items[index].name + "</td>";
        tablaProductos += "<td>" + items[index].brand + "</td>";
        tablaProductos += "<td>" + items[index].model + "</td>";
        tablaProductos += "<td>" + items[index].category_id + "</td>";
        tablaProductos += "<td>" + "<button onclick='eliminarProducto(" + items[index].id + ")'>Eliminar</button>";
        //tablaProductos += "<td><button onclick='DetallesProducto(" + items[index].id + ")'>Ver Detalles</button>";
        tablaProductos + "</tr>";
    }
    tablaProductos += "</table>";
    $("#resultadoOrtesis").append(tablaProductos);
}


/**Llamado AJAX de tipo GET para traer un elemento por id
function DetallesProducto(idElemento) {
    let id = idElemento;
    $.ajax({
        url: "https://g3d3c68042efbd0-orthesis.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/orthesis/orthesis/:id",
        type: "GET",
        dataType: "JSON",
        data: id,
        crossDomain: true,
        contentType: "application/json",
        success: function (response) {
            console.log(response);
            mostrarDetallesProducto(response.items, idElemento);
            //alert("Muéstreme los detalles")
        }
    });
}


//Mostrar un solo elemento
function mostrarDetallesProducto(items, idElemento) {
    $("#detalles").empty();
    const codigo = idElemento;
    let tablaDetalles = "<table>";
    tablaDetalles += "<tr>";
    tablaDetalles += "<th>Código</th>";
    tablaDetalles += "<th>Producto</th>";
    tablaDetalles += "<th>Marca</th>";
    tablaDetalles += "<th>Modelo</th>";
    tablaDetalles += "<th>Categoría</th>";
    tablaDetalles += "</tr>";
    tablaDetalles += "<tr>";
    for (index = 0; index < items.length; index++) {
        if (items[index].id === codigo) {
            tablaDetalles += "<td>" + items.id + "</td>";
            tablaDetalles += "<td>" + items.name + "</td>";
            tablaDetalles += "<td>" + items.brand + "</td>";
            tablaDetalles += "<td>" + items.model + "</td>";
            tablaDetalles += "<td>" + items.category_id + "</td>";
            tablaDetalles += "</tr>";
        }
    }
    $("detalles.html#detalles").append(tablaDetalles);

}*/


//Llamado AJAX de tipo POST para agregar un producto
function agregarOrtesis() {
    let datosOrtesis = {
        id: $("#productId").val(),
        brand: $("#brand").val(),
        model: $("#model").val(),
        category_id: $("#category_id").val(),
        name: $("#productName").val(),
    };
    let dataToSend = JSON.stringify(datosOrtesis);
    $.ajax({
        url: "https://g3d3c68042efbd0-orthesis.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/orthesis/orthesis",
        type: "POST",
        data: dataToSend,
        dataType: "JSON",
        crossDomain: true,
        contentType: "application/json",
        success: function (response) {
            console.log(response);
        }
    });
    $("#resultadoOrtesis").empty();
    $("#productId").val("");
    $("#brand").val("");
    $("#model").val("");
    $("#category_id").val("");
    $("#productName").val("");
    alert("Producto agregado correctamente");
    traerInformacion();
}


//Llamado AJAX de tipo PUT para actualizar un producto
function actualizarProducto() {
    let datosOrtesis = {
        id: $("#productId").val(),
        brand: $("#brand").val(),
        model: $("#model").val(),
        category_id: $("#category_id").val(),
        name: $("#productName").val(),
    };
    let dataToSend = JSON.stringify(datosOrtesis);
    $.ajax({
        url: "https://g3d3c68042efbd0-orthesis.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/orthesis/orthesis",
        type: "PUT",
        data: dataToSend,
        contentType: "application/json",
        dataType: "text",
        //crossDomain:true,
        success: function (response) {
            console.log(response)
        }
    });
    $("#resultadoOrtesis").empty();
    $("#productId").val("");
    $("#brand").val("");
    $("#model").val("");
    $("#category_id").val("");
    $("#productName").val("");
    traerInformacion();
    alert("Órtesis actualizada correctamente")
}


//Llamado AJAX de tipo DELETE para eliminar un producto
function eliminarProducto(idElemento) {
    let datosOrtesis = {
        id: idElemento
    };
    let dataToSend = JSON.stringify(datosOrtesis);
    $.ajax({
        url: "https://g3d3c68042efbd0-orthesis.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/orthesis/orthesis",
        type: "DELETE",
        data: dataToSend,
        datatype: "JSON",
        crossDomain: true,
        contentType: "application/json",
        success: function (response) {
            console.log(response);
        }
    });
    $("#resultadoOrtesis").empty();
    traerInformacion();
    alert("Producto eliminado")
}


//Llamado AJAX de tipo GET para traer la información de todos los clientes.
function traerInfoClientes() {
    $.ajax({
        url: "https://g3d3c68042efbd0-orthesis.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client",
        type: "GET",
        datatype: "JSON",
        crossDomain: true,
        contentType: "application/json",
        success: function (response) {
            console.log(response);
            mostrarInformacionClientes(response.items);
        }
    });
}


//Mostrar el resultado de llamar todos los clientes
function mostrarInformacionClientes(items) {
    $("#resultadoClientes").empty();
    let tabla = "<table>";
    tabla += "<tr>";
    tabla += "<th>Código</th>";
    tabla += "<th>Cliente</th>";
    tabla += "<th>Email</th>";
    tabla += "<th>Edad</th>";
    tabla += "</tr>";
    for (index = 0; index < items.length; index++) {
        tabla += "<tr>";
        tabla += "<td>" + items[index].id + "</td>";
        tabla += "<td>" + items[index].name + "</td>";
        tabla += "<td>" + items[index].email + "</td>";
        tabla += "<td>" + items[index].age + "</td>";
        tabla += "<td><button onclick='eliminarCliente(" + items[index].id + ")'>Eliminar</button>";
        //tabla += "<td><button onclick='verDetallesCliente(" + items[index].id + ")'>Ver Detalles</button>";
        tabla + "</tr>";
    }
    tabla += "</table>";
    $("#resultadoClientes").append(tabla);
}


//Llamado AJAX de tipo POST para agregar clientes
function agregarCliente() {
    let datosCliente = {
        id: $("#clientId").val(),
        name: $("#clientName").val(),
        email: $("#email").val(),
        age: $("#age").val(),
    };
    let dataToSend = JSON.stringify(datosCliente);
    console.log(datosCliente);
    $.ajax({
        url: "https://g3d3c68042efbd0-orthesis.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client",
        type: "POST",
        data: dataToSend,
        dataType: "JSON",
        crossDomain: true,
        contentType: "application/json",
        success: function (response) {
            console.log(response);
        }
    });
    $("#resultadoClientes").empty();
    $("#clientId").val("");
    $("#clientName").val("");
    $("#email").val("");
    $("#age").val("");
    alert("Cliente agregado correctamente");
    traerInfoClientes();

}


//Llamado AJAX de tipo PUT para actualizar un cliente
function actualizarCliente() {
    let datosCliente = {
        id: $("#clientId").val(),
        name: $("#clientName").val(),
        email: $("#email").val(),
        age: $("#age").val(),
    };
    let dataToSend = JSON.stringify(datosCliente);
    $.ajax({
        url: "https://g3d3c68042efbd0-orthesis.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client",
        type: "PUT",
        data: dataToSend,
        dataType: "JSON",
        contentType: "application/json",
        crossDomain: true,
        success: function (response) {
            console.log(response);
        }
    });
    $("#resultadoClientes").empty();
    $("#clientId").val("");
    $("#clientName").val("");
    $("#email").val("");
    $("#age").val("");
    alert("Cliente actualizado correctamente")
    traerInfoClientes();
}


//Llamado AJAX de tipo DELETE para eliminar la información de un cliente
function eliminarCliente(idCliente) {
    let datosCliente = {
        id: idCliente
    };
    let dataToSend = JSON.stringify(datosCliente);
    $.ajax({
        url: "https://g3d3c68042efbd0-orthesis.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client",
        type: "DELETE",
        data: dataToSend,
        dataType: "JSON",
        contentType: "application/json",
        crossDomain: true,
        success(response) {
            console.log(response);
        }
    });
    $("#resultadoClientes").empty();
    $("#clientId").val("");
    $("#clientName").val("");
    $("#email").val("");
    $("#age").val("");
    alert("Cliente eliminado exitosamente");
    traerInfoClientes();
}


//Llamado AJAX de tipo GET para traer la información de todos los mensajes
function traerMensajes() {
    $.ajax({
        url: "https://g3d3c68042efbd0-orthesis.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message",
        type: "GET",
        contentType: "application/JSON",
        crossDomain: true,
        success(response) {
            console.log(response);
            mostrarMensajes(response.items);
        }
    });
}


//Mostrar el resultado de traer todos los mensajes
function mostrarMensajes(items) {
    $("#resultadoMensajes").empty();
    let tabla = "<table>";
    tabla += "<tr>";
    tabla += "<th>Código</th>";
    tabla += "<th>Mensaje</th>";
    tabla += "</tr>";
    for (index = 0; index < items.length; index++) {
        tabla += "<tr>";
        tabla += "<td>" + items[index].id + "</td>";
        tabla += "<td>" + items[index].messagetext + "</td>";
        tabla += "<td>" + "<button onclick='eliminarMensaje(" + items[index].id + ")'>Eliminar</button>";
        tabla + "</tr>";
    }
    tabla += "</table>";
    $("#resultadoMensajes").append(tabla);
}


//Llamado AJAX de tipo "POST" para agregar mensajes
function agregarMensaje() {
    let mensaje = {
        id: $("#messageId").val(),
        messagetext: $("#message").val()
    };
    let dataToSend = JSON.stringify(mensaje);
    $.ajax({
        url: "https://g3d3c68042efbd0-orthesis.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message",
        type: "POST",
        data: dataToSend,
        dataType: "JSON",
        crossDomain: true,
        contentType: "application/json",
        success: function (response) {
            console.log(response.items);
        }
    });
    $("#resultadoMensajes").empty();
    $("#messageId").val("");
    $("#message").val("");
    alert("Mensaje agregado correctamente");
    traerMensajes();
}


//Llamado AJAX de tipo "PUT" para editar mensajes
function editarMensaje() {
    let mensaje = {
        id: $("#messageId").val(),
        messagetext: $("#message").val()
    };
    let dataToSend = JSON.stringify(mensaje);
    $.ajax({
        url: "https://g3d3c68042efbd0-orthesis.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message",
        type: "PUT",
        data: dataToSend,
        dataType: "JSON",
        contentType: "application/json",
        crossDomain: true,
        success: function (response) {
            console.log(response);
        }
    });
    $("#resultadoMensajes").empty();
    $("#messageId").val("");
    $("#message").val("");
    alert("Mensaje editado correctamente");
    traerMensajes();
}


//Llamado AJAX de tipo "DELETE" para eliminar un mensaje
function eliminarMensaje(idMensaje) {
    let mensaje = {
        id: idMensaje
    };
    let dataToSend = JSON.stringify(mensaje);
    $.ajax({
        url: "https://g3d3c68042efbd0-orthesis.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message",
        type: "DELETE",
        data: dataToSend,
        dataType: "JSON",
        contentType: "application/json",
        crossDomain: true,
        success: function (response) {
            console.log(response);
        }
    });
    $("#resultadoMensajes").empty();
    alert("Mensaje eliminado correctamente")
    traerMensajes();
}