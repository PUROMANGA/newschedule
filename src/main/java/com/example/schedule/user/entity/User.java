package com.example.schedule.user.entity;

import com.example.schedule.baseEntity.BaseEntity;
import com.example.schedule.user.dto.RequestUserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "users")
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, length = 4)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String pw;

    public User(RequestUserDto requestUserDto) {
        this.name = requestUserDto.getName() != null ? requestUserDto.getName() : "ㅇㅇ";
        this.email = requestUserDto.getEmail();
        this.pw = requestUserDto.getPw();
    }

    public User(String email, String pw) {
        this.email = email;
        this.pw = pw;
    }

    public void update(RequestUserDto requestUserDto) {
        this.name = requestUserDto.getName();
        this.email = requestUserDto.getEmail();
        this.pw = requestUserDto.getPw();
    }
}
