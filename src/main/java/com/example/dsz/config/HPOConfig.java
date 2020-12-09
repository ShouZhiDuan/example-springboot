package com.example.dsz.config;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/9 15:46
 * @Description:
 */
@Data
public class HPOConfig {
    /**
     * 网站URL
     */
    public final static List<String> hpos = Arrays.asList(
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_connective_tissue",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_the_voice",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_the_nervous_system",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_the_breast",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_the_eye",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_prenatal_development_or_birth",
            "http://www.chinahpo.org/wiki/index.php/Neoplasm",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_the_endocrine_system",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_head_and_neck",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_the_immune_system",
            "http://www.chinahpo.org/wiki/index.php/Growth_abnormality",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_limbs",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_the_thoracic_cavity",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_blood_and_blood-forming_tissues",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_the_musculature",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_the_cardiovascular_system",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_the_skeletal_system",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_the_respiratory_system",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_the_ear",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_metabolism/homeostasis",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_the_genitourinary_system",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_the_integument",
            "http://www.chinahpo.org/wiki/index.php/Abnormality_of_the_digestive_system",
            "http://www.chinahpo.org/wiki/index.php/Mode_of_inheritance",
            "http://www.chinahpo.org/wiki/index.php/Mortality/Aging",
            "http://www.chinahpo.org/wiki/index.php/Clinical_modifier"
    );
}
