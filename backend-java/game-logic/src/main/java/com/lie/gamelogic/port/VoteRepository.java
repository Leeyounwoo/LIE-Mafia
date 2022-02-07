package com.lie.gamelogic.port;

import com.lie.gamelogic.domain.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends CrudRepository<Vote,String> {
}
