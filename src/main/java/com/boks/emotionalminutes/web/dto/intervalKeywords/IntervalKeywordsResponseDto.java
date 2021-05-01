package com.boks.emotionalminutes.web.dto.intervalKeywords;

import com.boks.emotionalminutes.domain.intervalKeywords.IntervalKeywords;
import com.boks.emotionalminutes.domain.minutes.Minutes;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class IntervalKeywordsResponseDto {
    private final Long id;
    private final Minutes minutes;
    private final String interval1Keywords;
    private final String interval2Keywords;
    private final String interval3Keywords;
    private final String interval4Keywords;
    private final String interval5Keywords;

    public IntervalKeywordsResponseDto (IntervalKeywords entity) {
        this.id = entity.getId();
        this.minutes = entity.getMinutes();
        this.interval1Keywords = entity.getInterval1Keywords();
        this.interval2Keywords = entity.getInterval2Keywords();
        this.interval3Keywords = entity.getInterval3Keywords();
        this.interval4Keywords = entity.getInterval4Keywords();
        this.interval5Keywords = entity.getInterval5Keywords();
    }
}