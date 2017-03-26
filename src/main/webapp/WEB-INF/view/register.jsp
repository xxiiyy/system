<!DOCTYPE html>
<head>
    <title>Create Account</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="resources/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="resources/css/templatemo_style.css" rel="stylesheet" type="text/css">
</head>
<body class="templatemo-bg-gray">
<h1 class="margin-bottom-15">Create User</h1>
<div class="container">
    <div class="col-md-12">
        <form class="form-horizontal templatemo-create-account templatemo-container" role="form" action="registerMethod"
              method="post">
            <div class="form-inner">
                <div class="form-group">
                    <div class="col-md-6">
                        <label for="first_name" class="control-label">nickname</label>
                        <input type="text" required class="form-control" name="nickName" id="first_name" placeholder="">
                    </div>
                    <div class="col-md-6 templatemo-radio-group">
                        <label class="radio-inline">
                            <input type="radio" name="sex" checked id="optionsRadios1" value="1"> Male
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="sex" id="optionsRadios2" value="0"> Female
                        </label>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-6">
                        <label for="username" class="control-label">username</label>
                        <input type="text" required name="loginName" class="form-control" id="username" placeholder="">
                    </div>

                </div>
                <div class="form-group">
                    <div class="col-md-6">
                        <label for="password" class="control-label">password</label>
                        <input type="password" required name="password" class="form-control" id="password" placeholder="">
                    </div>

                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <input id="submit" type="submit" value="Create user" class="btn btn-info">
                        <a href="login" class="pull-right">Login</a>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    /*$("#submit").click(function () {
        var obj = new Object();
        obj.loginName = $("#username");
        obj.password = $("#password");
        obj.name = $("#name");
        obj.birthday = $("#birthday");
        if($("#repassword") == obj.password) {
            $.post(registerMethod, obj, function (result) {
                    alert("添加成功");
            });
        }
    })*/

</script>
<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
</body>
</html>