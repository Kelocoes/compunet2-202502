package com.games.back.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.games.back.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    List<User> findAll();
    Optional<User> findById(Long id);
    void deleteById(Long id);

    Optional<User> findByUsernameEquals(String username);

    List<User> findByUsername(String username);

    List<User> findByUsernameContaining(String username);

    List<User> findByUsernameStartingWith(String username);

    List<User> findByUsernameEndingWith(String username);

    List<User> findByUsernameIgnoreCase(String username);

    List<User> findByUsernameIsNot(String username);

    List<User> findByUsernameLike(String username);

    List<User> findByCreatedAtGreaterThan(Timestamp createdAt);

    List<User> findByCreatedAtLessThan(Timestamp createdAt);

    List<User> findByCreatedAtLessThanEqual(Timestamp createdAt);

    @Query("SELECT count(*), year(u.createdAt) from User u group by year(u.createdAt)")
    List<List<Integer>> countByYearCreated();

    @Query(value = "SELECT * FROM users WHERE username = ?1", nativeQuery = true)
    List<User> findByUsernameNative(String username);

    List<User> findByIdIn(List<Long> ids);

    @Query("SELECT u FROM User u WHERE u.username = :username")
    List<User> findByUsernameParam(@Param("username") String username);
}
