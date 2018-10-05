/**
 * MinusAccount
 */

function MinusAccount(accountNum, accountOwner, passwd, restMoney, borrowMoney) {
	Account.call(this, accountNum, accountOwner, passwd);
	this.restMoney = restMoney;
	this.borrowMoney = borrowMoney;
};

MinusAccount.prototype = new Account();

MinusAccount.prototype.constructor = MinusAccount;
MinusAccount.prototype.toString = function() {
	return '마이너스계좌' + "\t" + this.accountNum + "\t" + this.accountOwner + "\t"
			+ this.restMoney + "\t" + (this.restMoney - this.borrowMoney);
};