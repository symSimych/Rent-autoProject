<#macro cars>
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
    <#if car.getAvailable()>
        <tr>
            <td>${car.brand}</td>
            <td>${car.model}</td>
            <td>${car.price}</td>
            <td>${car.year}</td>
            <td>${car.fuelType}</td>
            <td>${car.fuelConsumption}</td>
            <td>${car.transmission}</td>
            <td><a href="/all_cars/${car.id}" class="btn btn-info">More details</a></td>
        </tr>
    </#if>
    </#list>
    </table>
</#macro>