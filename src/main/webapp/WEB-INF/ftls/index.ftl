<#include "/common/js_css/css.ftl">
    <style>

    </style>
</head>
<body>

    <div class="am-g">
        <div class="am-u-sm-6 am-u-sm-centered">

            <#-- 导航栏-->
                <header class="am-topbar am-topbar-inverse am-topbar-fixed-top">
                    <div class="am-container">
                        <h1 class="am-topbar-brand">
                            <a href="#" class="am-text-ir">Amaze UI</a>
                        </h1>

                        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
                                data-am-collapse="{target: '#doc-topbar-collapse-4'}"><span class="am-sr-only">导航切换</span> <span
                                class="am-icon-bars"></span></button>

                        <div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse-4">
                            <ul class="am-nav am-nav-pills am-topbar-nav">
                                <li class="am-active"><a href="#">首页</a></li>
                                <li><a href="${basePath}/admin/privilege.jsp">权限设置</a></li>
                                <li><a href="${basePath}/admin/role.jsp">岗位设置</a></li>
                                <li><a href="${basePath}/admin/user.jsp">用户设置</a></li>
                                <li class="am-dropdown" data-am-dropdown>
                                    <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                                        下拉 <span class="am-icon-caret-down"></span>
                                    </a>
                                    <ul class="am-dropdown-content">
                                        <li><a href="#">带我去月球</a></li>
                                        <li><a href="#">还是回地球</a></li>
                                        <li class="am-disabled"><a href="#">臣妾做不到</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </header>



        </div>
    </div>

<#-- 引入js -->
<#include "/common/js_css/js.ftl">
<script>

</script>
</body>
</html>