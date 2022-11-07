<#import "/layouts/main.ftlh" as layout>
<@layout.page>
<div>
    <form action="/login" method="post">
          <div class="form-group row mt-3">
            <label class="col-sm-2 col-form-label">Email address:</label>
            <div class="col-sm-10">
                <input type="email" name="username" class="form-control" placeholder="Email" />
            </div>
          </div>
          <div class="form-group row mt-3">
            <label class="col-sm-2 col-form-label">Password:</label>
            <div class="col-sm-10">
                <input type="password" name="password" class="form-control" placeholder="Password" />
            </div>
          </div>
          <div class="form-group row mt-3">
          <div class="col-sm-6"
             <button class="btn btn-info"><a href="/registration" class="btn btn-info">Register</a></button>
          </div>
            <div class="col-sm-6">
                <button class="btn btn-info" type="submit">Sign In</button>
            </div>

          </div>
    </form>
</div>
</@layout.page>