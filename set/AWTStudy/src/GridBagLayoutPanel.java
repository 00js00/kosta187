import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;

public class GridBagLayoutPanel extends Panel {
	Button button1, button2, button3;
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstrains;
	
	public GridBagLayoutPanel() {
		button1 = new Button("Button1");
		button2 = new Button("Button2");
		button3 = new Button("Button3");
		gridBagLayout = new GridBagLayout();
		gridBagConstrains = new GridBagConstraints();	
	}
	
	public void setContents() {
		setLayout(gridBagLayout);

//		gridBagConstrains.gridx = 0;
//		gridBagConstrains.gridy = 0;
////		격자가 붙을 때마다 격자가 자동생성됨 : 붙이면서 격자를 자동생성 
//		gridBagConstrains.gridheight = 1;
//		gridBagConstrains.gridwidth = 1;
//		gridBagConstrains.weightx = 0; //가중치
//		gridBagConstrains.weighty = 0; //가중치
//		gridBagLayout.setConstraints(button1, gridBagConstrains);
//		add(button1);
//		
//		setLayout(gridBagLayout);
//		gridBagConstrains.gridx = 1;
//		gridBagConstrains.gridy = 0;
////		격자가 붙을 때마다 격자가 자동생성됨 : 붙이면서 격자를 자동생성 
//		gridBagConstrains.gridheight = 1;
//		gridBagConstrains.gridwidth = 1;
//		gridBagConstrains.weightx = 1; //가중치 1/(1+0) --> 오른쪽에 붙어있음
//		gridBagConstrains.weighty = 1; //가중치
//		gridBagConstrains.fill = GridBagConstraints.HORIZONTAL; // 격자가 커지면 안에있는애가 커지는지, 여백이 커지는지 지정
//		gridBagConstrains.insets = new Insets(5, 5, 5, 5);
//		gridBagLayout.setConstraints(button2, gridBagConstrains);
//		add(button2);
		add(button1,0,0,1,1,0,0);
		add(button2,1,0,1,1,1,0);
		add(button3,0,1,2,1,1,1);
//		
	}
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty) {

		gridBagConstrains.gridx = gridx;// 몇개의 격자를 차지할것인가
		gridBagConstrains.gridy = gridy;// 몇개의 격자를 차지할것인가 // 붙이면서 격자를 늘려가는것
		gridBagConstrains.gridheight = gridheight;
		gridBagConstrains.gridwidth = gridwidth;
		gridBagConstrains.weightx = weightx; 
		gridBagConstrains.weighty = weighty; 
		gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
//		gridBagConstrains.insets = new Insets(5, 5, 5, 5);
		
		gridBagLayout.setConstraints(component, gridBagConstrains);
		add(component);
		
	}
	

	public static void main(String[] args) {
		Frame frame = new Frame("GridLayout Example");
		
		GridBagLayoutPanel panel = new GridBagLayoutPanel()	;

		
		
		panel.setContents();
		frame.add(panel);
		
//		frame.setSize(400,400);
//		frame.pack();// 버튼 안에 딱 넣어줌
		frame.setVisible(true);
		
	}
}
