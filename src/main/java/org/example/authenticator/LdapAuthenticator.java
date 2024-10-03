package org.example.authenticator;

import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import java.util.Properties;

@Service
public class LdapAuthenticator implements Authenticator
{
    private final String _ldapUrl;
    public LdapAuthenticator(@Value("${spring.ldap.urls}") String ldapUrl)
    {
        _ldapUrl = ldapUrl;
    }

    @Override public boolean authenticate(final LoginInfo loginInfo)
    {
        try
        {
            Properties environment = new Properties();
            environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            environment.put(Context.PROVIDER_URL, _ldapUrl);
            environment.put(Context.SECURITY_PRINCIPAL, "cn="+loginInfo.getUsername()+",dc=example,dc=org");
            environment.put(Context.SECURITY_CREDENTIALS, loginInfo.getPassword());
            environment.put(Context.SECURITY_AUTHENTICATION, "simple");
            environment.put("com.sun.jndi.ldap.connect.timeout", "10000");
            environment.put("java.naming.ldap.version", "3");
            final Context context = new InitialDirContext(environment);
            context.close();
            return true;
        }
        catch (NamingException e)
        {

            return false;
        }
    }
}
