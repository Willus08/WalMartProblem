package posidenpalace.com.walmartproblem.View.Activities.detailedListActivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import posidenpalace.com.walmartproblem.Model.WMItemsPOJO;
import posidenpalace.com.walmartproblem.R;


public class DetailedListActivityAdapter extends RecyclerView.Adapter<DetailedListActivityAdapter.ViewHolder> {
    List<WMItemsPOJO> itemsPOJO = new ArrayList<>();

    public DetailedListActivityAdapter(List<WMItemsPOJO> itemsPOJO) {
        this.itemsPOJO = itemsPOJO;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detailed_items_list,parent,false);
        return new DetailedListActivityAdapter.ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final WMItemsPOJO item = itemsPOJO.get(position);
        holder.name.setText("Name: "+item.getItemName());
        holder.price.setText("Price: $"+item.getPrice());
        holder.stock.setText("Stock: "+ item.getStock());
        holder.description.setText("Description :" + item.getDescription());
//        holder.rating.setText("Ratings: " +item.getCustomerRaiting());
        Glide.with(holder.itemView.getContext()).load(item.getLargeImage()).into(holder.icon);

    }

    @Override
    public int getItemCount() {
        return itemsPOJO.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView name;
        TextView stock;
        TextView price;
        TextView description;
        TextView rating;


        public ViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.ivLargeItemImage);
            name =(TextView) itemView.findViewById(R.id.tvItemNameD);
            stock = (TextView) itemView.findViewById(R.id.tvItemStockD);
            price = (TextView) itemView.findViewById(R.id.tvItemPriceD);
            description =(TextView) itemView.findViewById(R.id.tvItemDescription);
            stock = (TextView) itemView.findViewById(R.id.tvItemReview);


        }
    }
}


