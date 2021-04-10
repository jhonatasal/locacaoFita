$(document).ready(function() {
	mascara();
	$("#cadastro").submit(function() {
		retiraMascara();
	});
});
function mascara() {
	$('.cpf').mask('000.000.000-00');
	$(".preco").maskMoney({
		prefix : "R$:",
		decimal : ",",
		thousands : "."
	});
}

function retiraMascara() {
	$("#preco").val($("#preco").val().replace("R$:", "").replace(",", "."));
}