package athread.room;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

//Login처리는 LoginForm에서 진행되므로 TalkClientVer2에서 생성하면 될것이다.
public class TalkClientVer2 extends JFrame {
	JTabbedPane 		jtp 	= new JTabbedPane();
//	JPanel 				wr 		= new JPanel();//waitroom.java
	WaitRoom			wr		= new WaitRoom(this);
//	JPanel 				mr 		= new JPanel();//MessageRoom.java
	MessageRoom			mr 		= new MessageRoom(this);
	SettingRoom			sr 		= new SettingRoom(this);
	Socket				mySocket = null;
	ObjectInputStream	ois 	= null;
	ObjectOutputStream 	oos 	= null;
	final static String _IP   	= "127.0.0.1";
	final static int 	_PORT 	= 5001;//0~65575사이에 포트사용사을
	//대화명을 담는 변수
	String				nickName = null;
	LoginForm 			lf 		= null;
	public TalkClientVer2() {
	}
	public TalkClientVer2(LoginForm lf) {
		this.lf = lf;
		nickName  = lf.nickName;//로그인 화면에에서 결정된 대화명으로 동기화
		initDisplay();
		//화면처리 후 서버 소켓 연결하기
		connect_process();
	}
	private void connect_process() {
		this.setTitle(nickName+"님의 대화창");
	try {
		mySocket = new Socket(_IP,_PORT);
		oos = new ObjectOutputStream(mySocket.getOutputStream());
		ois = new ObjectInputStream(mySocket.getInputStream());
		oos.writeObject(Protocol.WAIT+"#"+nickName+"#"+"대기");
		//말하고 듣기
		//내가 한 말도 서버를 경유하야 듣는다.(run)-꼭기억할것
		TalkClientThread tct = new TalkClientThread(this);
		tct.start();
				
	} catch (Exception e) {
		// TODO: handle exception
	}	
	}
	public void initDisplay() {
		this.getContentPane().setLayout(null);
		jtp.addTab("대기실", wr);
		jtp.addTab("단톡방", mr);
		jtp.addTab("설정", sr);
		this.getContentPane().setBackground(new Color(158,217,164));
		jtp.setBounds(5, 4, 620, 530);
		this.getContentPane().add(jtp);
		this.setSize(650,580);
		this.setVisible(true);
		jtp.setSelectedIndex(0);//선택된 탭이 1번이 됨. 대기실을 먼저 열고싶으면 0을 넣어주기
	}
	public static void main(String[] args) {
		TalkClientVer2 tc = new TalkClientVer2(new LoginForm());
	}
}
