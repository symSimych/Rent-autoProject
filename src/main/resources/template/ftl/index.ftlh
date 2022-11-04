<#import "layouts/main.ftlh" as layout>
<@layout.page>
    <#assign all_cars = "all_cars">
    <#assign registration = "registration">
    <#assign logout = "logout">
    <p>
        <a href="${all_cars}" class="btn btn-info">All Cars</a>
        <a href="${registration}" class="btn btn-info">Registration</a>
        <a href="${logout}" class="btn btn-info">Sign Out</a>
        <#if user.isAdmin()>
            <a href="/admin" class="btn btn-info">Admin Panel</a>
        </#if>
        <#if user.isManager()>
            <a href="/manager" class="btn btn-info">Manager Panel</a>
        </#if>
    </p>
</@layout.page>

