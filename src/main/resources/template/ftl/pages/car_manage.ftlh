<#import "../layouts/main.ftlh" as layout>
<@layout.page>
    <a href="/manager" class="btn btn-info">Back</a>
    <table class="datatable">
        <tr>
            <th>brand</th> <b/>
            <th>model</th> <b/>
            <th>price $</th> <b/>
            <th>year</th> <b/>
            <th>fuelType</th> <b/>
            <th>fuelConsumption</th> <b/>
            <th>transmission</th> <b/>
            <th></th>
        </tr>
        <#list model["carList"] as car>
            <tr>
                <td>${car.brand}</td>
                <td>${car.model}</td>
                <td>${car.price}</td>
                <td>${car.year}</td>
                <td>${car.fuelType}</td>
                <td>${car.fuelConsumption}</td>
                <td>${car.transmission}</td>
                <td><a href="/manager/car_manage/${car.id}" class="btn btn-info">Edit</a></td>
            </tr>
        </#list>
        </table>
</@layout.page>