<#import "../layouts/main.ftlh" as layout>
<@layout.page>
    <a href="/manager/car_manage" class="btn btn-info">Car manage</a>
    <form name="phoneNumber" action="/manager" method="post">
        Phone number: <input type="tel" name="phone_number" />
        <input type="submit" value="Find"/>
    </form>
    <table class="w3-centred">
            <tr>
                <th>Place of filing</th>
                <th>Filing time</th>
                <th>Place of return</th>
                <th>Return time</th>
                <th>Car brand</th>
                <th>Car model</th>
                <th>User</th>
                <th></th>
                <th></th>
            </tr>
            <#list model["orderList"] as order>
            <tr>
                <td>${order.placeOfFiling}</td>
                <td>${order.filingTime}</td>
                <td>${order.placeOfReturn}</td>
                <td>${order.returnTime}</td>
                <td>${order.car.brand}</td>
                <td>${order.car.model}</td>
                <td>${order.user.email}</td>
                <td>
                    <a href="/manager/order/${order.id}" class="btn btn-info">Edit</a>
                </td>
                <td>
                    <form name="ConfirmOrder" action="/manager" method="post">
                        <input type="hidden" name="carId" value="${order.car.id}"/>
                        <input type="submit" value="Confirm"/>
                    </form>
                </td>
            </tr>
            <#else>
                <h1>No orders</h1>
            </#list>
        </table>
</@layout.page>