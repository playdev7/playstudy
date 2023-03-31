import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class HelloWorldGUIApp {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Java Application Title");  // JFrame 에 대한 frame 인스턴스 생성.
				// "Java Application Title" 이 인수로 전달 되어 새로운 윈도에 타이틀이 됨.
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setPreferredSize(new Dimension(800, 300));  // Dimension 객체 기반의 사이즈 조절 인스턴스 생성.
				// (너비, 높이) 파라미터가 되어있음. 따라서 너비-800, 높이-300의 인수가 전달 됨.
				JLabel label = new JLabel("VC++ 이후로 처음 만들어보는 GUI 앱!", SwingConstants.CENTER); // JLabel 기반의 label 인스턴스 생성.
				// SwingConstants 속성의 값으로 Center 지정. -> label 인스턴스의 텍스트를 중앙으로 배치.
				frame.getContentPane().add(label);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setLocation(dim.width/2-400/2, dim.height/2-300/2);
				
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
}