package com.example.blog.reply;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;

    public List<ReplyResponse.findAllDTO> findAll() {
        return replyRepository.findAll().stream()
                .map(ReplyResponse.findAllDTO::new)
                .toList();
    }
}
