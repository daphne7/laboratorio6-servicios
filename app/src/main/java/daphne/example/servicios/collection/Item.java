package daphne.example.servicios.collection;

public class Item {
    public String title;
    public String descripsion;
    public String url;
    public int id;




    public void setTitle(String title) {

        this.title = title;
    }
    public void setDescripsion(String descripsion){
        this.descripsion = descripsion;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public  void setId(int id){
        this.id = id;
    }

    public int getId(){
        return  this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getDescripsion(){
        return this.descripsion;
    }
    public String getUrl(){
        return this.url;
    }
}