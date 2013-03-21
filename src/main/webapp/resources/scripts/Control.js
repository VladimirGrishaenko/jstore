var controller = new Controller();

window.onload = function() {
	controller.init();
	document.getElementById("add").disabled = true;
	
}

$(document).ready(function() {
	$("#myTable").tablesorter({
		sortList : [ [ 0, 0 ], [ 1, 0 ] ]
	});
});

function Controller() {
	self = this;
	this.init = function() {

		document.getElementById("add").onclick = function(e) {
			console.log(e.target.id);
			self.add($(this).attr('id'));
		}
		document.onkeyup = function() {
			if(self.checkPrice() & self.check() & self.checkQuantity() & self.check1()){
			document.getElementById("add").disabled=false;	
				
			} else {document.getElementById("add").disabled=true;}
			
			
			

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


	this.add = function(i) {
		$
				.ajax({
					url : '/goodproject/add',
					type : 'POST',

					data : "&name=" + $('#name').val() + "&type="
							+ $('#type').val() + "&price=" + $('#price').val()
							+ "&quantity=" + $('#quantity').val() + "&descr="
							+ $('#descr').val(),
					success : function() {
						
//						var arr1 = document.getElementsByName("idColumn"), result;
//						result= $('#lastId').val();
//							
//							
//						
//						console.log(result);
//						
//						    
//						var n,t,p,q,d;
//						n=$('#name').val();
//						t=$('#type').val();
//						p=$('#price').val();
//						q=$('#quantity').val();
//						d=$('#descr').val();
//						$('#tbody').html($('#tbody').html()+ '<tr ><td name="'+'idColumn"'+' id='+result+'>'+result+'</td><td  id="'+'name'+result+'">'+n+'</td><td id="'+'type'+result+'">'+t+'</td><td id="'+'price'+result+'">'+p+'</td><td id="'+'quantity'+result+'">'+q+'</td><td id="'+'descr'+result+'">'+d+'</td><td><center><input type="'+'checkbox"'+' name="'+result+'" value="'+result+'"></center></td><td><center><input type="'+'radio"'+' name="'+'Radiobutton"'+' id="'+result+'"></center></td></tr>');
						alert("Data Added")

					}
				})

	}

	return this;
}
