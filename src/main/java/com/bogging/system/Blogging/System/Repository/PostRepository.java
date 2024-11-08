package com.bogging.system.Blogging.System.Repository;

import com.bogging.system.Blogging.System.Entity.Post;
import com.bogging.system.Blogging.System.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
//    List<Post> findByStatus(PostStatus status);
    List<Post> findByAuthor(User author);
}

