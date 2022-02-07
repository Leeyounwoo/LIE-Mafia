package com.lie.gamelogic.port.task;

import com.lie.gamelogic.domain.Room;
import com.lie.gamelogic.port.GameService;
import com.lie.gamelogic.port.GameTurnImpl;
import com.lie.gamelogic.port.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.TimerTask;

@Service
@RequiredArgsConstructor
@Log4j2
public class MorningVoteTask extends TimerTask {

    private final RoomRepository roomRepository;
    private final GameService gameService;
    private final GameTurnImpl gameTurn;

    Room room;

    @Override
    public void run() {
        room = gameTurn.getRoom();

        //투표 결과를 저장 하는것
//        gameService.resultMornigVote(room.getRoomId());
//        //저장한 결과값을 불려와주어야 한다.
//        room = roomRepository.findById(room.getRoomId()).orElseThrow();

        room.setDay(room.getDay());
        room.setRoomPhase(gameTurn.getNextPhase());

        //투표 결과를 삭제
        gameService.deleteVote(room.getRoomId());

        //log.info(room);
        roomRepository.save(room);

        log.info(roomRepository.findById(gameTurn.getRoomId()));
    }
}
