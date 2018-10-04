import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamExample {
		static final String path="example2.dat";
public static void main(String[] args) throws IOException {
	FileOutputStream  fos = new FileOutputStream(path);
	BufferedOutputStream out = new BufferedOutputStream(fos); // fos,512 : 버퍼 사이즈 조정 가능
	out.write(10); // 배열형식: buffredoutputstream 에 작성하는 것  --> 512 바이트 모두 채워야 fileoutputstream 에 작성됨
	out.write(10);
	byte[] data = {5,6,7,8,9};
	out.write(data);
	out.flush(); // 안에 다 안채웠어도 작성하고 싶은 것 : 거의 꼭 씀
	System.out.println("파일에 데이터 썼음..");
	
	
	
}
}
