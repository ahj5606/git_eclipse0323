package athread.room;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class WaitRoom extends JPanel implements MouseListener, ActionListener {
	TalkClientVer2 		tc 				= null;
	JPanel				jp_first 		= new JPanel();//대기모드처리
	JPanel				jp_second 		= new JPanel();//단톡정보처리
	JPanel				jp_second_north = new JPanel();
	JButton				jbtn_open 		= new JButton("방생성");
	JButton				jbtn_in			= new JButton("입장하기");
	JButton				jbtn_exit 		= new JButton("나가기");
	JButton				jbtn_quit 		= new JButton("종료");
	String				wait_cols[]		= {"닉네임","위치"};
	String				room_cols[]		= {"단톡방명","현재인원"};
	String 				wait_data[][] 	= new String[5][2];
	String 				room_data[][] 	= new String[5][2];
	DefaultTableModel	dtm_wait 		= new DefaultTableModel(wait_data,wait_cols);
	DefaultTableModel	dtm_room 		= new DefaultTableModel(room_data,room_cols);
	JTable				jtb_wait 		= new JTable(dtm_wait);
	JTable				jtb_room 		= new JTable(dtm_room);
	JScrollPane			jsp_wait 		= new JScrollPane(jtb_wait);
	JScrollPane			jsp_room 		= new JScrollPane(jtb_room);
	JTableHeader		jth_wait		= jtb_wait.getTableHeader();
	JTableHeader		jth_room		= jtb_room.getTableHeader();
	JLabel				jlb_banner		= new JLabel();
	
	public WaitRoom(TalkClientVer2 tc) {
		this.tc = tc;
		initDisplay();
	}

	public void initDisplay() {
		jbtn_in.addActionListener(this);
		jtb_room.addMouseListener(this);
		this.setLayout(new GridLayout(1,2));
		jth_wait.setBackground(new Color(000,051,051));		
		jth_wait.setForeground(Color.white);		
		jtb_wait.setSelectionBackground(Color.LIGHT_GRAY);
		jth_room.setBackground(new Color(000,051,051));		
		jth_room.setForeground(Color.white);		
		jtb_wait.setGridColor(Color.green);
		jtb_room.setGridColor(new Color(255,102,255));
		jth_wait.setReorderingAllowed(false);//테이블헤더 위치변경 꺼두기
		jth_room.setReorderingAllowed(false);//테이블헤더 위치변경 꺼두기
		jp_first.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		jp_second.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		jp_first.setBackground(new Color(255,102,153));
		jp_second.setBackground(new Color(102,255,204));
		jp_first.setLayout(new BorderLayout());
		jp_second.setLayout(new BorderLayout());
		jp_second_north.setLayout(new GridLayout(2,2));
		jp_first.add(jsp_wait);
		jp_second.add("Center",jsp_room);
		jp_second_north.add(jbtn_open);
		jp_second_north.add(jbtn_in);
		jp_second_north.add(jbtn_exit);
		jp_second_north.add(jbtn_quit);
		jp_second.add("South",jp_second_north);
		jlb_banner.setBorder(BorderFactory.createEmptyBorder());
		jlb_banner.setIcon(new ImageIcon("src\\athread\\room\\etest.gif"));
		jp_second.add("North",jlb_banner);
		this.add(jp_first);
		this.add(jp_second);
		this.setBackground(new Color(204,153,255));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==jtb_room) {
			JOptionPane.showMessageDialog(tc, "mousePressed");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(jbtn_in==obj) {
			tc.jtp.setSelectedIndex(1);
		}
		
	}
}
