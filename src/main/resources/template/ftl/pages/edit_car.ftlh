<#import "../layouts/main.ftlh" as layout>
<@layout.page>
    <a href="/manager" class="btn btn-info">Back</a>
    <fieldset>
            <legend>Change Order</legend>
            <form name="editCar" action="/manager/car_manage/${car.id}" method="post">
                Brand : <input type="text" name="brand" value=${car.brand} /> <br/>
                Model : <input type="text" name="carModel" value=${car.model} /> <br/>
                Body type : <input type="text" name="bodyType" value=${car.bodyType} /> <br/>
                Bail : <input type="number" step="0.01" name="bail" value=${car.bail} /> <br/>
                Price : <input type="number" step="0.01" name="price" value=${car.price} /> <br/>
                Year : <input type="number" name="year" value=${car.year} /> <br/>
                Transmission : <input type="text" name="transmission" value=${car.transmission} /> <br/>
                Horse power : <input type="number" name="horsePower" value=${car.horsePower} /> <br/>
                Engine volume : <input type="number" step="0.01" name="engineVolume" value=${car.engineVolume} /> <br/>
                Fuel type : <input type="text" name="fuelType" value=${car.fuelType} /> <br/>
                Tank volume : <input type="number" name="tankVolume" value=${car.tankVolume} /> <br/>
                Fuel consumption : <input type="number" step="0.01" name="fuelConsumption" value=${car.fuelConsumption} /> <br/>
                <select name="status">
                    <option value=""></option>
                    <option value="true">available</option>
                    <option value="false">unavailable</option>
                </select> <br/>
                <input type="submit" value="   Confirm   " />
            </form>
    </fieldset>
</@layout.page>