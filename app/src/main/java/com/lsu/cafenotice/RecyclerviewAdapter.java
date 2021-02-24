package com.lsu.cafenotice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {
    ArrayList<Recyclerviewitem> items = new ArrayList<Recyclerviewitem>();

    private OnItemClickListener mListener = null ;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.activity_recyclerview_item, viewGroup, false);

        /*
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_layout, parent, false);

            ViewGroup.LayoutParams p = v.getLayoutParams();

            p.width = parent.getWidth() / mLayoutManager.getSpanCount();
            p.height = p.width * 3/2;

            v.setLayoutParams(p);

            return new MyViewHolder(v);
        }
        
        실험 12
         */

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Recyclerviewitem item = items.get(position);
        viewHolder.setItem(item);
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position) ;
    }

    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener ;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Recyclerviewitem item) {
        items.add(item);
    }

    public void setItems(ArrayList<Recyclerviewitem> items) {
        this.items = items;
    }

    public Recyclerviewitem getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, Recyclerviewitem item) {
        items.set(position, item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView1;
        TextView textView1;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView1 = itemView.findViewById(R.id.cafe_icon_1);
            textView1 = itemView.findViewById(R.id.cafe_name);
        }

        public void setItem(Recyclerviewitem item) {
            imageView1.setImageResource(item.getResId());
            textView1.setText(item.getName());
        }

    }

    /*
가장 큰 특징은 원본 데이터를 뷰에 직접 설정하지 않고 어댑터라는 클래스를 사용한다는 점입니다.

선택할 수 있능 여러개의 아이템이 표시된느 선택 위젯은 어댑터를 통해 각각의 아이템을 화면에 디스플레이합니다.
따라서 원본 데이터는 어댑터에 설정해야 하며 어댑터가 데이터 관리 기능을 담당합니다.
선택 위젯에 보이는 각각의 아이템이 화면에 디스플레이되기 전에 어댑터에 getView() 메서드가 호출됩니다.
이 메서드는 어댑터에서 가장 중요한 메서드로 이 메서드에서 반환하는 뷰가 하나의 아이템으로 디스플레이됩니다.
예를 들어, getView()에서 반환하는 객체가 텍스트뷰 객체라면 선택 위젯의 각 아이템은 텍스트뷰로 표시됩니다.
이 메서드의 읾은 어댑터에 따라 다를 수 있으먀 좀 더 편하게 다룰 수 있는 다른 메서드가 들어있는 경우도 있습니다.

만약 어댑터에서 만들어 반환하는 객체가 텍스트뷰나 버튼과 같은 하나의 뷰가 아니라 리니어 레이아숭처럼 여러개의 뷰들을 담고있는 컨테이너 객체라면 하나의 아이템에 여러 정보를 보여줄 수 있을것입니다.

리싸이클러뷰는 아이템이 화면에 보일 때 메모리를 효율적으로 사용하도록 캐시 메커니즘이 구현되어있다.

전달받은 뷰의 객체의 이미지나 텍스트뷰를 findViewById() 메서드로 찾아 변수에 할당하면 setItem() 메서드에서 참조할 수 있습니다.

setItem()메서드는 이 뷰 홀더에 들어있는 뷰 객체의 데이터를 다른것으로 보이도록 하는 역할을 합니다.


onBindViewHodler()메서드는 뷰홀더가 재사용될때 호출됨

격자망식으로 레이아웃을 짜고자

메인엑티비티.java에서

RecyclerView recyclerView = findViewById(R.id.recyclerView);

GridLayoutManager layoutManager = new FridLayoutManager(this, 2);
recyclerView.setLayoutManager(layoutManager);


 */

}