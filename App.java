import java.util.*;
import java.io.*;
import DataBase.LibDB;
import myClass.DB_Element;
import myClass.User;
import myClass.Book;

/**
 * App 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
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
    }
}