<#import "../common/html.ftl" as html>
<#import "../common/lookup.ftl" as filter>

<@html.root "Книги">

    <@filter.lookup "/books"></@filter.lookup>

    <#list books as book>
        <h4>
            <a href="/books/${book.id!}">${book.name!}</a><br>
        </h4>
    </#list>

</@html.root>