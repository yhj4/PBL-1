package DataBase;
import java.util.*;
import myClass.DB_Element;

/**
 * LibDB 책DB와 이용자DB로 사용되는 Generic크래스
 *
 * @author (2023320018_김현중, 2023320030_권종빈, 2023320035_윤효준)
 * @version (2026.10.18)
 */
public class LibDB<T extends DB_Element>
{
    private ArrayList<T> db;

    /**
     * LibDB 클래스의 객체 생성자
     * 
     */
    public LibDB()
    {
        db = new ArrayList<T>();
    }

    /**
     * 데이터베이스에 요소를 1개 추가하는 메소드
     *
     * @param element 요소
     */
    public void addElement(T element)
    {
        db.add(element);
    }

    /**
     * 데이터베이스에 저장된 요소를 id로 찾아서 리턴해주는 메소드
     *
     * @param id 찾으려는 요소의ID
     * @return 찾은 요소
     */
    public T findElement(String id)
    {
        Iterator<T> it = db.iterator();
        while(it.hasNext()){
            T element = it.next();
            if(element.getID().equals(id)){
                return element;
            }
        }
        return null;
    }

    /**
     * 데이터베이스에 저장된 모든 요소를 출력하는 메소드
     */
    public void printAllElements()
    {
        for(T element : db){
            System.out.println(element);
        }
    }
}