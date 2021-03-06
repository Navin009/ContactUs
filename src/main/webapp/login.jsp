<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet" href="./css/login.css">
</head>

<body>
	<div class="login-container">
		<div class="login-form">
			<div class="login-header">
				<span>Login</span>
			</div>
			<div class="login-body">
				<form action="./login" method="post">
					<div class="form-group">
						<label for="email">Email</label> <input type="text" name="email"
							id="email">
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							name="password" id="password">
					</div>
					<div class="form-group">
						<button type="reset" onclick="contactUsRedirect()">Contact
							Us</button>
						<button type="submit">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function contactUsRedirect() {
			window.location.replace("./contactus");
		}
	</script>
</body>

</html>