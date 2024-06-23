package com.bsejawal.wiremock.vo;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public class PostRequest {
    private int userId;
    private String title;
    private String body;

    @Override
    public String toString() {
        return "PostRequest{" +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
