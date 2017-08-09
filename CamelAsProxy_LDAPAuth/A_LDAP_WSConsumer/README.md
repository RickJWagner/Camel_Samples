This example has a 'jaxws' package and a 'simplews' package.

The jaxws package contains a web service very similar to the camel-jaxws quickstart.  It demonstrates how Camel Proxy can be used to offer a SOAP interface
to clients.

The simplews package contains a web service that also offers a SOAP front end, but it acts as a proxy to the jaxws web service.  So you can call 
simplews, which will in turn call jaxws to get the desired response.

Web security is used to tie to an LDAP backend.  

A suitable LDAP provider can be found in the osixia Docker image.  The 'admin' user (password 'admin') has been added to a group 'Manager'.



------------ Additional LDAP helpers ---------------------------


Set up LDAP
- Start my Docker LDAP container
- Add LDIF example from JXplorer



- Work QS A_LDAP_WSConsumer (which is a copy of camel-jaxws)
jboss-web.xml
    <jboss-web>
        <security-domain>java:/jaas/LDAPAuth</security-domain>
    </jboss-web> 

web.xml

<web-app>
    <security-constraint>
           <web-resource-collection>
               <web-resource-name>Secure Content</web-resource-name>
               <!--
               <url-pattern>/jaxws</url-pattern>
               <url-pattern>/*</url-pattern>
               -->
               <url-pattern>/*</url-pattern>
           </web-resource-collection>

           <auth-constraint>
               <role-name>Manager</role-name>
           </auth-constraint>
   </security-constraint>

   <security-role>
      <role-name>Manager</role-name>
   </security-role>

    <login-config>
      <auth-method>BASIC</auth-method>
      <realm-name>Sample LDAP Domain</realm-name> <!--NOTE: This is simply a Display Name-->
    </login-config>
</web-app>


standalone.xml
<security-domain name="LDAPAuth" cache-type="default">
    <authentication>
        <login-module code="org.jboss.security.auth.spi.LdapExtLoginModule" flag="required">
            <module-option name="java.naming.factory.initial" value="com.sun.jndi.ldap.LdapCtxFactory"/>
            <module-option name="java.naming.provider.url" value="ldap://localhost:389"/>
            <module-option name="bindDN" value="uid=admin,dc=example,dc=org"/>
            <module-option name="bindCredential" value="admin"/>
            <module-option name="baseCtxDN" value="cn=admin,dc=example,dc=org"/>
            <module-option name="baseFilter" value="(uid={0})"/>
            <module-option name="rolesCtxDN" value="cn=Groups,dc=example,dc=org"/>
            <module-option name="roleFilter" value="(member={1})"/>
            <module-option name="roleNameAttributeID" value="cn"/>
            <module-option name="roleAttributeIsDN" value="true"/>
            <module-option name="throwValidateError" value="true"/>
            <module-option name="searchScope" value="SUBTREE_SCOPE"/>
            <module-option name="roleRecursion" value="2"/>
            <module-option name="allowEmptyPasswords" value="false"/>
            <module-option name="parseUsername" value="true"/>
            <module-option name="NOTusernameBeginString" value="ad"/>
        </login-module>
    </authentication>
</security-domain>

LDIF info

version: 1
dn: dc=example,dc=org
objectClass: dcObject
objectClass: organization
objectClass: top
dc: example
o: Example Inc.

dn: cn=admin,dc=example,dc=org
objectClass: simpleSecurityObject
objectClass: organizationalRole
objectClass: top
cn: admin
description: LDAP administrator
userPassword:: e1NTSEF9clUwNlJlM0tGKzNvbjZJb1lHL1J0VDhqU0ljQTRkakQ=

dn: ou=People,dc=example,dc=org
objectClass: organizationalUnit
objectClass: top
ou: People

dn: uid=manager,ou=People,dc=example,dc=org
objectClass: uidObject
objectClass: simpleSecurityObject
objectClass: organizationalRole
objectClass: top
cn: Manager
uid: manager
userPassword:: c2VjcmV0

dn: ou=Roles,dc=example,dc=org
objectClass: organizationalUnit
objectClass: top
ou: Roles

dn: cn=Manager,ou=Roles,dc=example,dc=org
objectClass: groupOfNames
objectClass: top
cn: Manager
description: the acmeAS7 group
member: cn=admin,dc=example,dc=org
