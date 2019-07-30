package com.techyouth.developer.techyouth;

public class Model {

    private String Interest_id;
    private boolean isSelected = false;
        private  String  Interset_Area ;

    public Model( String interset_Area,String interest_id) {
        Interset_Area = interset_Area;
        Interest_id = interest_id;

    }

    public String getInterest_id() {
        return Interest_id;
    }

    public void setInterest_id(String interest_id) {
        Interest_id = interest_id;
    }

    public String getInterset_Area() {
        return Interset_Area;
    }

    public void setInterset_Area(String interset_Area) {
        Interset_Area = interset_Area;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public boolean isSelected() {
        return isSelected;
    }
}
