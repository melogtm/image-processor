package org.melogtm.imgprocessor.domain.image.transformation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Filters {
    private Boolean grayscale;
    private Boolean sepia;
}
