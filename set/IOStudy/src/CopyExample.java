import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {

	public static long copy(String srcPath, String destPath) throws IOException {
		InputStream in = null;
		OutputStream out = null; // 사용(호출)하는 쪽에서 throw하는게 좋음
		try {
			in = new FileInputStream(srcPath);
			out = new FileOutputStream(destPath);

			byte[] buffer = new byte[4 * 1024];

			int count = 0;
			long totalCount = 0;
			while ((count = in.read(buffer)) != -1) {
				out.write(buffer, 0, count);
				totalCount += count;
			}
			return totalCount;
		} finally {
			if(out!=null) out.close(); // 생성한 순서 역순으로
			if(in!=null) in.close();
		}

	}

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		String src = "C:\\KOSTA187\\설치프로그램\\drive-download-20180903T021126Z-001.zip";
		String dest = "eclipse.dat";

		try {
			long copySize = copy(src, dest);
			System.out.println(String.format("%,d", copySize)+"바이트 파일 복사 완료...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
