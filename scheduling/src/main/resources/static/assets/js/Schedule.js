function back(number) {
	alert(number)
	window.history.go(number)
}


if (performance.navigation.type == 1) {
	var frame = document.getElementById("iFrame");
}