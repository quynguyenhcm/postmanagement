package postmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import postmanagment.model.Comment;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>
{
    List<Comment> findByPostId(Long postId);
    Optional<Comment> findByIdAndPostId(Long id, Long postId);
}