package kr.or.kosta.entitiy;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * RandomAccessFile을 이용하여 계좌정보를 레코드 단위로 파일에 저장/읽기 처리
 * 
 * @author 서지원
 *
 */
public class AccountDao {
	/** 저장 파일 경로 */
	private static final String FILE_PATH = "account.dbf";
	/** 레코드 수 저장을 위한 파일 컬럼 사이즈 고정 */
	private static final int RECORD_COUNT_LENGTH = 4;
	/** 레코드 저장을 위한 컬럼별 사이즈 고정 */
	private static final int ACCOUNT_NUM_LENGTH = 30;
	private static final int ACCOUNT_OWNER_LENGTH = 20;
	private static final int PASSWORD_LENGTH = 4;
	private static final int REST_MONEY_LENGTH = 8;
	private static final int BORROW_MONEY_LENGTH = 8;
	/** 계좌정보 저장을 위한 레코드 사이즈 : 74바이트 */
	public static final int RECORD_LENGTH = RECORD_COUNT_LENGTH + ACCOUNT_NUM_LENGTH + ACCOUNT_OWNER_LENGTH
			+ PASSWORD_LENGTH + REST_MONEY_LENGTH + BORROW_MONEY_LENGTH;
	/** 저장된 레코드 수 */
	private int recordCount = 0;

