package com.example.pp3_1_1.repository;

import com.example.pp3_1_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {  //методы можно добавлять и в репозиторий
    User findUserByUsername(String username);   // все условия прописываем прямо в имени метода
}
