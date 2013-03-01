<html>
<head>

    <script type="text/javascript">
        $(document).ready(function () {
            window.alert("AALLLLLLLEEEERRRRTTTT");
        });
    </script>


    <script type="text/javascript" src="../../scripts/jquery-1.4.1.min.js"></script>
    <script type="text/javascript" src="../../scripts/jquery-ui-1.7.2.custom.min.js"></script>
    <script type="text/javascript" src="../../scripts/script.js"></script>
    <script type="text/javascript" src="../../scripts/jquery-1.9.1.js"></script>

    <style type="text/css">
        div {
            padding: 16px;
        }

        .focus, .blur, .change, .select {
            color: white;
            border: 1px solid red;
            background-color: blue;
            padding: 8px;
            margin: 8px;
        }
    </style>
</head>

<body>

<h1>jQuery form events - focus(), change(), blur(), select(), submit() example</h1>

<form name="testing" action="#">
    <div>
        TextBox : <input type="textbox" size="50">
    </div>
    <div>
        <label style="float:left">TextArea : </label>
        <textarea cols="30" rows="5"></textarea>
    </div>
    <div>
        Radio : <input name="sex" type="radio" value="Male" checked>Male</input>
        <input name="sex" type="radio" value="Female">Female</input>
    </div>
    <div>
        CheckBox : <input type="checkbox" name="checkme">Check Me</input>
    </div>

    <div>
        Country : <select id="country">
        <option value="China">China</option>
        <option value="United State">United State</option>
    </select>
    </div>

    <div>
        <input type="submit"> <input type="reset">
    </div>

</form>

<script type="text/javascript">

    $("input,select,textarea").focus(function () {

        $(this).after("<span class='focus'> focus() triggered! </span>");
        $("span").filter('.focus').fadeOut(4000);

    });

    $("input,select,textarea").blur(function () {

        $(this).after("<span class='blur'> blur() triggered! </span>");
        $("span").filter('.blur').fadeOut(4000);

    });

    $("input,select,textarea").change(function () {

        $(this).after("<span class='change'> change() triggered! </span>");
        $("span").filter('.change').fadeOut(4000);

    });

    $("input,textarea").select(function () {

        $(this).after("<span class='select'> select() triggered! </span>");
        $("span").filter('.select').fadeOut(4000);

    });

    $("form").submit(function () {

        alert('Form submitted!');

    });
</script>

</body>
</html>