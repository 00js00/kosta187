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
return money;	
};

Account.prototype.withdraw=function(money){
	return moeny;
};

Account.prototype.checkPasswd=function(pw){
	return this.passwd==pw;
};

Account.prototype.toString=function(){
	return '입출금계좌'+"\t"+ this.accountNum +"\t"+ this.accountOwner +"\t"+this.restMoney ;
};