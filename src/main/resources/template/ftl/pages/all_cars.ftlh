<#import "../layouts/main.ftlh" as layout>
<@layout.page>
    <a href="/" class="btn btn-info">Back</a>
    <fieldset>
        <legend>Sorted by</legend>
            <form action="/all_cars" method="get">
             <select name="sorted_by">
                <option value=""></option>
                <option value="price">price</option>
                <option value="fuel consumption">fuel consumption</option>
                <option value="fuel type">fuel type</option>
                <option value="transmission">transmission</option>
                <option value="brand">brand</option>
                <option value="model">model</option>
                <option value="year">year</option>
             </select>
            <input type = "submit" value = "confirm">
            </form>
    </fieldset>
    <#import "../partial/cars_list.ftlh" as carsPartial>
    <@carsPartial.cars />
</@layout.page>