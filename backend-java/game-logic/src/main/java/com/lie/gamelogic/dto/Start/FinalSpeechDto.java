package com.lie.gamelogic.dto.Start;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class FinalSpeechDto {

    String roomId;
    LocalDateTime endTime;
    String pointedUser;
}
