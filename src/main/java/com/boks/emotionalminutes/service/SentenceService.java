package com.boks.emotionalminutes.service;

import com.boks.emotionalminutes.domain.minutes.Minutes;
import com.boks.emotionalminutes.domain.minutes.MinutesRepository;
import com.boks.emotionalminutes.domain.sentence.Sentence;
import com.boks.emotionalminutes.domain.sentence.SentenceRepository;
import com.boks.emotionalminutes.domain.user.User;
import com.boks.emotionalminutes.domain.user.UserRepository;
import com.boks.emotionalminutes.web.dto.sentence.SentenceRequestDto;
import com.boks.emotionalminutes.web.dto.sentence.SentenceResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class SentenceService {
    private final UserRepository userRepository;
    private final MinutesRepository minutesRepository;
    private final SentenceRepository sentenceRepository;

    @Transactional
    public Long save(SentenceRequestDto sentenceRequestDto) {
        User user = userRepository.findById(sentenceRequestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 발언자가 없습니다. id=" + sentenceRequestDto.getUserId()));
        Minutes minutes = minutesRepository.findById(sentenceRequestDto.getMinutesId())
                .orElseThrow(() -> new IllegalArgumentException("해당 회의록이 없습니다. id=" + sentenceRequestDto.getMinutesId()));

        return sentenceRepository.save(sentenceRequestDto.toEntity(user, minutes)).getId();
    }

    @Transactional
    public List<SentenceResponseDto> findById(Long id) {
        Minutes minutes = minutesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 회의가 없습니다. id=" + id));
        List<Sentence> sentences = minutes.getSentences();
        List<SentenceResponseDto> sentenceResponseDtos = new ArrayList<>();

        for (Sentence value : sentences) {
            SentenceResponseDto responseDto = new SentenceResponseDto(value);
            sentenceResponseDtos.add(responseDto);
        }
        return sentenceResponseDtos;
    }
}
