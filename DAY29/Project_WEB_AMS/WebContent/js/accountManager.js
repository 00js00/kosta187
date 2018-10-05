/**
 * accountManager 은행 계좌 관리
 */

function AccountManager() {
	this.accounts = [];
};

AccountManager.prototype.add = function(account) {
	this.accounts.push(account);
	return;
};
AccountManager.prototype.list = function() {
	return this.accounts;
};
AccountManager.prototype.get = function(accountNum) {
	var temp = '';
	for ( var i in this.accounts) {
		if (this.accounts[i].accountNum == accountNum) {
			temp = this.accounts[i];
			break;
		};
	};
	return temp.toString();
};
AccountManager.prototype.search = function(accountOwner) {
	return this.accounts.filter(function(v){
		return (v.accountOwner == accountOwner);
	});
};
AccountManager.prototype.remove = function(accountNum) {
	for ( var i in this.accounts) {
		if (this.accounts[i].accountNum == accountNum) {
			this.accounts.splice(i,1);
			 console.log(("삭제완료"));
		};
	};
};
