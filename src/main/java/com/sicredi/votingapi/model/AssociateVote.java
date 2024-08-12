package com.sicredi.votingapi.model;

import com.sicredi.votingapi.entity.VotingTopicEntity;
import lombok.Data;

@Data
public class AssociateVote {

    Long id;

    VotingTopicEntity votingTopic;

    Long associateCode;

    Boolean vote;

    String nationalId;
}
