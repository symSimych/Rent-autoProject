<#import "../layouts/main.ftlh" as layout>
<@layout.page>
        <a href="/manager/car-manage" class="btn btn-info">Back</a>
        <legend>Add Car</legend>
        <form action="/add-new-car" commandName="car" method="post" enctype="multipart/form-data">
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Brand:</label>
              <div class="col-sm-10">
                  <input type="text" name="brand" class="form-control" placeholder="Brand"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Model:</label>
              <div class="col-sm-10">
                  <input type="text" name="model" class="form-control" placeholder="Model"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Body type:</label>
              <div class="col-sm-10">
                  <input type="text" name="bodyType" class="form-control" placeholder="Body type"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Transmission:</label>
              <div class="col-sm-10">
                  <input type="text" name="transmission" class="form-control" placeholder="Transmission"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Year:</label>
              <div class="col-sm-10">
                  <input type="text" name="year" class="form-control" placeholder="Year"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Fuel type:</label>
              <div class="col-sm-10">
                  <input type="text" name="fuelType" class="form-control" placeholder="Fuel type"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Horse power:</label>
              <div class="col-sm-10">
                  <input type="number" name="horsePower" class="form-control" placeholder="Horse power"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Engine volume:</label>
              <div class="col-sm-10">
                  <input type="number" step="0.1" name="engineVolume" class="form-control" placeholder="Engine volume"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Fuel consumption:</label>
              <div class="col-sm-10">
                  <input type="number" step="0.1" name="fuelConsumption" class="form-control" placeholder="Fuel consumption"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Tank volume:</label>
              <div class="col-sm-10">
                  <input type="number" name="tankVolume" class="form-control" placeholder="Tank volume"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Bail:</label>
              <div class="col-sm-10">
                  <input type="number" step="0.1" name="bail" class="form-control" placeholder="Bail"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Price:</label>
              <div class="col-sm-10">
                  <input type="number" step="0.1" name="price" class="form-control" placeholder="Price"/>
              </div>
          </div>
          <div class="form-group row mt-1">
              <label class="col-sm-2 col-form-label">Images:</label>
              <div class="col-sm-10">
                  <input type="file" multiple name="files" class="form-control" placeholder="Images"/>
              </div>
          </div>
          <div class="form-group row mt-1">
            <button class="btn btn-info" type="submit">Add</button>
          </div>
        </form>
</@layout.page>