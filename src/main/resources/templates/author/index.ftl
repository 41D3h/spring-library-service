<#import "../common/html.ftl" as html>
<#import "../common/lookup.ftl" as filter>
<#import "list.ftl" as wa>

<@html.root "Авторы">

        <@filter.lookup "/authors"></@filter.lookup>
        <@wa.list authors></@wa.list>

</@html.root>