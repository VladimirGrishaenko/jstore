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

	
	this.check = function() {

		var name = document.getElementById("name");

		if (name.value === '') {
			return false;
		} else {
			return true;
		}

	}
	this.check1 = function() {

		var phone = document.getElementById("phone");
		if (phone.value === '') {
			return false;
		} else {
			return true;
		}

	}
	

	this.checkEmail = function() {

		var email = document.getElementById("email");
		if (email.value === '') {
			return false;
		} else {
			return true;
		}
	}
	
	this.check2 = function() {

		var username = document.getElementById("username");

		if (username.value === '') {
			return false;
		} else {
			return true;
		}

	};

	this.getRadio = function(i) {
		var name = $('#name' + i).html();
		$('#Editname').val(name);
		
		var phone = $('#phone' + i).html();
		$('#Editphone').val(phone);
		
		var email = $('#email' + i).html();
		$('#Editemail').val(email);
		
		var username = $('#username' + i).html();
		$('#Editusername').val(username);
		
		var role = $('#role' + i).html();
		$('#Editrole').val(role);
		
		document.getElementsByName("Edit")[0].id = i;
	};

	this.edit = function(i) {		
		$.ajax({
			url : './editoneuser',
			type : 'POST',

			data : "id=" + i + "&name=" + $('#Editname').val() + "&phone="
					+ $('#Editphone').val() + "&email=" + $('#Editemail').val()
					+ "&username=" + $('#Editusername').val() + "&role="
					+ $('#Editrole').val(),
			success : function() {
				$('#name' + i).html($('#Editname').val());
				$('#phone' + i).html($('#Editphone').val());
				$('#email' + i).html($('#Editemail').val());
				$('#username' + i).html($('#Editusername').val());	
				$('#role' + i).html($('#Editrole').val());

			}
		})

	}

	return this;
}
