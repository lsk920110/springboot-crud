package spring.boot.crud.repository;

import java.time.LocalDateTime;

public interface BoardListReadAll {
    Long getId();
    String getTitle();
    LocalDateTime getCreateDate();
}
