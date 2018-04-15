selectSample
===
* 一个简单的查询例子
	select * from user where 1=1
	@if(!IsEmpty(name)){
		and name=#name#
	@}
	