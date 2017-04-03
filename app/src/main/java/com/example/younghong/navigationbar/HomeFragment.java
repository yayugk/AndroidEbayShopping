package com.example.younghong.navigationbar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        Button btn1 = (Button) v.findViewById(R.id.btn1);
        Button btn2 = (Button) v.findViewById(R.id.btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn1:

                Toast.makeText(getActivity(), "Button 1 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn2:
                Toast.makeText(getActivity(), "Button 2 clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
//    private ViewStub stubGrid;
//    private ViewStub stubList;
//    private ListView listView;
//    private GridView gridView;
//    private View mylistview;
//    private View mygridview;
//    private ListViewAdapter listViewAdapter;
//    private GridViewAdapter gridViewAdapter;
//    private List<Product> productList;
//    private int currentViewMode = 1;
//
//    static final int VIEW_MODE_LISTVIEW = 0;
//    static final int VIEW_MODE_GRIDVIEW = 1;
//
//    public static HomeFragment newInstance()
//    {
//        HomeFragment HomeFragment=new HomeFragment();
//        return HomeFragment;
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        View stubView = inflater.inflate(R.layout.fragment_home, null);
//
//        stubList = (ViewStub) stubView.findViewById(R.id.stub_list);
//        stubGrid = (ViewStub) stubView.findViewById(R.id.stub_grid);
//
//        //Inflate ViewStub before get view
//        stubList.inflate();
//        stubGrid.inflate();
//
//        mylistview = inflater.inflate(R.layout.my_listview, null);
//        mygridview = inflater.inflate(R.layout.my_gridview, null);
//
//        listView = (ListView) mylistview.findViewById(R.id.mylistview);
//        gridView = (GridView) mygridview.findViewById(R.id.mygridview);
//
//        //get list of product
//        getProductList();
//
//        //Get current view mode in share reference
//        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("ViewMode", MODE_PRIVATE);
//        currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_LISTVIEW);//Default is view listview
//        //Register item lick
//        listView.setOnItemClickListener(onItemClick);
//        gridView.setOnItemClickListener(onItemClick);
//
//        switchView();
//
////        if (VIEW_MODE_LISTVIEW == currentViewMode) {
////            return mylistview;
////        }
////        else{
////            return mygridview;
////        }
//        return mylistview;
//    }
//
//    private void switchView() {
//
//        if (VIEW_MODE_LISTVIEW == currentViewMode) {
//            //Display listview
//            stubList.setVisibility(View.VISIBLE);
//            //Hide gridview
//            stubGrid.setVisibility(View.GONE);
//        } else {
//            //Hide listview
//            stubList.setVisibility(View.GONE);
//            //Display gridview
//            stubGrid.setVisibility(View.VISIBLE);
//        }
//
//        setAdapters();
//    }
//
//    private void setAdapters() {
//        if (VIEW_MODE_LISTVIEW == currentViewMode) {
//            listViewAdapter = new ListViewAdapter(getActivity(), R.layout.list_item, productList);
//            listView.setAdapter(listViewAdapter);
//        } else {
//            gridViewAdapter = new GridViewAdapter(getActivity(), R.layout.grid_item, productList);
//            gridView.setAdapter(gridViewAdapter);
//        }
//    }
//
//    public List<Product> getProductList() {
//        //pseudo code to get product, replace your code to get real product here
//        productList = new ArrayList<>();
//        productList.add(new Product(R.drawable.icon_android, "Title 1", "This is description 1"));
//        productList.add(new Product(R.drawable.icon_android, "Title 2", "This is description 2"));
//        productList.add(new Product(R.drawable.icon_android, "Title 3", "This is description 3"));
//        productList.add(new Product(R.drawable.icon_android, "Title 4", "This is description 4"));
//        productList.add(new Product(R.drawable.icon_android, "Title 5", "This is description 5"));
//        productList.add(new Product(R.drawable.icon_android, "Title 6", "This is description 6"));
//        productList.add(new Product(R.drawable.icon_android, "Title 7", "This is description 7"));
//        productList.add(new Product(R.drawable.icon_android, "Title 8", "This is description 8"));
//        productList.add(new Product(R.drawable.icon_android, "Title 9", "This is description 9"));
//        productList.add(new Product(R.drawable.icon_android, "Title 10", "This is description 10"));
//
//        return productList;
//    }
//
//    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            //Do any thing when user click to item
//            Toast.makeText(getActivity(), productList.get(position).getTitle() + " - " + productList.get(position).getDescription(), Toast.LENGTH_SHORT).show();
//        }
//    };
//
//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.main, menu);
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.item_menu_1:
//                if (VIEW_MODE_LISTVIEW == currentViewMode) {
//                    currentViewMode = VIEW_MODE_GRIDVIEW;
//                } else {
//                    currentViewMode = VIEW_MODE_LISTVIEW;
//                }
//                //Switch view
//                switchView();
//                //Save view mode in share reference
//                SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("ViewMode", MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putInt("currentViewMode", currentViewMode);
//                editor.commit();
//
//                break;
//        }
//        return true;
//    }

