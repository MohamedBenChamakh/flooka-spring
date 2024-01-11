package com.project.content.service.impl;

import com.google.apps.meet.v2beta.Space;
import com.google.apps.meet.v2beta.SpacesServiceClient;
import com.project.content.domain.Content;
import com.project.content.domain.Like;
import com.project.content.dto.ContentDTO;
import com.project.content.dto.ContentDetailsDTO;
import com.project.content.mapper.ContentMapper;
import com.project.content.repository.ContentRepository;
import com.project.content.service.ContentService;
import com.project.content.utils.TokenManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;

    public ContentServiceImpl(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public List<ContentDTO> getAllContents(int page) {
        int pageSize = 10;
        Pageable paging = PageRequest.of(page, pageSize);
        return ContentMapper.INSTANCE.toDTO(contentRepository.findAll(paging).getContent());
    }

    @Override
    public ContentDTO getContentById(String contentId) {
        return ContentMapper.INSTANCE.toDTO(contentRepository.findById(contentId).orElse(null));
    }

    @Override
    public List<ContentDTO> getContentByCategoryId(String categoryId, int page) {
        int pageSize = 10;
        Pageable paging = PageRequest.of(page, pageSize);
        return ContentMapper.INSTANCE.toDTO(contentRepository.findByCategory_id(categoryId, paging).getContent());
    }

    @Override
    public ContentDTO createContent(ContentDetailsDTO contentDTO) {
        return ContentMapper.INSTANCE.toDTO(contentRepository
                .save(ContentMapper.INSTANCE.toEntity(contentDTO)));
    }

    @Override
    public ContentDTO likeContent(String contentId, Principal principal) {
        String userId = TokenManager.extractFromToken("sub",principal);
        Optional<Content> contentOptional = contentRepository.findById(contentId);
        if (contentOptional.isPresent()) {
            Content content = contentOptional.get();
            List<Like> likes = content.getLikes();
            Optional<Like> optionalLike = likes.stream()
                    .filter(likeEntity -> likeEntity.getUser().getId().equals(userId))
                    .findAny();
            if(optionalLike.isPresent()){
                likes.remove(optionalLike.get());
            }else{
                Like like = new Like(userId, contentId);
                likes.add(like);
            }
            content.setLikes(likes);
            content.setTotalLikes(content.getLikes().size());
            return ContentMapper.INSTANCE.toDTO(contentRepository.saveAndFlush(content));
        }
        return null;
    }

}
