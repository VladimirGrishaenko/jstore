var controller = new Controller();

window.onload = function() {
	controller.init();	
}


function Controller() {
	self = this;
	this.init = function() {

		document.getElementById("add").onclick = function(e) {
			console.log(e.target.id);
			self.add($(this).attr('id'));
		}
	
}

	this.add = function(i) {
		$
				.ajax({
					url : './addoneuser',
					type : 'POST',

					data : "&name=" + $('#name').val() + "&phone="
					+ $('#phone').val() + "&email=" + $('#email').val()
					+ "&username=" + $('#username').val() + "&role="
					+ $('#role').val(),
					success : function() {				
						
						alert("Data Added")

					}
				})

	}

	return this;
}