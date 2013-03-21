$(document).ready(function() {
	/*alert("QQQQQQQ");*/
	$('#action').click(function(){});
	/* document.getElementById("action").disabled = true; */
	var key1 = 0;
	var key2 = 0;
	var key3 = 0;
	/*  alert("Vsego kart-k ");  */

	// Функция срабатывает по событию .blur
	$('#name').keyup(function() {
		// Убираем все классы с поля «Ваше имя»
		$('#name').removeClass();
		// Определяем длину значения поля
		var nameLngth = $('#name').val().length;

		if (nameLngth <= 1) {
			$('#name').addClass('notValid');
			$(this).next().text('Введите пожалуйста ваше имя');
			key1 = 0;

		} else {
			// Здесь мы пишем что должно быть, если все введено
			// верно
			$('#name').removeClass();
			$(this).next().text('');
			key1 = 1;
		}
		butoon();
	});

	// Функция срабатывает по событию .blur
	$('#phone').keyup(function() {
						// Убираем все классы с поля «Ваш номер
						// телефона»
						$('#phone').removeClass();
						// Берем значение поля «Ваш номер
						// телефона»
						var phoneV = $('#phone').val();
						// Определяем длину значения поля
						var phoneLngth = phoneV.length;
						if (/[^0-9]/.test(phoneV)) {
							$('#phone').addClass('notValid');
							$(this)
									.next()
									.text('Номер телефона должен содержать только цифры');
						} else if (phoneLngth <= 5) {
							$('#phone').addClass('notValid');
							$(this)
									.next()
									.text('Введите пожалуйста ваш номер телефона');
							key2 = 0;
						} else {
							$('#phone').removeClass();
							$(this).next().text('');
							key2 = 1;
						}
						butoon();
					});

		
	$('#email').mousemove( function(){email()});
	$('#email').keyup( function(){email()});
	$('#email').change( function(){email()});
	
	
	function email() {
		// Убираем все классы с поля «Ваш
		// e-mail»
		$('#email').removeClass();
		var emailV = $('#email').val();
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,6})+$/;
		// Проверяем верно ли введен e-mail
		if (filter.test(emailV)) {
			$('#email').removeClass();
			$(this).next().text('');
			key3 = 1;
		} else {
			$('#email').addClass('notValid');
			$(this)
					.next()
					.text('Введите пожалуйста правильно ваш e-mail');
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

});
