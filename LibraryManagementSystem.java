import java.util.*;
import java.io.*;
import DataBase.LibDB;
import myClass.DB_Element;
import myClass.Book;
import myClass.User;

/**
 * LibraryManagementSystem 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
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
     * 예제 메소드 - 이 주석을 사용자에 맞게 바꾸십시오
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public void borrowBook(String userID, String bookID)
    {
        User user = userDB.findElement(userID);
        Book book = bookDB.findElement(bookID);
        loanDB.put(user, book);
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
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
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
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
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
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
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
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