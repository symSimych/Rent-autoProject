<#import "../layouts/main.ftlh" as layout>
<@layout.page>
    <h1>Edit user ${user.email}</h1>
    <form action="/admin/edit_user" method="post">
        <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${user.email}" name="email" />
        <input type="submit" value="Save"/>
    </form>
</@layout.page>