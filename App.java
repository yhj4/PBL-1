import java.util.*;
import java.io.*;
import DataBase.LibDB;
import myClass.DB_Element;
import myClass.User;
import myClass.Book;

/**
 * App 도서관 관리 시스템을 실행하는 클래스
 *
 * @author (2023320018_김현중, 2023320030_권종빈, 2023320035_윤효준)
 * @version (2026.10.18)
 */
public class App
{
    public static void main(String[] args){

        System.out.println("----- 이용자 목록 출력 -----");
        LibDB<User> userDB = new LibDB<User>();
        LibDB<Book> bookDb = new LibDB<Book>();

        FileReader fin = null;
        try{
            fin = new FileReader("C://Temp//UserData2025.txt");
            int c;
            while((c = fin.read()) != -1){
                System.out.print((char)c);
            }
            fin.close();
        }
        catch(IOException e){
            System.out.println("입출력 오류");
        }

        LibraryManagementSystem libMS = new LibraryManagementSystem();
        LibDB<User> userDB = libMS.setUserDB("c:\\Temp\\UserData2025.txt");
        libMS.printDB(userDB);
        LibDB<Book> bookDB = libMS.setBookDB("c:\\Temp\\BookData2025.txt");
        libMS.printDB(bookDB);

        libMS.borrowBook("2025320001", "B02");
        libMS.borrowBook("2024320002", "B03");
        libMS.borrowBook("2023320003", "B04");

        libMS.printLoanList();
    }
}