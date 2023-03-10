<#import "common/html.ftl" as html>

<@html.root "Главная">

    <#if books??>
        <div class="list">
            <#list books as book>
                <a href="/books/${book.id}">${book.name}</a><br>
            </#list>
        </div>
    </#if>

</@html.root>