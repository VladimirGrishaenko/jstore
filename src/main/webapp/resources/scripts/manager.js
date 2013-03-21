var controller = new Controller();

$(document).ready(function() {
	$("#myTable").tablesorter({
		sortList : [ [ 0, 0 ], [ 1, 0 ] ]
	});
});

function editStatus(id){
	controller.init(id);
}

function Controller(){
	self = this;
	this.init = function(id) {
		self.add(id);
	};
	
	this.add = function(id) {
		$.ajax({
			url : './changestatus',
			type : 'POST',
			data : "&status=" + $('#status'+id).val() + "&id=" + $('#idOrder'+id).text(),
			
			success : function() {		
				alert("Order status changed");
			},
			error : function(){
				alert("The request failed");
			}
		});
	};
	return this;
}
