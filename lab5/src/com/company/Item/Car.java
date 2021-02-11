package com.Item;

public class Car implements IItem {
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
    private Engine engine;
    private Accessory accessory;
    private Body body;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Accessory getAccessory() {
        return accessory;
    }

    public void setAccessory(Accessory accessory) {
        this.accessory = accessory;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
