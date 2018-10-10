/*초기화 함수*/
function init() {
	blank();
	document.getElementById("kind").focus();
	var target = document.getElementById("kind");
	target.onchange = function() {
		var disabledTarget = target.value;
		if (disabledTarget == '입출금계좌') {
			document.getElementById("borrowMoney").disabled = true;
			document.getElementById("regist").disabled = false;
			clickListKind();
		} else if (disabledTarget == '마이너스계좌') {
			document.getElementById("borrowMoney").disabled = false;
			document.getElementById("regist").disabled = false;
			clickListKind();
		}
	}
}

/* 이벤트 등록 */
function eventRegist() {
	var accountNum = document.getElementById("accountNum");
	accountNum.onkeyup = function(e) {
		var event = e || window.event;
		if (e.keyCode == 13) {
			clickFind();
		}
	}
	var accountOwner = document.getElementById("accountOwner");
	accountOwner.onkeyup = function(e) {
		var event = e || window.event;
		if (e.keyCode == 13) {
			clickSearch();
		}
	}
	var doRegist = document.getElementById("regist");
	doRegist.onclick = clickRegist;
	var doListAll = document.getElementById("listAll");
	doListAll.onclick = clickListAll;
	var doSearch = document.getElementById("search");
	doSearch.onclick = clickSearch;
	var doFind = document.getElementById("find");
	doFind.onclick = clickFind;
	var doDelete = document.getElementById("delete");
	doDelete.onclick = clickDelete;
}
/* 기본 입력 */
var manager = new AccountManager();
var account = new Account("1111-2222-3333", "서지원", 1234, 1000);
manager.add(account);
manager.add(new Account("1111-2222-3330", "김지원", 1234, 10000));
manager.add(new Account("1111-2222-3334", "최지원", 1234, 1000));
manager.add(new Account("1111-2222-3335", "박지원", 1234, 1000));
manager.add(new Account("1111-2222-3336", "최지원", 1234, 1000));
manager.add(new MinusAccount("1111-1111-1111", "대출씨", 1234, 1000, 10000));

/* 메세지 3초 띄어주고 사라지기 */
function errorMessage(message) {
	var count = 0;
	var errors = setInterval(function() {
		document.getElementById("error").innerHTML = "ERROR : ";
		document.getElementById("errorText").innerHTML = message;
		count++;
		if (count == 3) {
			document.getElementById("error").innerHTML = "";
			document.getElementById("errorText").innerHTML = '';
			clearInterval(errors);
		}
	}, 1000);
	errors;
}
function infoMessage(message) {
	var count = 0;
	var errors = setInterval(function() {
		document.getElementById("info").innerHTML = "INFO : ";
		document.getElementById("errorText").innerHTML = message;
		count++;
		if (count == 3) {
			document.getElementById("info").innerHTML = "";
			document.getElementById("errorText").innerHTML = '';
			clearInterval(errors);
		}
	}, 1000);
	errors;
}
/* 빈칸만들기 */
function blank() {
	document.getElementById("accountNum").value = "";
	document.getElementById("accountOwner").value = "";
	document.getElementById("passwd").value = "";
	document.getElementById("deposit").value = "";
	document.getElementById("borrowMoney").value = "";
}
/* 정규표현식 */
var regExpr = {
	accountNumRegExp : /^\d{4}-\d{4}-\d{4}$/,
	accountOwnerRegExp : /^[가-힣]{2,5}|[a-zA-Z]{2,10}$/,
	passwdRegExp : /^[0-9]{4}$/,
	depositRegExp : /^[0-9]{1,}$/,
	borrowMoneyRegExp : /^[0-9]+$/
}
/* 신규등록 */
function clickRegist() {

	var accountNum = document.getElementById("accountNum").value.trim();
	var accountOwner = document.getElementById("accountOwner").value;
	var passwd = document.getElementById("passwd").value;
	var deposit = document.getElementById("deposit").value;
	var addArray = [];
	var target = document.getElementById("kind");
	if (target.value == "선택하세요") {
		errorMessage("계좌종류를 선택하여 주세요");
	} else if (!accountNum) {
		errorMessage("계좌번호를 입력하여 주세요");
		document.getElementById("accountNum").focus();
	} else if (!accountNum.match(regExpr.accountNumRegExp)) {
		errorMessage("계좌번호를 형식에 맞게 입력하여 주세요");
		document.getElementById("accountNum").focus();
	} else if (manager.get(accountNum).length == 1) {
		errorMessage("중복된 계좌번호입니다");
		document.getElementById("accountNum").focus();
	}

	else if (!accountOwner) {
		errorMessage("예금주명을 입력하여 주세요");
		document.getElementById("accountOwner").focus();
	} else if (!accountOwner.match(regExpr.accountOwnerRegExp)) {
		errorMessage("예금주명을 형식에 맞게 입력하여 주세요");
		document.getElementById("accountOwner").focus();
	}

	else if (!passwd) {
		errorMessage("비밀번호를 입력하여 주세요");
		document.getElementById("passwd").focus();
	} else if (!passwd.match(regExpr.passwdRegExp)) {
		errorMessage("비밀번호를 형식에 맞게 입력하여 주세요");
		document.getElementById("passwd").focus();
	}

	else if (!deposit) {
		errorMessage("입금금액을 입력하여 주세요");
		document.getElementById("deposit").focus();
	} else if (!deposit.match(regExpr.depositRegExp)) {
		errorMessage("입금금액을 형식에 맞게 입력하여 주세요");
		document.getElementById("deposit").focus();
	}

	else {
		var target = document.getElementById("kind");
		var kind = target.value;
		if (kind == "마이너스계좌") {
			var borrowMoney = document.getElementById("borrowMoney").value;
			if (!borrowMoney) {
				errorMessage("대출금액을 입력하여 주세요");
				document.getElementById("borrowMoney").focus();
			} else if (!borrowMoney.match(regExpr.borrowMoneyRegExp)) {
				errorMessage("대출금액을 형식에 맞게 입력하여 주세요");
				document.getElementById("borrowMoney").focus();
			} else {
				var add = new MinusAccount(accountNum, accountOwner, passwd,
						deposit, borrowMoney);
			}
		} else {
			var add = new Account(accountNum, accountOwner, passwd, deposit);
		}
		manager.add(add);
		addArray.push(add);
		infoMessage(accountOwner + "님의 계좌가 성공적으로 등록되었습니다");
		showList(addArray);
		blank();
	}
}

