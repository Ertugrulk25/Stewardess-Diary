package com.example.service;

import com.example.domain.Archive;
import com.example.domain.User;
import com.example.repository.ArchiveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveService {
    private final
    ArchiveRepository archiveRepository;

    public ArchiveService(ArchiveRepository archiveRepository) {
        this.archiveRepository = archiveRepository;
    }

    public List<Archive> getArchivesByUser(User user) {
        return archiveRepository.findByUser(user);
    }

    public Archive saveArchive(Archive archive) {
        return archiveRepository.save(archive);
    }
}
