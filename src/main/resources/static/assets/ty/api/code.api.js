var codeUrl = '';
var imgId = '';
var token = '';
function initCode(targetDomain, authToken, pageImgId) {
	if (targetDomain != undefined && authToken != undefined
			&& pageImgId != undefined
			&& document.getElementById( pageImgId) && authToken != '') {
		codeUrl = targetDomain + '/getCode';
		imgId = pageImgId;
		token = authToken;
		getCode();
	}

}
function getCode() {
	if (codeUrl != undefined && token != undefined && imgId != undefined
			&& document.getElementById('' + imgId) && token != '') {
		$.ajax({
			type : 'GET',
			url : codeUrl,
			data : {
				token : token
			},
			dataType : 'json',
			async : false,
			error : function(jqXHR, textStatus, errorThrown) {
				if (textStatus == "timeout") {
					alert("加载超时，请重试");
				} else {
					alert(textStatus);
				}
			},
			success : function(data) {
				if (data.iscreated == true) {
					$('#' + imgId).attr('src', data.imgCode);
					$('#key').val(data.uuid);
				} else {
					alert("fail!");
				}
			}
		});
	}
}
function refreashCode() {
	getCode();
}