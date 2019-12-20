package com.momen.recylerviewjsonpass;

public class ExampleItem {


    private String mImageUrl;
    private String mCreator;
    private  String mEmail;
    private  String mPhone;
    private  String mAdress;
    private  String mCompanyName;

    private int mLikes;



    public ExampleItem(String imageUrl, String creator,String email,String phone,String adress,String companyName, int likes) {
        mImageUrl = imageUrl;
        mCreator = creator;
        mLikes = likes;
        mEmail=email;
        mPhone=phone;
        mAdress=adress;
        mCompanyName=companyName;

    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getCreator() {
        return mCreator;
    }

    public String getEmail(){
        return mEmail;
    }
    public String getPhone(){
        return mPhone;
    }
    public String getAdress(){
        return mAdress;
    }
    public String getCompany(){
        return mCompanyName;
    }

    public int getLikeCount() {
        return mLikes;
    }
}