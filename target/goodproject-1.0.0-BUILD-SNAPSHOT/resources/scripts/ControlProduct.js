var controller = new Controller();

window.onload = function() {
	controller.init();

}



function Controller() {
	self = this;
	this.init = function() {
		document.getElementById("linkprice_sort").onclick = function() { self.check(); };
		var arr = document.getElementsByName("Add");
		for ( var i = 0; i < arr.length; i++) {
			arr[i].onclick = function() {
				 self.sendProduct(this.id);

			}
		
		}
		this.check = function() {

			
			var regex = new RegExp(/^(?:\d+?)$/);
			var less = document.getElementById("less");
			var more = document.getElementById("more");
			if (regex.test(less.value) && regex.test(more.value) ) {
				
				window.location.replace($('#linkprice').attr('href')+"&l="+less.value+"&m="+more.value);
			} else {
			
			}

		}
		
		
			this.sendProduct = function(i) {
				console.log(i);
				$.ajax({
					url : '/goodproject/shopcartadd',
					type : 'POST',
					data : "prod_id=" + i,
					success : function() {
						alert("Product Added!");
						
					}
				})

			}
		
	}
	
	
	

	
	return this;
}
