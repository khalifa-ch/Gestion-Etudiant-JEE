<!DOCTYPE html>
<html>
<head>	
	<title>Login</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
	<script src="jQuery/jquery-3.1.1.min.js" type="text/javascript"></script>
	<style type="text/css">
	
		body{
			background-color: black;
		}

		#box{
			height: 2px;
			width: 1px;
			padding: 5px;
			background-color: transparent;
			border-radius: 10px;
			line-height:90px;
			box-shadow: 0 0 15px #A9A9A9;
		}
		#circle{
			height: 100%;
			width: 75%;
			border-radius: 400px;
			background-color: none;
			padding-bottom: 30px;
			border : 4px solid #00cccc;
		}
		#in{
			width: 90%;
			height: 50px;
			border-radius: 10px;
			padding: 8px;
			border : 4px solid #008B8B;
			background-color: #333333;
			color: white;
		}
		#in:focus{
			border:6px solid #008B8B;
		}
		#inBtn{
			width: 90%;
			height: 50px;
			border-radius: 10px;
			line-height:10px;
			border : 4px solid #008B8B;
			background-color: #333333;
			color:white;
			cursor: pointer;
		}
		#copy{
			color: #008B8B;
			text-align: center;
			font-style: italic;
		}
		footer{
			position:fixed;		    
		    bottom:0px;
		    left:0px;
		    right:0px;
		    margin-bottom:0px;
		}
		hr{
			color: #00cccc;
		}
	</style>

</head>
<body background="image/a.jpg" style="background-repeat:no-repeat;background-size:cover;" >
	<br>
	<hr>
	<h1 align="center" style="color:#008B8B;">Login Form</h1>
	<hr>
	<br>
	<form class="was-validated" action="connServlet" method="POST">
		<center>
				<h1 id="blinking" style="color: #008B8B;">Please Login Here</h1>				
				<div id="box">
					<input type="text" name="login" id="in" placeholder="Username"><br>
					<input type="password" name="password" placeholder="Password" id="in">
					<input type="submit"  value="connexion" id="inBtn" style="color:white;">
					<p class="box-register">Vous êtes nouveau ici? <a href="inscription.jsp" style="color: #008B8B;">S'inscrire</a></p>
				</div>
		</center>
		
	</form>

	<br><br><br><br>
	<!-- <hr>
		<p id="footer">Misfar ©</p>
	<hr> -->
	<footer>
		<hr>
			<p id="copy">Yassine Ben Ghanem ©</p>
		<hr>
	</footer>
	<script type="text/javascript">

	$(document).ready(function(){
		$("#circle").hide();
		$("#box").animate({height:"280px"},"slow");
		$("#box").animate({width:"450px"},"slow");
		$("#circle").fadeIn(1000);

	});
	function blinker(){
		$('#blinking').fadeOut("slow");
		$('#blinking').fadeIn("slow");
	}
	setInterval(blinker, 1000);

	</script>
</body>
</html>
