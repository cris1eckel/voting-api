package com.sicredi.votingapi.mapper;

import com.sicredi.votingapi.entity.VotingSessionEntity;
import com.sicredi.votingapi.model.VotingSession;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VotingSessionMapper {

    VotingSessionEntity toEntity (VotingSession model);

    VotingSession toModel(VotingSessionEntity entity);
}
