<#macro page>
    <!doctype html>
    <html>
        <#import "/partial/header.ftlh" as h>
        <@h.header />
        <body>
            <div id="container">
                <#nested>
            </div>
            <#import "/partial/footer.ftlh" as f>
            <@f.footer />
        </body>
    </html>
</#macro>