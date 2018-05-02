<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Index page</title>
</head>
<body>
<form action="ActionProcess" method="POST">
    <input type="hidden" name="act" value="getdata"/>
    <input type="submit" value="Get Data"/>
</form>
<form action="ActionProcess" method="POST">
    <input type="hidden" name="act" value="showdata"/>
    <input type="submit" value="Show Data"/></form>
<form action="ActionProcess" method="POST">
    <input type="text" name="filter" value="" I>
    <input type="hidden" name="act" value="filteddata"/>
    <input type="submit" value="Filted Data"/>
</form>
</body>
</html>
