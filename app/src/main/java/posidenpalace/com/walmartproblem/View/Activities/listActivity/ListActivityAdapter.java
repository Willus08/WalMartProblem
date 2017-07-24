package posidenpalace.com.walmartproblem.View.Activities.listActivity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import posidenpalace.com.walmartproblem.Model.WMItemsPOJO;
import posidenpalace.com.walmartproblem.R;
import posidenpalace.com.walmartproblem.View.Activities.detailedListActivity.DetailedListActivity;


public class ListActivityAdapter extends RecyclerView.Adapter<ListActivityAdapter.ViewHolder> {
    List<WMItemsPOJO> itemsPOJO = new ArrayList<WMItemsPOJO>();

    public ListActivityAdapter(List<WMItemsPOJO> itemsPOJO) {
        this.itemsPOJO = itemsPOJO;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listed_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final WMItemsPOJO item = itemsPOJO.get(position);
        holder.name.setText("Name: "+item.getItemName());
        holder.price.setText("Price: $"+item.getPrice());
        holder.stock.setText("Stock: "+ item.getStock());
        item.setPos(position);
        Glide.with(holder.itemView.getContext()).load(item.getSmallImage()).into(holder.icon);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailedListActivity.class);
                intent.putParcelableArrayListExtra("list", (ArrayList<? extends Parcelable>) itemsPOJO);
                intent.putExtra("item", item);
                v.getContext().startActivity(intent);
            }
        });
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
        FrameLayout container;
        public ViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.ivIcon);
            name =(TextView) itemView.findViewById(R.id.tvItemName);
            stock = (TextView) itemView.findViewById(R.id.tvItemStock);
            price = (TextView) itemView.findViewById(R.id.tvItemPrice);
            container = (FrameLayout) itemView.findViewById(R.id.flItemListLayout);
        }
    }
}
