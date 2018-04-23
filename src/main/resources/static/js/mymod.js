
// 导出代码
layui.define(function(exports){
	var obj = {
		hello: function(str){
			alert('Hello ' + (str || 'mymod'));
		}
	};
	exports('mymod', obj);
});
