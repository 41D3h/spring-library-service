<#import "../common/html.ftl" as html>

<@html.root "Добавить книгу">

        <form method="post" action="/books/add">
            <span>Название книги: </span><input type="text" name="name" value="${book.name!}"/><br>
            <span>Авторы: </span>
            <select name="authors">
                <option value="">Выберите автора</option>
                <#list authors as author>
                    <option value="${author.id!}" <#if book.authors!?seq_contains(author)>selected</#if>>
                        ${author.surname!} ${author.name!} ${author.patronymic!}
                    </option>
                </#list>
            </select><br>
            <input type="submit" value="Сохранить"/>
        </form>

</@html.root>