<#include "security.ftlh">
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">Rent-Auto</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="/">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/all_cars">All cars</a>
        </li>
        <#if isAdmin>
        <li class="nav-item">
          <a class="nav-link" href="/admin">Admin Panel</a>
        </li>
        </#if>
        <#if isManager>
        <li class="nav-item">
          <a class="nav-link" href="/manager">Manager Panel</a>
        </li>
        </#if>
        <li class="nav-item">
          <a class="nav-link" href="/registration">Registration</a>
        </li>
      </ul>
      <div class="navbar-text">
        ${email}
        <a class="btn btn-dark" href="/logout">Logout</a>
      </div>
    </div>
  </div>
</nav>
