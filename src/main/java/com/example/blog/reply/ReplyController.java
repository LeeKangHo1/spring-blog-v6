package com.example.blog.reply;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping("/comment")
    public String commentList(Model model) {
        List<ReplyResponse.findAllDTO> commentList = replyService.findAll();
        model.addAttribute("commentList", commentList);
        return "reply/comment";
    }
}
