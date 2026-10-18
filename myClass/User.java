package myClass;
/**
 * User 이용자에 대한 클래스
 *
 * @author (2023320018_김현중, 2023320030_권종빈, 2023320035_윤효준)
 * @version (2026.10.18)
 */
public class User extends DB_Element
{
    private String name;
    private Integer stID;

    /**
     * User 클래스의 객체 생성자
     * 
     * @param stID 학번
     * @param name 이름
     */
    public User(Integer stID, String name)
    {
        this.stID = stID;
        this.name = name;
    }

    /**
     * 학번을 문자열로 만들어서 리턴해주는 메소드
     *
     * @return 문자열로 변환한 학번
     */
    public String getID()
    {
        return stID.toString();
    }

    /**
     * 이용자 정보를 [학번] 이름 형태로 리턴해주는 메소드
     *
     * @return [학번] 이름
     */
    public String toString()
    {
        return "[" + stID + "] " + name;
    }
}