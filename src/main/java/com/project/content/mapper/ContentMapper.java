package com.project.content.mapper;
import com.project.content.domain.Content;
import com.project.content.dto.ContentDTO;
import com.project.content.dto.ContentDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContentMapper {

    ContentMapper INSTANCE = Mappers.getMapper(ContentMapper.class);

    @Mapping(target = "createdAt", dateFormat = "MM/dd/yyyy HH:mm")
    ContentDTO toDTO(Content content);
    List<ContentDTO> toDTO(List<Content> contentList);

    Content toEntity(ContentDetailsDTO contentDTO);
}
