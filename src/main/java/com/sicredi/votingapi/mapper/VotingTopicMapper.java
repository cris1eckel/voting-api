package com.sicredi.votingapi.mapper;

import com.sicredi.votingapi.entity.VotingTopicEntity;
import com.sicredi.votingapi.model.VotingTopic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VotingTopicMapper {

    VotingTopicEntity toEntity (VotingTopic votingTopic);

    VotingTopic toModel (VotingTopicEntity entity);
}
