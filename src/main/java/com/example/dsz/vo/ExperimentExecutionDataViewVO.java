package com.example.dsz.vo;

import lombok.Data;

import java.util.List;


@Data
public class ExperimentExecutionDataViewVO {
    private String featureName;
    private String featureSchema;
    private List<String> values;
    private List<Integer> distribution;
    private Double min;
    private Double max;
    private Double step;
}
