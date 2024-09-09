package com.news.system.news_api.controller;

import com.news.system.news_api.dto.RequestCommentDto;
import com.news.system.news_api.service.CommentService;
import com.news.system.news_api.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
@CrossOrigin
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<StandardResponse> create(@RequestBody RequestCommentDto dto) {
        commentService.createComment(dto);
        return new ResponseEntity<>(
                new StandardResponse(
                        201,
                        "Comment Created",
                        null
                ), HttpStatus.CREATED
        );
    }
}
