package ru.initiative.jasper.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by no on 10.05.2017.
 */
public class DtoCharts {
    private List<DtoChartsData> dtoChartsDataList = new ArrayList<>();

    public List<DtoChartsData> getDtoChartsDataList() {
        return dtoChartsDataList;
    }

    public void setDtoChartsPieList(List<DtoChartsData> dtoChartsPieList) {
        this.dtoChartsDataList = dtoChartsDataList;
    }
}
