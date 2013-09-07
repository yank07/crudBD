//DECLARACION DE LAS CLASES
ABML = {
Views: {},
        Models: {},
        Collections: {},
        URL:'http://localhost:8080/CRUD/webresources/clientes'
        
};
        ABML.Collections.Clientes = Backbone.Collection.extend({
            url: '/CRUD/webresources/clientes/'
        });
        ABML.Models.Cliente = Backbone.Model.extend({
initialize: function() {
_.bindAll(this);
}
});
        ABML.Models.Producto = Backbone.Model.extend({
defaults: {
id: '',
        nombre: '',
        descripcion: '',
        cantidad: 0,
        precio: 0

},
        initialize: function() {
_.bindAll(this);
}
});
        ABML.Views.GridView = Backbone.View.extend(
{
events: {
        "click #btnSearch": "search",
        "click #btnGuardar": "onSave",
        "click #btnBorrar": "deleteCliente",
               "click #btnAdd": "newCliente",
               "click #btnContinuar": "iniciarVenta"
},
        initialize: function() {
//  _.bindAll(this);
//this.render();
            this.search();
            console.log("Se inicializo la vista GRID");
            console.log(ABML.URL);
},
        iniciarVenta : function(){
               console.log('iniciar venta');
               if ($('#clienteId').val() === '' ){
                   alert("Debes Seleccionar cliente");
               }
               else{
                    console.log('iniciar venta');
                    $.ajax({
                    type: 'POST',
                    contentType: 'application/json',
                    url: 'http://localhost:8080/CRUD/webresources/ventas',
                    dataType: "json",
                    data: this.formToJSONVenta(),
                    success: function(data, textStatus, jqXHR) {
                        alert('Venta agrego el cliente');
                    $('#btnDelete').show();
                    window.location.replace("/CRUD/compraProductos.html");
                    
            },
                    error: function(jqXHR, textStatus, errorThrown) {
            alert('addWine error: ' + textStatus);
                    console.log("kilombo frente al arco en la venta");
                    
            }
                    
                        });
               }
                        
                        return false;
                 
               
        },
        newCliente: function () {
	$('#btnDelete').hide();
        $('#clienteId').val('');
            $('#nombre').val('');
            $('#direccion').val('');
            $('#ci').val('');
                  
	
},
           
        onSave: function() {
            var self = this;
            console.log("estoy en funcion onSave");
            if ($('#clienteId').val() === '') {
            console.log("ADD CLIENTE");
               $.ajax({
                    type: 'POST',
                    contentType: 'application/json',
                    url: ABML.URL,
                    dataType: "json",
                    data: self.formToJSON(),
                    success: function(data, textStatus, jqXHR) {
            alert('Cliente Creado de la gran pistola');
                    $('#btnDelete').show();
                    $('#clienteId').val(data.id);
            },
                    error: function(jqXHR, textStatus, errorThrown) {
            alert('addWine error: ' + textStatus);
                    console.log("kilombo frente al arco");
            }
                        });
            }
            else
                    self.updateCliente();
                
                    return false;
},
        updateCliente : function() {
            console.log('updateCliente');
            $.ajax({
            type: 'PUT',
            contentType: 'application/json',
            url: ABML.URL+ '/' + $('#clienteId').val(),
            dataType: "json",
            data: this.formToJSON(),
            success: function(data, textStatus, jqXHR) {
            alert('Wine updated successfully');
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert('updateCliente error: ' + textStatus);
            }
    });
},
        deleteCliente: function () {
	console.log('deleteWine');
	$.ajax({
		type: 'DELETE',
                contentType: 'application/json',
                dataType: "json",
		url: ABML.URL + '/' + $('#clienteId').val(),
		success: function(data){
			alert('Cliente Eliminado al fin!!');
                        console.log("cliente elimidado"+ data);
		},
		error: function(data){
                        console.log("Error"+ data);
			alert('deleteCliente error');
                        
		}
                
	});
        return false;
},
        search: function () {
                    console.log("estoy en search");
                searchKey = $('#searchKey').val();
                if (searchKey === '')
                    this.findAll();
                else
                    this.findByCi(searchKey);
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
                            width: 580,
                            source: gridDataAdapter,
                            //editable: true,
                            pageable: true,
                            autoheight: true,
                           // selectionmode: 'singlecell',
                            columns: [
                              { text: 'ID', datafield: 'id', width: 30 },
                              { text: 'Nombre', datafield: 'nombre', width: 200 },
                              { text: 'Direccion', datafield: 'direccion', width: 200 },
                              { text: 'CI', datafield: 'ci', width: 150 }

                         ]
                    });	}});
    },
        findByName: function (searchKey) {
	console.log('findByName: ' + searchKey);
	$.ajax({
		type: 'GET',
		url: rootURL + '/search/' + searchKey,
		dataType: "json",
		success: this.renderList() 
	});
},
        
        findByCi: function (ci) {
	console.log('findByCi: ' + ci);
	$.ajax({
		type: 'GET',
		url: ABML.URL + '/' + ci,
		dataType: "json",
		success: function(data){
			$('#btnDelete').show();
			console.log('findByCi success: ' + data.nombre);
			currentCliente = data;			 
             $('#clienteId').val(data.id);
             $('#nombre').val(data.nombre);
             $('#direccion').val(data.direccion);
             $('#ci').val(data.ci);


 
		}
                
	});
},
        renderList : function (data) {
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
                            width: 670,
                            source: gridDataAdapter,
                            editable: true,
                            pageable: true,
                            autoheight: true,
                            selectionmode: 'singlecell',
                            columns: [
                              { text: 'ID', datafield: 'id', width: 120 },
                              { text: 'Nombre', datafield: 'nombre', width: 250 },
                              { text: 'Direccion', datafield: 'direccion', width: 250 },
                              { text: 'CI', datafield: 'ci', width: 180 }

                         ]
                    });
        },        
        formToJSON: function() {
            var clienteId = $('#clienteId').val();
          console.log("formtojson");
           return JSON.stringify({
                "id": clienteId === "" ? null : clienteId,
                "nombre": $('#nombre').val(),
                "direccion": $('#direccion').val(),
                "ci": $('#ci').val()
            });
        },
            formToJSONVenta: function() {
                    var obj = {
           'comprador': {'id':clienteId === "" ? null : clienteId,
                "nombre": $('#nombre').val(),
                "direccion": $('#direccion').val(),
                "ci": $('#ci').val()}
           
         };
            var clienteId = $('#clienteId').val();
          console.log("formtojson");
           return JSON.stringify(obj);
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



