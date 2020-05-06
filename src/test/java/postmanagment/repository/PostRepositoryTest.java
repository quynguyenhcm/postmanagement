package postmanagment.repository;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
//import westpac.test.config.H2TestConfig;
import postmanagment.model.Post;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testFindAll(){
        
        List<Post> posts = postRepository.findAll();
        assertNotNull(posts);
        assertEquals(posts.size(), 3);
    }

    @Test
    public void testFindById(){
        
        Optional<Post> post = postRepository.findById(1L);
        assertNotNull(post);
        assertEquals(post.isPresent(), true);
        assertEquals(post.get().getId(), 1);
    }

    @Test
    public void testFindByIdNotExist(){
        Optional<Post> post = postRepository.findById(8L);

        assertNotNull(post);
        assertEquals(post.isPresent(), false);
    }
}
