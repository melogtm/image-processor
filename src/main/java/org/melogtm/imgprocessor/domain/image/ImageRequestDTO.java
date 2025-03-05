package org.melogtm.imgprocessor.domain.image;

import org.springframework.web.multipart.MultipartFile;

public record ImageRequestDTO(MultipartFile image) {}
