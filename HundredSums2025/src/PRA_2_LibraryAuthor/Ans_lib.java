package PRA_2_LibraryAuthor;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Ans_lib {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Author> authorList = new ArrayList<Author>();

        for(int i = 0; i<n; i++){
            Author a = new Author();
            a.setAuthorId(sc.nextInt());sc.nextLine();
            a.setAuthName(sc.nextLine());
            a.setNationality(sc.nextLine());
            int num = sc.nextInt();sc.nextLine();
            ArrayList<Book> BookList = new ArrayList<Book>();
            for(int j = 0; j<num; j++){
                Book b = new Book();
                b.setBookId(sc.nextInt());sc.nextLine();
                b.setTitle(sc.nextLine());
                b.setPubYear(sc.nextInt());sc.nextLine();
                BookList.add(b);
            }
            a.setBookList(BookList);
            authorList.add(a);
        }

        int authorToFind = sc.nextInt();sc.nextLine();
        String nationalityToFind = sc.nextLine();
        LiService lis = new LiService();
        try{
            ArrayList<Integer> uniYear = lis.getUniquePublishedYear(authorList, authorToFind);
            if(uniYear.isEmpty()){
                System.out.println("Author Not Found");
        
            }
            else{
                for(int i: uniYear){
                    System.out.println(i);
                }
            }
            ArrayList<String> natBk = lis.getBooksByNationality(authorList, nationalityToFind);
            if(natBk.isEmpty()){
                System.out.println("Books Not Found");
            }
            else{
                for(String s: natBk){
                    System.out.println(s);
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        sc.close();


    }
    
}
class LiService{
    LiService(){};

    ArrayList<Integer> getUniquePublishedYear(ArrayList<Author> authorList, int author ){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(Author a: authorList){
            if(a.getAuthorId()==author){
                ArrayList<Book> bl = a.getBookList();
                for(Book b: bl){
                    if(!ans.contains(b.getPubYear())){
                        ans.add(b.getPubYear());
                    }
                }
                
            }
            Collections.sort(ans);
                return ans;
        }

        return ans;

    }
    ArrayList<String> getBooksByNationality(ArrayList<Author> authorList, String nationalityToFind){
        ArrayList<String> bkTitles = new ArrayList<String>();
        for(Author a: authorList){
            if(a.getNationality().equalsIgnoreCase(nationalityToFind)){
                ArrayList<Book> bl = a.getBookList();
                for(Book b: bl){
                    bkTitles.add(b.getTitle());
                }
            }
        }
        return bkTitles;

    }

}
class custException extends Exception{
    public custException(String s){
        super(s);
    }
}
class Author{
    int authorId;
    String authName;
    String nationality;
    ArrayList<Book> bookList;

    public int getAuthorId() {
        return authorId;
    }
    public void setAuthorId(int author) {
        this.authorId = author;
    }
    public String getAuthName() {
        return authName;
    }
    public void setAuthName(String authName) {
        this.authName = authName;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public ArrayList<Book> getBookList() {
        return bookList;
    }
    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

}
class Book{
    int bookId;
    String title;
    int pubYear;
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPubYear() {
        return pubYear;
    }
    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }
    }
