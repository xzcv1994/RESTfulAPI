package rest_api.member.vo;

public class MemberVO {
    private String id;
    private String name;

    public MemberVO (String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId(){
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}