package com.example.blog.reply;

import com.example.blog._core.util.MyDate;
import com.example.blog.board.Board;
import com.example.blog.user.User;
import lombok.Data;

public class ReplyResponse {

    @Data
    public static class findAllDTO {
        private Integer id;
        private String comment;
        private String createdAt;

        private Integer userId;
        private String username;

        private Integer boardId;
        private String boardTitle;

        public findAllDTO(Reply reply) {
            this.id = reply.getId();
            this.comment = reply.getComment();
            this.createdAt = MyDate.formatToStr(reply.getCreatedAt());

            this.userId = reply.getUser().getId();
            this.username = reply.getUser().getUsername();

            this.boardId = reply.getBoard().getId();
            this.boardTitle = reply.getBoard().getTitle();
        }
    }
}
