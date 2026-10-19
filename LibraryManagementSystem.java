import java.util.*;
import java.io.*;
import DataBase.LibDB;
import myClass.DB_Element;
import myClass.Book;
import myClass.User;

/**
 * LibraryManagementSystem 도서관 관리 시스템에 대한 클래스
 *
 * @author (2023320018_김현중, 2023320030_권종빈, 2023320035_윤효준)
 * @version (2026.10.18)
 */
public class LibraryManagementSystem
{
    LibDB<Book> bookDB;
    LibDB<User> userDB;
    HashMap<User, Book> loanDB;

    /**
     * LibraryManagementSystem 클래스의 객체 생성자
     */
    public LibraryManagementSystem()
    {
        bookDB = new LibDB<Book>();
        userDB = new LibDB<User>();
        loanDB = new HashMap<User, Book>();
    }

    /**
     * 학번과 책 등록번호로 이용자와 책을 찾아 대출DB에 저장하는 메소드
     *
     * @param userID 학번
     * @param bookID 책 등록번호
     */
    public void borrowBook(String userID, String bookID)
    {
        User user = userDB.findElement(userID);
        Book book = bookDB.findElement(bookID);
        loanDB.put(user, book);
    }

    /**
     * 전달받은 DB에 저장된 모든 요소를 출력하는 메소드
     *
     * @param db 출력할 DB
     */
    public <T extends DB_Element> void printDB(LibDB<T> db)
    {
        if(db == userDB){
            System.out.println("----- 이용자 목록 출력 -----");
        }
        else{
            System.out.println();
            System.out.println("----- 책 목록 출력 -----");
        }
        db.printAllElements();
    }

    /**
     * 대출DB에 저장된 대출 현황을 출력하는 메소드
     */
    public void printLoanList()
    {
        System.out.println();
        System.out.println("----- 대출 현황 -----");

        Iterator<User> it = loanDB.keySet().iterator();
        while(it.hasNext()){
            User user = it.next();
            Book book = loanDB.get(user);
            System.out.println(user + " ===> " + book);
        }
        System.out.println("--------------------");
    }

    /**
     * 책 파일을 읽어서 책DB에 저장하고 리턴해주는 메소드
     *
     * @param bookFile 책 데이터가 저장된 파일
     * @return bookDB 책DB
     */
    public LibDB<Book> setBookDB(String bookFile)
    {
        try{
            Scanner scanner = new Scanner(new FileReader(new File(bookFile)));

            while(scanner.hasNext()){
                String line = scanner.nextLine();
                StringTokenizer st = new StringTokenizer(line, "/");

                if(st.hasMoreTokens() == false){
                    continue;
                }

                String bookID = st.nextToken();
                String title = st.nextToken();
                String author = st.nextToken();
                String publisher = st.nextToken();
                int year = Integer.parseInt(st.nextToken());

                bookDB.addElement(new Book(author, bookID, publisher, title, year));
            }
            scanner.close();
        }
        catch(FileNotFoundException e){
            System.out.println("파일을 찾을 수 없습니다!");
        }
        return bookDB;
    }

    /**
     * 이용자 파일을 읽어서 이용자DB에 저장하고 리턴해주는 메소드
     *
     * @param userFile 이용자 데이터가 저장된 파일
     * @return userDB 이용자DB
     */
    public LibDB<User> setUserDB(String userFile)
    { 
        try{
            Scanner scanner = new Scanner(new FileReader(new File(userFile)));

            while(scanner.hasNext()){
                String line = scanner.nextLine();
                StringTokenizer st = new StringTokenizer(line, "/");

                if(st.hasMoreTokens() == false){
                    continue;
                }

                int stID = Integer.parseInt(st.nextToken());
                String name = st.nextToken();

                userDB.addElement(new User(stID, name));
            }
            scanner.close();
        }
        catch(FileNotFoundException e){
            System.out.println("파일을 찾을 수 없습니다!");
        }
        return userDB;
    }
}