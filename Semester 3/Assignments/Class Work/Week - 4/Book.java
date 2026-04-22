public class Book { 
    String title; 
    String author; 
    double price; 
    // TODO: Default constructor 
    Book(){

    }
    Book(String t, String a,double p){
        title=t;
        author=a;
        price=p;
    }
 
    void Display(){
        System.out.println("Title : "+ title + " \n Author : "+author+ "\n Price : ");
    }
 
 public static void main(String[] args) { 
    Book book1 = new Book();
    Book book2 = new Book("Ruskin Bond Biography","Ruskin Bond",200);

    book2.Display();

 } 
} 
