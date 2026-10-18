package myClass;
/**
 * Book 책에 대한 클래스
 *
 * @author (2023320018_김현중, 2023320030_권종빈, 2023320035_윤효준)
 * @version (2026.10.18)
 */
public class Book extends DB_Element
{
    private String author;
    private String bookID;
    private String publisher;
    private String title;
    private int year;

    /**
     * Book 클래스의 객체 생성자
     * 
     * @param author 저자
     * @param bookID 책 등록번호
     * @param publisher 출판사
     * @param title 제목
     * @param year 출판년도
     */
    public Book(String author, String bookID, String publisher, String title, int year)
    {
        this.author = author;
        this.bookID = bookID;
        this.publisher = publisher;
        this.title = title;
        this.year = year;
    }

    /**
     * 책 등록번호를 리턴해주는 메소드
     *
     * @return 책 등록번호
     */
    public String getID()
    {
        return bookID;
    }

    /**
     * 책 정보를 (책 등록번호) 제목, 저자, 출판사, 출판년도 형태로 리턴해주는 메소드
     *
     * @return (책 등록번호) 제목, 저자, 출판사, 출판년도
     */
    public String toString()
    {
        return "(" + bookID + ")" + " " + title + ", " + author + ", " + publisher + ", " + year;
    }
}