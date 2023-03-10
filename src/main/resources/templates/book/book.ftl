<#import "../common/html.ftl" as html>
<#import "../author/list.ftl" as wa>

<#assign title>
    ${(book.name)!"Название книги неизвестно"}
</#assign>

<@html.root title>

        <h3>Название: ${book.name!}</h3>
        <h4>Авторы</h4>
        <@wa.list book.authors></@wa.list>

</@html.root>