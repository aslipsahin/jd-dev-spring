package com.cyber.security;

import com.cyber.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    /*
    Spring security does not have ability to understand the custom User class. It understands from its own interface
    UserDetails. So i created this UserPrincipal class which implements UserDetails interface to connect the User class
    to Spring security.
     */

    private User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //The authorityList object will keep all the converted permissions and roles. It is going to distinguish the
        //roles and permissions with the keyword "ROLE_" added before the role (spring naming convention).
        List<GrantedAuthority> authorityList = new ArrayList<>();

        //Extract list of permissions from User Entity to UserDetails (Conversion is happening now)
        user.getPermissionList().forEach(permission -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(permission);
            authorityList.add(authority);
        });

        //Extract list of roles from User Entity to UserDetails
        /*
        Spring is using the same class SimpleGrantedAuthority to convert the permissions and roles. So how spring
        determines for which purpose it is going to use the class is:
        spring has a naming convention for using the SimpleGrantedAuthority class. If you directly use the permission
        as the argument, it will assume, it is a permission. If you use "ROLE_" keyword in the beginning of the
        argument, it will understand that you are using the class to create a role.
         */
        user.getRoleList().forEach(role -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
            authorityList.add(authority);
        });

        return authorityList;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    //i can add this true as default
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //i can add this true as default
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //i can add this true as default
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.getActive() == 1;
    }
}
