package com.Item;

public class Body implements IItem {
    private String id;
    public void setId(String id){
        this.id = id;
    }
    private String Titel;
    public  void setTitel(String Titel){
        this.Titel = Titel;
    }
    public String getId(){
        return id;
    }
    public String getTitel(){
        return Titel;
    }
    public Body(String _id, String _Titel)
    {
        id = _id;
        Titel = _Titel;
    }
}
