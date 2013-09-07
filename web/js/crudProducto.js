//DECLARACION DE LAS CLASES
ABML = {
Views: {},
        Models: {},
        Collections: {},
        URL:'http://localhost:8080/CRUD/webresources/productos',
        id_venta : -1
};
        ABML.Collections.Productos = Backbone.Collection.extend({
            url: '/CRUD/webresources/productos/'
        });
       ABML.Models.Producto = Backbone.Model.extend({

            initialize: function() {
                _.bindAll(this);
                
            }
        });
        ABML.Views.GridView = Backbone.View.extend(
{
events: {
        "click #btnSearch": "search",
        "click #btnGuardar": "onSave",
        "click #btnBorrar": "deleteProducto",        
        "click #btnAdd": "newProducto",
        "click #btnAgregarCarrito": "agregarCarrito",
        "click #btnIrPago": "irPago"
},
        initialize: function() {
//  _.bindAll(this);
//this.render();
this.search();
console.log("Se inicializo la vista GRID");
console.log(ABML.URL);
	$.ajax({
		type: 'GET',
		url: 'http://localhost:8080/CRUD/webresources/ventas/ultimaVenta',
		dataType: "json",
		success: function(data, textStatus, jqXHR) {
               
                    console.log("Se trajo el id de venta " + data.id );
                    ABML.id_venta = data.id;
            } 
	});

},
        newProducto: function () {
	$('#btnDelete').hide();
        $('#productoId').val('');
            $('#nombre').val('');
            $('#descripcion').val('');
            $('#cantidad').val('');
            $('#precio').val('');       
	
},
       
           
        onSave: function() {
            var self = this;
            console.log("estoy en funcion onSave");
            if ($('#productoId').val() === '') {
            console.log("ADD PRODUCTO");
               $.ajax({
                    type: 'POST',
                    contentType: 'application/json',
                    url: ABML.URL,
                    dataType: "json",
                    data: self.formToJSON(),
                    success: function(data, textStatus, jqXHR) {
            alert('Producto Creado de la gran pistola');
                    $('#btnDelete').show();
                    $('#productoId').val(data.id);
            },
                    error: function(jqXHR, textStatus, errorThrown) {
            alert('agregarProducto error: ' + textStatus);
                    console.log("kilombo frente al arco al guardar");
            }
                        });
            }
            else
                    self.updateProducto();
                
                    return false;
},
        updateProducto : function() {
            console.log('updateProducto');
            $.ajax({
            type: 'PUT',
            contentType: 'application/json',
            url: ABML.URL+ '/' + $('#productoId').val(),
            dataType: "json",
            data: this.formToJSON(),
            success: function(data, textStatus, jqXHR) {
            alert('Producto updated successfully');
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert('updateProducto error: ' + textStatus);
            }
    });
},
        deleteProducto: function () {
	console.log('deleteProducto');
	$.ajax({
		type: 'DELETE',
                contentType: 'application/json',
                dataType: "json",
		url: ABML.URL + '/' + $('#productoId').val(),
		success: function(data){
			alert('Producto Eliminado al fin!!');
                        console.log("producto elimidado"+ data);
		},
		error: function(data){
                        console.log("Error"+ data);
			alert('deleteProducto error');
                        
		}
	});
},
        search: function () {
                    console.log("estoy en search");
                searchKey = $('#searchKey').val();
                if (searchKey === '')
                    this.findAll();
                else
                    this.findByName(searchKey);
                },
        findAll: function()  {
            console.log('findAll');
            $.ajax({
                    type: 'GET',
                    url: ABML.URL,
                    dataType: "json", // data type of response
                    beforeSend: function () {
                            $("jqxgrid").html('');
                    },
                    error: function (json, textStatus, errorThrown) {
                            alert(' Error :' + errorThrown);
                    },                
                    success: function (data) {
                            // initailize grid
                            var gridData = data;
                            var gridSource =
                            {
                                localdata: gridData,
                                datatype: 'json'
                            };
                            var gridDataAdapter = new $.jqx.dataAdapter(gridSource);
                            $("#jqxgrid").jqxGrid(
                            {
                                width: 440,
                                source: gridDataAdapter,

                                pageable: true,
                                autoheight: true,


                                columns: [
                                  { text: 'ID', datafield: 'id', width: 30 },
                                  { text: 'Nombre', datafield: 'nombre', width: 100 },
                                  { text: 'Descripcion', datafield: 'descripcion', width: 150 },
                                  { text: 'Cant.', datafield: 'cantidad', width: 60 },
                                  { text: 'Precio', datafield: 'precio', width: 100 }


                             ]
                        });	
                    }
                });
    },
               

        
       
        formToJSON: function() {
            var productoId = $('#productoId').val();
          console.log("formtojson");
           return JSON.stringify({
                "id": productoId === "" ? null : productoId,
                "nombre": $('#nombre').val(),
                "cantidad": $('#cantidad').val(),
                "descripcion": $('#descripcion').val(),
                "precio": $('#precio').val()
                
                
            });
        },
               
        agregarCarrito : function() {
            console.log('agregar al carro');
            
            $.ajax({
            type: 'PUT',
            contentType: 'application/json',
            url: 'http://localhost:8080/CRUD/webresources/ventas/' + ABML.id_venta ,
            dataType: "json",
            data: this.formToJSONDetalle(),
            success: function(data, textStatus, jqXHR) {
                        alert('Venta detalle create successfully');
                          var gridDataDetalle = data;
                            var gridSource =
                            {
                                localdata: gridDataDetalle,
                                datatype: 'json'
                            };
                            var gridDataAdapter = new $.jqx.dataAdapter(gridSource);
                            $("#jqxgrid2").jqxGrid(
                            {
                                width: 300,
                                source: gridDataAdapter,

                                pageable: true,
                                autoheight: true,


                                columns: [
                                  { text: 'nombre', datafield: 'nombre', width: 150 },
                                  { text: 'cant de venta', datafield: 'cant_venta', width: 150 }
                                  
                                  
                               

                             ]
                        });
            
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert('update ventadetalle error: ' + textStatus);
            }
            
    });
    return false;
},

    formToJSONDetalle: function() {
            var productoId = $('#productoId').val();
          console.log("formtojson");
           return JSON.stringify({
                "id_producto": productoId === "" ? null : productoId,
                "nombre": $('#nombre').val(),
                "cantidad": $('#cantidad').val(),
                "descripcion": $('#descripcion').val(),
                "precio": $('#precio').val(),
                "cant_venta": $('#cant_venta').val()
                
            });
        },
     
     irPago: function(){
        console.log("hiciste click en ir a paga");
         window.location.replace("/CRUD/pago.html");
         return false;
     }
        

});
        // ACA EMPIEZA LA ACCION

        ABML.gridView = new ABML.Views.GridView({el:'#main'});
