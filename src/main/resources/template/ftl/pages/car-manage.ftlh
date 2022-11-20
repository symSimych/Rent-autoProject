<#import "../layouts/main.ftlh" as layout>
<#import "../partial/pager.ftlh" as p>
<@layout.page>
    <a href="/manager" class="btn btn-info">Back</a>
    <a href="/manager/add-car" class="btn btn-info">Add car</a>
    <table class="table table-bordered border-info">
        <tr class="table-info">
            <th>brand</th> <b/>
            <th>model</th> <b/>
            <th>price $</th> <b/>
            <th>year</th> <b/>
            <th>fuelType</th> <b/>
            <th>fuelConsumption</th> <b/>
            <th>transmission</th> <b/>
            <th>available</th> <b/>
            <th></th>
        </tr>
        <#list page.content as car>
            <tr>
                <td>${car.brand}</td>
                <td>${car.model}</td>
                <td>${car.price}</td>
                <td>${car.year}</td>
                <td>${car.fuelType}</td>
                <td>${car.fuelConsumption}</td>
                <td>${car.transmission}</td>
                <td>${car.available?string('available', 'unavailable')}</td>
                <td><a href="/manager/car-manage/${car.id}" >Edit</a></td>
            </tr>
        </#list>
    </table>
</@layout.page>