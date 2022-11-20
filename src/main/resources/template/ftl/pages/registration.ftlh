<#import "../layouts/main.ftlh" as layout>
<@layout.page>
      <form action="/registration" commandName="user" method="post">
          <div class="form-group row mt-3">
              <label class="col-sm-2 col-form-label">Firstname:</label>
              <div class="col-sm-10">
                  <input type="text" name="firstname" value="<#if user??>${user.firstname}</#if>"
                  class="form-control ${(firstnameError??)?string('is-invalid', '')}" placeholder="Firstname" />
                  <#if firstnameError??>
                      <div class="invalid-feedback">
                        ${firstnameError}
                      </div>
                  </#if>
              </div>
          </div>
          <div class="form-group row mt-3">
              <label class="col-sm-2 col-form-label">Lastname:</label>
              <div class="col-sm-10">
                  <input type="text" name="lastname" class="form-control ${(lastnameError??)?string('is-invalid', '')}"
                   value="<#if user??>${user.lastname}</#if>" placeholder="Lastname" />
                   <#if lastnameError??>
                      <div class="invalid-feedback">
                        ${lastnameError}
                      </div>
                  </#if>
              </div>
          </div>
          <div class="form-group row mt-3">
             <label class="col-sm-2 col-form-label">Phone number:</label>
             <div class="col-sm-10">
                  <input type="tel" name="phoneNumber" class="form-control ${(phoneNumberError??)?string('is-invalid', '')}"
                   value="<#if user??>${user.phoneNumber}</#if>" placeholder="Phone number" />
                   <#if phoneNumberError??>
                      <div class="invalid-feedback">
                        ${phoneNumberError}
                      </div>
                  </#if>
             </div>
          </div>
          <div class="form-group row mt-3">
              <label class="col-sm-2 col-form-label">Email:</label>
              <div class="col-sm-10">
                  <input type="email" name="email" autocomplete="off" class="form-control ${(emailError??)?string('is-invalid', '')}"
                  value="<#if user??> ${user.email} </#if>" placeholder="Email" />
                  <#if emailError??>
                      <div class="invalid-feedback">
                        ${emailError}
                      </div>
                  </#if>
              </div>
          </div>
          <div class="form-group row mt-3">
              <label class="col-sm-2 col-form-label">Password:</label>
              <div class="col-sm-10">
                  <input type="password" name="password" autocomplete="off" class="form-control ${(passwordError??)?string('is-invalid', '')}" placeholder="Password" />
                  <#if passwordError??>
                      <div class="invalid-feedback">
                        ${passwordError}
                      </div>
                  </#if>
              </div>
          </div>
          <div class="form-group row mt-3">
              <label class="col-sm-2 col-form-label">Confirm password:</label>
              <div class="col-sm-10">
                  <input type="password" name="confirmPassword" autocomplete="off" class="form-control ${(confirmPasswordError??)?string('is-invalid', '')}" placeholder="Confirm password" />
                  <#if confirmPasswordError??>
                      <div class="invalid-feedback">
                        ${confirmPasswordError}
                      </div>
                  </#if>
              </div>
          </div>
          <div class="form-group row mt-3">
            <button class="btn btn-info" type="submit">Register</button>
          </div>
      </form>
</@layout.page>