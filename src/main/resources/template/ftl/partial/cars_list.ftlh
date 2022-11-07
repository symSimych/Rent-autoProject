<#macro cars>
<div class="row row-cols-3 row-cols-md-4 g-4 mt-3">
    <#list model["carList"] as car>
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
</#macro>