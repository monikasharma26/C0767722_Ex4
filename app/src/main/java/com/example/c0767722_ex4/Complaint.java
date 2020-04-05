package com.example.c0767722_ex4;

import android.os.Parcel;
import android.os.Parcelable;

public class Complaint implements Parcelable
{
    private String suffix;
    private String fName;
    private String lName;
    private String empStatus;
    private String designation;
    private int unitNo;
    private String streetName;
    private String provience;
    private String Cntry;
    private String postCode;
    private String emailId;
    private String mobileNumber;
    private String date;
    private String issueType;
    private String desc;
    private float rating;


    public Complaint(String suffix, String fName, String lName, String radioStatus, String designation,
                     int unitNo, String streetName, String provience, String cntry,
                     String postCode, String emailId, String mobileNumber, String dob, String desc, String mspinner
    ,float rating) {
        this.suffix = suffix;
        this.fName = fName;
        this.lName = lName;
        this.empStatus = radioStatus;
        this.designation = designation;
        this.unitNo = unitNo;
        this.streetName = streetName;
        this.provience = provience;
        Cntry = cntry;
        this.postCode = postCode;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.date = date;
        this.desc = desc;
        this.issueType = mspinner;
        this.rating =  rating;
    }

    public String getSuffix() {
        return suffix;
    }
    public float rating() {
        return rating;
    }
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(int unitNo) {
        this.unitNo = unitNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getProvience() {
        return provience;
    }

    public void setProvience(String provience) {
        this.provience = provience;
    }

    public String getCntry() {
        return Cntry;
    }

    public void setCntry(String cntry) {
        Cntry = cntry;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }



    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }

    public String fullName() {
        return lName.toUpperCase() + ", " + fName.toLowerCase();
    }

    public Complaint(String suffix, String fName, String lName, String empStatus, String designation,
                    String streetName, String provience, String cntry,
                     String postCode, String emailId, String mobileNumber, String date,
                    String desc,int rating) {
        this.suffix = suffix;
        this.fName = fName;
        this.lName = lName;
        this.empStatus = empStatus;
        this.designation = designation;
       // this.unitNo = unitNo;
        this.streetName = streetName;
        this.provience = provience;
        Cntry = cntry;
        this.postCode = postCode;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.date = date;
       // this.issueType = issueType;

        this.desc = desc;
    }
      public Complaint()
        {

        }
    protected Complaint(Parcel in) {
        suffix = in.readString();
        fName = in.readString();
        lName = in.readString();
        empStatus = in.readString();
        designation = in.readString();
      unitNo = in.readInt();
        streetName = in.readString();
        provience = in.readString();
        Cntry = in.readString();
        postCode = in.readString();
        emailId = in.readString();
        mobileNumber = in.readString();
        date = in.readString();
       issueType = in.readString();
      // severity = in.readString();
        desc = in.readString();
        rating = in.readFloat();
    }

    public static final Creator<Complaint> CREATOR = new Creator<Complaint>() {
        @Override
        public Complaint createFromParcel(Parcel in) {
            return new Complaint(in);
        }

        @Override
        public Complaint[] newArray(int size) {
            return new Complaint[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(suffix);
        dest.writeString(fName);
        dest.writeString(lName);
        dest.writeString(empStatus);
        dest.writeString(designation);
         dest.writeInt(unitNo);
        dest.writeString(streetName);
        dest.writeString(provience);
        dest.writeString(Cntry);
        dest.writeString(postCode);
        dest.writeString(emailId);
        dest.writeString(mobileNumber);
        dest.writeString(date);
       dest.writeString(issueType);
       //dest.writeInt(severity);
        dest.writeString(desc);
        dest.writeFloat(rating);
    }
    public String getData(){
        return "Full Name: "+ suffix + fName +" " + lName+ "\n"+
                "Employement Status: "+ empStatus+ "\n"+
                "Designation: "+ designation + "\n"+
                " Address: \n"+
                "  "+unitNo+", "+streetName+", "+provience+" \n"+
                "Email: "+emailId+"\n"+
                "Mobile: "+mobileNumber+"\n"+
                "Date "+date+"\n"+
                "Description:   "+desc+"\n"
                ;

    }
}
