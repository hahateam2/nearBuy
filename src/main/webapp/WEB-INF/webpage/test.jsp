<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath %>">
    <title>Title</title>
    <link rel="stylesheet" href="uploadFiles/ss.css">
    <script src="uploadFiles/as.js"></script>
</head>
<body>
<img src="uploadFiles/image/123.jpg" alt="">
<h1>sfsfaf</h1>
</body>
</html>
