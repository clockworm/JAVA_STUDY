package day14;
//HashSet 集合不能加入重复的数据
//底层操作的是hashMap
//hashset 对象放置容器的位置是乱序的 ------>遍历输出的内容不是有序的 1 2 3  遍历输出可能是 3 1 2
import java.util.HashSet;

public class JavaHashSet {
	public static void main(String[] args) {
		User user1 = new User(1, "张三", "111");
		User user2 = new User(1, "李四", "222");
		User user3 = new User(3, "王五", "333");
		User user4 = new User(4, "赵六", "444");
		User user5 = new User(5, "田七", "555");
		HashSet<User> users = new HashSet<User>();
		users.add(user1);
		//users.add(user2); // 第二个没有加入 User类重写了equals方法和hashCode方法
		users.add(user3);
		users.add(user4);
		System.out.println(users.size());
		// 对象放入hashset容器中 对象的唯一标识不能被修改 飛則導致對象不能被刪除   
		user4.setId(6); //修改了对象的唯一标识 导致删除失败
		users.remove(user4);//删除是通过唯一标识删除的。user2没被添加也可以被删除 這個時候刪除的是user1  底层会操作传入的对象找到对应的属性标识通过hashcode算法得到元素位置进行删除 沒用找到也會導致刪除失敗
		System.out.println(users); 

	}
}
