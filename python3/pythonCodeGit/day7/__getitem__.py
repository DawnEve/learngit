class Demo:
	L=[1,2,3,4,5,6,7,8,9]
	def __getitem__(self,para):
		#return isinstance(para,slice)
		#return self.L[para]
		#return para;
		#return para.start;#起始
		#return para.stop;#终结
		return para.step;#步长
		
		
d=Demo()
print( d[1:10:2] ) 
