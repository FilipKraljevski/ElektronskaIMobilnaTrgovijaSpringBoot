package mk.ukim.finki.lvemt.repository;

import mk.ukim.finki.lvemt.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
