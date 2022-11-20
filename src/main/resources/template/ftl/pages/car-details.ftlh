<#import "../layouts/main.ftlh" as layout>
<@layout.page>
    <div>
        <a href="/all-cars" class="btn btn-info">Back</a>
    </div>
    <div class="text-center mt-6">
        <h1 class="display-2">${car.brand} ${car.model}</h1>
    </div>
    <div id="carouselExampleIndicators" class="carousel carousel-dark slide" data-bs-ride="true">
      <div class="carousel-inner">
        <#list car.images as image>
        <div class="carousel-item active">
          <div class="d-flex justify-content-center">
            <img src="/images/${image.id}" class="d-block w-50" alt="${car.brand} ${car.model}">
          </div>
        </div>
        </#list>
      </div>
      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
    <div class="text-center mt-3">
        <p class="h3">${car.bodyType} / ${car.year} / ${car.engineVolume} / ${car.horsePower} / ${car.transmission} / ${car.fuelType} / ${car.fuelConsumption} / ${car.tankVolume}</p>
    </div>
    <div class="text-center mt-5">
        <p class="h1">Make order</p>
    </div>
    <form class="row g-3 mt-3" name="CreateOrder" action="/all-cars/${car.id}" method="post">
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
        <button type="submit" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#orderModal">Confirm order</button>
      </div>
    </form>

    <div class="modal fade" id="orderModal" tabindex="-1" role="dialog" area-labelledby="orderModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="orderModalLabel">Order is accepted</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
        </div>
      </div>
    </div>
</@layout.page>