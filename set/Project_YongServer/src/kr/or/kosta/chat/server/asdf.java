package kr.or.kosta.chat.server;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class asdf {
	public static void main(String[] args) {
		  GraphicsEnvironment ge = null;

          ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

          Font[] fonts = ge.getAllFonts();

         

          for(int i=0; i<fonts.length;i++){

                 System.out.println(fonts[i].getFontName());	}
}
}
