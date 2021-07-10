package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.library.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
