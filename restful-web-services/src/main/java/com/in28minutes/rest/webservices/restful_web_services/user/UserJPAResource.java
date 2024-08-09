package com.in28minutes.rest.webservices.restful_web_services.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
class UserJPAResource {

    private UserRepository userRepository;

    private PostRepository postRepository;

    public UserJPAResource(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    //Get All Users
    //GET /users
    @GetMapping(path = "/jpa/users")
    public List<User> retrieveAllUser() {
        return userRepository.findAll();
    }

    //Get one specific user
    //GET /users/{id}
    //Add HATEOAS link: http://localhost:8080/users
    //Two concepts:
    //EntityModel
    //WebMvcLinkBuilder
    @GetMapping(path = "/jpa/users/{userId}")
    public EntityModel<User> retrieveUser(@PathVariable Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id: " + userId + " Not Found");
        }
        EntityModel<User> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUser());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    //Create new User
    //POST /users
    @PostMapping(path = "/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        //Returning the location of created user
        // /users/4 -> /users/{id}, user.getID()
        //Take the current URL, add a path variable, get the value of the path variable and build the URI
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    //Delete a user
    //DELETE /users/{id}
    @DeleteMapping(path = "/jpa/users/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userRepository.deleteById(userId);
    }

    //Post URL Methods
    //Get Posts for a user id
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("id:" + id  + " Not Found");
        return user.get().getPosts();
    }

    //Create a Post for a user
    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable Integer id, @Valid @RequestBody Post post) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty())
            throw new UserNotFoundException("id:" + id + " Not Found");

        post.setUser(user.get());

        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    //get a post with id
    @GetMapping("/jpa/users/{userId}/posts/{postId}")
    public Post retrievePostsWithIdForUser(@PathVariable Integer userId, @PathVariable Integer postId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Post> post = postRepository.findById(postId);
        if (user.isEmpty())
            throw new UserNotFoundException("User id:" + userId + " Not found");
        if (post.isEmpty())
            throw new PostNotFoundException("Post id:" + postId + " Not found");
        return post.get();
    }
}
