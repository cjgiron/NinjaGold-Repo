<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<h3>Your Gold: ${gold}</h3>
	<div class="container">
		<form class="box" method="POST" action="/processGold">
			<input type="hidden" value="farm" name="venue"/>
			<h3>Farm</h3>
			<p>(earns 10-20 gold)</p>
			<button type="submit">Find Gold</button>
		</form>
		<form class="box" method="POST" action="/processGold">
			<input type="hidden" value="cave" name="venue"/>
			<h3>Cave</h3>
			<p>(earns 5-10 gold)</p>
			<button type="submit">Find Gold</button>
		</form>
		<form class="box" method="POST" action="/processGold">
			<input type="hidden" value="house" name="venue"/>
			<h3>House</h3>
			<p>(earns 2-5 gold)</p>
			<button type="submit">Find Gold</button>
		</form>
		<form class="box" method="POST" action="/processGold">
			<input type="hidden" value="casino" name="venue"/>
			<h3>Casino</h3>
			<p>(earns/takes 0-50 gold)</p>
			<button type="submit">Find Gold</button>
		</form>
	</div>
	<div>
		<p>${activityLog}</p>
	</div>
	<a href="/reset">Reset</a>
</body>
</html>