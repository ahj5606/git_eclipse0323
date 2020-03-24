package athread.room;

import java.awt.Color;

import javax.swing.JPanel;

public class SettingRoom extends JPanel {
	TalkClientVer2 tc = null;
	public SettingRoom(TalkClientVer2 tc) {
		this.tc = tc;
		initDisplay();
	}

	public void initDisplay() {
		this.setBackground(new Color(255,204,000));
	}
}

