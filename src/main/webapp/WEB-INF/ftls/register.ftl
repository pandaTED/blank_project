<#include "/common/js_css/css.ftl">
    <style>

        .header {
            text-align: center;
        }
        .header h1 {
            font-size: 200%;
            color: #333;
            margin-top: 30px;
        }
        .header p {
            font-size: 14px;
        }

    </style>
</head>
<body>

<div class="header">
    <div class="am-g">
        <h3>管理后台</h3>
    </div>
    <hr />
</div>
<div class="am-g">
    <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
        <h3>注册</h3>
        <hr>
        <br>
        <br>

        <form method="post" class="am-form" action="${basePath}/register">

            <label for="username">用户名:</label>
            <input type="text" name="username" id="username">
            <br>
            <label for="password">密码:</label>
            <input type="password" name="password" id="password">
            <label for="repeatpassword">重复密码:</label>
            <input type="password" name="repeatpassword" id="password">
            <br>

            <span style="color: #ff0000"> ${errMsg} </span>

            <br />
            <div class="am-cf">
                <input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
                <a href="${basePath}/login.jsp"  class="am-btn am-btn-primary am-btn-sm am-fl">登陆</a>
                <input type="submit" name="" value="忘记密码 ^_^? " class="am-btn am-btn-default am-btn-sm am-fr">
            </div>
        </form>

        <hr>

    </div>
</div>



<#-- 引入js -->
<#include "/common/js_css/js.ftl">
<script>

</script>
</body>
</html>