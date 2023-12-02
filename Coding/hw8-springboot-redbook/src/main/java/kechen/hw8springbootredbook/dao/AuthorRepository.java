package kechen.hw8springbootredbook.dao;

import kechen.hw8springbootredbook.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // You can add specific methods here if needed
}
