<#import "../layouts/main.ftlh" as layout>
<@layout.page>
        <table class="w3-centred">
                <tr>
                    <th>Name</th>
                    <th>Lastname</th>
                    <th>Phone number</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Roles</th>
                    <th></th>
                </tr>
                <#list model["userList"] as user>
                    <tr>
                        <td>${user.firstname}</td>
                        <td>${user.lastname}</td>
                        <td>${user.phoneNumber}</td>
                        <td>${user.email}</td>
                        <td>${user.password}</td>
                        <td><#list user.roles as role>${role}</#list></td>
                        <td><a href="admin/edit-user/${user.email}">Edit</a></td>
                    </tr>
                </#list>
            </table>
</@layout.page>