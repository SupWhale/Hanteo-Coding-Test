import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Category Category1 = new Category("Man", "남성", "", "Exo, BTS", "Category");
        Category Category2 = new Category("Exo", "엑소", "Man", "1,2,3,4", "Category");
        Category Category3 = new Category("1", "공지사항", "Exo", "", "Board");
        Category Category4 = new Category("2", "첸", "Exo", "", "Board");
        Category Category5 = new Category("3", "백현", "Exo", "", "Board");
        Category Category6 = new Category("4", "시우민", "Exo", "", "Board");

        Category Category7 = new Category("BTS", "방탄소년단", "Man", "5,6,7", "Category");
        Category Category8 = new Category("5", "공지사항", "BTS", "", "Board");
        Category Category9 = new Category("6", "익명게시판", "BTS, BlackPink", "", "Board");
        Category Category10 = new Category("7", "뷔", "BTS", "", "Board");

        Category Category11 = new Category("Woman", "여성", "", "BlackPink", "Category");
        Category Category12 = new Category("BlackPink", "블랙핑크", "Woman", "8,9,6", "Category");
        Category Category13 = new Category("8", "공지사항", "BlackPink", "", "Board");
        Category Category14 = new Category("9", "로제", "BlackPink", "", "Board");

        List<Category> CategoryList = new ArrayList<>();

        CategoryList.add(Category1);
        CategoryList.add(Category2);
        CategoryList.add(Category3);
        CategoryList.add(Category4);
        CategoryList.add(Category5);
        CategoryList.add(Category6);
        CategoryList.add(Category7);
        CategoryList.add(Category8);
        CategoryList.add(Category9);
        CategoryList.add(Category10);
        CategoryList.add(Category11);
        CategoryList.add(Category12);
        CategoryList.add(Category13);
        CategoryList.add(Category14);


        Category_Manage CateMa = new Category_Manage();
        Category target = CateMa.Search_category(CategoryList, "Woman");
        JSONObject result = new JSONObject();
        JSONObject result2 = new JSONObject() ;
        JSONObject result3 = new JSONObject() ;
        result2.put("카테고리",CateMa.Category_Path(CategoryList, target, result));
        result3.put("카테고리",CateMa.AllCategory_Path(CategoryList, result));
        System.out.print(result3);



    }
}
