package com.twoCube.gifts.dto;

import lombok.Getter;

@Getter
public class PillListResponse {
    private long pillId;
    private String pillImage;

//    public static PillListResponse from(Pill pill) {
//        if(comment == null){
//            return null;
//        }
//        return CommentResponse.builder()
//                .pillId()
//                .replyCount(comment.countReply())
//                .build();
//    }
//
//    public static List<CommentResponse> listFrom(List<Comment> commentList, User user, List<Long> reportId) {
//        if(commentList == null){
//            return null;
//        }
//        return commentList.stream()
//                .filter(comment -> !comment.getUser().getId().equals(user.getId()))
//                .filter(comment -> !reportId.contains(comment.getUser().getReportId()))
//                .map(CommentResponse::from)
//                .collect(Collectors.toList());
//    }
}
