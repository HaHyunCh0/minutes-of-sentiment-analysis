package com.boks.emotionalminutes.service;

import com.boks.emotionalminutes.domain.bookmark.Bookmark;
import com.boks.emotionalminutes.domain.bookmark.BookmarkRepository;
import com.boks.emotionalminutes.web.dto.bookmark.BookmarkRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;

    @Transactional
    public Bookmark save(@RequestBody BookmarkRequestDto requestDto) {
        return bookmarkRepository.save(requestDto.toEntity());
    }
}