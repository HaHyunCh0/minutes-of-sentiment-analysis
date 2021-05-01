package com.boks.emotionalminutes.domain.sentence;

import com.boks.emotionalminutes.domain.minutes.Minutes;
import com.boks.emotionalminutes.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Getter
public class Sentence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    // 이게 맞나?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "minutes_id")
    private Minutes minutes;

    @Column
    private String content;

    @Column
    private String emotion;

    @Column(name = "created_time")
    private Time createdTime;

    @Builder
    public Sentence(User user, Minutes minutes, String content, String emotion, Time createdTime) {
        this.user = user;
        this.minutes = minutes;
        this.content = content;
        this.emotion = emotion;
        this.createdTime = createdTime;

        user.getSentences().add(this);
        minutes.getSentences().add(this);
    }
}