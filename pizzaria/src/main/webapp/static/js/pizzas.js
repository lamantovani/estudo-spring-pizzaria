/**
 * 
 */

$(document).ready(function() {
	aplicarListeners();
	aplicarListenerBtnSalvar();
});

var limparModal = function() {
	$('#id').val('');
	$('#nome').val('');
	$('#preco').val('');
	$('#categoria').val('');
	$('#ingredientes').val('');
}

var aplicarListenerBtnSalvar = function() {
	$('#btn-salvar').on('click', function() {

		var url = 'pizzas';
		var dadosPizza = $('#form-pizza').serialize();

		$.post(url, dadosPizza).done(function(pagina) {
			$('#secao-pizzas').html(pagina);
			aplicarListeners();
		}).fail(function() {
			alert('Erro ao salvar a Pizza!');
		}).always(function() {
			$('#modal-pizza').modal('hide');
		});

	});

}

var aplicarListeners = function() {

	$('#modal-pizza').on('hide.bs.modal', limparModal());

	$('.btn-deletar').on('click', function() {
		var id = $(this).parents('tr').data('id');

		$.ajax({
			url : "pizzas/" + id,
			type : "DELETE",
			success : function(result) {
				$('tr[data-id="' + id + '"]').remove();
				var quantPizzas = parseInt($('#quantidade-pizzas').text());
				$('#quantidade-pizzas').text(quantPizzas - 1);
			}
		});
	});

	$('.btn-editar').on(
			'click',
			function() {
				var id = $(this).parents('tr').data('id');
				var url = 'pizzas/' + id;

				$.get(url).done(
						function(pizza) {
							$('#id').val(pizza.id);
							$('#nome').val(pizza.nome);
							$('#preco').val(pizza.preco);
							$('#categoria').val(pizza.categoria);

							pizza.ingredientes.forEach(function(ingrediente) {
								var id = ingrediente.id;
								$('#ingredientes option[value=' + id + ']')
										.attr('selected', true);
							});

							$('#modal-pizza').modal('show');
						});
			});

}