package day2;
//位运算符
//二进制移动
// >>> 无符号(前面补0) 对负数结果很大 对正数有效 

/* >>移动 砍掉后面 >>移1位除以2
   <<移动  <<移1位乘以2
*/
public class OperatorBit{

	public static void main(String[] args) {
		int a = 11;
		//1010   
		System.out.println(a>>2);
		a = 11;
		System.out.println(a<<2);

	/*逻辑位运算异或运算
		&(同为1即为1)    |(同为0即为0)     ^(相同为0不同为1)
	*/
		int a_ = 5 ,b_ = 4;
		// 5  101  
		// 4  100
		System.out.println(b_ & a_);
		System.out.println(b_ | a_);
		System.out.println(b_ ^ a_);
		//异或运算  ^ 可以正反推
		int c_ = a_ ^ b_;
			a_ = c_^ b_;
		System.out.println(a_);
		System.out.println(c_);
		//异或运算 互换
		int a_1 = 5 ,b_1 = 4;
		a_1 = a_1 ^ b_1;
		b_1 = a_1 ^ b_1;
		a_1 = a_1 ^ b_1;
		System.out.println(a_1);
		System.out.println(b_1);

	}
}