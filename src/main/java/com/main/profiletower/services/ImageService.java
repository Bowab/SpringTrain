package com.main.profiletower.services;

import com.main.profiletower.models.Image;

public interface ImageService {
    public Image findUserByFileNameServer(String username);
}
