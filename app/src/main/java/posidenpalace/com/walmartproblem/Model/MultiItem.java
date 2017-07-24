
package posidenpalace.com.walmartproblem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MultiItem implements Serializable
{

    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    private final static long serialVersionUID = 1090520676918972500L;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
