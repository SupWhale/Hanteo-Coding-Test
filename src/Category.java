
public class Category {
    String ID;          //카테고리 ID
    String Title;       //카테고리 이름
    String parent_idx;  //부모 카테고리 ID
    String child_id;    //자식 카테고리 ID
    String kind_of;     //카테고리, 게시판 구분

    
    //Category의 생성자
    public Category(String ID, String title, String parent_idx, String child_id, String kind_of) {
        this.ID = ID;
        Title = title;
        this.parent_idx = parent_idx;
        this.child_id = child_id;
        this.kind_of = kind_of;
    }

    
    //객체 Category의 요소 접근을 위한 메소드
    public String getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public String getParent_idx() {
        return parent_idx;
    }

    public String getChild_id() {
        return child_id;
    }
    public String getKind_of() {
        return kind_of;
    }



}
