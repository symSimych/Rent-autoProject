<#import "../layouts/main.ftlh" as layout>
<@layout.page>
    <a href="/manager/car-manage" class="btn btn-info">Back</a>
        <legend>Edit car</legend>
        <form name="editCar" action="/manager/car-manage/${car.id}" method="post" enctype="multipart/form-data">
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Brand:</label>
              <div class="col-sm-10">
                  <input type="text" name="brand" class="form-control" value="<#if car??>${car.brand}</#if>" placeholder="Brand"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Model:</label>
              <div class="col-sm-10">
                  <input type="text" name="carModel" class="form-control" value="<#if car??>${car.model}</#if>" placeholder="Model"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Body type:</label>
              <div class="col-sm-10">
                  <input type="text" name="bodyType" class="form-control" value="<#if car??>${car.bodyType}</#if>" placeholder="Body type"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Transmission:</label>
              <div class="col-sm-10">
                  <input type="text" name="transmission" class="form-control" value="<#if car??>${car.transmission}</#if>" placeholder="Transmission"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Year:</label>
              <div class="col-sm-10">
                  <input type="text" name="year" class="form-control" value="<#if car??>${car.year}</#if>" placeholder="Year"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Fuel type:</label>
              <div class="col-sm-10">
                  <input type="text" name="fuelType" class="form-control" value="<#if car??>${car.fuelType}</#if>" placeholder="Fuel type"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Horse power:</label>
              <div class="col-sm-10">
                  <input type="number" name="horsePower" class="form-control" value="<#if car??>${car.horsePower}</#if>" placeholder="Horse power"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Engine volume:</label>
              <div class="col-sm-10">
                  <input type="number" step="0.1" name="engineVolume" class="form-control" value="<#if car??>${car.engineVolume}</#if>" placeholder="Engine volume"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Fuel consumption:</label>
              <div class="col-sm-10">
                  <input type="number" step="0.1" name="fuelConsumption" class="form-control" value="<#if car??>${car.fuelConsumption}</#if>" placeholder="Fuel consumption"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Tank volume:</label>
              <div class="col-sm-10">
                  <input type="number" name="tankVolume" class="form-control" value="<#if car??>${car.tankVolume}</#if>" placeholder="Tank volume"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Bail:</label>
              <div class="col-sm-10">
                  <input type="number" step="0.1" name="bail" class="form-control" value="<#if car??>${car.bail}</#if>" placeholder="Bail"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Price:</label>
              <div class="col-sm-10">
                  <input type="number" step="0.1" name="price" class="form-control" value="<#if car??>${car.price}</#if>" placeholder="Price"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Images:</label>
              <div class="col-sm-10">
                  <input type="file" multiple name="files" class="form-control" placeholder="Images"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Status:</label>
              <div class="col-sm-10">
                <select name="status" class="form-control">
                    <option value=""></option>
                    <option value="true">available</option>
                    <option value="false">unavailable</option>
                </select>
              </div>
          </div>
          <input type="hidden" name="carId" value="${car.id}" />
          <div class="form-group row mt-1">
            <button class="btn btn-info" type="submit">Save</button>
          </div>
        </form>

</@layout.page>