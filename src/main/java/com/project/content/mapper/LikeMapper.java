package com.project.content.mapper;

import com.project.content.domain.Like;
import com.project.content.dto.LikeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LikeMapper {

    LikeMapper INSTANCE = Mappers.getMapper(LikeMapper.class);

    LikeDTO toDTO(Like like);
    List<LikeDTO> toDTO(List<Like> likes);
}
