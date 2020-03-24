package athread.room;
/********************************************************************************
 * 코드를 볼 때 가장 먼저봐야할것
 * 1. 생성자 살펴보기
 * 2. 제공되는 메소드
 * 3. 제공되는 필드
 * 4. 관련있는 추상클래스, 인터페이스 같이 생각해 보기
 ********************************************************************************/
import java.util.List;
import java.util.Vector;

public class Room {
	List<TalkServerThread> userList = new Vector<>();//단톡방에 있는 친구들만 관리하는 List이다.
	List<String> nameList = new Vector<>();//닉네임 명단관리
	String title = null;//단톡방이름
	String state = null;//대기, 단톡방이름의 상태
	int max = 0;//단톡방의 최대 정원수
	int current = 0;//현재 인원수
	
	public Room(){
		
	}
	public Room(String title, int current){
		this.title = title;
		this.current = current;
	}
	public Room(String title, int current,String state){
		this.title = title;
		this.current = current;
		this.state = state;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	
}
