// 这里的$ var 出现下划线没关系，通过测试可以知道，已经起到了作用，如果有问题，重启IDEA，手动部署项目就好了。
function post() {
    var questionId = $("#question_id").val();
    // console.log(questionId); // 测试是否能收到id
    var content = $("#comment_content").val();
    // console.log(content); // 测试是否能拿到值

    if(!content) {
        alert("回复不能为空");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/json',
        data: JSON.stringify({
            "parentId": questionId,
            "content": content,
            "type": 1
        }),
        success: function (response) {
            if (response.code == 200) {
                location.reload();
            } else {
                if(response.code == 2003) {
                    var isAccepted = confirm(response.message);
                    if(isAccepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=b2bdb77b12d28d02cd9d&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", true);
                    }
                } else {
                    alert(response.message);
                }
            }
            console.log(response);
        },
        dataType: "json"
    });
}