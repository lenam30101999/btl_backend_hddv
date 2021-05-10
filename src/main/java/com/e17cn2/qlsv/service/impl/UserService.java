package com.e17cn2.qlsv.service.impl;


import com.e17cn2.qlsv.entity.User;
import com.e17cn2.qlsv.security.FirebaseUserDetails;
import com.e17cn2.qlsv.service.BaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@Log4j2
public class UserService extends BaseService {

    public FirebaseUserDetails addUser(User user){
        User userCheck = userRepository.findByUid(user.getUid()).orElse(null);
        if (Objects.isNull(userCheck)) {
            userRepository.save(user);
        }
        return null;
    }
}
