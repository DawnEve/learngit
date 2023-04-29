package chapter3;

public class EnumDemo {
	public static void main(String[] args) {
//		demo1();
//		demo2();
//		demo3();
//		demo4();
//		demo5(); //枚举类可以有自己的方法，构造函数是私有的
		demo6();
	}

	//如果枚举类具有抽象方法，则枚举类的每个实例都必须实现它。
	enum Color3{
	    RED{
	        public String getColor(){//枚举对象实现抽象方法
	            return "红色";
	        }
	    },
	    GREEN{
	        public String getColor(){//枚举对象实现抽象方法
	            return "绿色";
	        }
	    },
	    BLUE{
	        public String getColor(){//枚举对象实现抽象方法
	            return "蓝色";
	        }
	    };
	    public abstract String getColor();//定义抽象方法
	}
	private static void demo6() {
        for (Color3 c:Color3.values()){
            System.out.print(c.getColor() + " | ");
        }
	}

	
	
	
	// 枚举的方法
	enum Color2{
		RED, GREEN, BLUE;
		//构造函数
		private Color2() {
			System.out.println("Constructor called for: "+this.toString());
		}
		
		public void colorInfo() {
			System.out.println("Universal Color");
		}
	}
	private static void demo5() {
		Color2 c2=Color2.RED;
		System.out.println(c2);
		c2.colorInfo();
	}

	
	// values(), ordinal() 和 valueOf() 方法
	private static void demo4() {
		// values() 返回枚举中的所有值
		Color[] arr=Color.values();
		
		//迭代枚举：val.ordinal() 获取 0-based 序号
		for(Color col: arr) {
			//查看索引
			int index=col.ordinal();
			System.out.println(col+" at index "+ index);
		}
		
		// valueOf() 由字符出值，返回枚举常量。不存在则报错 IllegalArgumentException
		System.out.println(Color.valueOf("RED"));
		try {
			System.out.println(Color.valueOf("WHITE"));
		}catch(IllegalArgumentException e) {
			System.out.println(">> exception now");
		}
	}

	//在 switch 中使用枚举类
	private static void demo3() {
		Color val=Color.BLUE;
		
		switch(val) {
		case RED:
			System.out.println("红色");
			break;
		case GREEN:
			System.out.println("绿色");
			break;
		case BLUE:
			System.out.println("蓝色");
			break;
		}
	}

	//迭代枚举元素
	private static void demo2() {
		for(Color val: Color.values()) {
			System.out.println(val);
		}
	}

	enum Color{ RED, GREEN, BLUE } //不能放到方法中 why?
	private static void demo1() {
		Color c1 = Color.RED;
        System.out.println(c1);
	}

}
