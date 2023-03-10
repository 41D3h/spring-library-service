<#import "../common/html.ftl" as html>

<@html.root "Добавить автора">

        <form method="post" action="/authors/add">
            <p>Фамилия: <input type="text" name="surname" value="${author.surname!}"/></p>
            <p>Имя: <input type="text" name="name" value="${author.name!}"/></p>
            <p>Отчество: <input type="text" name="patronymic" value="${author.patronymic!}"/></p>
            <input type="submit" value="Сохранить"/>
        </form>

</@html.root>


