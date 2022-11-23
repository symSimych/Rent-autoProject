<#import "../layouts/main.ftlh" as layout>
<@layout.page>
    <a href="/manager/car-manage" class="btn btn-info">Car manage</a>

    <div class="row align-items-center">
        <div class="col">
        <h1>unconfirmed orders</h1>
          <form name="phoneNumber" action="/manager" method="post">
            Phone number: <input type="tel" name="phoneNumber" />
            <input type="submit" value="Find"/>
          </form>
          <table class="table table-bordered border-info">
            <tr class="table-info">
              <th>Place of filing</th>
              <th>Filing time</th>
              <th>Place of return</th>
              <th>Return time</th>
              <th>Car brand</th>
              <th>Car model</th>
              <th>User email</th>
              <th>User phone</th>
              <th></th>
              <th></th>
            </tr>
            <#list model["orderList"] as order>
            <#if !order.getConfirmed()>
            <tr>
              <td>${order.placeOfFiling}</td>
              <td>${order.filingTime}</td>
              <td>${order.placeOfReturn}</td>
              <td>${order.returnTime}</td>
              <td>${order.car.brand}</td>
              <td>${order.car.model}</td>
              <td>${order.user.email}</td>
              <td>${order.user.phoneNumber}</td>
              <td>
                <a href="/manager/order/${order.id}" class="btn btn-info">Edit</a>
              </td>
              <td>
                <form name="ConfirmOrder" action="/manager" method="post">
                  <input type="hidden" name="carId" value="${order.car.id}"/>
                  <input type="hidden" name="orderId" value="${order.id}"/>
                  <input type="submit" value="Confirm"/>
                </form>
              </td>
            </tr>
            </#if>
            <#else>
              <h1>No orders</h1>
            </#list>
          </table>
        </div>
        <div class="col">
        <h1>confirmed orders</h1>
          <form name="phoneNumber" action="/manager" method="post">
            Phone number: <input type="tel" name="phone_number" />
            <input type="submit" value="Find"/>
          </form>
          <table class="table table-bordered border-info">
            <tr class="table-info">
              <th>Place of filing</th>
              <th>Filing time</th>
              <th>Place of return</th>
              <th>Return time</th>
              <th>Car brand</th>
              <th>Car model</th>
              <th>User email</th>
              <th>User phone</th>
              <th></th>
              <th></th>
            </tr>
            <#list model["orderList"] as order>
            <#if order.getConfirmed()>
            <tr>
              <td>${order.placeOfFiling}</td>
              <td>${order.filingTime}</td>
              <td>${order.placeOfReturn}</td>
              <td>${order.returnTime}</td>
              <td>${order.car.brand}</td>
              <td>${order.car.model}</td>
              <td>${order.user.email}</td>
              <td>${order.user.phoneNumber}</td>
              <td>
                <a href="/manager/order/${order.id}" class="btn btn-info">Edit</a>
              </td>
              <td>
                <form name="ConfirmOrder" action="/manager" method="post">
                  <input type="hidden" name="carId" value="${order.car.id}"/>
                  <input type="hidden" name="orderId" value="${order.id}"/>
                  <input type="submit" value="Confirm"/>
                </form>
              </td>
            </tr>
            </#if>
            <#else>
              <h1>No orders</h1>
            </#list>
          </table>
        </div>
    </div>
</@layout.page>