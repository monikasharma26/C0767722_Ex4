package com.example.c0767722_ex4;

import java.util.List;

public class DetailsComplaint {

    public static List<Complaint> detailList;
    public static void addNewComplaint(Complaint cmp) {
        detailList.add(cmp);

    }

    public static List<Complaint> getCmpDetails() {
        return detailList;
    }


}
