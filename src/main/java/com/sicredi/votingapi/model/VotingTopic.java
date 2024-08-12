package com.sicredi.votingapi.model;

import com.sicredi.votingapi.entity.AssociateVoteEntity;
import java.util.List;
import lombok.Data;

@Data
public class VotingTopic {

    Long id;

    String subject;

    List<AssociateVoteEntity> votes;
}
