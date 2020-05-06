package postmanagment.repository;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import postmanagment.model.Comment;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CommentRepositoryTest {
    @Autowired
    private CommentRepository postRepository;
    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void testCommentFindById(){
        Optional<Comment> comment = postRepository.findById(1L);
        
        assertNotNull(comment);
        assertEquals(comment.isPresent(), true);
        assertEquals(comment.get().getId(), 1);
    }

    @Test
    public void testCommentFindByIdAndPostId(){
        Optional<Comment> comment = postRepository.findByIdAndPostId(1L, 1L);
        
        assertNotNull(comment);
        assertEquals(comment.isPresent(), true);
        assertEquals(comment.get().getId(), 1);
    }
}
