<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us Page</title>
    <link rel="stylesheet" href="./css/contactus.css">
</head>

<body>
    <div class="container">
        <header>
            <h1>Contact Us</h1>
            <h4>Please fill this form in decent manner</h4>
        </header>
        <form action="./contactus" method="post" class="container-form">
            <div class="form-block">
                <label for="name">Full Name <sup>*</sup></label>
                <input type="text" name="name" id="name" required>
            </div>
            <div class="form-block">
                <label for="email">E-mail <sup>*</sup></label>
                <input type="text" name="email" id="email" required>
            </div>

            <div class="form-block">
                <label for="message">Message <sup>*</sup></label>
                <textarea name="message" id="message" cols="30" rows="7" required></textarea>
            </div>
            <div>
                <button type="submit">Submit</button>
                <button onclick="loginRedirect()">Admin login</button>
            </div>
        </form>
    </div>
    <script type="text/javascript">
        function loginRedirect() {
            window.location.replace("./login");
        }
    </script>
</body>

</html>