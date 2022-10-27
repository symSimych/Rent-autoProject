<#macro content url>
    <div id = "header">
        <h2>
            Auto-rent demo
        </h2>
    </div>
    <div id="container">
        <#import "/partial/${url}" as c>
        <@c.content />
    </div>
</#macro>