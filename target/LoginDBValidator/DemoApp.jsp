<!DOCTYPE html>
<html>
<style>
    input[type=text], input[type=password] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    button {
        background-color: #fd4343;;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;

    }

    button:hover {
        opacity: 0.8;
    }

    .container {
        margin: 0 auto;
        width: 50%;
        text-align: center;
        padding-top: 100px;
    }

</style>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div id="text">
        <h3>Welcome to the OAuth2.0 Demo Application!</h3>
    </div>
    <button type="button" id="LoginVia" onclick="visitGooglePage()">Login via Google</button>
</div>

<script type="text/javascript">
    var rootURL = "http://localhost:8080/webapi/";
    var client_id = "DemoApp";
    var redirect_uri = "/demo-app/callback";

    function visitGooglePage() {
        window.location = rootURL + 'login?client_id=' + client_id + '&redirect_uri=' + redirect_uri;
    }
</script>

</body>
</html>
