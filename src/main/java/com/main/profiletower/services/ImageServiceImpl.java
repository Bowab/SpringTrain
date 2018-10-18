package com.main.profiletower.services;

import com.main.profiletower.models.Image;
import com.main.profiletower.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("imageService")
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image findUserByFileNameServer(String ServerFileName) {
        return imageRepository.findByFileNameServer(ServerFileName);
    }
}
