var controller = new Controller();

window.onload = function() {
	controller.init();
	
	
}

$(document).ready(function() {
	$("#myTable").tablesorter({
		sortList : [ [ 0, 0 ], [ 1, 0 ] ]
	});
});

function Controller() {
	self = this;
	this.init = function() {

		var arrRadio = document.getElementsByName("Radiobutton"), result;
		for ( var i = 0; i < arrRadio.length; i++) {
			arrRadio[i].onclick = function() {
				self.getRadio($(this).attr('id'));

			}
		}
		document.getElementsByName("Edit")[0].onclick = function(e) {
			console.log(e.target.id);
			self.edit($(this).attr('id'));
		}

	}

	this.checkPrice = function() {

		var regex = new RegExp(/^(?:\d+(?:\.\d+)?)$/);
		var price = document.getElementById("price");
		if (!regex.test(price.value) || price.value === '') {
			return false;
		} else {
			return true;
		}

	}
	this.check = function() {

		var name = document.getElementById("name");

		if (name.value === '') {
			return false;
		} else {
			return true;
		}

	}
	this.check1 = function() {

		var descr = document.getElementById("descr");
		if (descr.value === '') {
			return false;
		} else {
			return true;
		}

	}

	this.checkQuantity = function() {

		var regex = new RegExp(/^\d+$/);
		var quantity = document.getElementById("quantity");
		if (!regex.test(quantity.value) || quantity.value === '') {
			return false;
		} else {
			return true;
		}
	};

	this.getRadio = function(i) {
		var name = $('#name' + i).html();
		$('#Editname').val(name);
		var type = $('#type' + i).html();
		$('#Edittype').val(type);
		var price = $('#price' + i).html();
		$('#Editprice').val(price);
		var quantity = $('#quantity' + i).html();
		$('#Editquantity').val(quantity);
		var descr = $('#descr' + i).html();
		$('#Editdescr').val(descr);
		document.getElementsByName("Edit")[0].id = i;
	};

	this.edit = function(i) {
		$.ajax({
			url : './edit',
			type : 'POST',

			data : "id=" + i + "&name=" + $('#Editname').val() + "&type="
					+ $('#Edittype').val() + "&price=" + $('#Editprice').val()
					+ "&quantity=" + $('#Editquantity').val() + "&descr="
					+ $('#Editdescr').val(),
			success : function() {
				$('#name' + i).html($('#Editname').val());
				$('#type' + i).html($('#Edittype').val());
				$('#price' + i).html($('#Editprice').val());
				$('#quantity' + i).html($('#Editquantity').val());
				$('#descr' + i).html($('#Editdescr').val());

			}
		})

	}

	this.add = function(i) {
		$
				.ajax({
					url : './add',
					type : 'POST',

					data : "&name=" + $('#name').val() + "&type="
							+ $('#type').val() + "&price=" + $('#price').val()
							+ "&quantity=" + $('#quantity').val() + "&descr="
							+ $('#descr').val(),
					success : function() {

						alert("Data Added")

					}
				})

	}

	return this;
}
