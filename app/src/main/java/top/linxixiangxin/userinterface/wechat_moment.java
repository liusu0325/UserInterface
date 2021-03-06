package top.linxixiangxin.userinterface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

public class wechat_moment extends BaseAdapter {
    private Context context; //上下文
    private List<Map<String, Object>> listItems;
    private LayoutInflater listContainer;

    public class ViewHolder {
        public ImageView image;
        public TextView user_name;
        public TextView user_content;
        public TextView sendTime;
        public ImageView header_img,gimg1,gimg2,gimg3,gimg4,gimg5,gimg6;
        public ImageView popDialog;
    }

    public wechat_moment(Context context, List<Map<String, Object>> listItems) {
        this.context = context;
        listContainer = LayoutInflater.from(context);
        this.listItems = listItems;
    }

    @Override
    public int getItemViewType(int position) { //查得只支持两种Type故弃用
        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        ViewHolder holder1 = null;
        view = null;
        if (view == null) {
            switch (i) {
                case 0://头秃（图）
                    //通过这种方法来设置不同的View
                    view = LayoutInflater.from(context).inflate(R.layout.wechat_header, null);
                    holder1 = new ViewHolder();
                    view = listContainer.inflate(R.layout.wechat_header, null);
                    holder1.header_img = view.findViewById(R.id.wechat_header_img);
                    view.setTag(holder1);
                    break;
                default:
                    holder = new ViewHolder();
                    view = listContainer.inflate(R.layout.wechat_moment, null); //设置布局
                    holder.image = view.findViewById(R.id.friend_head_img);
                    holder.user_name = view.findViewById(R.id.moment_Name);
                    holder.user_content = view.findViewById(R.id.moment_content);
                    holder.sendTime = view.findViewById(R.id.moment_sendtime);
                    holder.gimg1 = view.findViewById(R.id.grid_1);
                    holder.gimg2 = view.findViewById(R.id.grid_2);
                    holder.gimg3 = view.findViewById(R.id.grid_3);
                    holder.gimg4 = view.findViewById(R.id.grid_4);
                    holder.gimg5 = view.findViewById(R.id.grid_5);
                    holder.gimg6 = view.findViewById(R.id.grid_6);
                    holder.popDialog = view.findViewById(R.id.popDialog);
                    holder.popDialog.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {//设置menu按下的监听
                            Toast.makeText(context, "被按下", Toast.LENGTH_SHORT).show();
                        }
                    });

                    view.setTag(holder);
                    break;
            }

        } else {
            switch (i) {
                case 0:
                    holder1 = (ViewHolder) view.getTag();
                    break;
                default:
                    holder = (ViewHolder) view.getTag();
                    break;
            }

        }
        switch (i){
            case 0:
                holder1.header_img.setImageResource(R.drawable.head_pic);
                break;
                default:
                    holder.image.setImageResource((Integer) listItems.get(i).get("image"));
                    holder.user_name.setText((String) listItems.get(i).get("username"));
                    holder.user_content.setText((String) listItems.get(i).get("usercontent"));
                    holder.sendTime.setText((String) listItems.get(i).get("sendtime"));
                    holder.gimg1.setImageResource((Integer) listItems.get(i).get("img1"));
                    holder.gimg2.setImageResource((Integer) listItems.get(i).get("img2"));
                    holder.gimg3.setImageResource((Integer) listItems.get(i).get("img3"));
                    holder.gimg4.setImageResource((Integer) listItems.get(i).get("img4"));
                    holder.gimg5.setImageResource((Integer) listItems.get(i).get("img5"));
                    holder.gimg6.setImageResource((Integer) listItems.get(i).get("img6"));
                    break;
        }

        return view;
    }
}
