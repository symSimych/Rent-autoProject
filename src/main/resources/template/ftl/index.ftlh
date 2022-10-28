<#import "layouts/main.ftlh" as layout>
<@layout.page>
    <#assign all_cars = "all_cars">
    <#assign add_car = "add_car">
    <#assign registration = "registration">
    <#assign logout = "logout">
    <p>
        <a href="${all_cars}" class="btn btn-info">All Cars</a>
        <a href="${add_car}" class="btn btn-info">Add Car</a>
        <a href="${registration}" class="btn btn-info">Registration</a>
        <a href="${logout}" class="btn btn-info">Sign Out</a>
    </p>
</@layout.page>

