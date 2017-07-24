package posidenpalace.com.walmartproblem.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Android on 7/22/2017.
 */

public class WMItemsPOJO implements Parcelable {

    //  value   // refrence in the jsons Pojo
    String itemName; // name
    String smallImage; // thumbnail
    String largeImage; // largeImage
    String productUrl; // productUrl
    String customerRaiting; // customerRating
    String stock; // stock
    double price; //SalePrice
    String description; //short Description
    int pos;

    protected WMItemsPOJO(Parcel in) {
        itemName = in.readString();
        smallImage = in.readString();
        largeImage = in.readString();
        productUrl = in.readString();
        customerRaiting = in.readString();
        stock = in.readString();
        price = in.readDouble();
        description = in.readString();
        pos = in.readInt();
    }

    public static final Creator<WMItemsPOJO> CREATOR = new Creator<WMItemsPOJO>() {
        @Override
        public WMItemsPOJO createFromParcel(Parcel in) {
            return new WMItemsPOJO(in);
        }

        @Override
        public WMItemsPOJO[] newArray(int size) {
            return new WMItemsPOJO[size];
        }
    };

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public WMItemsPOJO(String itemName, String smallImage, String largeImage, String productUrl, String customerRaiting, String stock, double price, String description) {
        this.itemName = itemName;
        this.smallImage = smallImage;
        this.largeImage = largeImage;
        this.productUrl = productUrl;
        this.customerRaiting = customerRaiting;
        this.stock = stock;
        this.price = price;
        this.description = description;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getCustomerRaiting() {
        return customerRaiting;
    }

    public void setCustomerRaiting(String customerRaiting) {
        this.customerRaiting = customerRaiting;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemName);
        dest.writeString(smallImage);
        dest.writeString(largeImage);
        dest.writeString(productUrl);
        dest.writeString(customerRaiting);
        dest.writeString(stock);
        dest.writeDouble(price);
        dest.writeString(description);
        dest.writeInt(pos);
    }
}
