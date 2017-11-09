<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <!-- 引入样式 -->
    <title>${pageTitle}</title>
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

    </div>
    <hr />
</div>
<div class="am-g">
    <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
        <h3>${pageTitle}</h3>
    </div>
</div>

</body>

<#-- 引入js -->
<#include "/common/js_css/js.ftl">
<script>

</script>

</html>