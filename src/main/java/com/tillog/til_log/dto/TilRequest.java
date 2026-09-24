package com.tillog.til_log.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TilRequest {
    private LocalDate tilDate;
    private String tilTitle;
    private String tilUrl;
    private String tilLevel;
    private String tilSolve;
}
