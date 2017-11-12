<!DOCTYPE html>
<html>
<style>
    #content .authorize_options li {
        float: left;
        list-style-type: none;
        font-style: normal;
    }
    #content ul li {
        font-style: italic;
        font-size: 14px;
        color: #D85700;
    }
    .button {
        color: #333;
        text-shadow: 0 1px 0 white;
        border: 1px solid #D4D4D4;
        border-bottom-color: #BCBCBC;
        background: #FAFAFA;
        background: -moz-linear-gradient(#FAFAFA, #EAEAEA);
        background: -webkit-linear-gradient(#FAFAFA, #EAEAEA);
        -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#fafafa', endColorstr='#eaeaea')";
        position: relative;
        display: inline-block;
        padding: 0 10px 0 10px;
        font-family: Helvetica, arial, freesans, clean, sans-serif;
        font-size: 13px;
        font-weight: bold;
        line-height: 24px;
        white-space: nowrap;
        border-radius: 3px;
        cursor: pointer;
        -webkit-touch-callout: none;
        -webkit-user-select: none;
        -khtml-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
        text-decoration: none;
    }
    #container {
        margin-left: auto;
        margin-right: auto;
        width: 974px;
        padding: 0;
    }
    #content {
        margin-left: auto;
        margin-right: auto;
        width: 974px;
        float: left;
        background: white;
        padding: 10px 20px;
        -moz-box-shadow: 0 0 1px #999;
        -webkit-box-shadow: 0 0 1px #999;
        -o-box-shadow: 0 0 1px #999;
        box-shadow: 0 0 1px #999;
        margin-bottom: 10px;
        position: relative;
    }

</style>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div id="container">
<div id="content" role="main">
    <h3>
        Welcome to the Google Server!
    </h3>
    <p>
        You have been sent here by <strong>demoapp</strong>.  demoapp would like to access the following data:
    </p>
    <ul>
        <li>friends</li>
        <li>memories</li>
        <li>hopes, dreams, passions, etc.</li>
        <li>sock drawer</li>
    </ul>
    <p>It will use this data to:</p>
    <ul>
        <li>integrate with friends</li>
        <li>make your life better</li>
        <li>miscellaneous nefarious purposes</li>
    </ul>
    <p>Click the button below to complete the authorize request and grant an <code>Authoriation Code</code> to demoapp.
    </p><ul class="authorize_options">
    <li>
        <form action="authorize" method="post">
            <input type="submit" class="button authorize" value="Yes, I Authorize This Request">
            <input type="hidden" name="authorize" value="1">
        </form>
    </li>
    <li class="cancel">
        <form id="cancel">
            <a href="#" onclick="document.getElementById('cancel').submit()">cancel</a>
            <input type="hidden" name="authorize" value="0">
        </form>
    </li>
</ul>
</div>
</div>
<script type="text/javascript">

</script>

</body>
</html>
