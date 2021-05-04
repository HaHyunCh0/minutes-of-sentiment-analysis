package com.boks.emotionalminutes.domain.meeting;

import com.boks.emotionalminutes.domain.participation.Participation;
import com.boks.emotionalminutes.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Meeting {
    @Id
    @Column
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String name;

    @OneToMany(mappedBy = "meeting")
    private List<Participation> participation = new ArrayList<>();

    @Builder
    public Meeting(String code, User user, String name) {
        this.code = code;
        this.user = user;
        this.name = name;
    }
}
