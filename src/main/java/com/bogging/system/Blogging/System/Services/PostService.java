package com.bogging.system.Blogging.System.Services;

import com.bogging.system.Blogging.System.Entity.Post;
import com.bogging.system.Blogging.System.Entity.User;
import com.bogging.system.Blogging.System.Repository.PostRepository;
import com.bogging.system.Blogging.System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    public Post createPost(Post post, Long authorId) {
        User author = userRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found"));
        post.setAuthor(author);
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post updatedPost) {
        Post existingPost = getPostById(id);
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());
        existingPost.setImage(updatedPost.getImage());
        existingPost.setStatus(updatedPost.getStatus());
        return postRepository.save(existingPost);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}

