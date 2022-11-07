<#assign known=Session.SPRING_SECURITY_CONTEXT??>
<#if known>
    <#assign
        user=Session.SPRING_SECURITY_CONTEXT.authentication.principal
        email=user.getEmail()
        isAdmin=user.isAdmin()
        isManager=user.isManager()
    >
<#else>
    <#assign
        email="unknown"
        isAdmin=false
        isManager=false
    >
</#if>