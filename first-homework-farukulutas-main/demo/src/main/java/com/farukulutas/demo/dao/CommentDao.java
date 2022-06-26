package com.farukulutas.demo.dao;

import com.farukulutas.demo.entity.UserComment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<UserComment, Long> {
}