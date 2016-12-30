<html>
<head>
    <#include  "/common/js_css/js_css.ftl">
    <title>${pageTitle}</title>

</head>
<body>

    <div class="container">
        <div class="text-center">
            <input type="text" class="form-control" id="userId">

            <div class="text-center">
                <button class="btn btn-danger" onclick="getUser()">提交</button>
            </div>

        </div>
    </div>


    <script>
        
        function getUser() {
            var id = $("#userId").val();
            $.ajax({
                method:"POST",
                url:"/user/"+id,
                success:function (data) {

                    if(data.code == 'success') {
                        alert(data.user.username);
                    }else if (data.code = 'fail'){
                        alert(data.error.errmessage);
                    }

                }
            })
        }

        
    </script>


</body>
</html>