<#import "../layouts/main.ftlh" as layout>
<@layout.page>
       <fieldset>
               <legend>Registration user</legend>
               <form name="Registration" action="/registration" method="post">
                   Firstname : <input type="text" name="firstname"/> <br/>
                   Lastname : <input type="text" name="lastname"/> <br/>
                   Phone number : <input type="tel" name="phone_number"/> <br/>
                   Email : <input type="email" name="email" autocomplete="off"/> <br/>
                   Password: <input type="password" name="password" autocomplete="off"/> <br/>
                   <input type="submit" value="Sign In"/>
               </form>
               <#if errorMessage??>
                   <h2 style="color: red">${errorMessage}</h2>
               </#if>
      </fieldset>
</@layout.page>