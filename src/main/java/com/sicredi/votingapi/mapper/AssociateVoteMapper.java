package com.sicredi.votingapi.mapper;

import com.sicredi.votingapi.entity.AssociateVoteEntity;
import com.sicredi.votingapi.model.AssociateVote;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssociateVoteMapper {

    AssociateVoteEntity toEntity (AssociateVote model);

    AssociateVote toModel(AssociateVoteEntity entity);
}
