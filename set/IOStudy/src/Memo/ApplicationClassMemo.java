package Memo;

public class ApplicationClassMemo {
	public static void main(String[] args) {
		MemoFrame memoFrame;
		memoFrame = new MemoFrame();
		memoFrame.setCenter();
		memoFrame.init();

		FileDao fileDao;
		fileDao = new FileDao();

	}
}
