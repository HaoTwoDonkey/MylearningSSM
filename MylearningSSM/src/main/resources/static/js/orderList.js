
$(document).ready(function () {
    OrderList.init();
})


OrderList = {

    gird : null,
    init : function () {
        OrderList.gird = $('#orderGrid');
        //OrderList.queryList();
    },
    queryList : function () {
        OrderList.gird.datagrid('load',{
            name:$('#itemName').val()
        });
    },
    formatDate : function (val) {
        return OrderList.timeStampToTime(val);
    },
    timeStampToTime : function (val) {
        var date = new Date(val);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
        Y = date.getFullYear() + '-';
        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        D = date.getDate() + ' ';
        return Y+M+D;
    },
    doAdd : function () {
        $("#dlg").dialog("open").dialog("setTitle", "新增订单信息");
    },
    doSave : function () {
        if(!$('#ff').form('validate')){
            return;
        }
        $.ajax({
            type: "post",
            url: "/items/addItem",
            data: {
                name : $("#name").val(),
                price : $("#price").val(),
                detail : $("#detail").val()
            },
            success: function (data) {
                if(data.resultCode!="666"){
                    alert("新增失败");
                }else{
                    OrderList.doCanCel();
                    OrderList.queryList();
                }
            },
            error: function (err,err1,err2) {
            }
        });

    },
    doCanCel :function () {
        $("#dlg").dialog("close");
    }






}