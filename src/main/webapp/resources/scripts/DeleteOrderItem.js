var controller = new Controller();

window.onload = function() {
	controller.init();
	 $('#name').val(getCookie("name"));
	 $('#phone').val(getCookie("phone"));
	 $('#email').val(getCookie("email"));
	 self.check();
}



function Controller() {
	self = this;
	this.init = function() {
		document.getElementById("action").onclick = function(e) {
			self.addcookie();
		}

		var arr = document.getElementsByName("Delete");
		var tr = document.getElementsByName("ProductTR");
		for ( var i = 0; i < arr.length; i++) {
			arr[i].onclick = function() {
				 self.sendProduct(this.id);
				
			}
		
		}
			this.sendProduct = function(i) {
				console.log(i);
				$.ajax({
					
					url : './deleteorderitem',
					type : 'POST',
					data : "prod_id=" + i,
					success : function() {
						alert("Product Delete!");
						 $('#'+"tr"+i).remove();
						
					}
				})

			}
			document.onkeyup = function() {
				self.check();
				
			
			
			
			
		
	}
	this.addcookie = function() {
		var name = $('#name').val();
		var phone = $('#phone').val();
		var email = $('#email').val();
		
		setCookie("name",name,"Wed, 02-Jan-2030 00:00:00 GMT");
		setCookie("phone",phone,"Wed, 02-Jan-2030 00:00:00 GMT");
		setCookie("email",email,"Wed, 02-Jan-2030 00:00:00 GMT");
	


	}
	 this.check = function (){
			$('#action').click(function(){});
			/* document.getElementById("action").disabled = true; */
			var key1 = 0;
			var key2 = 0;
			var key3 = 0;
			/*  alert("Vsego kart-k ");  */

			// ������� ����������� �� ������� .blur
		 {
				// ������� ��� ������ � ���� ����� ����
				$('#name').removeClass();
				// ���������� ����� �������� ����
				var nameLngth = $('#name').val().length;

				if (nameLngth <= 1) {
					$('#name').addClass('notValid');
					$(this).next().text('������� ���������� ���� ���');
					key1 = 0;

				} else {
					// ����� �� ����� ��� ������ ����, ���� ��� �������
					// �����
					$('#name').removeClass();
					$(this).next().text('');
					key1 = 1;
				}
				butoon();
			};

			// ������� ����������� �� ������� .blur
			 {
								// ������� ��� ������ � ���� ���� �����
								// ��������
								$('#phone').removeClass();
								// ����� �������� ���� ���� �����
								// ��������
								var phoneV = $('#phone').val();
								// ���������� ����� �������� ����
								var phoneLngth = phoneV.length;
								if (/[^0-9]/.test(phoneV)) {
									$('#phone').addClass('notValid');
									$(this)
											.next()
											.text('����� �������� ������ ��������� ������ �����');
								} else if (phoneLngth <= 5) {
									$('#phone').addClass('notValid');
									$(this)
											.next()
											.text('������� ���������� ��� ����� ��������');
									key2 = 0;
								} else {
									$('#phone').removeClass();
									$(this).next().text('');
									key2 = 1;
								}
								butoon();
							};

				
			$('#email').mousemove( function(){email()});
			$('#email').keyup( function(){email()});
			$('#email').change( function(){email()});
			
			
			{
				// ������� ��� ������ � ���� ����
				// e-mail�
				$('#email').removeClass();
				var emailV = $('#email').val();
				var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,6})+$/;
				// ��������� ����� �� ������ e-mail
				if (filter.test(emailV)) {
					$('#email').removeClass();
					$(this).next().text('');
					key3 = 1;
				} else {
					$('#email').addClass('notValid');
					$(this)
							.next()
							.text('������� ���������� ��������� ��� e-mail');
					key3 = 0;
				}
				butoon();
			}
			
			function butoon() {

				if (key1 == 1 && key2 == 1 && key3 == 1) {
					/* document.getElementById("action").disabled = false; */
					$('#action').click(function(){sendRequest()});
				} else
					/* document.getElementById("action").disabled = true; */
					$('#action').unbind('click', function(){});
				 /* alert(key1+" "+key2+" "+key3+" ");  */
			}
			
			
			
			
			
			
		}
		 
		 
		 
		 
		 
		 
	 }
	
	

	
	return this;
}