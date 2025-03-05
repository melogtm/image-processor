package org.melogtm.imgprocessor.domain.image.transformation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transformations {
    private Double rotate;
    private Crop crop;
    private Filters filters;
    private Resize resize;
    private String format;
}