/* 금액 포맷 */

Number.prototype.format = function() {
	if (this == 0)
		return 0;
	var reg = /(^[+-]?\d+)(\d{3})/;
	var n = (this + '');
	while (reg.test(n))
		n = n.replace(reg, '$1' + ',' + '$2');
	return n;
};

String.prototype.format = function() {
	var num = parseFloat(this);
	if (isNaN(num))
		return " ";
	return num.format();
};

/* 계좌목록에 띄어주기 */
function showList(showArray) {
	var data = [];
	for ( var i in showArray) {
		if (showArray[i] instanceof MinusAccount) {
			var minus = {
				kind : "마이너스계좌",
				accountNum : showArray[i].accountNum,
				accountOwner : showArray[i].accountOwner,
				restMoney : (showArray[i].restMoney - showArray[i].borrowMoney),
				borrowMoney : showArray[i].borrowMoney
			};
			data.push(minus);
		} else {
			var plus = {
				kind : "입출금계좌",
				accountNum : showArray[i].accountNum,
				accountOwner : showArray[i].accountOwner,
				restMoney : showArray[i].restMoney,
				borrowMoney : ''
			};
			data.push(plus);
		}
	}
	var html = document.querySelector("#accountSet").innerHTML;
	var resultHTML = "";

	for (var i = 0; i < data.length; i++) {
		resultHTML += html.replace("{kind}", data[i].kind).replace(
				"{accountNum}", data[i].accountNum).replace("{accountOwner}",
				data[i].accountOwner).replace("{restMoney}",
				data[i].restMoney.format()).replace("{borrowMoney}",
				data[i].borrowMoney.format());
	}
	document.querySelector("#put").innerHTML = resultHTML;
}
/* 전체조회 */
function clickListAll() {
	var showAll = manager.list();
	showList(showAll);
}
/* 계좌종류별 조회 */
function clickListKind() {
	var target = document.getElementById("kind");
	var show = manager.list();
	var outputPlus = [];
	var outputMinus = [];
	for ( var i in show) {
		if (show[i] instanceof MinusAccount) {
			outputMinus.push(show[i]);
		} else {
			outputPlus.push(show[i]);
		}
	}
	if (target.value == "마이너스계좌") {
		showList(outputMinus);
	} else {
		showList(outputPlus);
	}
}
/* 검색 */
function clickSearch() {
	var searchOwn = document.getElementById("accountOwner").value;
	if (!searchOwn) {
		errorMessage("예금주명을 입력하여 주세요");
		document.getElementById("accountOwner").focus();
	} else if (!searchOwn.match(regExpr.accountOwnerRegExp)) {
		errorMessage("예금주명을 형식에 맞게 입력하여 주세요");
		document.getElementById("accountOwner").focus();
	} else if (manager.search(searchOwn).length == 0) {
		errorMessage("일치하는 계좌가 존재하지 않습니다");
		document.getElementById("accountOwner").focus();
	} else {
		var searchAll = manager.search(searchOwn);
		showList(searchAll);
		blank();
	}
}
/* 조회 */
function clickFind() {
	var accountNumRegExp = /^\d{4}-\d{4}-\d{4}$/;
	var findNum = document.getElementById("accountNum").value;
	if (!findNum) {
		errorMessage("계좌번호를 입력하여 주세요");
		document.getElementById("accountNum").focus();
	} else if (!findNum.match(regExpr.accountNumRegExp)) {
		errorMessage("계좌번호를 형식에 맞게 입력하여 주세요");
		document.getElementById("accountNum").focus();
	} else if (manager.get(findNum).length == 0) {
		errorMessage("일치하는 계좌가 존재하지 않습니다");
		document.getElementById("accountNum").focus();
	} else {
		var findList = manager.get(findNum);
		showList(findList);
		blank();
	}
}

/* 삭제 */
function clickDelete() {
	var deleteNum = document.getElementById("accountNum").value;
	if (!deleteNum) {
		errorMessage("계좌번호를 입력하여 주세요");
		document.getElementById("accountNum").focus();
	} else if (!deleteNum.match(regExpr.accountNumRegExp)) {
		errorMessage("계좌번호를 형식에 맞게 입력하여 주세요");
		document.getElementById("accountNum").focus();
	} else if (manager.get(deleteNum).length == 0) {
		errorMessage("일치하는 계좌가 존재하지 않습니다");
		document.getElementById("accountNum").focus();
	} else {
		manager.remove(deleteNum);
		infoMessage("계좌가 삭제되었습니다");
		document.getElementById("accountNum").value = "";
		blank();
		showList([]);
	}
}