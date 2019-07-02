<html>
<head>
    <title>文章列表</title>
    <script type="application/javascript" >
        function getValue()
        {
            var x=document.getElementById("id1")
            alert(x.innerHTML);

        }
    </script>
</head>

<body>
<h6>Freemarker 模板引擎</h6>
<table border="1">
    <thead>
    <tr>
        <#--这种注释不会在页面审查中显示出来-->
        <th>序号</th>
        <th>标题</th>
        <th>摘要</th>
        <th>创建时间</th>
    </tr>
    </thead>
        <#list list as article>
            <tr>
                <td id ="id1" onclick="getValue()">${article.id}</td>
                <td>${article.title}<#if article.title == "c2">,这是才222222</#if></td>
                <td>${article.summary}</td>
                <td>${article.createTime?string('yyyy-MM-dd hh:mm:ss')}</td>
            </tr>
        </#list>
</table>
</body>
</html>