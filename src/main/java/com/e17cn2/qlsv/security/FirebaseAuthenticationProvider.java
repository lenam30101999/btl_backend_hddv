package com.e17cn2.qlsv.security;


import com.e17cn2.qlsv.entity.Student;
import com.e17cn2.qlsv.entity.User;
import com.e17cn2.qlsv.repository.StudentRepository;
import com.e17cn2.qlsv.service.impl.StudentService;
import com.google.api.core.ApiFuture;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
@Slf4j
public class FirebaseAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private StudentService studentService;

    @Override
    public boolean supports(Class<?> authentication) {
        return (FirebaseAuthenticationToken.class.isAssignableFrom(authentication));
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) {
        final FirebaseAuthenticationToken authenticationToken = (FirebaseAuthenticationToken) authentication;

        ApiFuture<FirebaseToken> task = FirebaseAuth.getInstance().verifyIdTokenAsync(authenticationToken.getToken());
        try {
            FirebaseToken token = task.get();
            FirebaseUserDetails created = new FirebaseUserDetails(token.getUid(), token.getName(), token.getEmail(), token.getPicture());
            User user = new User();
            user.setUid(created.getUid());
            user.setPassword("");
            user.setUsername(created.getEmail());

            Student student = new Student();
            student.setAvatarUrl(created.getAvatarUrl());
            student.setUser(user);
            studentService.addUser(student, user);

            return created;
        } catch (InterruptedException | ExecutionException e) {
            throw new SessionAuthenticationException(e.getMessage());
        }
    }
}
