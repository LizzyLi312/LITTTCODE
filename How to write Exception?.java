try{
	//cc
	if(c == null) throw new IllegalArgumentException(‘msg say sth’);
	int row;
	int col;
	int mask = 1;
	int[] res = new int[8];
	for(int i = 0; i < c.length; i++){
	row = c / 32;  //直接运算就行
	col = c % 32;
	res[row] | mask << col;
	if((res[row] & (mask << col)) != 0) return false;
	else res[row] |= mask << j;  //如果不是1的话 set成1
}
return true;
} 
catch(IllegalArgumentException e){
	System.out.println(e.getMessage());
	e.printStacktrace();
	Logger.log(e); //singleton 因为每个class都可以直接调用
} 
catch(Exception e){
	//do something
}
}
