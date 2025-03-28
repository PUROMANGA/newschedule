package com.example.schedule.entity;

import com.example.schedule.dto.RequestUserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "User")
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    public User(RequestUserDto requestUserDto) {
        this.name = name;
        this.email = email;
    }

    public void update(RequestUserDto requestUserDto) {
        this.name = requestUserDto.getName();
        this.email = requestUserDto.getEmail();
    }
}
