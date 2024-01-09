package com.project.content.dto;


import java.math.BigInteger;
import java.util.List;

public class ContentDTO {

    private String id;
    private String title;
    private String description;
    private String media;
    private MediaTypeDTO mediaTypeDTO;
    private BigInteger totalLikes;
    private BigInteger totalComments;
    private UserShortDTO publisher;
    private String createdAt;
    private List<LikeDTO> likes;

    public ContentDTO() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public MediaTypeDTO getMediaType() {
        return mediaTypeDTO;
    }

    public void setMediaType(MediaTypeDTO mediaTypeDTO) {
        this.mediaTypeDTO = mediaTypeDTO;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public UserShortDTO getPublisher() {
        return publisher;
    }

    public void setPublisher(UserShortDTO publisher) {
        this.publisher = publisher;
    }

    public MediaTypeDTO getMediaTypeDTO() {
        return mediaTypeDTO;
    }

    public void setMediaTypeDTO(MediaTypeDTO mediaTypeDTO) {
        this.mediaTypeDTO = mediaTypeDTO;
    }

    public BigInteger getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(BigInteger totalLikes) {
        this.totalLikes = totalLikes;
    }

    public BigInteger getTotalComments() {
        return totalComments;
    }

    public void setTotalComments(BigInteger totalComments) {
        this.totalComments = totalComments;
    }

    public List<LikeDTO> getLikes() {
        return likes;
    }

    public void setLikes(List<LikeDTO> likes) {
        this.likes = likes;
    }
}
