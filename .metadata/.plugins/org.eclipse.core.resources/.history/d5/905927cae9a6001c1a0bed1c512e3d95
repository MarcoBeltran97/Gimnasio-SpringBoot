function eliminar(id){
	swal({
	  title: "¿Está seguro de eliminar el registro seleccionado?",
	  text: "Los cambios no se podrán rehacer",
	  icon: "warning",
	  buttons: true,
	  dangerMode: true,
	})
	.then((OK) => {
	  if (OK) {
		$.ajax({
			url:"/delete/"+id,
			success: function(res){
				console.log(res);
			}
		});
	    swal("Registro eliminado correctamente", {
	      icon: "success",
	    }).then((ok)=>{
		if(ok){
			location.href="/carrito";
		}
	});
	  } else {
	    swal("No se eliminó el registro");
	  }
	});
}