//ABML.Clientes = new ABML.Collections.Clientes();
//ABML.cliente = new ABML.Models.Cliente({'nombre': 'Prueba Nueva'});
//ABML.Clientes.add(ABML.cliente);
//ABML.cliente.save({}, {// se genera POST /usuarios  - contenido: {nombre:'Alfonso'}
//    success: function() {
//        alert("Usuario guardado con exito");
//        console.log("Usuario guardado con exito");
//    }
//});
//
//ABML.cliente2 = new ABML.Models.Cliente({'nombre': 'Prueba Nueva2'});
//ABML.Clientes.add(ABML.cliente2);
//ABML.cliente2.save({}, {// se genera POST /usuarios  - contenido: {nombre:'Alfonso'}
//    success: function() {
//        alert("Usuario guardado con exito");
//        console.log("Usuario guardado con exito");
//    }
//});
//
//ABML.cliente3 = new ABML.Models.Cliente({'nombre': 'Prueba Nueva3'});
//ABML.Clientes.add(ABML.cliente3);
//ABML.cliente3.save({}, {
//    success: function() {
//        alert("Usuario guardado con exito");
//        console.log("Usuario guardado con exito");
//    }
//});
//
//
//ABML.cliente4 = new ABML.Models.Cliente({id:1});
//ABML.Clientes.add(ABML.cliente4);
//ABML.cliente4.destroy();
//
//Clientes = new ABML.Collections.Clientes();
//Clientes.fetch({// genera GET /usuarios
//    success: function() {
//        alert('Recuperados ' + ABML.Clientes.length + ' usuarios');
//    }
//    
// 
// 
//});
//
//setTimeout(function(){ABML.cliente3.save({'nombre':'te cambie de nombre'});}, 1000);





