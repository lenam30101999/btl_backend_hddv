package com.e17cn2.qlsv.security;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@NoArgsConstructor
@Builder
public class FirebaseUserDetails implements UserDetails {

    private String uid;
    private static final long serialVersionUID = 1L;
    private final boolean enabled = true;
    private final boolean credentialsNonExpired = true;
    private final boolean accountNonLocked = true;
    private final boolean accountNonExpired = true;
    private final String password = null;
    private String username;
    private String email;
    private String avatarUrl;

    public FirebaseUserDetails(String uid, String username, String email, String avatarUrl) {
        this.uid = uid;
        this.username = username;
        this.email = email;
        this.avatarUrl = avatarUrl;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }

}
