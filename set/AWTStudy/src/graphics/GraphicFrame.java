package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

public class GraphicFrame extends Frame {
	private Font font1, font2, font3;
	private Image image, image2; // 추상클래스 
	private String path = "classes/resource/test.png";
	private URL url;
	public GraphicFrame() {
		image= Toolkit.getDefaultToolkit().getImage(path);
		try {
		url = new URL("https://www.google.co.kr/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
		}catch(MalformedURLException e){
			e.printStackTrace();
		}
		
		image2= Toolkit.getDefaultToolkit().getImage(url);
	}
	/*
	 * 모든 컴포넌트가 처음 화면에 보여질 때, 리사이징될 때,
	 * 활성화/비활성화 될 때 JVM에 자동으로 호출되는 그래픽 처리 콜백메소드
	 * (java.awt.Component 클래스에 정의)로 사용자가 그래픽을 처리하고자 
	 * 할 경우 paint(Graphics g)를 오버라이딩 한다.
	 * 인자로 주어지는 Graphics는 그래픽 처리에 필요한 도구 제공(붓 역할)
	 */
	@Override
	public void paint(Graphics g) {
//		super.paint(g); // 반드시 필요 : 없으면 실행 안됨 - 무조건 호출되게 되어있음
	System.out.println("painted() Called.. ");
	font1 = new Font("Serif", Font.BOLD, 12);
	font2 = new Font("Batang", Font.ITALIC + Font.BOLD, 24);
	font3 = new Font("SansSerif", Font.PLAIN, 14);
	g.setFont(font1);
	g.setColor(Color.red);
	
	g.drawString("Serif 12 point bold.", 20, 100);
	g.setFont(font2);
	g.setColor(Color.green);
	g.drawString("바탕 24 point italic.", 20, 65);
	g.setFont(font3);
	g.setColor(Color.blue);
	g.drawString("SansSerif 14 point plain.", 20, 80);
	
	// 도형별 그리기 메소드 제공
	g.draw3DRect(  0, 0, 46, 36, true); // x,y 축 폭,높이 만 있으면 그려줌
	g.drawOval(50, 0, 46, 36); //내접원 그려줌
	int x1[] = new int[] { 100, 300, 273 };
	int y1[] = new int[] {   0,   0,  36 };
	g.drawPolygon(x1, y1, x1.length);
	g.setColor(Color.blue);
	g.fill3DRect(  0, 40, 46, 36, true); // 원하는 색으로 채워줌 
	g.fillOval(50, 40, 46, 36);
	int x2[] = new int[] { 100, 300, 273 };
	int y2[] = new int[] {  40,  40,  76 };
	g.fillPolygon(x2, y2, x2.length);
	g.drawLine(150, 40, 396, 76);
	g.setColor(Color.black);
	g.drawString("www. bangry.com", 10, 115);
	g.setColor(Color.cyan);
	g.drawRoundRect( 0, 120, 46, 36, 10, 10);
	g.fillRoundRect(50, 120, 46, 36, 10, 10);
	g.clearRect(30, 30, 250, 30); // 지우고자 하는 영역
	g.drawImage(image, 200, 200,100,100, this); //가지고 오고자 하는 애 this 
	g.drawImage(image2, 100, 100, this);
	}

	

	public static void main(String[] args) {
		GraphicFrame frame = new GraphicFrame()	;
		frame.setSize(600,400);
		frame.setVisible(true); 
	}

}
