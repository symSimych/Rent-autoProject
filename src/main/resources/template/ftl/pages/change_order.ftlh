<#import "../layouts/main.ftlh" as layout>
<@layout.page>
    <a href="/manager" class="btn btn-info">Back</a>
    <table class="w3-centred">
        <tr>
            <th>Place of filing</th>
            <th>Filing time</th>
            <th>Place of return</th>
            <th>Return time</th>
        </tr>
        <tr>
            <td>${order.placeOfFiling}</td>
            <td>${order.filingTime}</td>
            <td>${order.placeOfReturn}</td>
            <td>${order.returnTime}</td>
        </tr>
    </table>
    <fieldset>
        <legend>Change Order</legend>
        <form name="ChangeOrder" action="/manager/order/${order.id}" method="post">
            Place of filing : <input type="text" name="placeOfFiling" value="${order.placeOfFiling}" />
            Filing time : <input type="datetime-local" name="filingTime" value="${order.filingTime}" />	<br/>
            Place of return: <input type="text" name="placeOfReturn" value="${order.placeOfReturn}" />
            Return time: <input type="datetime-local" name="returnTime" value="${order.returnTime}" />    <br/>
            <input type="submit" value="Confirm" />
        </form>
    </fieldset>
</@layout.page>