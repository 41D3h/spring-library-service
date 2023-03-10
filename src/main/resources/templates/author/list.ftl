<#macro list authors>

    <#list authors as author>
        <h4>
            <a href="/authors/${author.id!}">
                <#if author.surname?has_content>
                    ${author.surname!}
                </#if>

                ${author.name?substring(0,1) + "."}

                <#if author.patronymic?has_content>
                    ${author.patronymic?substring(0, 1) + "."}
                </#if>
            </a><br>
        </h4>
    </#list>

</#macro>