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
            <th>fuel type</th>
            <th>tank volume</th>
            <th>fuel consumption</th>
        </tr>
            <tr>
                <td>${car.brand}</td>
                <td>${car.model}</td>
                <td>${car.bodyType}</td>
                <td>${car.bail}</td>
                <td>${car.price}</td>
                <td>${car.year}</td>
                <td>${car.transmission}</td>
                <td>${car.horsePower}</td>
                <td>${car.engineVolume}</td>
                <td>${car.fuelType}</td>
                <td>${car.tankVolume}</td>
                <td>${car.fuelConsumption}</td>
            </tr>
    </table>
        <br/>
    <fieldset>
        <legend>Make Order</legend>
                <form name="CreateOrder" action="/add_new_order" method="post">
                    Place of filing : <input type="text" name="placeOfFiling" />
                    Filing time : <input type="datetime-local" name="filingTime" />	<br/>
                    Place of return: <input type="text" name="placeOfReturn" />
                    Return time: <input type="datetime-local" name="returnTime" />
                    <input type="hidden" name="carId" value=${car.id} /> <br/>
                    <input type="submit" value="   Confirm   " />
                </form>
        </fieldset>
</@layout.page>