package com.e17cn2.qlsv.repository;

import com.e17cn2.qlsv.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUid(String uid);
}
