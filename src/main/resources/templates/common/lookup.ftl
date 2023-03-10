<#macro lookup path>

    <form action="${path}" method="post">
        <input type="text" name="filter"/>
        <input type="submit" value="Найти"/>
    </form>

</#macro>