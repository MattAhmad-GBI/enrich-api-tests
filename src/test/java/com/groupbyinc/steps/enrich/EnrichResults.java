package com.groupbyinc.steps.enrich;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class EnrichResults {
    private  List<Map<String, Object>> allMetaList;
    private int recordSize;

    public List<Map<String, Object>> getAllMetaList() {
        return allMetaList;
    }

    public void setAllMetaList(List<Map<String, Object>> allMetaList) {
        this.allMetaList = allMetaList;
    }

    public int getRecordSize() {
        return recordSize;
    }

    public void setRecordSize(int recordSize) {
        this.recordSize = recordSize;
    }

}
