package com.example.schedule.user.entity;

import com.example.schedule.baseEntity.BaseEntity;
import com.example.schedule.comment.entity.Comment;
import com.example.schedule.schedule.entitiy.Schedule;
import com.example.schedule.user.dto.RequestUserDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Table(name = "users")
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 8)
    //4글자라고 하셨는데 대략 8byte가 한글 4~5문자 나올 것 같아서 길이를 이렇게 설정했습니다!
    //또 nullable은 밑에서 이름을 설정하지 않으면 defalut name을 출력해주고 싶어서 nullable을 ok했습니다!
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String pw;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Schedule> scheduleList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> commentList;

    public User(RequestUserDto requestUserDto) {
        this.name = (requestUserDto.getName() == null || requestUserDto.getName().isBlank()) ? "ㅇㅇ" : requestUserDto.getName();
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
