

var buscar = function (){
	var nomePizza = $('#pizza_pesquisa').val();
	var url = 'pizzarias/pizza/' + nomePizza;
	
	$.get(url)
	.done(function (view){
		$('#secao-pizzarias').html(view);
	});
};

$(document).ready(function (){
	$('#btn-buscar').on('click', buscar);
});