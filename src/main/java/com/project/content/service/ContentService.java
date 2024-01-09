package com.project.content.service;


import com.project.content.dto.ContentDTO;
import com.project.content.dto.ContentDetailsDTO;

import java.net.URI;
import java.security.Principal;
import java.util.List;

public interface ContentService {

    List<ContentDTO> getAllContents(int page);

    ContentDTO getContentById(String contentId);

    List<ContentDTO> getContentByCategoryId(String categoryId, int page);

    ContentDTO createContent(ContentDetailsDTO contentDTO);

    ContentDTO likeContent(String contentId, Principal principal);
}
