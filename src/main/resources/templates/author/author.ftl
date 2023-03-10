<#import "../common/html.ftl" as html>
<#import "../common/header.ftl" as header>
<#import "../common/footer.ftl" as footer>

<#assign title>
    ${author.name!}
    <#if author.patronymic?has_content>
        ${author.patronymic}
    </#if>
    <#if author.surname?has_content>
        ${author.surname!}
    </#if>
</#assign>

<@html.root title>

        <#if author??>
            <h3>О авторе:</h3>
            <#if author.surname?has_content>
                <p>Фамилия: ${author.surname!}</p>
            </#if>
            <p>Имя: ${author.name!}</p>
            <#if author.patronymic?has_content>
                <p>Отчество: ${author.patronymic}</p>
            </#if>

            <#list author.books as book>
                <a href="/books/${book.id!}">${book.name!}</a><br>
            </#list>
        </#if>

</@html.root>