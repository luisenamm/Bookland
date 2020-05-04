package com.itesm.bookland;

//CLASE BASADA EN EJEMPLO SQL DE PROFESOR CARRILLO LLAMADA USER
public class Book {
    private String imageUrl,
            title,
            author,
            editorial,
            description,
            price;

    public Book(String imageUrl,String title,String author,String editorial,String description,String price){
        this.imageUrl=imageUrl;
        this.title=title;
        this.author=author;
        this.editorial=editorial;
        this.description=description;
        this.price=price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}