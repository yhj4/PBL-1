
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
    public static void main(String[] args)
    {
        LibraryManagementSystem libMS =
            new LibraryManagementSystem();

        System.out.println("----- 이용자 목록 출력 -----");

        LibDB<User> userDB =
            libMS.setUserDB("C:\\Temp\\UserData2025.txt");

        libMS.printDB(userDB);

        System.out.println("----- 도서 목록 출력 -----");

        LibDB<Book> bookDB =
            libMS.setBookDB("C:\\Temp\\BookData2025.txt");

        libMS.printDB(bookDB);

        System.out.println("----- 도서 대출 처리 -----");

        libMS.borrowBook("2025320001", "B02");
        libMS.borrowBook("2024320002", "B03");
        libMS.borrowBook("2023320003", "B04");

        System.out.println("----- 대출 목록 출력 -----");

        libMS.printLoanList();
    }
}
