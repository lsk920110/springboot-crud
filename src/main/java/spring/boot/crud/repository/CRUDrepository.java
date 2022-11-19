package spring.boot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.crud.entity.BoardEntity;

@Repository
public interface CRUDrepository extends JpaRepository<BoardEntity , Long> {




}
