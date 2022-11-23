<#import "../layouts/main.ftlh" as layout>
<@layout.page>
    <h1>Edit user ${user.email}</h1>
    <form action="/admin/edit-user" method="post">
        <#list roles as role>
            <div>
                <label><input type="checkbox" ${user.roles?seq_contains(role)?string("", "")} name="${role}"/>${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${user.email}" name="user" />
        <input type="submit" value="Save"/>
    </form>
</@layout.page>