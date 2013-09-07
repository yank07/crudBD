


Clientes = Backbone.Collection.extend({
    url: '/CRUD/webresources/clientes/'
});
var clientes = new Clientes();
Cliente = Backbone.Model.extend();
var cliente = new Cliente({'nombre': 'Marin'});
clientes.add(cliente);

cliente.save({}, {  // se genera POST /usuarios  - contenido: {nombre:'Alfonso'}
    success:function(){
        alert("Usuario guardado con exito");
        console.log("Usuario guardado con exito");
    }
});



Clientes2 = new Clientes();
Clientes2.fetch({    // genera GET /usuarios
    success: function(){
        alert('Recuperados ' + clientes.length + ' usuarios');
    }
});