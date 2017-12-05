package mycollege.asmobisoft.com.restaurentapp.activity;

/**
 * Created by gaurav on 12/9/17.
 */

public class ListRowModel {
    private int imageId;
    private String countryName;
    private String countryCode;

    public ListRowModel(int imageId, String title, String countryCode) {
        this.imageId = imageId;
        this.countryName = title;
        this.countryCode = countryCode;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String desc) {
        this.countryCode = desc;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return countryName + "\n" + countryCode;
    }

}
