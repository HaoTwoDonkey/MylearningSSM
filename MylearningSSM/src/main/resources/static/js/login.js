$(document).ready(function () {

});

Login = {
    /**
     * 登录的动作
     */
    doLog: function () {
        var userName = $("#username").val();
        var password = $("#password").val();
        if (userName == null || userName == "") {
            alert("用户名不能为空！");
            return;
        }
        if (password == null || password == "") {
            alert("密码不能为空！");
            return;
        }

        $.ajax({
            type: "POST",
            dataType: "json",
            url: "/login",
            data: $('#adminlogin').serialize(),
            success: function (result) {
                if (result.resultCode == 666) {
                    window.location.href = "main.html";
                }else{
                    $("#errorText").html(result.message);
                }
            },
            error: function () {
                alert("异常！");
            }
        });
    }


}