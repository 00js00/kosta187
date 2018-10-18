<%@ page contentType="text/html; charset=utf-8"%>

<script type="text/javascript">

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

</script>
