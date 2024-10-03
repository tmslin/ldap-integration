package org.example.authenticator;

public class LoginInfo
{
    private String _username;
    private String _password;

    private LoginInfo()
    {
    }

    public LoginInfo(String username, String password)
    {
        this._username = username;
        this._password = password;
    }

    public String getUsername()
    {
        return _username;
    }

    public void setUsername(final String username)
    {
        _username = username;
    }

    public String getPassword()
    {
        return _password;
    }

    public void setPassword(final String password)
    {
        _password = password;
    }
}
