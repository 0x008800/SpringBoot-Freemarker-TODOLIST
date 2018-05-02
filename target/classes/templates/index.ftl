<html xmlns="http://www.w3.org/1999/html">
<body>
<#list tasks as t>
    <form action="/delete/${t.id}" method="get">
        <p> ${t.text}
        <input type="submit" value="Delete this task"/>
    </form>
</#list>
<form name="form" action="/add" method="post">
    <input type="text" name="text" autofocus/>
    <input type="submit" value="Add a new task"/>
</form>
</body>
</html>
