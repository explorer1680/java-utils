package personal.test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WeakLinkage {

	public static void main(String[] args) {

		List<Pair> list = new LinkedList<>();
		list.add(new Pair(1, 2));
		list.add(new Pair(2, 3));
		list.add(new Pair(3, 7));
		list.add(new Pair(3, 6));
		list.add(new Pair(2, 6));
		list.add(new Pair(6, 7));
		list.add(new Pair(2, 5));
		list.add(new Pair(4, 5));

		LinkedList<Integer> nodeList = getNodeList(list);

		for (Integer node : nodeList) {
			LinkedList<Integer> tempList = new LinkedList<Integer>(
					nodeList.stream().filter(p -> !p.equals(node)).collect(Collectors.toList()));

			LinkedList<Pair> tempPairList = new LinkedList<Pair>(
					list.stream().filter(p -> !p.contains(node)).collect(Collectors.toList()));

			Integer endNode = tempList.remove();

			for (Integer anotherNode : tempList) {
				if (!connected(endNode, anotherNode, tempPairList)) {
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Node: " + node + " is key for: " + endNode
							+ " and " + anotherNode);
				}
			}
		}
	}

	static boolean connected(Integer endNode, Integer targetNode, LinkedList<Pair> list) {
		if (list.stream().filter(p -> p.contains(endNode) && p.contains(targetNode)).count() > 0) {
			return true;
		} else {
			long previousCount = list.stream().filter(p -> p.contains(endNode)).count();
			Set<Integer> linkedNodes = new HashSet<>();
			list.stream().forEach(p -> {
				if (p.contains(endNode)) {
					linkedNodes.add(p.findAnother(endNode));
				}
			});

			if (linkedNodes != null) {
				linkedNodes.remove(endNode);
			}

			LinkedList<Pair> temp = null;
			LinkedList<Pair> orginal = list;
			for (Integer linkedNode : linkedNodes) {
				temp = new LinkedList<Pair>(orginal.stream().map(p -> {
					if (p.contains(linkedNode)) {

						Pair newPair = p.replacePairNode(linkedNode, endNode);
						return newPair;
					} else {
						return p;
					}
				}).collect(Collectors.toList()));
				orginal = temp;
			}

			if (temp == null) {
				return false;
			}

			long newCount = temp.stream().filter(p -> p.contains(endNode)).count();
			if (newCount == previousCount) {
				return false;
			} else {
				return connected(endNode, targetNode, temp);
			}
		}
	}

	static LinkedList<Integer> getNodeList(List<Pair> list) {
		Set<Integer> set = new HashSet<>();
		list.stream().forEach(p -> {
			set.add(p.first);
			set.add(p.second);
		});
		return set.stream().sorted().collect(() -> new LinkedList<Integer>(), (c, e) -> c.add(e),
				(c1, c2) -> c1.addAll(c2));
	}

	static int findTotalNodes(List<Pair> list) {
		Set<Integer> set = new HashSet<>();
		list.stream().forEach(p -> {
			set.add(p.first);
			set.add(p.second);
		});
		return set.size();
	}

	static class Pair {
		Integer first;
		Integer second;

		Pair(Integer first, Integer second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public String toString() {
			return "Pair [first=" + first + ", second=" + second + "]";
		}

		private boolean contains(Integer node) {
			if (first.equals(node) || second.equals(node)) {
				return true;
			}
			return false;
		}

		private Integer findAnother(Integer one) {
			if (one.equals(first)) {
				return second;
			} else if (one.equals(second)) {
				return first;
			} else {
				return null;
			}
		}

		private Pair replacePairNode(Integer original, Integer target) {
			if (original.equals(this.first)) {
				return new Pair(target, this.second);
			} else {
				return new Pair(this.first, target);
			}
		}
	}

}
