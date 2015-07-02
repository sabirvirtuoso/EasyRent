package com.easyrent.webapp.bean;

/**
 * Created by sabir.salman on 4/23/15.
 */
public class SearchCriteria {

    private Integer minSize;

    private Integer maxBudget;

    private Integer bedrooms;

    private String area;

    public void setMaxBudget(Integer maxBudget) {
        this.maxBudget = maxBudget;
    }

    public Integer getMaxBudget() {
        return maxBudget;
    }

    public Integer getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }
}
