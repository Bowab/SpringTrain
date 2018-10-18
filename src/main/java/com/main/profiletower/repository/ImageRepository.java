package com.main.profiletower.repository;

import com.main.profiletower.models.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {
    public Image findByFileNameServer(String serverFileName);
}
