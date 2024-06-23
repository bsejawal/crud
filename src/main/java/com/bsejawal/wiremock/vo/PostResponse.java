package com.bsejawal.wiremock.vo;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public class PostResponse {
    private int id;
    private int userId;
    private String title;
    private String body;


    @Override
    public String toString() {
        return "PostResponse{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
