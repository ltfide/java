package belajar.java.database;

import belajar.java.database.entity.Comment;
import belajar.java.database.repository.CommentRepository;
import belajar.java.database.repository.CommentRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.util.List;

public class RepositoryTest {

    private CommentRepository commentRepository;

    @BeforeEach
    void setup() {
        commentRepository = new CommentRepositoryImpl();
    }

    @Test
    void testInsert() {
        Comment comment = new Comment("lutfi@gmail.com", "test");
        commentRepository.insert(comment);

        Assertions.assertNotNull(comment.getId());
        System.out.println(comment.getId());
    }

    @Test
    void testFindById() {
        Comment comment = commentRepository.findById(1804);
        Assertions.assertNotNull(comment);
        System.out.println(comment.getId());
        System.out.println(comment.getEmail());
        System.out.println(comment.getComment());

        Comment notfound = commentRepository.findById(100000);
        Assertions.assertNull(notfound);
    }

    @Test
    void testFindAll() {
        List<Comment> comments = commentRepository.findAll();
        System.out.println(comments.size());
        for (Comment comment : comments) {
            System.out.println(comment.getId());
            System.out.println(comment.getEmail());
            System.out.println(comment.getComment());
        }
    }

    @Test
    void testFindByEmail() {
        List<Comment> comments = commentRepository.findAllByEmail("lutfi@gmail.com");
        System.out.println(comments.size());
        for (Comment comment : comments) {
            System.out.println(comment.getId());
            System.out.println(comment.getEmail());
            System.out.println(comment.getComment());
        }
    }

}
