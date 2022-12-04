package com.example.javaapi;

@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "watch")
class Watch {
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private long id;
    private String name;
    private Integer price;

    Watch() {
    }

    Watch(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String toString() {
        return "Watch [id=" + id + ", name=" + name + "]";
    }
}