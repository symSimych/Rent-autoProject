<#import "../layouts/main.ftlh" as layout>
<@layout.page>
    <div>
        <a href="/all_cars" class="btn btn-info">Back</a>
    </div>
    <div class="text-center mt-6">
        <h1 class="display-2">${car.brand} ${car.model}</h1>
    </div>
    <div class="text-center mt-3">
        <p class="h3">${car.bodyType} / ${car.year} / ${car.engineVolume} / ${car.horsePower} / ${car.transmission} / ${car.fuelType} / ${car.fuelConsumption} / ${car.tankVolume}</p>
    </div>
    <div class="text-center mt-5">
        <p class="h1">Make order</p>
    </div>
    <form class="row g-3 mt-3" name="CreateOrder" action="/all_cars" method="post">
      <div class="col-md-6">
        <label for="placeOfFiling" class="form-label">Place of filing</label>
        <input type="text" class="form-control" id="placeOfFiling" name="placeOfFiling"/>
      </div>
      <div class="col-md-6">
        <label for="filingTime" class="form-label">Filing time</label>
        <input type="datetime-local" class="form-control" id="filingTime" name="filingTime"/>
      </div>
      <div class="col-md-6">
        <label for="placeOfReturn" class="form-label">Place of return</label>
        <input type="text" class="form-control" id="placeOfReturn" name="placeOfReturn"/>
      </div>
      <div class="col-md-6">
        <label for="returnTime" class="form-label">Return time</label>
        <input type="datetime-local" class="form-control" id="returnTime" name="returnTime"/>
      </div>
      <div class="col-12">
        <input type="hidden" name="carId" value="${car.id}" />
        <button type="submit" class="btn btn-info">Confirm order</button>
      </div>
    </form>
</@layout.page>