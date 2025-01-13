package com.example.repository;

import com.example.domain.Archive;
import com.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArchiveRepository extends JpaRepository<Archive, Long> {
    List<Archive> findByUser(User user);
}
