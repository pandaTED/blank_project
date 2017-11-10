<#--取得应用的绝对路径-->
<#assign basePath=request.contextPath>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
    <#if pageTitle??>
       ${pageTitle}
    </#if>
</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />

<#--导入css-->
<link rel="stylesheet" href="${basePath}/resources/css/amazeui.min.css"/>
<link rel="stylesheet" href="${basePath}/resources/css/app.css"/>