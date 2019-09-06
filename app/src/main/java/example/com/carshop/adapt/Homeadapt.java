package example.com.carshop.adapt;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import example.com.carshop.R;
import example.com.carshop.bean.HomeBean;

import java.util.List;

public class Homeadapt extends BaseAdapter {

    List<HomeBean> homeBeanList;
    Context mcontext;

    public Homeadapt(List<HomeBean> homeBeanList, Context mcontext) {
        this.homeBeanList = homeBeanList;
        this.mcontext = mcontext;
    }

    @Override
    public int getCount() {
        return homeBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView== null)
        {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.row_home,null,false);
            convertView.setTag(viewHolder);
        }else
        {
           viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    class ViewHolder
    {

    }
}
