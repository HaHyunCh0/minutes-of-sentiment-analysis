package com.boks.emotionalminutes.controller;

import com.boks.emotionalminutes.domain.meeting.Meeting;
import com.boks.emotionalminutes.service.MeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MeetingController {

    MeetingService meetingService;

    @PostMapping("/api/meeting")
    public Meeting save(@RequestParam("code") String code,
                                 @RequestParam("userId") Long userId,
                                 @RequestParam("name") String name) {
        return meetingService.save(code, userId, name);
    }
}