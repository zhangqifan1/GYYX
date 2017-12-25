package com.v.gyyx.beans;

public class MultipleItem {
    public static final int Type0 = 0;
    public static final int Type1 = 1;
    public static final int Type2 = 2;
    public static final int Type3 = 3;
    public static final int Type4 = 4;
    public static final int Type5 = 5;
    public int itemType;

    /****************条目0*************************/
    private int TitleImageResID;
    private String TitleText;
    private String TitleNum1;
    private String TitleNum2;
    private String TitleDate;

    public int getTitleImageResID() {
        return TitleImageResID;
    }

    public void setTitleImageResID(int titleImageResID) {
        TitleImageResID = titleImageResID;
    }

    public String getTitleText() {
        return TitleText;
    }

    public void setTitleText(String titleText) {
        TitleText = titleText;
    }

    public String getTitleNum1() {
        return TitleNum1;
    }

    public void setTitleNum1(String titleNum1) {
        TitleNum1 = titleNum1;
    }

    public String getTitleNum2() {
        return TitleNum2;
    }

    public void setTitleNum2(String titleNum2) {
        TitleNum2 = titleNum2;
    }

    public String getTitleDate() {
        return TitleDate;
    }

    public void setTitleDate(String titleDate) {
        TitleDate = titleDate;
    }

    /****************条目1*************************/
    private int image1_i1;
    private int image2_i1;
    private int image3_i1;
    private String text_i1;

    public int getImage1_i1() {
        return image1_i1;
    }

    public void setImage1_i1(int image1_i1) {
        this.image1_i1 = image1_i1;
    }

    public int getImage2_i1() {
        return image2_i1;
    }

    public void setImage2_i1(int image2_i1) {
        this.image2_i1 = image2_i1;
    }

    public int getImage3_i1() {
        return image3_i1;
    }

    public void setImage3_i1(int image3_i1) {
        this.image3_i1 = image3_i1;
    }

    public String getText_i1() {
        return text_i1;
    }

    public void setText_i1(String text_i1) {
        this.text_i1 = text_i1;
    }

    /************************条目2*****************/
    private HuatiBean huatiBean;

    public HuatiBean getHuatiBean() {
        return huatiBean;
    }

    public void setHuatiBean(HuatiBean huatiBean) {
        this.huatiBean = huatiBean;
    }

    /**********************条目3***********************/

    private HuaTi7Bean huaTi7Bean;

    public HuaTi7Bean getHuaTi7Bean() {
        return huaTi7Bean;
    }

    public void setHuaTi7Bean(HuaTi7Bean huaTi7Bean) {
        this.huaTi7Bean = huaTi7Bean;
    }
}
