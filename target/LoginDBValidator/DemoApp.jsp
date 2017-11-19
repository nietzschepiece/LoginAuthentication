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

    .form-auth {
        max-width: 400px;
        margin: 20px auto 20px;
        background-color: #FFF;
        padding: 20px 40px 20px;
        border-radius: 5px;
        -webkit-box-shadow: 1px 2px 5px #CCC;
        -moz-box-shadow: 1px 2px 5px #CCC;
        box-shadow: 1px 2px 5px #CCC;
    }

</style>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <form class="form-auth -gui-form -form-blocks -wide" data-validate-on-submit="" novalidate="">
        <input type="hidden" name="action_token" value="ba936e5c244a38621eb02ddd755e52fcdebb227c">
        <div id="text">
            <h3>Welcome to the OAuth2.0 Demo Application!</h3>
            <h3>This is the client application</h3>
        </div>
        <button type="button" id="LoginVia" onclick="visitGooglePage()">Login via third party app</button>
    </form>
</div>

<script type="text/javascript">
    var rootURL = "http://localhost:8080/webapi/";
    var client_id = "demoApp";
    var redirect_uri = "http://localhost:8080/webapi/demoApp?callbackURL";

    function visitGooglePage() {
        window.location = rootURL + 'login?client_id=' + client_id + '&redirect_uri=' + redirect_uri;
    }
</script>

</body>
</html>
