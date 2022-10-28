<#import "../layouts/main.ftlh" as layout>
<@layout.page>
       <fieldset>
               <legend>Registration user</legend>
               <form name="Registration" action="/registration" method="post">
                   Firstname : <input type="text" name="firstname"/> <br/>
                   Lastname : <input type="text" name="lastname"/> <br/>
                   Phone number : <input type="text" name="phone_number"/> <br/>
                   Email : <input type="text" name="email"/> <br/>
                   Password: <input type="password" name="password"/> <br/>
                   <input type="submit" value="Sign In"/>
               </form>
      </fieldset>
</@layout.page>