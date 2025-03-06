package org.melogtm.imgprocessor.controllers;

import org.melogtm.imgprocessor.domain.image.ImageRequestDTO;
import org.melogtm.imgprocessor.domain.image.ImageResponseDTO;
import org.melogtm.imgprocessor.domain.image.transformation.Transformations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController()
@RequestMapping("/image")
public class ImageController {

    /*
    I'll use a temporary folder as my DB, future me will implement S3 buckets and so, I just
    want to transform mah images
     */
    private static final String IMAGE_FOLDER = System.getProperty("user.dir") + "/src/main/resources/images/";

    @PostMapping(value = "/", consumes = "multipart/form-data")
    public ResponseEntity<ImageResponseDTO> processImage(@ModelAttribute ImageRequestDTO imageRequestDTO) {
        String filename = imageRequestDTO.image().getOriginalFilename();

        File file = new File(IMAGE_FOLDER + filename);

        try {
            file.createNewFile();
            imageRequestDTO.image().transferTo(file);
        } catch (IOException e) {
            System.out.println("Sorry, can't save image: " + e.getMessage());
        }

        return ResponseEntity.ok(new ImageResponseDTO("http://localhost:8080/image/1", "metadata"));
    }

    @PostMapping("/{id}/transform")
    public ResponseEntity<ImageResponseDTO> transformImage(@PathVariable UUID id, @RequestBody Transformations transformations) {
        return ResponseEntity.ok(new ImageResponseDTO("http://localhost:8080/image/2", "metadata"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageResponseDTO> getImage(@PathVariable String id) {
        return ResponseEntity.ok(new ImageResponseDTO("http://localhost:8080/image/3", "metadata"));
    }

    // think abt pagination later on
}
