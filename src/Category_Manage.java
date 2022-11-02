import org.json.simple.*;

import java.util.List;

public class Category_Manage {

    //ID 혹은 카테고리 이름을 매개변수로 받아 카테고리를 검색해오는 메소드입니다.
    public Category Search_category(List<Category> CategoryList, String keyword){
        Category result = null;
        //List에 담겨진 카테고리들을 하나씩 꺼내어 진행합니다.
        for(Category Cate:CategoryList) {
            //매개변수와 일치한 ID나 카데고리 명이 있다면
            if (keyword.equals(Cate.getID()) || keyword.equals(Cate.getTitle())) {
                //null 이었던 result를 다시 Category로 재생성 시켜줍니다.
                result = new Category(Cate.getID(), Cate.getTitle(), Cate.getParent_idx()
                        , Cate.getChild_id(), Cate.getKind_of());
            }
        }
        return result;
    }

    //지정된 카테고리내의 모든 하위 카테고리들을 재귀적으로 접근하여 json 계층을 도출하는 메소드입니다.
    public JSONObject Category_Path(List<Category> CategoryList, Category Current, JSONObject result){
        JSONArray CateArray = new JSONArray();
        //List에 담겨진 카테고리들을 하나씩 꺼내어 진행합니다.
        for(Category Cate:CategoryList){
            //현재 위치한 카테고리의 자식 ID 목록 중에서 일치하는 하위 카테고리가 있고 더 내려갈 수 있는 카테고리(자식 목록이 있는 카테고리)인가
            if(Current.getChild_id().contains(Cate.getID()) && !Cate.getChild_id().equals("")) {
                //부모 카테고리와 자식 카테고리 둘 다 있는 카테고리의 처리를 위한 분기입니다.
                JSONObject Category_Info = new JSONObject();
                Category_Info.put("카테고리 ID", Cate.getID());
                Category_Info.put("카테고리명", Cate.getTitle());
                Category_Info.put("부모 카테고리", Cate.getParent_idx());
                Category_Info.put("자식 카테고리", Cate.getChild_id());
                Category_Info.put("종류", Cate.getKind_of());
                //현재 위치한 카테고리의 json 배열에 추가합니다.
                CateArray.add(Category_Info);
                //수정된 json 배열을 최종 반환할 result에 추가합니다.
                result.put(Current.getTitle(),CateArray);
                Category_Path(CategoryList, Cate, Category_Info); //자식 카테고리의 하위 카테고리를 찾기 위해 재귀합니다.
            }
            //현재 카테고리의 자식목록에 포함된 카테고리이고 자식 카테고리 ID 목록이 없는 카테고리인가
            else if(Current.getChild_id().contains(Cate.getID()) && Cate.getChild_id().equals("")){
                //최하위 카테고리들을 처리하기 위한 분기입니다.
                JSONObject Category_Info = new JSONObject();
                Category_Info.put("카테고리 ID", Cate.getID());
                Category_Info.put("카테고리명", Cate.getTitle());
                Category_Info.put("부모 카테고리", Cate.getParent_idx());
                Category_Info.put("자식 카테고리", Cate.getChild_id());
                Category_Info.put("종류", Cate.getKind_of());
                //현재 위치한 카테고리의 json 배열에 추가합니다.
                CateArray.add(Category_Info);
                //수정된 json 배열을 최종 반환할 result에 추가합니다.
                result.put(Current.getTitle(),CateArray);
            }
        }

        return result;
    }

    //모든 자료구조를 json 형태로 변환하기 위한 메소드입니다.
    public JSONObject AllCategory_Path(List<Category> CategoryList, JSONObject result){
        JSONArray CateArray = new JSONArray();
        //List에 담겨진 카테고리들을 하나씩 꺼내어 진행합니다.
        for(Category Cate:CategoryList){
            //부모 카테고리가 없으며 자식 카테고리가 반드시 있다면
            if(Cate.getParent_idx().equals("") && !Cate.getChild_id().equals("")) {
                //최상위 카테고리(ex 남성, 여성)의 처리를 위한 분기입니다.
                JSONObject Category_Info = new JSONObject();
                Category_Info.put("카테고리 ID", Cate.getID());
                Category_Info.put("카테고리명", Cate.getTitle());
                Category_Info.put("부모 카테고리", Cate.getParent_idx());
                Category_Info.put("자식 카테고리", Cate.getChild_id());
                Category_Info.put("종류", Cate.getKind_of());
                //현재 위치한 카테고리의 json 배열에 추가합니다.
                CateArray.add(Category_Info);
                //수정된 json 배열을 최종 반환할 result에 추가합니다.
                result.put(Cate.getTitle(), CateArray);
                //하위 카테고리도 처리하기 위해 Category_Path 메소드를 호출합니다.
                Category_Path(CategoryList, Cate, Category_Info);
            }
            //최상위 카테고리가 없거나 아니라면 반복문을 종료시킵니다.
            else{
                return result;
           }
        }

        return result;
    }




}
