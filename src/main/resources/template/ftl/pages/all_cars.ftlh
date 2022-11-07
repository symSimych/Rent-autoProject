<#import "../layouts/main.ftlh" as layout>
<#import "../partial/pager.ftlh" as p>
<@layout.page>
        <div class="form-group">
            <a href="/" class="btn btn-info">Back</a>
        </div>
        <div class="form-group mt-3">
                <form class="row g-3" action="/all_cars" method="get">
                <div class="col-auto">
                    <label class="form-label">Sorted by</label>
                </div>
                <div class="col-auto">
                 <select class="form-select" aria-label="sorted_by" name="sorted_by">
                    <option value="price">price</option>
                    <option value="fuel consumption">fuel consumption</option>
                    <option value="fuel type">fuel type</option>
                    <option value="transmission">transmission</option>
                    <option value="brand">brand</option>
                    <option value="model">model</option>
                    <option value="year">year</option>
                 </select>
                </div>
                <div class="col-auto">
                    <button class="btn btn-info" type="submit">Confirm</button>
                </div>
                </form>
        </div>
        <@p.pager url page />
        <div class="row row-cols-3 row-cols-md-4 g-4 mt-3" id="carList">
            <#list page.content as car>
            <#if car.getAvailable()>
              <div class="col">
                <div class="card border-info mb-3 text-center" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">${car.brand} ${car.model}</h5>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Price: ${car.price} $/day</li>
                        <li class="list-group-item">Transmission: ${car.transmission}</li>
                        <li class="list-group-item">Year: ${car.year}</li>
                        <li class="list-group-item">Fuel type: ${car.fuelType}</li>
                        <li class="list-group-item">Fuel consumption: ${car.fuelConsumption}</li>
                    </ul>
                    <div class="card-body">
                        <a href="/all_cars/${car.id}" class="btn btn-info">More details</a>
                    </div>
                </div>
              </div>
            </#if>
            <#else>
            NO CARS
            </#list>
        </div>
        <@p.pager url page />
</@layout.page>