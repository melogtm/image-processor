package org.melogtm.imgprocessor.controllers;

import org.melogtm.imgprocessor.domain.image.ImageRequestDTO;
import org.melogtm.imgprocessor.domain.image.ImageResponseDTO;
import org.melogtm.imgprocessor.domain.image.transformation.Transformations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("/image")
public class ImageController {

    @PostMapping(value = "/", consumes = "multipart/form-data")
    public ResponseEntity<ImageResponseDTO> processImage(@ModelAttribute ImageRequestDTO imageRequestDTO) {
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
