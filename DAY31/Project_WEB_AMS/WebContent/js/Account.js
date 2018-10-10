/**
 * Account 
 */

function Account(accountNum, accountOwner, passwd, restMoney){
	this.accountNum = accountNum;
	this.accountOwner=accountOwner;
	this.passwd=passwd;
	this.restMoney=restMoney;
};

Account.prototype.deposit = function(money){
	if(money<=0){
		console.log("입금하고자 하는 금액은 음수일 수 없습니다.");
	};
	return money;	
};

Account.prototype.withdraw=function(money){
	if(money<=0){
		console.log("출금하고자 하는 금액은 음수일 수 없습니다.");
	};
	if(money> restMoney){
		console.log("잔액이 부족합니다");
	};
	return moeny;
};

Account.prototype.checkPasswd=function(pw){
	return this.passwd==pw;
};

Account.prototype.equals=function(check){
if(check instanceof Account){
	return this.toString() === check.toString();
};
};


Account.prototype.toString=function(){
	return '입출금계좌'+"\t"+ this.accountNum +"\t"+ this.accountOwner +"\t"+this.restMoney ;
};