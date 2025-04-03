package com.example.schedule.user.repository;

import com.example.schedule.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 유저 이메일로 조회
     * Optional이라 오류 확인할 것.
     * @param email
     * @return
     */
    Optional<User> findByEmail(String email);

    /**
     * 유저 존재하는지 확인
     * @param email
     * @return
     */
    boolean existsByEmail(String email);
}
