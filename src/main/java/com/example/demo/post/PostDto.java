package com.example.demo.post;

import com.example.demo.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.micrometer.common.lang.NonNull;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

/* @JsonIgnoreProperties(ignoreUnknown = false) */
public class PostDto {
    @NotNull
    @Schema(description = "userID.", required = true, example = "35") 
    private Integer userId; 

    @NotNull
    @Schema(description = "title.", required = true, example = "title")
    private String title;

    @NotNull
    @Schema(description = "content.", required = true, example = "Once upon a time..")
    private String content;
    
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    
}
