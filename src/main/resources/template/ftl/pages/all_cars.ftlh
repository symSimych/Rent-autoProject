<#import "../layouts/main.ftlh" as layout>
<@layout.page>
    <fieldset>
        <legend>Sorted by</legend>
            <form action="/all_cars_sorted_by" method="get">
                <input type = "text" list = "sorted_by" name="sorted_by">
                    <datalist id = "sorted_by">
                        <option value = "price">
                        <option value = "fuel consumption">
                        <option value = "fuel type">
                        <option value = "transmission">
                        <option value = "brand">
                        <option value = "model">
                        <option value = "year">
                    </datalist>
                    <input type = "submit" value = "confirm">
            </form>
    </fieldset>
    <#import "../partial/cars_list.ftlh" as carsPartial>
    <@carsPartial.cars />
</@layout.page>