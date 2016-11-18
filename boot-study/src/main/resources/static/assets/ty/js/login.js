$(function() {
	initCode(window.location.protocol + '//' + window.location.host, 'token',
			'img');
});
function changeCode() {
	refreashCode();
}
function login() {
	var result = false;
	$.ajax({
		type : 'GET',
		url : '/auth',
		data : $('#loginForm').serialize(),
		dataType : 'json',
		async : false,
		error : function(jqXHR, textStatus, errorThrown) {
			if (textStatus == "timeout") {
				alert("加载超时，请重试");
			} else {
				alert(textStatus);
			}
			result = false;
		},
		success : function(data) {
			if (data.success == true) {
				result = true;
			} else {
				alert(data.msg);
				refreashCode();
				$('#code').val('');
				result = false;
			}
		}
	});
	return result;
}