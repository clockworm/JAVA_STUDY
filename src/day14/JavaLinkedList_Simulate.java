package day14;

public class JavaLinkedList_Simulate {
	public static void main(String[] args) {
		NodeSimulate note = new NodeSimulate("10");
		note.nextNode = new NodeSimulate("J");
		note.nextNode.nextNode = new NodeSimulate("Q");
		note.nextNode.nextNode.nextNode = new NodeSimulate("K");
		note.nextNode.nextNode.nextNode.nextNode = new NodeSimulate("A");
		System.out.println(note);
	}
}

// 模拟链表结构
class NodeSimulate {
	Object value;
	NodeSimulate nextNode; // 单向链接

	public NodeSimulate(Object value) {
		this.value = value;
	}

	public String toString() {
		return nextNode == null ? value.toString() : (value.toString() + "," + nextNode);
	}

}
