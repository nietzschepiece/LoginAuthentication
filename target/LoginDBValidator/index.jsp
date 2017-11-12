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
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
    }

    button:hover {
        opacity: 0.8;
    }

    .container {
        margin: 0 auto;
        padding: 16px;
        width:20%;
     }

</style>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<form>
    <div class="container">
        <label><b>Username</b></label>
        <input type="text" placeholder="Enter Username" id="user" required>

        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password" id="pass" required>

        <button type="button" id="loginButton" >Login</button>
    </div>
</form>

<script type="text/javascript">
    document.getElementById ("loginButton").addEventListener ("click", postMethod);
    var rootURL = "http://localhost:8080/webapi/";

    function postMethod() {
        var user = document.getElementById('user').value
        var pass = document.getElementById('pass').value
        var auth = window.btoa(user + ":" + pass);
        console.log(auth)
        $.ajax({
            type: 'POST',
            url: rootURL + 'login',
            headers: { 'Authorization': auth },
            dataType: "text",
            success: function(data, textStatus, jqXHR){
                alert("Login: " + textStatus );
            },
            error: function(jqXHR, textStatus, errorThrown){
                alert("Login: " + textStatus + errorThrown);
            }
        });
    }
</script>

</body>
</html>
