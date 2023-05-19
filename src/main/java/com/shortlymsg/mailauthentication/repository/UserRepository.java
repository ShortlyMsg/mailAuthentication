package com.shortlymsg.mailauthentication.repository;

import com.shortlymsg.mailauthentication.entity.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User2, String> {
}
