<#import "../layouts/main.ftlh" as layout>
<@layout.page>
    <a href="/all_cars" class="btn btn-info">Back</a>
    <table class="w3-centred">
        <tr>
            <th>brand</th>
            <th>model</th>
            <th>body type</th>
            <th>bail</th>
            <th>price $</th>
            <th>  year  </th>
            <th>transmission</th>
            <th>horse power</th>
            <th>engine volume</th>
            <th>fuelType</th>
            <th>tank volume</th>
            <th>fuel consumption</th>
        </tr>
        <#list model["car"] as c>
            <tr>
                <td>${c.brand}</td>
                <td>${c.model}</td>
                <td>${c.bodyType}</td>
                <td>${c.bail}</td>
                <td>${c.price}</td>
                <td>${c.year}</td>
                <td>${c.transmission}</td>
                <td>${c.horsePower}</td>
                <td>${c.engineVolume}</td>
                <td>${c.fuelType}</td>
                <td>${c.tankVolume}</td>
                <td>${c.fuelConsumption}</td>
            </tr>
        </#list>
        </table>
</@layout.page>