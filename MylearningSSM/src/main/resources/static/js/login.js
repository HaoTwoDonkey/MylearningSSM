$(document).ready(function () {

});

Login = {
    /**
     * ��¼�Ķ���
     */
    doLog: function () {
        var userName = $("#username").val();
        var password = $("#password").val();
        if (userName == null || userName == "") {
            alert("�û�������Ϊ�գ�");
            return;
        }
        if (password == null || password == "") {
            alert("���벻��Ϊ�գ�");
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
                alert("�쳣��");
            }
        });
    }


}