	private RandomAccessFile file;
	/** 저장된 파일이 있는 경우에 읽을 것*/
	public AccountDao() throws IOException {
		file = new RandomAccessFile(FILE_PATH, "rw");
		if (file.length() != 0) {
			recordCount = file.readInt();
		} else {
		}
	}
	/** getter*/
	public int getRecordCount() {
		return recordCount;
	}
	/** 계좌정보 저장*/
	public void create(Account accounts) throws IOException, AccountException {
		/** 예외처리*/
		if (accounts.getAccountNum().length() < 1) {
			throw new AccountException("계좌번호를 입력해주세요.", -2);
		}
		if (accounts.getAccountOwner().length() < 1) {
			throw new AccountException("예금주명을 입력해주세요.", -3);
		}
		if (!(accounts.getPasswd() > 0)) {
			throw new AccountException("비밀번호를 입력해주세요.", -4);
		}
		if (!(accounts.getRestMoney() >= 10000)) {
			throw new AccountException("최소 입금금액은 10,000원 입니다.", -5);
		}
		if (get(accounts.getAccountNum()) != null) {
			System.out.println("6");
			throw new AccountException("이미 등록된 계좌입니다.", -6);
		}
		/** 파일의 마지막 레코드 끝으로 파일 포인터 이동*/
		file.seek((recordCount * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
		/** 새로운 레코드 추가*/
		String accountNum = accounts.getAccountNum();
		String accountOwner = accounts.getAccountOwner();
		int passwd = accounts.getPasswd();
		long restMoney = accounts.getRestMoney();
		
		int accountNumCharCount = accountNum.length();
		/** 30바이트로 계좌번호 저장 */
		for (int i = 0; i < (ACCOUNT_NUM_LENGTH / 2); i++) {
			file.writeChar((i < accountNumCharCount ? accountNum.charAt(i) : ' '));
		}
		int accountOwnerCharCount = accountOwner.length();
		/** 20바이트로 예금주명 저장 */
		for (int i = 0; i < (ACCOUNT_OWNER_LENGTH / 2); i++) {
			file.writeChar((i < accountOwnerCharCount ? accountOwner.charAt(i) : ' '));
		}
		// 비밀번호 4바이트
		file.writeInt(passwd); 
		// 입금금액 8바이트
		file.writeLong(restMoney);
		long borrowMoney = 0;
		// 계좌 종류에 따라 대출금액 8바이트 저장
		if (accounts instanceof MinusAccount) {
			borrowMoney = accounts.getBorrowMoney();
			file.writeLong(borrowMoney);
		} else {
			borrowMoney = 0;
			file.writeLong(borrowMoney);
		}
		// 레코드 저장 후 파일포인터를 파일의 처음으로 이동시켜
		// 등록된 레코드 수 1 증가
		file.seek(0);
		file.writeInt(++recordCount);

	}
	/** 특정 레코드의 정보를 Account로 반환 */
	private Account read(int index) throws IOException {
		Account account = null;
		file.seek((index * RECORD_LENGTH) + RECORD_COUNT_LENGTH);

		String accountNum = "";
		for (int i = 0; i < (ACCOUNT_NUM_LENGTH / 2); i++) {
			accountNum += file.readChar();
		}
		accountNum = accountNum.trim();

		String accountOwner = "";
		for (int i = 0; i < (ACCOUNT_OWNER_LENGTH / 2); i++) {
			accountOwner += file.readChar();
		}
		accountOwner = accountOwner.trim();

		int passwd = 0;
		passwd = file.readInt();

		long restMoney = 0;

		restMoney = file.readLong();

		long borrowMoney = 0;
		borrowMoney = file.readLong();

		if (borrowMoney != 0) {

			account = new MinusAccount(accountNum, accountOwner, passwd, restMoney, borrowMoney);
			restMoney += borrowMoney;

		} else {
			account = new Account(accountNum, accountOwner, passwd, restMoney);
		}

		return account;
	}

	/**
	 * @return 전체 조회 : 모든 계좌 조회
	 * @throws IOException
	 */
	public List<Account> listAll() throws IOException {
		List<Account> list = new ArrayList<Account>();
		for (int i = 0; i < recordCount; i++) {
			Account accounts = read(i);
			list.add(accounts);
		}
		Collections.sort(list, new NumberCompare());
		return list;
	}

	public void close() {
		try {
			if (file != null)
				file.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 조회 : 계좌번호 입력시 계좌 조회
	 * 
	 * @param accountNum : 조회하고자 하는 계좌번호
	 * @return
	 * @throws IOException
	 * @throws AccountException
	 */

	public Account get(String accountNum) throws IOException, AccountException { // 검색 조회기능
		Account account = null;

		if (accountNum.length() < 1) {
			throw new AccountException("계좌번호를 입력해주세요.", -2);
		} else if (recordCount != 0) {
			for (int i = 0; i < recordCount; i++) {
				if (read(i).getAccountNum().equals(accountNum)) {
					account = read(i);
				}

			}
		}

		return account;
	}

	/**
	 * 검색 : 예금주명 입력시 계좌 검색
	 * 
	 * @param accountOwner : 검색하고자 하는 예금주명
	 * @return
	 * @throws IOException
	 * @throws AccountException
	 */

	public List<Account> search(String accountOwner) throws IOException, AccountException {
		if (!(accountOwner.length() > 0)) {
			throw new AccountException("예금주명을 입력해주세요", -3);
		}
		List<Account> list = new ArrayList();
		for (int i = 0; i < recordCount; i++) {
			if (read(i).getAccountOwner().equals(accountOwner)) {
				list.add(read(i));
			}
		}
		if (list.size() == 0) {
			throw new AccountException("결과가없습니다", -5);
		}
		return list;
	}

	/**
	 * 삭제 : 계좌번호 입력시 해당 계좌 삭제
	 * 
	 * @param accountNum : 삭제하고자 하는 계좌번호
	 * @return
	 * @throws IOException
	 * @throws AccountException
	 */
	public boolean remove(String accountNum) throws IOException, AccountException {
		
		if (accountNum.length() < 1) {
			throw new AccountException("계좌번호를 입력해주세요", -2);
		}
		for (int i = 0; i < recordCount; i++) {
			if (read(i).getAccountNum().equals(accountNum)) {
				if (i != recordCount - 1) {
					String accountNum2 = read(recordCount + 1).getAccountNum();
					String accountOwner = read(recordCount + 1).getAccountOwner();
					int passwd = read(recordCount + 1).getPasswd();
					long restMoney = read(recordCount + 1).getRestMoney();
					int accountNumCharCount = accountNum2.length();

					file.seek((i * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
					for (int j = 0; j < (ACCOUNT_NUM_LENGTH / 2); j++) {
						file.writeChar((j < accountNumCharCount ? accountNum2.charAt(j) : ' '));
					}
					int accountOwnerCharCount = accountOwner.length();
					for (int j = 0; j < (ACCOUNT_OWNER_LENGTH / 2); j++) {
						file.writeChar((j < accountOwnerCharCount ? accountOwner.charAt(j) : ' '));
					}

					file.writeInt(passwd);
					file.writeLong(restMoney);
					long borrowMoney = 0;
					if (read(recordCount - 1) instanceof MinusAccount) {
						borrowMoney = ((MinusAccount) read(recordCount - 1)).getBorrowMoney();
						file.writeLong(borrowMoney);
					} else
						borrowMoney = 0;

					file.seek(0);
					recordCount--;
					file.writeInt(recordCount);
					return true;

				} else { 	/** 특정 레코드의 정보를 Friend로 반환 */
					file.seek((i * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
					for (int j = 0; j < (ACCOUNT_NUM_LENGTH / 2); j++) {
						file.writeChar(' ');
					}

					for (int j = 0; j < (ACCOUNT_OWNER_LENGTH / 2); j++) {
						file.writeChar(' ');
					}
					file.writeInt(0);
					file.writeLong(0);
					file.writeLong(0);
					file.seek(0);
					recordCount--;
					file.writeInt(recordCount);

				}

			}
			
		}
		if
		return false;
	}

}
