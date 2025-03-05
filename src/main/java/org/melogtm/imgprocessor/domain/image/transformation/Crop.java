package org.melogtm.imgprocessor.domain.image.transformation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Crop {
    private int x;
    private int y;
    private int width;
    private int height;
}
