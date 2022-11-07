<#import "../layouts/main.ftlh" as layout>
<@layout.page>
    <fieldset>
        <a href="/admin" class="btn btn-info">Back</a>
        <legend>Add Car</legend>
        <form name="LogIn" action="/add_new_car" method="post">
            Brand : <input type="text" name="brand" />	<br/>
            Model : <input type="text" name="carModel" />	<br/>
            Body type: <input type="text" name="bodyType" />	<br/>
            Transmission: <input type="text" name="transmission" />	<br/>
            Year: <input type="text" name="year" />	<br/>
            Fuel type: <input type="text" name="fuelType" /> <br/>
            Horse poser: <input type="text" name="horsePower" />	<br/>
            Engine volume: <input type="text" name="engineVolume" />	<br/>
            Fuel consumption: <input type="text" name="fuelConsumption" />	<br/>
            Tank volume: <input type="text" name="tankVolume" />	<br/>
            Bail: <input type="text" name="bail" />	<br/>
            Price: <input type="text" name="price" />	<br/>
            <input type="submit" value="   Save   " />
        </form>
    </fieldset>

    <br/>
</@layout.page>