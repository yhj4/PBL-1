import java.util.*;
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
        LibDB<User> userDB = new LibDB<User>();
        LibDB<Book> bookDb = new LibDB<Book>();
        
        User user1 = new User (2025320001, "Kim");
        User user2 = new User (2024320002, "Lee");
        User user3 = new User (2023320003, "Park");
        
        userDB.addElement(user1);
        userDB.addElement(user2);
        userDB.addElement(user3);
        
    }
}