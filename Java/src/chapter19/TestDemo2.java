package chapter19;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.containsString;

import org.junit.Test;

public class TestDemo2 {
	// 可以直接写一个public无参无返回值的方法，顶上加 @Test 注解，这样就自动加 import
	@Test
	public void testPerson() {
		Student s2=new Student();
		s2.setName("zhangsan");
		// 其他测试方法：判断相等
		assertSame(s2.getName(), "zhangsan");
		assertEquals(s2.getName(), "zhangsan");
		
		// 结果为假
		s2.setAge(20);
		assertFalse(s2.getAge()>100);
		
		//System.out.println(s2.toString());
		// 判断结果中包含
		assertThat(s2.toString(), containsString("class"));
	}

}
