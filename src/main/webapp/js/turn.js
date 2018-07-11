window.onload=function(){
	alert($("#h").val())
	$("#userAdmin").click(function() {
		$(".page").css("opacity", 0);
		$(".users").css("opacity", 1);
	})
	$("#control").click(function() {
		$(".page").css("opacity", 0);
		$(".userdetail").css("opacity", 1);
	})
	$("#wei").click(function() {
		$(".page").css("opacity", 0);
		$(".weibo").css("opacity", 1);
	})
	$("#message").click(function() {
		$(".page").css("opacity", 0);
		$(".adminpage").css("opacity", 1);
	})
}
