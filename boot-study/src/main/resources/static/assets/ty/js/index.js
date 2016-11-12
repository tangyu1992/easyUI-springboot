$(function() {
	getCode();
});
function getCode() {
	$.ajax({
		type : 'GET',
		url : window.location.protocol + '//' + window.location.host + '/img',
		// data : $('#formAdd').serialize(),
		dataType : 'json',
		async : false,
		success : function(data) {
			if (data.iscreated == true) {
				$('#img').attr('src', data.imgCode);
				$('#code').val(data.uuid);
			} else {
				alert("fail!");
			}
		}
	});
}
function refreashCode() {
	getCode();
}