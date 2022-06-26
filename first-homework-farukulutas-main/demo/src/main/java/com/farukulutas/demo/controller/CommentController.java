package com.farukulutas.demo.controller;

import java.util.List;

import com.farukulutas.demo.dao.CommentDao;
import com.farukulutas.demo.entity.UserComment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentDao commentDao;

    @PostMapping("/register")
    public ResponseEntity<UserComment> saveComment(@RequestBody UserComment comment) {

        comment = commentDao.save(comment);

        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @GetMapping("/getAllComments")
    public ResponseEntity<List<UserComment>> getAllComments() {

        List<UserComment> userComment = commentDao.findAll();

        return ResponseEntity.ok(userComment);
    }

    @DeleteMapping("/remove/{id}")
    public void delete(@PathVariable Long id) {
        commentDao.deleteById(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<UserComment> updateComment(@PathVariable Long id, @RequestBody String newComment) {

        UserComment userComment = commentDao.findById(id).orElseThrow();

        userComment.setComment(newComment);

        userComment = commentDao.save(userComment);

        return ResponseEntity.ok(userComment);
    }
}
