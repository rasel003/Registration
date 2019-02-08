package com.rasel.registration.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rasel.registration.R;
import com.rasel.registration.model.UserInfo;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class All_User_Adapter extends RecyclerView.Adapter<All_User_Adapter.ViewHolder> {
    private Context context;
    private List<UserInfo> userInfoList;
    private OnItemClickListener listener;

    public All_User_Adapter(Context context, List<UserInfo> userList) {
        this.context = context;
        this.userInfoList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.all_user_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        //viewHolder.circleImageView
        viewHolder.tvNameValue.setText(userInfoList.get(i).getName());
        viewHolder.tvAddressValue.setText(userInfoList.get(i).getAddress());
        viewHolder.tvEmailValue.setText(userInfoList.get(i).getEmail());
        viewHolder.tvPhoneValue.setText(userInfoList.get(i).getPhone());

    }

    @Override
    public int getItemCount() {
        return userInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView circleImageView;
        private TextView tvNameValue, tvAddressValue, tvEmailValue, tvPhoneValue;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            circleImageView = itemView.findViewById(R.id.circleImageView);
            tvNameValue = itemView.findViewById(R.id.tvNameValue);
            tvAddressValue = itemView.findViewById(R.id.tvAddressValue);
            tvEmailValue = itemView.findViewById(R.id.tvEmailValue);
            tvPhoneValue = itemView.findViewById(R.id.tvPhoneValue);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(userInfoList.get(position));
                    }
                }
            });
        }
    }
    public interface OnItemClickListener {
        void onItemClick(UserInfo userInfo);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
